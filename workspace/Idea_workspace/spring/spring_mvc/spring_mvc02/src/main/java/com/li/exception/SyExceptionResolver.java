package com.li.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Program: spring_mvc02
 * @ClassName: SyExceptionResolver
 * @Description: 异常处理类
 * @Author: li
 * @Create: 2019-08-03 17:17
 */

@Component
public class SyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        SyException e = null;

        if (ex instanceof  SyException){
            e = (SyException) ex;
        }else{
            e = new SyException("请联系管理员");
        }

        ModelAndView mv = new ModelAndView("error", "msg", e.getExceptionMsg());
        return mv;
    }
}
