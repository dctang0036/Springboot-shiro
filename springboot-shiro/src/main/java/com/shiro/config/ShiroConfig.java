package com.shiro.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 注入自定义的 Realm
     * @return
     */
    @Bean
    public MyShiroRealm myAuthRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        System.out.println("====myShiroRealm注册完成=====");
        return myShiroRealm;
    }

    /**
     * 注入安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        // 将自定义的realm加进来
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm());
        System.out.println("====securityManager注册完成====");
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        // 定义 shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置自定义的 securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置默认登陆的URL，身份认证失败后会访问改URL
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置认证成功之后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/success");
        // 设置未授权界面，权限认证失败后会访问改URL
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/imags/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/swagger-*/**", "anon");
        filterChainMap.put("/swagger-ui.html/**", "anon");
        // 登陆url
        filterChainMap.put("/login", "anon");

        // 以“/user/admin” 开头的用户需要身份认证，authc 表示要进行身份认证
        filterChainMap.put("/user/admin*", "authc");
        // “/user/student” 开头的用户需要角色认证，是“admin”才允许
        filterChainMap.put("/user/student*/**", "roles[admin]");
        // “/user/teacher” 开头的用户需要权限认证，是“user:create”才允许
        filterChainMap.put("/user/teacher*/**", "perms[\"user:create\"]");

        // 配置 logout 过滤器
        filterChainMap.put("/logout", "logout");

        // 设置 shiroFilterFactoryBean 的 FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        System.out.println("====shiroFilterFactoryBean注册完成====");
        return shiroFilterFactoryBean;
    }
}
