<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("user")!=null){
%>
<table width="100%">
<tr>
<td width="33%"></td>
<td align="center"><font color="red">欢迎</font></td>
<td align="right"><a href="Cancel.jsp">注销</a></td>
</tr>
</table>
<img src="img/bg.jpg" width="100%" height="100%" >
<%
}else{
%>
<script type="text/javascript">
 alert("非法登陆");
 window.location.href="login.html";
</script>
<%
}
 %>
</body>
</html>