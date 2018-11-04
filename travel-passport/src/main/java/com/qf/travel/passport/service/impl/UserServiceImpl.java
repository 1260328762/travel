package com.qf.travel.passport.service.impl;

import com.qf.travel.passport.dao.UserMapper;
import com.qf.travel.passport.pojo.po.User;
import com.qf.travel.passport.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    /**
     * 验证用户登陆
     * @param username
     * @param password
     * @return
     */
    @Override
    public User doLogin(String username,String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            User user = userMapper.selectByUsername(username);
            session.setAttribute("sessionUser", user);
            return user;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return null;
        }

    }



    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findUserByUsername(String username){

        return userMapper.selectByUsername(username);
    }


    /**
     * 根据用户名查询据角色名称
     * @param username
     * @return
     */
    @Override
    public List<String> findRolesByUsername(String username) {
        return userMapper.selectRolesByUsername(username);
    }


}
