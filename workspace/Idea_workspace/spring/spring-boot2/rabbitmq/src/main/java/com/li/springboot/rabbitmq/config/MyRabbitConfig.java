package com.li.springboot.rabbitmq.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-13 17:03
 */
@Configuration
public class MyRabbitConfig {

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }
}
