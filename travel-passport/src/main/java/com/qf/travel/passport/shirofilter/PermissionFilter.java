package com.qf.travel.passport.shirofilter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * 自定义权限过滤器当用户具有权限中的任何一种权限就放行
 */
public class PermissionFilter extends AuthorizationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {

        Subject subject = getSubject(servletRequest, servletResponse);

        //获取权限列表
        String[] roles = (String[]) o;
        if (roles == null || roles.length == 0) {
            return true;
        }
        //当具有权限列表中的任何一个权限就放行
        for (String role : roles) {
            if (subject.hasRole(role)) {
                return true;
            }
        }

        return false;
    }
}
