<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<jsp:useBean id="student" class="db.dbConn" scope="page"></jsp:useBean>
<body>
<%
String newPassword=request.getParameter("password1");
String newPassword2=request.getParameter("password2");
if(newPassword.equals("")){
%>
<script>
 alert("密码为空");
 window.location.href="changePass.jsp";
</script>
<%
}
if(!newPassword.equals(newPassword2)){
%>
<script>
 alert("两次密码不同");
 window.location.href="changePass.jsp";
</script>
<%
}
String user=(String)session.getAttribute("user");
String sql="update stu set 密码='"+newPassword+"' where 用户名='"+user+"'";
int i=student.executeUpdate(sql);
if(i>0){
%>
<script>
 alert("修改成功");
 window.location.href="changePass.jsp";
</script>

<%
}
%>
</body>
</html>
