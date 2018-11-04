package com.qf.travel.passport.shirofilter;

import com.qf.travel.passport.pojo.po.User;
import com.qf.travel.passport.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义realm
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 每次验证权限会调用的方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("sessionUser");
        List<String> roles = userService.findRolesByUsername(user.getUsername());
        if (roles != null && roles.size() > 0) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRoles(roles);
            info.addStringPermission("user:list");
            return info;
        }
        return null;
    }


    /**
     * 登陆时会调用的方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //获取用户名
        String username = (String) authenticationToken.getPrincipal();
        //根据用户名查询信息
        User user = userService.findUserByUsername(username);

        /*
         * 一.用户名
         * 二.密码
         * 三,盐值
         * 四,ream名称
         */
        return user!=null? new SimpleAuthenticationInfo(username,user.getPassword(),
                null,getName()):null;
    }
}
