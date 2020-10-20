package com.li.springboot.tomcat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-04 16:16
 */
@Controller
public class HelloController {

    @RequestMapping("/he")
    public String hello(Model model){
        model.addAttribute("he", "hello");
        return "success";
    }
}
