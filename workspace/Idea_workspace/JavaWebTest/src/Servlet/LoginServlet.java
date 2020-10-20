package Servlet;

import Dao.IStudentDao;
import Dao.StudentDaoImpl;
import Entity.LoginEntity;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/Login/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uname");
        String password = request.getParameter("upwd");
        LoginEntity login = new LoginEntity(name, password);
        IStudentDao studentDao = new StudentDaoImpl();
        //用户名错误
        if (studentDao.login(login)) {
            response.sendRedirect("/JavaWebTest_war_exploded/Student/StudentAllServlet");
        } else  {
            request.setAttribute("error","用户名错误!!");
            request.getRequestDispatcher("Login.jsp").forward(request,response);
        }


    }
}
