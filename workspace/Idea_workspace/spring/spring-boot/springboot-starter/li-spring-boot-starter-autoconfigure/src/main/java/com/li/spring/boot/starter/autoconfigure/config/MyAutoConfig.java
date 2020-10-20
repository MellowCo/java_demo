package com.li.spring.boot.starter.autoconfigure.config;

import com.li.spring.boot.starter.autoconfigure.properties.MyProperties;
import com.li.spring.boot.starter.autoconfigure.services.MyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-08 17:20
 */
@Configuration
//使MyProperties生效
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfig {
    @Autowired
    MyProperties properties;

    @Bean
    MyServices services(){
        return new MyServices(properties);
    }

}
