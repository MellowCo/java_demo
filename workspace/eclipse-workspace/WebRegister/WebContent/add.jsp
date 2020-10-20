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
		request.setCharacterEncoding("utf-8");
		String strid = request.getParameter("id");
		String strname = request.getParameter("name");
		String strsex = request.getParameter("sex");
		String stremail = request.getParameter("email");
		String strtel = request.getParameter("tel");
		String strclass = request.getParameter("class");
		String strqq = request.getParameter("qq");
		String stryear = request.getParameter("year");
		String strmajor[] = request.getParameterValues("major");
		String strmemo = request.getParameter("memo");
		String straddress[] = request.getParameterValues("address");

		Connection conn=null;
		PreparedStatement s=null;
		ResultSet rs=null;
		String newMajor=" ";
		String newAddress=" ";
		for(int i=0;i<strmajor.length;i++){
			newMajor=newMajor+" "+strmajor[i];
		}
		for(int i=0;i<straddress.length;i++){
			newAddress=newAddress+" "+straddress[i];
		}
		
		String sql="insert into student values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC","root","123456");
			s=conn.prepareStatement(sql);
			s.setString(1, strid);
			s.setString(2, strname);
			s.setString(3, strsex);
			s.setString(4, stremail);
			s.setString(5, strtel);
			s.setString(6, strclass);
			s.setString(7, strqq);
			s.setString(8, stryear);
			s.setString(9, newMajor);
			s.setString(10, newAddress);
			
			int i=s.executeUpdate();
		
		if(i>0) {
				out.println("注册成功"+"<br><a href='sql.jsp'>显示成员</a>");
			}else{
				out.println("注册失败");
			}
			
		} catch (Exception e) {
			out.println("false");
			e.printStackTrace();
		}
		finally {
		try {
				s.close();
				conn.close();
			} catch (SQLException e) {

				System.out.print(e.getMessage());
			}
		}
	 %>
	 
</body>
</html>