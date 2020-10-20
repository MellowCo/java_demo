package com.li.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

/**
 * @Program: spring_mvc02
 * @ClassName: NewException
 * @Description:
 * @Author: li
 * @Create: 2019-08-03 20:16
 */

@ControllerAdvice
public class NewException {

    //在注解可以写多个异常类
    @ExceptionHandler({ArrayIndexOutOfBoundsException.class, ExecutionException.class})
    public ModelAndView testE(){
        return new ModelAndView("error", "msg", "页面出现了异常");
    }

}
