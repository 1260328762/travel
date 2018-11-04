package com.qf.travel.passport.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用来进行页面跳转的控制器
 */
@Controller
public class PassportIndexAction {

    @RequestMapping(value = "/{pageName}")
    public String index(@PathVariable String pageName) {

        return pageName;

    }


}
