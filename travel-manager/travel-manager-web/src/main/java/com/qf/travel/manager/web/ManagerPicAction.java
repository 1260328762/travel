package com.qf.travel.manager.web;

import com.qf.travel.common.jedis.JedisClient;
import com.qf.travel.common.pojo.dto.ItemResult;
import com.qf.travel.common.pojo.dto.PageInfo;
import com.qf.travel.common.pojo.po.TbPic;
import com.qf.travel.manager.service.PicService;
import core.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ManagerPicAction {

    @Autowired
    private PicService service;

    @Autowired
    private JedisClient jedisClient;


    /**
     * 上传图片
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadimage")
    public String uploadImage(MultipartFile file){
       return service.uploadImage(file);
    }


    /**
     * 添加图片
     * @param pic
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addpic")
    public int addpic(TbPic pic){
        //让redis缓存中的图片失效
        try {
            jedisClient.expire("piclist", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service.addPic(pic);
    }


    /**
     * 显示轮播图列表
     *
     * @param pageInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/picmanager", produces = "text/html;charset=UTF-8;")
    public String picList(PageInfo pageInfo, Model model) {
        String json = service.listPicByPage(pageInfo);
        ItemResult result = JsonUtils.jsonToPojo(json, ItemResult.class);
        System.out.println(result.getData());
        model.addAttribute("pics",result.getData());
        return json;
    }

}
