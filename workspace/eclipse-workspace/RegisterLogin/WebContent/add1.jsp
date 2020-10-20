<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
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
		String strName = request.getParameter("name");
		String strPassword = request.getParameter("passwd1");
		String strSex = request.getParameter("sex");
		String strEmail = request.getParameter("email");
		String strTel = request.getParameter("tel");
		String strQq = request.getParameter("qq");
		String strYear = request.getParameter("year");
		String strSubject[] = request.getParameterValues("subject");
		String strDescription = request.getParameter("description");

		Connection conn=null;
		PreparedStatement s=null;
		Statement s2=null;
		ResultSet rs=null;
		int j=-1;
			
		String sql="insert into stu(用户名,密码,性别,Email,电话,QQ,入学年份,个人简介) values(?,?,?,?,?,?,?,?)";
		String newSql="insert into sub values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC","root","123456");
			s=conn.prepareStatement(sql);
			s.setString(1, strName);
			s.setString(2, strPassword);
			s.setString(3, strSex);
			s.setString(4, strEmail);
			s.setString(5, strTel);
			s.setString(6, strQq);
			s.setString(7, strYear);
			s.setString(8, strDescription);
			int i=s.executeUpdate();
			
		if(i>0) {
			if(strSubject.length>0){
				s2=conn.createStatement();
				rs=s2.executeQuery("select 编号 from stu where 用户名='"+strName+"'");	
				if(rs.next()){
					j=rs.getInt(1);
					out.println(j);
				}
				for(int k=0;k<strSubject.length;k++){
					s=conn.prepareStatement(newSql);
					s.setInt(1,j);
					s.setString(2,strSubject[k]);
					s.executeUpdate();
				}
			}
				out.println("注册成功");
			}else{
				out.println("注册失败");
			}
		
		} catch (Exception e) {
			out.print("fas");
			e.printStackTrace();
		}finally {
		try {
		  if(rs!=null){
		        rs.close();		  
		  }
		    if(s!=null){
				s.close();  
          }
              if(s2!=null){
				s2.close();    
          }
              if(conn!=null){
				conn.close();
          }          
			} catch (SQLException e) {

				System.out.print(e.getMessage());
			}
		}
	 %>
	 
</body>
</html>

</body>
</html>
