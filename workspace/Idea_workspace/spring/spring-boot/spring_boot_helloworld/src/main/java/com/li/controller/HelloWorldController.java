package com.li.controller;/**
 * @Description:
 * @Author: li
 * @Create: 2019-08-24 12:17
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Description:
 *@Author: li
 *@Create: 2019-08-24 12:17
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String Hello(){
        return "Hello World";
    }
}
