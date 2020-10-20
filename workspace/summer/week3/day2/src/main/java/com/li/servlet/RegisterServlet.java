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
 * @ClassName ${NAME}
 * @date 2019/7/16 15:10
 */
@WebServlet("/addUserServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String birthplace = request.getParameter("address");
        String qq = request.getParameter("qq");
        String email = request.getParameter("email");

        User user = new User(name, gender, age, birthplace, qq, email);

        IUserService service = new UserServiceImpl();
        service.register(user);

        response.sendRedirect("findUserByPageServlet");

    }
}
