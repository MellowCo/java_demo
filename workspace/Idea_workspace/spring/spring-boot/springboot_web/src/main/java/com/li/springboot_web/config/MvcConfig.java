package com.li.springboot_web.config;

import com.li.springboot_web.component.LoginHandlerInterceptor;
import com.li.springboot_web.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-08-31 14:34
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //更改默认主页
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard.html");
    }

    @Bean
    LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**","/", "/index.html","/user/logincheck","/webjars/**");
    }
}
