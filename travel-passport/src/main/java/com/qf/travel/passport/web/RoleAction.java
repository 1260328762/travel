package com.qf.travel.passport.web;

import com.qf.travel.passport.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleAction {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/rolemanager")
    public String toRoleManager(){
        return "rolemanager";
    }


    /**
     * 返回角色列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/rolelist")
    public Map<String, Object> getRolelist(){
        return roleService.getRolelist();
    }

}
