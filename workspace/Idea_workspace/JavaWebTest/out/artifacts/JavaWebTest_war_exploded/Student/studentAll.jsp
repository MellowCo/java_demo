<%@ page import="Entity.StudentEntity" %>
<%@ page import="java.util.List" %>
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
<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>分院</th>
    </tr>
    <%
        List<StudentEntity> students = (List<StudentEntity>) request.getAttribute("students");
        for (StudentEntity student : students) {
    %>
    <tr>
        <td><a href="studentBySnoServlet?sno=<%= student.getSno() %>"><%= student.getSno() %>
        </a></td>
        <td><%= student.getSname() %>
        </td>
        <td><%= student.getSage() %>
        </td>
        <td><%= student.getSdept() %>
        </td>
        <td><a href="DeleteBySnoServlet?sno=<%= student.getSno() %>">删除</a></td>
    </tr>

    <%
        }

    %>
</table>
<a href="addStudent.jsp">新增</a>
<a href="StudentPageServlet">分页</a>
</body>
</html>
