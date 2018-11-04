package com.qf.travel.manager.web;

import com.qf.travel.manager.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerIndexAction {

    @Autowired
    private PicService service;

    @RequestMapping(value = "/{page}",method = RequestMethod.GET)
    public String index1(@PathVariable String page){
        return page;
    }

    @RequestMapping(value = "/pages/{pageName}",method = RequestMethod.GET)
    public String index2(@PathVariable String pageName){
        return "pages/" + pageName;
    }

    @RequestMapping(value = "/pages/{pageName1}/{pageName2}",method = RequestMethod.GET)
    public String index3(@PathVariable String pageName1,@PathVariable String pageName2){
        return "pages/" + pageName1 + "/" + pageName2;
    }

}
