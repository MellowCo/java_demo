<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
姓名:${param.name}<br>
性别:${param.sex}<br>
Email:${param.email}<br>
电话:${param.tel}<br>
QQ号码:${param.qq}<br>
选修科目:${paramValues.subject[0]}
        ${paramValues.subject[1]}
        ${paramValues.subject[2]}
        ${paramValues.subject[3]}
        ${paramValues.subject[4]}
        ${paramValues.subject[5]}

</body>
</html>
