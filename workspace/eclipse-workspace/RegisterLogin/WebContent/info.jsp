<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
</head>
<%@ include file="check.jsp" %>
<jsp:useBean id="student" class="db.dbConn" scope="session"></jsp:useBean>
<body>
<% 

String user=(String)session.getAttribute("user");
String sql="select * from stu where 用户名='"+user+"'";
ResultSet rs=student.executeQuery(sql);
String a[]=new String[10];
int j=2;
while(rs.next()){
	for(int i=0;i<8;i++){
	a[i]=rs.getString(j++);
}
}
%>
<table width="423" border="1" cellpadding="2" cellspacing="0" bordercolor="#FF0000" bordercolorlight="#FF0000" bordercolordark="#FFFFFF">
  <tr>
    <td width="121" bgcolor="#CCFF66"><font size="5" face="隶书">姓名:</font></td>
    <td width="288"><font size="5"><%= a[0] %></font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">性别:</font></td>
    <td><font size="5"><%= a[2] %></font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">Email:</font></td>
    <td><font size="5"><%= a[3] %></font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">电话:</font></td>
    <td><font size="5"><%= a[4] %></font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">QQ:</font></td>
    <td><font size="5"><%= a[5] %></font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">入学年份:</font></td>
    <td><font size="5"><%= a[6] %></font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">选修科目:</font></td>
    <td><font size="5">Java程序设计<br>
    操作系统<br>
    微机原理</font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">个人简介:</font></td>
    <td><font size="5"><%= a[7] %></font></td>
  </tr>
  
</table>
</body>
</html>
