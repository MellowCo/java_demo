<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix=""%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<a href="upload.jsp">up</a>

<form action="upload.jsp" method="post">
    用户名:<input type="text" name="uname"><br>
    密码:<input type="text" name="upwd"><br>
    <input type="submit" value="提交">
</form>

<%
    Student student = new Student(122, "li", 13);
    Student wang = new Student();
    wang.setAge(12);
    wang.setSno(122);
    wang.setName("wang");
    request.setAttribute("li1",student);
    request.setAttribute("wang1",wang);
    request.setAttribute("name1", "li");
    request.setAttribute("garde",30);
//    request.getRequestDispatcher("jstl.jsp").forward(request, response);
%>
<c:set scope="request" var="name" value="fjalksdjfklsdfj"/>





</body>
</html>
