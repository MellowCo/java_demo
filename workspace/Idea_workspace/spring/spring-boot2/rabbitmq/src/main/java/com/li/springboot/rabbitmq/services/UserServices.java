package com.li.springboot.rabbitmq.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-13 17:23
 */
@Service
public class UserServices {

    @RabbitListener(queues = {"li.news","li.emps"})
    public void receive(Object o){
        System.out.println(o);
    }

}
