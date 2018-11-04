package com.qf.travel.protal.web;


import com.qf.travel.protal.service.TbPicService;
import core.PropKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProtalIndexAction {


    @Autowired
    private TbPicService service;

    @RequestMapping(value = "/{page}")
    public String index1(@PathVariable String page, HttpServletRequest request) {
        if ("psp".equals(page)) {
            request.setAttribute("pics",
                    service.listPicByGroupId(PropKit.use("pic.properties").getInt("pic.groupid")));
        }
        return page;
    }
}
