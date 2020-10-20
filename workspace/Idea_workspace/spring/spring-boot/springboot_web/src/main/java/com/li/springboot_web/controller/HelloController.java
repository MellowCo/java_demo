package com.li.springboot_web.controller;

import com.li.springboot_web.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-08-29 16:53
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello", "1111111111");
        model.addAttribute("h1","<h1>h1</h1>");
        return "test";
    }

    @RequestMapping("/user")
    public String login(String name){
        if ("a".equals(name)){
            throw new UserNotExistException();
        }
        return "login";
    }

}
