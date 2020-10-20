<%@ page import="Entity.StudentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    StudentEntity student = (StudentEntity) request.getAttribute("student");
%>
<form action="changeBySnoServlet" method="post">
    学号:<input type="text" name="usno" value="<%= student.getSno() %>"> <br>
    姓名:<input type="text" name="usname" value="<%= student.getSname() %>"> <br>
    年龄:<input type="text" name="usage" value="<%= student.getSage() %>"> <br>
    分院:<input type="text" name="usdept" value="<%= student.getSdept() %>"> <br>
    <input type="submit" value="修改">
</form>

</body>
</html>
