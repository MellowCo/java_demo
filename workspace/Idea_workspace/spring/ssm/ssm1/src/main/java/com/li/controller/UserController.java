package com.li.controller;

import com.li.damain.User;
import com.li.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Program: ssm1
 * @ClassName: UserController
 * @Description:
 * @Author: li
 * @Create: 2019-08-04 16:22
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserServices services;

    @RequestMapping("/ssm")
    public ModelAndView testSSM(User user){
        services.addUser(user);
        ModelAndView view = new ModelAndView();

        System.out.println(user);

        view.setViewName("success");
        view.addObject("list", services.findAll());

        return view;
    }
}
