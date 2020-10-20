<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="TestServlet" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="uname"><br>
    密码:<input type="text" name="upwd"><br>
    文件:<input type="file" name="ufile"><br>
    <input type="submit" value="提交">
</form>
<a href="DownLoadServlet?fileName=图片.pdf">下载</a>

<%--<%--%>
    <%--String name="陶士涵";--%>
    <%--pageContext.setAttribute("name",name);--%>

    <%--Map<String,Object> map = new HashMap<>();--%>
    <%--map.put("cn","中国");--%>
    <%--map.put("us","美国");--%>
    <%--pageContext.setAttribute("m",map);--%>
    <%--response.sendRedirect("welcome.jsp");--%>
<%--%>--%>
<br>
    ${pageScope.m.cn}
    ${pageScope.m["us"]}<br>
===============<br>
${param.uname}
${param.upwd}
${pageScope.name}
${name}
-----------<br>
${param["uname"]}
${param["upwd"]}
${[name]}
+++++++++++++++++++<br>
<%
    Student person = new Student(14, "wang", 444);
    pageContext.setAttribute("person",person);
    String sname = "sno";
    pageContext.setAttribute("sname",sname);
%>


${pageScope.person.sname}<br>
${pageScope.person[sname]}

</body>
</html>
