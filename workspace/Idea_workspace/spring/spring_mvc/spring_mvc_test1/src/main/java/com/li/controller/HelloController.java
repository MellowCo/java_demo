package com.li.controller;

import com.li.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Program: spring_mvc_test1
 * @ClassName: HelloController
 * @Description: springMvc入门
 * @Author: li
 * @Create: 2019-07-21 13:13
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(value = "/hello")
    public String sayHello(String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/bean")
    public String bean(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/date")
    public String SringToDate(Date date){
        System.out.println(date);
        return "success";
    }

    @RequestMapping("/servletApi")
    public String servletApi(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(request);
        System.out.println(response);
        return "success";
    }

}
