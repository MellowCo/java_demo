package Servlet;

import Dao.IStudentDao;
import Dao.StudentDaoImpl;
import Entity.Paging;
import Entity.StudentEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Student/StudentPageServlet")
public class StudentPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IStudentDao studentDao = new StudentDaoImpl();
        String spageSize = request.getParameter("pageSize");
        if (spageSize == null) {
            spageSize = "2";
        }
		
        String scurrentPage = request.getParameter("currentPage");
        if (scurrentPage == null) {
            scurrentPage = "1";
        }

        int pageSize = Integer.parseInt(spageSize);
        int dataCount = studentDao.totalCount();
        int currentPage = Integer.parseInt(scurrentPage) - 1;
        List<StudentEntity> students = studentDao.pageStudent(currentPage, pageSize);
        Paging pageStudent = new Paging(dataCount, students, pageSize, currentPage);

        request.setAttribute("pageStudent", pageStudent);
        request.getRequestDispatcher("pageStudents.jsp").forward(request, response);

    }
}
