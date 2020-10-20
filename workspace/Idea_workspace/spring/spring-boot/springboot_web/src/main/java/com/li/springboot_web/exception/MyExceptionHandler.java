package com.li.springboot_web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-03 14:14
 */
@ControllerAdvice
public class MyExceptionHandler {

    // @ExceptionHandler(UserNotExistException.class)
    // @ResponseBody
    // public Map<String,Object> userNotEx(Exception e){
    //     Map<String, Object> map = new HashMap<>();
    //     map.put("code", "user.notexist");
    //     map.put("message", e.getMessage());
    //     return map;
    // }

    @ExceptionHandler(UserNotExistException.class)
    public String userNotEx2(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        //将数据保存在request域中
        request.setAttribute("ext", map);

        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        request.setAttribute("javax.servlet.error.status_code",404);
        //转发到/error
        return "forward:/error";
    }
}
