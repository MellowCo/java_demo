<%@ page language="java" contentType="text/html; charset=utf-8" import="java.sql.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="student" class="db.dbConn" scope="session"></jsp:useBean>
<% 
String strUserName=request.getParameter("username");
String strUserPassword=request.getParameter("password");
String sqlId="select * from stu where 用户名='"+strUserName+"'";
String sqlPassword="select * from stu where 用户名='"+strUserName+"'and 密码='"+strUserPassword+"'";
ResultSet rs=student.executeQuery(sqlId);
if(rs.next()){   
ResultSet rs1=student.executeQuery(sqlPassword);
if(rs1.next()){
session.setAttribute("user", strUserName);
response.sendRedirect("index2.html");
}else{
%>
<script>
 alert("密码错误");
 window.location.href="login.htm";
</script>
<%
}
}else{
%>
<script>
 alert("用户ID不存在");
 window.location.href="login.htm";
</script>
<%
}
student.free();
%>

</body>
</html>