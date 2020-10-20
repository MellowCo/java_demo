package com.li.springboot.controller;

import com.li.springboot.daomain.User;
import com.li.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-07 17:53
 */
@RestController
public class UserController {

    @Autowired
    UserMapper mapper;

    /*
     * 查询所有
     */
    @GetMapping("/user")
    public List<User> list(){
        return mapper.all();
    }

    /*
     * 插入
     */
    @PostMapping("/user")
    public User insert(User user){
        mapper.insert(user);
        return user;
    }

    @PostMapping("/url")
    public String get(){
        return "a";
    }

    @GetMapping("/url")
    public String post(String info){
        if (info.equals("a")){
            return "aa";
        }else{
            return "bb";
        }
    }


}
