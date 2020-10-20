package com.li.springboot.rabbitmq;

import com.li.springboot.rabbitmq.damain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate template;

    @Autowired
    AmqpAdmin admin;

    @Test
    public void create(){
        //创建队列
        admin.declareQueue(new Queue("admin.li",true));
        //创建转换器
        admin.declareExchange(new DirectExchange("admin.direct",true,true));
        //绑定
        admin.declareBinding(new Binding("admin.li", Binding.DestinationType.QUEUE, "admin.direct", "admin.admin", null));
    }

    @Test
    public void send(){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "消息");
        map.put("name", "li");
        map.put("list", Arrays.asList("msg", 123, true));
        //默认使用jdk序列化
        //单播
        // template.convertAndSend("exchange.direct", "li.news", map);

        //广播
        // template.convertAndSend("exchange.fanout","",map);
        template.convertAndSend("exchange.fanout","",new User("li",12));
    }


    @Test
    public void receive() {
        // Object o = template.receiveAndConvert("li.news");
        Object o2 = template.receiveAndConvert("li");
        Object o3 = template.receiveAndConvert("li.emps");
        Object o4 = template.receiveAndConvert("wang.news");
        // System.out.println(o.getClass());
        // System.out.println(o);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println(o4);
    }

}
