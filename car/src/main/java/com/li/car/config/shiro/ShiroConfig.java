package com.li.car.config.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.li.car.filter.VerfityCodeFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: shiro配置
 * @Author: li
 * @Create: 2020-03-21 14:39
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     * shiro过滤bean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("webSecurityManager") DefaultWebSecurityManager securityManager ) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filters=new HashMap<>();
        filters.put("verCode",getVerfityCodeFilter());
        factoryBean.setFilters(filters);

        //添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器：
         *      anon: 无需认证（登录）可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      roles: 该资源必须得到角色权限才可以访问
         *      logout： 退出
         */
        //设置权限
        Map<String, String> map = new HashMap<>();
        // pbulic/** 下 登录 注册不需要认证
        map.put("/public/login","verCode,anon");
        map.put("/public/**", "anon");
        // 静态资源 不需要认证
        map.put("/lib/**", "anon");
        map.put("/css/**", "anon");
        map.put("/fonts/**", "anon");
        map.put("/images/**", "anon");
        map.put("/img/**", "anon");
        map.put("/js/**", "anon");


        //设置 退出
        map.put("/logout", "logout");

        //设置角色
        map.put("/admin/**", "roles[admin]");



        //设置其他路径权限
        map.put("/**", "user");

        //设置过滤器
        factoryBean.setFilterChainDefinitionMap(map);
        //设置未认证的页面 跳转到 index.html
        factoryBean.setLoginUrl("/");
        //设置未授权的页面 跳转到 index.html
        factoryBean.setUnauthorizedUrl("/");

        return factoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "webSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联userRealm
        manager.setRealm(userRealm);
        //设置记住我
        manager.setRememberMeManager(rememberMeManager());
        return manager;
    }


    /**
     * 加密算法
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //设置加密的次数
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getUserRealm() {
        UserRealm userRealm = new UserRealm();
        //替换当前 Realm 的 credentialsMatcher 属性.
        //直接使用 HashedCredentialsMatcher 对象, 并设置加密算法即可.
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }


    /**
     2   * cookie对象;
     3   * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     4   * @return
     5  */
    @Bean
    public SimpleCookie rememberMeCookie(){
        //System.out.println("ShiroConfiguration.rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        //System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }

    /**
     * 配置验证码拦截器
     */
@Bean
public VerfityCodeFilter getVerfityCodeFilter(){
    VerfityCodeFilter vf= new VerfityCodeFilter();
    vf.setFailureKeyAttribute("shiroLoginFailure");
    vf.setJcaptchaParam("code");
    vf.setVerfitiCode(true);
    return vf;
}

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}