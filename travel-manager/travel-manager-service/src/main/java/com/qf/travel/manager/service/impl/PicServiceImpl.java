package com.qf.travel.manager.service.impl;

import com.qf.travel.common.pojo.dto.ItemResult;
import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.common.pojo.po.TbPic;
import com.qf.travel.manager.dao.TbPicMapper;
import com.qf.travel.manager.service.PicService;
import core.JsonUtils;
import core.PropKit;
import core.StrKit;
import fdfs.FastDFSFile;
import fdfs.FastDFSUtils;
import jdk.nashorn.internal.ir.LiteralNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PicServiceImpl implements PicService {

    @Autowired
    private TbPicMapper picMapper;

    @Override
    public String uploadImage(MultipartFile file) {
        String json = null;
        try {
            FastDFSFile fastDFSFile = new FastDFSFile(file.getBytes(), file.getOriginalFilename(), file.getSize());

            //上传文件
            String filePath = FastDFSUtils.uploadFile(fastDFSFile);
            //封装要返回前端页面的json数据(用来做回显)
            Map<String,Object> map = new HashMap<>();
            if (StrKit.notBlank()) {
                //读取服务器的地址
                String serverPath = PropKit.use("fdfs_client.conf").get("fdfs_server");
                //设置返回前台的状态码
                map.put("code", 0);
                map.put("msg", "success");
                Map<String,Object> data = new HashMap<>();
                data.put("src",serverPath+"/"+filePath);
                data.put("title", file.getOriginalFilename());
                map.put("data",data);
            }else{
                //上传失败
                map.put("code", 1);
                map.put("msg", "fail");
                map.put("data",null);
            }

            json = JsonUtils.objectToJson(map);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }



    @Override
    public int addPic(TbPic pic) {
        int i = 0;
        try {
            i = picMapper.insertImage(pic);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }


    /**
     * 查询图片列表
     * @param pageInfo
     * @return
     */
    @Override
    public String listPicByPage(PageInfo pageInfo) {
        ItemResult<TbPic> result = new ItemResult<>();
        try {
            List<TbPic> picList = picMapper.listPicByPage(pageInfo);
            result.setCode(0);
            result.setMsg("success");
            result.setData(picList);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("fail");
            result.setData(null);
        }
        return JsonUtils.objectToJson(result);
    }

}
