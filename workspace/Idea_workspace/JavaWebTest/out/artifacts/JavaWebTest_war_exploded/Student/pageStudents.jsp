<%@ page import="Entity.Paging" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.StudentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Paging student = (Paging) request.getAttribute("pageStudent");
    int currentPage = student.getCurrentPage();
    int pageCount = student.getPageCount();
    List<StudentEntity> students = student.getStudents();
%>
<div align="right">

    <form action="StudentPageServlet?currentPage=1" method="get">
    设置页面大小: <select name="pageSize" >
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
        <input type="submit" value="提交">
    </form>
</div>
<br>

<table border="1">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>分院</th>
    </tr>
    <%
        for (StudentEntity pStudent : students) {
    %>
    <tr>
        <td><a href="studentBySnoServlet?sno=<%= pStudent.getSno() %>"><%= pStudent.getSno() %>
        </a></td>
        <td><%= pStudent.getSname() %>
        </td>
        <td><%= pStudent.getSage() %>
        </td>
        <td><%= pStudent.getSdept() %>
        </td>
        <td><a href="deleteBySnoServlet?sno=<%= pStudent.getSno() %>">删除</a></td>
    </tr>

    <%
        }

    %>
</table>
<br>
<%
    if (currentPage == 0) {
%>
<a href="StudentPageServlet?currentPage=<%= currentPage + 2 %>">下一页</a>
<a href="StudentPageServlet?currentPage=<%= pageCount %>">尾页</a>

<%
} else if (currentPage == pageCount-1) {


%>
<a href="StudentPageServlet?currentPage=1">首页</a>
<a href="StudentPageServlet?currentPage=<%= currentPage  %>">上一页</a>
<%
    }else{
%>
<a href="StudentPageServlet?currentPage=1">首页</a>
<a href="StudentPageServlet?currentPage=<%= currentPage %>">上一页</a>
<a href="StudentPageServlet?currentPage=<%= currentPage + 2 %>">下一页</a>
<a href="StudentPageServlet?currentPage=<%= pageCount %>">尾页</a>
<%
    }
%>
<form action="StudentPageServlet" method="post">
    当前 <input type="text" name="currentPage" value="<%= currentPage+1 %>">页/<%= pageCount %>页
    <input type="submit" value="提交">
</form>

</body>
</html>
