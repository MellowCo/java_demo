package com.li.servlet;

import com.li.entity.User;
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
 * @ClassName FindUserServlet
 * @date 2019/7/17 14:37
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService is = new UserServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));

        User user = is.queryUserById(id);

        request.setAttribute("user",user);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
}
