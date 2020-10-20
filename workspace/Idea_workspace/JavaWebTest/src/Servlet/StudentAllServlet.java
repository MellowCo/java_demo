package Servlet;

import Dao.IStudentDao;
import Dao.StudentDaoImpl;
import Entity.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Student/StudentAllServlet")
public class StudentAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentDao studentDao = new StudentDaoImpl();
        List<StudentEntity> students = studentDao.studentAll();
        request.setAttribute("students",students);
        request.getRequestDispatcher("studentAll.jsp").forward(request,response);
    }
}
