package com.li.springboot_web.config;

import com.li.springboot_web.filter.MyFilter;
import com.li.springboot_web.listener.MyListener;
import com.li.springboot_web.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-03 14:49
 */
@Configuration
public class ServletConfig {

    @Bean
    ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new MyServlet());
        bean.setUrlMappings(Arrays.asList("/servlet"));
        return bean;
    }

    @Bean
    FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/filter"));
        return bean;
    }

    @Bean
    ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
        bean.setListener(new MyListener());
        return bean;
    }
}
