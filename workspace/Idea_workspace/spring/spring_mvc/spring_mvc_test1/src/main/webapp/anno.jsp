<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/anno/testRequestParam?username=li">testRequestParam</a><br>

<form action="${pageContext.request.contextPath}/anno/testRequestBody" method="post">
    用户名:<input type="text" name="name"/><br>
    密码:<input type="password" name="password"/><br>
    <input type="submit" value="提交">
</form>
<br>

<form action="${pageContext.request.contextPath}/anno/testModelAttribute" method="post">
    用户名:<input type="text" name="name"/><br>
    钱:<input type="text" name="money"/><br>
    <input type="submit" value="提交">
</form>

<br>

<a href="${pageContext.request.contextPath}/anno/testSessionAttributes">testSessionAttributes</a><br>
<a href="${pageContext.request.contextPath}/anno/testSessionAttributes2">testSessionAttributes</a><br>
<a href="${pageContext.request.contextPath}/anno/getSession">getSession</a><br>
<a href="${pageContext.request.contextPath}/anno/removeSession">removeSession</a><br>
<a href="${pageContext.request.contextPath}/anno/delSeesion">delSeesion</a><br>



</body>
</html>
