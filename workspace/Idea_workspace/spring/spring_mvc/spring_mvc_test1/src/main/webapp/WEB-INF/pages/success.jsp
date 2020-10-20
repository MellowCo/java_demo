<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h>入门成功</h>

<h1>request</h1><br>
${requestScope.user}-${requestScope.user2}

<h1>session</h1><br>
${sessionScope.user}-${sessionScope.user2}
</body>
</html>
