package com.li.controller;

import com.li.domain.Account;
import com.li.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * @Program: spring_mvc_test1
 * @ClassName: AnnoController
 * @Description: 测试SpringMvc常用注解
 * @Author: li
 * @Create: 2019-07-29 16:04
 */

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"user"},types = {User.class})
public class AnnoController {

    /**
     * @param
     * @Description: 测试RequestParam
     * @Author: li
     * @Create: 2019/7/29-16:06
     * @Return java.lang.String
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "username") String name, @RequestParam(name = "age",required = false) Integer age) {
        System.out.println(name + "," + age);
        return "success";
    }

    /**
     * @Description: 测试RequestBody
     * @Author: li
     * @Create: 2019/7/29-16:15
     * @param body
     * @Return java.lang.String
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    /**
     * @Description: 测试 ModelAttribute
     * @Author: li
     * @Create: 2019/7/30-15:50
     * @param account
     * @Return java.lang.String
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("li") Account account){
        System.out.println(account);
        return "success";
    }

    // //定义在方法上会在控制器的方法执行之前，先执行
    // @ModelAttribute
    // public Account showAccount(String name){
    //     //模拟数据库查询(通过name查找,返回date)
    //     Account account = new Account();
    //     account.setName(name);
    //     account.setDate(new Date());
    //     return account;
    // }

    //定义在方法上会在控制器的方法执行之前，先执行
    @ModelAttribute
    public void showAccount(String name, Map<String,Account> map){
        //模拟数据库查询(通过name查找,返回date)
        Account account = new Account();
        account.setName(name);
        account.setDate(new Date());
        map.put("li",account);
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model m){
        User user = new User("li", 12);
        m.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testSessionAttributes2")
    public String testSessionAttributes2(Model m){
        User user = new User("wang", 13);
        m.addAttribute("user2", user);
        return "success";
    }

    @RequestMapping("/getSession")
    public String getSession(ModelMap m){
        System.out.println(m.get("user"));
        return "success";
    }

    @RequestMapping("/removeSession")
    public String removeSession(ModelMap m){
        m.remove("user");
        return "success";
    }


    @RequestMapping("/delSeesion")
    public String delSeesion(SessionStatus s){
        s.setComplete();
        return "success";
    }

}
