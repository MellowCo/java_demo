package com.li.servlet;

import com.li.dao.IUserDao;
import com.li.dao.impl.UserDaoImpl;
import com.li.entity.PageUser;
import com.li.entity.User;
import com.li.service.IUserService;
import com.li.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author li
 * @version 1.0
 * @ClassName FindUserByPageServlet
 * @date 2019/7/17 13:49
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        IUserDao dao = new UserDaoImpl();
        IUserService is = new UserServiceImpl();
        Map<String, String[]> map = request.getParameterMap();

        String oPage = request.getParameter("currentPage");
        String oPageSize = request.getParameter("rows");
        int currentPage,pageSize;

        if (oPage == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(oPage);
        }

        if (oPageSize == null) {
            pageSize = 5;
        } else {
            pageSize = Integer.parseInt(oPageSize);
        }

        List<User> users = is.pageUser((currentPage - 1) * 5, pageSize, map);
        int totalCount = dao.totalUser(map);

        PageUser<User> pu = new PageUser(currentPage, totalCount, pageSize, users);

        request.setAttribute("pb", pu);
        request.setAttribute("condition",map);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
