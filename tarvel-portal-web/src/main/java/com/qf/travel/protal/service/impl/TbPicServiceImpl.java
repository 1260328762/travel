package com.qf.travel.protal.service.impl;

import com.qf.travel.common.jedis.JedisClient;
import com.qf.travel.common.pojo.po.TbPic;
import com.qf.travel.protal.dao.TbPicMapper;
import com.qf.travel.protal.service.TbPicService;
import core.JsonUtils;
import core.StrKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbPicServiceImpl implements TbPicService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JedisClient client;

    @Autowired
    private TbPicMapper picMapper;



    @Override
    public List<TbPic> listPicByGroupId(int groupid) {
        List<TbPic> list = null;
        //在缓存中查询
        try {
            String piclist = client.hget("piclist", groupid + "");
            if (StrKit.notBlank(piclist)) {
                list = JsonUtils.jsonToList(piclist, TbPic.class);
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }

        //缓存中查询不到就到数据库中查询
        try {
            list = picMapper.listPicByGroupId(groupid);
            //放一份到缓存中
            client.hset("piclist", groupid+"", JsonUtils.objectToJson(list));
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            e.printStackTrace();
        }

        return list;
    }
}
