package com.li.springboot.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-10 11:15
 */
@Configuration
public class MyKey {

    // @Bean("myKey")
    KeyGenerator generator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + Arrays.asList(params).toString();
            }
        };
    }

}
