package com.qf.travel.passport.dao;

import com.qf.travel.passport.pojo.po.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> getRoleList();

    Role selectByUsername(String username);


}
