// package com.qf.travel.shiro;
//
// import com.alibaba.druid.sql.visitor.functions.If;
// import org.apache.shiro.SecurityUtils;
// import org.apache.shiro.authc.AuthenticationException;
// import org.apache.shiro.authc.UsernamePasswordToken;
// import org.apache.shiro.config.IniSecurityManagerFactory;
// import org.apache.shiro.mgt.SecurityManager;
// import org.apache.shiro.realm.jdbc.JdbcRealm;
// import org.apache.shiro.subject.Subject;
// import org.apache.shiro.util.Factory;
// import org.junit.Assert;
// import org.junit.Test;
//
// import java.util.Arrays;
//
// public class ShiorTest {
//
//     @Test
//     public void testShiro(){
//         //1.获取SecutiryManger工厂
//         Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc.ini");
//         //2,获取SecurityManager实例
//         SecurityManager securityManager = factory.getInstance();
//         //3.绑定给SecurityUtils
//         SecurityUtils.setSecurityManager(securityManager);
//         //4获取subject
//         Subject subject = SecurityUtils.getSubject();
//         //5.获取绑定用户名和密码的对象
//         UsernamePasswordToken token = new UsernamePasswordToken("jack", "123");
//         //登陆
//        // JdbcRealm
//         try {
//             subject.login(token);
//             if (subject.isAuthenticated()) {
//                 System.out.println("登录成功");
//                 //判断角色
//                 System.out.println(token.getUsername()+"是否具有admin角色:"+subject.hasRole("admin"));
//                 //判断权限
//                 System.out.println(token.getUsername()+"是否具有更新权限:"+subject.isPermitted("update"));
//
//             }
//         } catch (AuthenticationException e) {
//             //e.printStackTrace();
//             System.out.println("登录失败");
//             //身份验证失败
//         }
//     }
//
//
//     @Test
//     public void testShiro2(){
//         //1.获取SecutiryManger工厂
//         Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc.ini");
//         //2,获取SecurityManager实例
//         SecurityManager securityManager = factory.getInstance();
//         //3.绑定给SecurityUtils
//         SecurityUtils.setSecurityManager(securityManager);
//         //4获取subject
//         Subject subject = SecurityUtils.getSubject();
//         //5.获取绑定用户名和密码的对象
//         UsernamePasswordToken token = new UsernamePasswordToken("jack", "123");
//         //登陆
//         try {
//             subject.login(token);
//         } catch (AuthenticationException e) {
//             e.printStackTrace();
//             //身份验证失败
//         }
//         Assert.assertEquals(true, subject.isAuthenticated());
//         System.out.println("验证通过");
//     }
// }
