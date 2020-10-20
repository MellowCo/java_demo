package com.li.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Program: myssm
 * @ClassName: LoginInterceptor
 * @Description:
 * @Author: li
 * @Create: 2019-08-13 14:59
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        System.out.println("访问地址:" + url);

        if(url.indexOf("public") >= 0 || url.indexOf("static") >= 0 || url.indexOf("login")>=0){
            return true;
        }

        HttpSession session = request.getSession();

        if(session.getAttribute("email") == null){
            response.sendRedirect(request.getContextPath() + "/public/userLogin.jsp");
            return false;
        }else{
            return true;
        }
    }
}
