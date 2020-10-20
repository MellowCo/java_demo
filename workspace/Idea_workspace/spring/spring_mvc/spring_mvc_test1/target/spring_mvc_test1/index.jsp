<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h><a href="${pageContext.request.contextPath}/user/hello?username=li">hello</a></h>

<form action="${pageContext.request.contextPath}/user/bean" method="post">
    用户名:<input type="text" name="name"/><br>
    密码:<input type="password" name="password"/><br>
    年龄:<input type="text" name="age"/><br>
    转账用户:<input type="text" name="account.name"/><br>
    金额:<input type="text" name="account.money"/><br>
    <input type="submit" value="提交"/>
</form>

<h><a href="${pageContext.request.contextPath}/user/date?date=2019-12-18">date</a></h>
<h><a href="${pageContext.request.contextPath}/user/servletApi">servletApi</a></h>

<br>

<a href="anno.jsp">anno</a>

</body>
</html>
