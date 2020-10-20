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

@WebServlet("/Student/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        IStudentDao studentDao = new StudentDaoImpl();
        int sno = Integer.parseInt(request.getParameter("usno"));
        String name = request.getParameter("usname");
        String age = request.getParameter("usage");
        String sdept = request.getParameter("usdept");
        StudentEntity student = new StudentEntity(sno, name, age, sdept);

        if (studentDao.addStudent(student)) {
            request.setAttribute("error", "增加成功!!");
        } else {
            request.setAttribute("error", "增加失败!!");
        }
        request.getRequestDispatcher("StudentAllServlet").forward(request, response);
    }
}
