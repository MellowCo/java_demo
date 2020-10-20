<%@ page import="entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Student person = new Student(14, "wang", 444);
    pageContext.setAttribute("person",person);

%>
+++++++++++++++++++++++++++++++<br>
<c:set var="sum" value="0" />
<c:forEach var="i" begin="1" end="10">
    <c:set var="sum" value="${sum + i}" />
</c:forEach>
<c:out value="sum = ${sum }"/>

<c:set var="sum" value="0" />
<c:forEach  var="i" begin="1" end="10" step ="2">
    <c:set var="sum" value="${sum + i}" />
</c:forEach>
<c:out value="sum = ${sum }"/>
——————————————————————————<br>
<c:set var="grade1" value="${requestScope.garde}"/>
${requestScope.garde}<br>
<c:out value="${grade1}"/>
<c:choose>
    <c:when test="${grade1>90}">a</c:when>
    <c:when test="${grade1>80}">b</c:when>
    <c:when test="${grade1>70}">c</c:when>
    <c:otherwise>e</c:otherwise>
</c:choose>
++++++++++++++++<br>
<c:set var="sname" value="sno" scope="page"/>
${person.sno}<br>
${person["sno"]}<br>
${person[sname]}<br>
${person.sno}<br>


</body>
</html>
