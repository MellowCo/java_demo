package com.li.springboot.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-16 09:54
 */
@EnableWebSecurity //开启WebSecurity模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * 认证
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2", "VIP3")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder()).withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP3");
    }

    /*
     * 授权
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests()
                //允许所有用户访问"/"和"/index.html"
                .antMatchers("/", "/index.html").permitAll()
                //访问均需验证权限
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3")
                .and()
                //开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
                //设置自定义的登陆页，默认为
                // /login GET        - 登录页    /userlogin GET
                // /login POST       - 登陆认证  /userlogin POST
                // /login?error GET  - 认证失败  /userlogin?error GET
                // /login?logout GET - 退出     /userlogin?logout GET
                //重定向到/login?error表示登陆失败
                .formLogin().loginPage("/userlogin")
                //默认登陆页，用户名name为 username 密码name为 password
                .usernameParameter("user").passwordParameter("pwd")
                .and()
                //开启自动配置的注销功能。注销成功会返回 /login?logout 页面
                //设置注销成功去 "/" 主页
                //发送post请求的 /logout,注销退出
                .logout().logoutSuccessUrl("/")
                .and()
                //开启记住我功能
                //默认记住我的checkbox name为 remember-me
                .rememberMe().rememberMeParameter("remeber");
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
    }
}
