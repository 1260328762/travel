package com.qf.travel.passport.shirofilter;


import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

/**
 * 用来动态添加验证规则的类
 */
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {

    private static final String ROLES_STRING = "roles[{0}]";

    /**
     * xml文件中配置的权限信息
     */
    private String strFilterChain;


    /**
     * 在容器启动时就开始添加权限
     * @param definitions
     */
    @Override
    public void setFilterChainDefinitions(String definitions) {
        Ini ini = new Ini();
        this.strFilterChain = definitions;
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }

        //模拟从数据库中读取数据
        //然后将对应的拦截路径和路径所需角色添加进去
        section.put("/test", MessageFormat.format(ROLES_STRING,"admin,test"));
        section.put("/menu", MessageFormat.format(ROLES_STRING,"admin"));
        this.setFilterChainDefinitionMap(section);

    }



    /**
     * 动态生成权限,不用重启服务器
     */
    public void update(){
        try {
            AbstractShiroFilter shiroFilter = (AbstractShiroFilter) this.getObject();
            PathMatchingFilterChainResolver resolver =
                    (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) resolver.getFilterChainManager();
            //清楚原来的权限信息
            manager.getFilterChains().clear();
            this.getFilterChainDefinitionMap().clear();

            //重新设置权限
            System.out.println(strFilterChain+"---------------------------------");
            this.setFilterChainDefinitions(strFilterChain);
            // Thread.sleep(5000);
            // this.setFilterChainDefinitions("/test2=authc,roles[guest]");


            Map<String, String> chains = this.getFilterChainDefinitionMap();
            if (!CollectionUtils.isEmpty(chains)) {
                Iterator var12 = chains.entrySet().iterator();
                while(var12.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry)var12.next();
                    String url = (String)entry.getKey();
                    String chainDefinition = (String)entry.getValue();
                    manager.createChain(url, chainDefinition);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

















