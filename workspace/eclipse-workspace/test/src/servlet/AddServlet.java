package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	        //设置编码
			request.setCharacterEncoding("gb2312");
			response.setContentType("text/html;charset:gb2312");
			response.setCharacterEncoding("gb2312");
		
			//获取 收藏单位数组
			String[] stocks = request.getParameterValues("stock");
			
			PrintWriter out = response.getWriter();
			
			out.print("<h1>所填信息如下:</h1><br>");
			out.println("ISBN:"+request.getParameter("isbn")+"<br>");
			out.println("书名:"+request.getParameter("name")+"<br>");
			out.println("作者:"+request.getParameter("author")+"<br>");
			out.println("出版社:"+request.getParameter("publisher")+"<br>");
			out.println("出版年:"+request.getParameter("year")+"<br>");
			out.println("类别:"+request.getParameter("catagory")+"<br>");
			out.println("简述:"+request.getParameter("abstract")+"<br>");
			out.println("库存量:"+request.getParameter("amount")+"<br>");
			
			//遍历输出 数组
			out.print("收藏单位:");
			for(String stock:stocks){
				out.println(stock);
			}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	

}
