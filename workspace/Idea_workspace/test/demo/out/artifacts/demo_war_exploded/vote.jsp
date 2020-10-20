<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>投票</title>

    <style>
        .content {
            margin: 20px auto;
            background-color: #63f056;
            width: 193px;
        }

        .but {
            text-align: center;
        }


        #sub {
            background: url("images/submit.png") no-repeat;
            border: none;
            width: 54px;
            height: 20px;
        }

        #view {
            background: url("images/view.png") no-repeat;
            display: inline-block;
            border: none;
            width: 54px;
            height: 20px;
        }


    </style>
</head>
<body>
<div class="content">
    <div>
        <img src="images/title.png" alt="标题">
    </div>
    <div>
        你喜欢本网站的系统吗?
        <form action="vote.jsp" method="post">
            <input type="radio" name="select" value="A">很喜欢<br>
            <input type="radio" name="select" value="B">只喜欢功能<br>
            <input type="radio" name="select" value="C">喜欢界面<br>
            <input type="radio" name="select" value="D">想要定制界面<br>
            <input type="radio" name="select" value="E">未达到我的要求<br>
            <div class="but">
                <input type="submit" id="sub" value="">
                <input type="button" id="view" value="" onclick="window.location.href='result.jsp'">
            </div>
        </form>
    </div>
</div>
<%
    String str = request.getParameter("select");
    if ("A".equals(str)) {
        if (application.getAttribute("A") == null) {
            application.setAttribute("A", 1);
        } else {
            int i = (Integer) application.getAttribute("A");
            application.setAttribute("A", i + 1);
        }
    } else if ("B".equals(str)) {
        if (application.getAttribute("B") == null) {
            application.setAttribute("B", 1);
        } else {
            int i = (Integer) application.getAttribute("B");
            application.setAttribute("B", i + 1);
        }
    } else if ("C".equals(str)) {
        if (application.getAttribute("C") == null) {
            application.setAttribute("C", 1);
        } else {
            int i = (Integer) application.getAttribute("C");
            application.setAttribute("C", i + 1);
        }
    } else if ("D".equals(str)) {
        if (application.getAttribute("D") == null) {
            application.setAttribute("D", 1);
        } else {
            int i = (Integer) application.getAttribute("D");
            application.setAttribute("D", i + 1);
        }
    } else if ("E".equals(str)) {
        if (application.getAttribute("E") == null) {
            application.setAttribute("E", 1);
        } else {
            int i = (Integer) application.getAttribute("E");
            application.setAttribute("E", i + 1);
        }
    }
%>
</body>
</html>
