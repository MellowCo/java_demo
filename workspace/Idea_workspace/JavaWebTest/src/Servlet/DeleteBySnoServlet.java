package Servlet;

import Dao.IStudentDao;
import Dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Student/DeleteBySnoServlet")
public class DeleteBySnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sno = Integer.parseInt(request.getParameter("sno"));
        IStudentDao studentDao = new StudentDaoImpl();

        if (studentDao.deleteBySno(sno)) {
            request.setAttribute("error", "删除成功!!");
        } else {
            request.setAttribute("error", "删除失败!!");
        }
        request.getRequestDispatcher("StudentAllServlet").forward(request,response);

    }
}
