package com.qf.travel.passport.service.impl;

import com.qf.travel.passport.dao.RoleMapper;
import com.qf.travel.passport.pojo.po.Role;
import com.qf.travel.passport.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    /**
     * 获取角色列表
     * @return
     */
    @Override
    public Map<String,Object> getRolelist() {

        Map<String,Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        map.put("count", 10);
        map.put("data", roleMapper.getRoleList());

        return map;
    }


    /**
     * 根据用户名获取用户列表
     * @param username
     * @return
     */
    @Override
    public Role findByUsername(String username) {
        return roleMapper.selectByUsername(username);
    }
}
