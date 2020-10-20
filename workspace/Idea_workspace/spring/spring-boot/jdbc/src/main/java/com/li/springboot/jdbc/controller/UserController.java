package com.li.springboot.jdbc.controller;

import com.li.springboot.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-06 18:43
 */
@Controller
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/all")
    @ResponseBody
    public List<User> all(){
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
    }
}
