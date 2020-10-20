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

@WebServlet("/Student/studentBySnoServlet")
public class StudentInfoBySnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        IStudentDao studentDao = new StudentDaoImpl();
        StudentEntity student = studentDao.studentInfoBySno(sno);
        request.setAttribute("student",student);
        request.getRequestDispatcher("studentBySno.jsp").forward(request,response);
    }
}
