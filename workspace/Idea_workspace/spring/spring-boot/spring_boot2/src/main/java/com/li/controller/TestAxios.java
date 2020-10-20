package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-24 13:01
 */
@Controller
public class TestAxios {


    @GetMapping("/getUrl")
    public String get(Model model){
        model.addAttribute("user","li");
        model.addAttribute("age",123);
        return "ax";
    }

}
