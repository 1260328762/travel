package com.qf.travel.passport.dao;

import com.qf.travel.passport.pojo.po.User;

import java.util.List;

public interface UserMapper {

    User selectByUsername(String username);

    List<String> selectRolesByUsername(String username);


}
