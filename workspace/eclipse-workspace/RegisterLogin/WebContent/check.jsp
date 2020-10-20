<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
if(session.getAttribute("user")==null){
%>
<script type="text/javascript">
alert("非法登陆");
window.location.href="login.htm";
</script>
<%
}
%>
</body>
</html>