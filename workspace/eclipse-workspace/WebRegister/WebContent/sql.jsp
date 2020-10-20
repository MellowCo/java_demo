<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*,java.io.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<% 
		Connection conn=null;
		Statement s=null;
		ResultSet rs=null;
		String sql="select * from student";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC","root","123456");
			s=conn.createStatement();
			rs=s.executeQuery(sql);
			out.println("<table width='100%' border='1'>");
%>		
			<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>邮箱</td>
			<td>电话</td>
			<td>班级</td>
			<td>QQ</td>
			<td>入学年份</td>
			<td>选修科目</td>
			<td>上网地址</td>
			</tr>
		
<% 			
		while(rs.next()) {
				out.println("<tr><td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td>"+rs.getString(8)+"</td>");
				out.println("<td >"+rs.getString(9)+"</td>");
				out.println("<td >"+rs.getString(10)+"</td></tr>");
				
			}
		out.println("</table><br><a href='table.html'>返回</a>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("wewe");
			e.printStackTrace();
		}finally {
		try {
				rs.close();
				s.close();
				conn.close();
			} catch (SQLException e) {

				System.out.print(e.getMessage());
			}
		}
	 %>
	 
</body>
</html>