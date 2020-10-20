<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
        }

        td {
            border: red 1px solid;
        }

    </style>
</head>
<%
    int a = application.getAttribute("A") == null ? 0 : (Integer) application.getAttribute("A");
    int b = application.getAttribute("B") == null ? 0 : (Integer) application.getAttribute("B");
    int c = application.getAttribute("C") == null ? 0 : (Integer) application.getAttribute("C");
    int d = application.getAttribute("D") == null ? 0 : (Integer) application.getAttribute("D");
    int e = application.getAttribute("E") == null ? 0 : (Integer) application.getAttribute("E");
    int total = a + b + c + d + e;

    String a2;
    String b2;
    String c2;
    String d2;
    String e2;

    if (total == 0) {
        a2 = b2 = c2 = d2 = e2 = "0.0%";
    } else {
        a2 = String.format("%.1f",(float)a * 100 / total) + "%";
        b2 = String.format("%.1f",(float)b * 100 / total )+ "%";
        c2 = String.format("%.1f",(float)c * 100 / total) + "%";
        d2 = String.format("%.1f",(float)d * 100 / total) + "%";
        e2 = String.format("%.1f",(float)e * 100 / total) + "%";
    }

%>

<body>
<div align="center">
    <h1>投票结果</h1>
    <table>
        <tr>
            <td>选项一</td>
            <td>很喜欢</td>
        </tr>

        <tr>
            <td>得票率<%= a %>票(<%= a2 %>)</td>
            <td width="400px">
                <div style="background-color: #ae3dff;height: 22px;width:<%= a2 %>;"></div>
            </td>
        </tr>

        <tr>
            <td>选项二</td>
            <td>只喜欢功能</td>
        </tr>

        <tr>
            <td>得票率<%= b %>票(<%= b2 %>)</td>
            <td width="400px">
                <div style="background-color: #ae3dff;height: 22px;width:<%= b2 %>;"></div>
            </td>
        </tr>

        <tr>
            <td>选项三</td>
            <td>喜欢界面</td>
        </tr>

        <tr>
            <td>得票率<%= c %>票(<%= c2 %>)</td>
            <td width="400px">
                <div style="background-color: #ae3dff;height: 22px;width:<%= c2 %>;"></div>
            </td>
        </tr>

        <tr>
            <td>选项四</td>
            <td>想要定制界面</td>
        </tr>

        <tr>
            <td>得票率<%= d %>票(<%= d2 %>)</td>
            <td width="400px">
                <div style="background-color: #ae3dff;height: 22px;width:<%= d2 %>;"></div>
            </td>
        </tr>

        <tr>
            <td>选项五</td>
            <td>未达到我的要求</td>
        </tr>

        <tr>
            <td>得票率<%= e %>票(<%= e2 %>)</td>
            <td width="400px">
                <div style="background-color: #ae3dff;height: 22px;width:<%= e2 %>;"></div>
            </td>
        </tr>

    </table>
    <a href="vote.jsp">返回</a>

</div>


</body>

</html>
