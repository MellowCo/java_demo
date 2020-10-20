<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="student" class="db.dbConn" />
<% 
String strUserId=request.getParameter("userName");
String strUserPassword=request.getParameter("userPassword");
String sqlId="select * from user1 where id='"+strUserId+"'";
String sqlPassword="select * from user1 where id='"+strUserId+"'and password='"+strUserPassword+"'";
ResultSet rs=student.executeQuery(sqlId);
if(rs.next()){   
ResultSet rs1=student.executeQuery(sqlPassword);
if(rs1.next()){
session.setAttribute("user", strUserId);
response.sendRedirect("Welcome.jsp");
}else{
%>
<script>
 alert("密码错误");
 window.location.href="login.html";
</script>
<%
}
}else{
%>
<script>
 alert("用户ID不存在");
 window.location.href="login.html";
</script>
<%
}
student.free();
%>

</body>
</html>