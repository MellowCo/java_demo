package com.li.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-16 18:04
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate template;

    @GetMapping("/buy")
    public String buy() {
        //通过http实现分布式
        //url http://项目名/mapping ,返回值类型
        String s = template.getForObject("http://provider/ticket", String.class);
        return "小明刚买了" + s;
    }
}
