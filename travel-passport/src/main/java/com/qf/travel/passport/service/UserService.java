package com.qf.travel.passport.service;

import com.qf.travel.passport.pojo.po.User;

import java.util.List;

public interface UserService {

    User doLogin(String username, String password);

    User findUserByUsername(String username);

    List<String> findRolesByUsername(String username);
}
