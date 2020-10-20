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
 * @ClassName UpdateUserServlet
 * @date 2019/7/17 14:46
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService is = new UserServiceImpl();

        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String birthplace = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");

        User user = new User(id,name, gender, age, birthplace, qq, email);

        is.update(user);
        response.sendRedirect("findUserByPageServlet");
    }
}
