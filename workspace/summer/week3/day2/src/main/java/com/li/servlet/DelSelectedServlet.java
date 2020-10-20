package com.li.servlet;

import com.li.service.IUserService;
import com.li.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author li
 * @version 1.0
 * @ClassName DelSelectedServlet
 * @date 2019/7/17 15:14
 */
@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService is = new UserServiceImpl();
        String[] ids = request.getParameterValues("uid");

        for (String id : ids) {
            is.delUserById(Integer.parseInt(id));
        }

        response.sendRedirect("findUserByPageServlet");
    }
}
