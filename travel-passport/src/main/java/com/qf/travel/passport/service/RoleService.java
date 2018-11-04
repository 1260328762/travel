package com.qf.travel.passport.service;

import com.qf.travel.passport.pojo.po.Role;

import java.util.Map;

public interface RoleService {

    Map<String,Object> getRolelist();

    Role findByUsername(String username);
}
