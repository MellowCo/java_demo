package com.li.springboot.startertest.controller;

import com.li.spring.boot.starter.autoconfigure.services.MyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-08 17:33
 */
@RestController
public class TestController {
    @Autowired
    MyServices services;

    @GetMapping("/test")
    public String test(){
        return services.say();
    }
}
