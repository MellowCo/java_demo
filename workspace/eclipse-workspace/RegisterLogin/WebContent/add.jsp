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
		PreparedStatement s2=null;
		ResultSet rs=null;
		int j=-1;
			
		String sql="insert into stu(用户名,密码,性别,Email,电话,QQ,入学年份,个人简介) values(?,?,?,?,?,?,?,?)";
		String newSql="insert into sub values(?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC","root","123456");
			s=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
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
				out.println("注册成功"+"<br><a href='sql.jsp'>显示成员</a>");
			}else{
				out.println("注册失败");
			}
			
		if(strSubject.length>0){	
            rs=s. getGeneratedKeys();	
            if(rs.next()){
            j=rs.getInt(1);       
            }
            for(i=0;i<strSubject.length;i++){
                s2=conn.prepareStatement(newSql);
                s2.setInt(1, j);
                s2.setString(2, strSubject[i]);
                s2.executeUpdate();    
            }      
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		try {
		  if(rs!=null){
		        rs.close();		  
		  }
		    if(rs!=null){
				s.close();  
          }
              if(rs!=null){
				s2.close();    
          }
              if(rs!=null){
				conn.close();
          }          
			} catch (SQLException e) {

				System.out.print(e.getMessage());
			}
		}
	 %>
	 
</body>
</html>