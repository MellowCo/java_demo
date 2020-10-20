package com.li.car.controller;

import com.li.car.util.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 18:50
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String toIndex() {
        //用户
        Subject subject = SecurityUtils.getSubject();


        Utils.printMsg("IndexController->用户认证:", subject.isAuthenticated());
        Utils.printMsg("IndexController->记住我:", subject.isRemembered());

        if (subject.isAuthenticated() || subject.isRemembered()) {
            return "redirect:/user";
        }

        return "index";
    }
}
