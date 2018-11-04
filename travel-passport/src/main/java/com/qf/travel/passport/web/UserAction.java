package com.qf.travel.passport.web;

import com.qf.travel.passport.pojo.po.User;
import com.qf.travel.passport.service.UserService;
import com.qf.travel.passport.shirofilter.MyShiroFilterFactoryBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserAction {

    @Autowired
    private MyShiroFilterFactoryBean shiroFilterFactoryBean;

    @Autowired
    private UserService userService;


    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping("/user/login")
    public boolean login(String username,String password){
        User user = userService.doLogin(username, password);
        return user!=null;
    }



    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/user/logout")
    @RequiresPermissions(value = {"logout"})//OR表示有其中一个权限即可访问
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }



    /**
     * 动态生成权限信息
     * @return
     */
    @RequestMapping(value = "/update")
    public String update() {
        shiroFilterFactoryBean.update();

        return "index";
    }



}
