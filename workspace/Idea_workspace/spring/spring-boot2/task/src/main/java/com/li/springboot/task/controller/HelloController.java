package com.li.springboot.task.controller;

import com.li.springboot.task.service.AysncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-15 15:42
 */
@RestController
public class HelloController {
    @Autowired
    AysncService service;


    @GetMapping("/hello")
    public String hello() {
        service.hello();
        return "success";
    }
}
