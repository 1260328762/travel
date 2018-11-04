package com.qf.travel.protal.web;

import com.qf.travel.common.pojo.po.TbPic;
import com.qf.travel.protal.service.TbPicService;
import core.PropKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PicAction {

    @Autowired
    private TbPicService service;

    @RequestMapping(value = "/pics")
    @ResponseBody
    public List<TbPic> getPicList(){
        int groupid = PropKit.use("pic.properties").getInt("pic.groupid");

        return service.listPicByGroupId(groupid);
    }
}
