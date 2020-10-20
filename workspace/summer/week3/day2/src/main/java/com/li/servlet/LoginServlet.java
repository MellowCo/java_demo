// package com.li.servlet;
//
// import com.li.service.IUserService;
// import com.li.service.impl.UserServiceImpl;
//
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.io.PrintWriter;
//
// /**
//  * @author li
//  * @version 1.0
//  * @ClassName ${NAME}
//  * @date 2019/7/16 15:46
//  */
// @WebServlet("/LoginServlet")
// public class LoginServlet extends HttpServlet {
//     @Override
//     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         doGet(request, response);
//     }
//
//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         request.setCharacterEncoding("UTF-8");
//         response.setContentType("text/html;charset=UTF-8");
//         response.setCharacterEncoding("UTF-8");
//
//         String userName = request.getParameter("username");
//         String pwd = request.getParameter("pwd");
//
//         IUserService service = new UserServiceImpl();
//         int i = service.login(userName,pwd);
//
//         PrintWriter writer = response.getWriter();
//
//         if(i == -1){
//             writer.print("用户名不存在，请检查用户名");
//         }else if(i == 0){
//             writer.print("密码错误，请检查密码");
//         }else {
//             response.sendRedirect("loginSuccess.html");
//         }
//
//     }
// }
