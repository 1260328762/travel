package com.qf.travel.manager.service.impl;

import com.qf.travel.common.pojo.dto.Options;
import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.common.pojo.dto.TbHotelResult;
import com.qf.travel.manager.dao.HotelCustomMapper;
import com.qf.travel.manager.dao.TbHotelCatMapper;
import com.qf.travel.manager.dao.TbHotelMapper;
import com.qf.travel.manager.pojo.po.*;
import com.qf.travel.manager.service.HotelService;
import core.JsonUtils;
import core.StrKit;
import fdfs.FastDFSFile;
import fdfs.FastDFSUtils;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.IOException;
import java.util.*;

@Service
public class HotelServiceImpl implements HotelService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HotelCustomMapper mapper;

    @Autowired
    private TbHotelMapper mapper2;

    @Autowired
    private SolrServer solrServer;

    @Autowired
    private TbHotelCatMapper hotelCatMapper;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination topicDestination;


    /**
     * 显示酒店列表
     * @param page
     * @param hotel
     * @return
     */
    @Override
    public TbHotelResult<TbHotelCustom> hotelList(PageInfo page, TbHotelCustom hotel) {
        TbHotelResult<TbHotelCustom> result = new TbHotelResult<>();
        result.setCode(0);
        result.setMsg("success");
        try {
            result.setCount(mapper.getCount(hotel));
            result.setData(mapper.hotelList(page,hotel));
        }catch (Exception e){
            result.setCode(1);
            result.setMsg("fail");
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return result;
    }




    /**
     * 修改酒店状态
     * @param flg
     * @return
     */
    @Override
    public int modifyHotelStatus(TbHotel hotel, boolean flg) {
        int i = 0;
        if(flg){
            hotel.setStatus((byte) 1);
        }else{
            hotel.setStatus((byte) 2);
        }
        try {
            i = mapper2.updateByPrimaryKeySelective(hotel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }


    /**
     * 获取分类列表
     * @return
     */
    @Override
    public List<TbHotelCat> getHotelCatList() {
        List<TbHotelCat> list = null;
        try {
           list = mapper.HotelCatList();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return list;
    }


    /**
     * 增加酒店,将插入的id发送的给订阅者用来导入索引库
     * @param hotel
     * @return
     */
    @Override
    public int hotelAdd(TbHotelCustom hotel) {
        int i= 0;

        try {
            hotel.setRestof(hotel.getNum());
            Date date = new Date();
            hotel.setCreated(date);
            hotel.setUpdated(date);
            i = mapper.hotelInsert(hotel);

            //发布消息
            jmsTemplate.send(topicDestination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {

                    return session.createTextMessage(hotel.getId() + "");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }



    /**
     * 批量删除(修改状态值)
     * @param ids
     * @return
     */
    @Override
    public int upateBatch(List<Long> ids) {
        int i = 0;
        try {
            TbHotelExample example = new TbHotelExample();
            TbHotelExample.Criteria criteria = example.createCriteria();
            TbHotel hotel = new TbHotel();
            hotel.setStatus((byte) 3);
            criteria.andIdIn(ids);

            i = mapper2.updateByExampleSelective(hotel, example);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }



    /**
     * 根据id查询酒店
     * @param hotel
     * @return
     */
    @Override
    public TbHotelCustom findHotelById(TbHotelCustom hotel) {
        hotel = mapper.selectHotelById(hotel);
        return hotel;
    }


    /**
     * 修改酒店信息
     * @param hotel
     * @return
     */
    @Override
    public int modifyHotel(TbHotelCustom hotel) {
        int i = 0;
        try {
            Date date = new Date();
            hotel.setUpdated(date);
            i = mapper.updateHotel(hotel);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;
    }


    /**
     * 导入酒店信息索引库
     * @return
     */
    @Override
    public int importIndexlib() {
        int i = 0;

        try {
            List<TbHotelCustom> list = mapper.selectHotelByStatus();
            for (TbHotelCustom hotel : list) {
                SolrInputDocument document = new SolrInputDocument();
                document.addField("id", hotel.getId());
                document.addField("hotel_name", hotel.getName());
                document.addField("hotel_content", hotel.getContent());
                document.addField("hotel_num", hotel.getNum());
                document.addField("hotel_restof", hotel.getRestof());
                document.addField("hotel_price", hotel.getPrice());
                document.addField("hotel_image", hotel.getImage());
                solrServer.add(document);
            }
            solrServer.commit();
            i = 1;
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }
        return i;

    }


    /**
     * 查询酒店分类列表
     * @return
     */
    @Override
    public String showCat() {

        List<Options> totalList = null;

        try {
            TbHotelCatExample example = new TbHotelCatExample();
            TbHotelCatExample.Criteria criteria = example.createCriteria();
            //查询父级分类列表
            criteria.andParentIdEqualTo(0L);
            List<TbHotelCat> parents = hotelCatMapper.selectByExample(example);

            //查询子级分类列表
            example = new TbHotelCatExample();
            criteria = example.createCriteria();
            criteria.andIsParentEqualTo(false);
            List<TbHotelCat> childs = hotelCatMapper.selectByExample(example);
            totalList = new ArrayList<>();
            //遍历父级类目
            for (TbHotelCat cat : parents) {
                Options o1 = new Options();
                o1.setName(cat.getName());
                o1.setParentId(cat.getParentId());
                List<Options> list1 = new ArrayList<>();
                //遍历子集类目查询,属于父级的子集
                for (TbHotelCat cat2 : childs) {
                    if (cat2.getParentId().equals(cat.getId())) {
                        Options o2 = new Options();
                        o2.setName(cat2.getName());
                        o2.setId(cat2.getId());
                        o2.setParentId(cat2.getParentId());
                        list1.add(o2);
                    }
                }
                o1.setChildren(list1);
                totalList.add(o1);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return JsonUtils.objectToJson(totalList);
    }


    /**
     * 上传酒店图片
     * @param file
     * @return
     */
    @Override
    public String uploadImage(MultipartFile file) {
        String message = null;
        try {
            FastDFSFile fastDFSFile = new FastDFSFile();
            fastDFSFile.setContent(file.getBytes());
            fastDFSFile.setName(file.getOriginalFilename());
            fastDFSFile.setSize(file.getSize());
            String uploadPath = FastDFSUtils.uploadFile(fastDFSFile);
            if (StrKit.notBlank(uploadPath)) {
                Map<String,Object> map = new HashMap<>();
                map.put("success", true);
                map.put("uploadPath", uploadPath);
                message = JsonUtils.objectToJson(map);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return message;
    }
}

