<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
        out.print(error);
    }
%>
<form action="LoginServlet" method="post">
    用户名:<input type="text" name="uname"> <br>
    密码:<input type="password" name="upwd"> <br>
    <input type="submit" value="提交">
</form>


</body>
</html>
