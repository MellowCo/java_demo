<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="js/jquery-1.12.4.min.js"></script>

    <script>
        $(function () {
            $("#but").click(function () {
                alert("按钮点击");
                $.ajax({
                        url: "${pageContext.request.contextPath}/user/testAjax",
                        data: '{"name":"li","sex":"男","age":12}',
                        //设置发送信息至服务器时内容 json 编码 utf-8
                        contentType: "application/json;charset=UTF-8",
                        type: "post",
                        dataType: "json",
                        success: function (data) {
                            alert(data);
                            alert("name:" + data.name + ",sex:" + data.sex + ",age:" + data.age);
                        }
                    }
                );
            });

            $("#but2").click(function () {
                alert("按钮点击");

                $.post(
                    "${pageContext.request.contextPath}/user/testAjax2",
                    {
                        name:"li",
                        sex:"男",
                        age:12
                    },
                    function (data) {
                        alert("name:" + data.name + ",sex:" + data.sex + ",age:" + data.age);
                    }
                );

            });

        });
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/reString">reString</a><br>
<a href="${pageContext.request.contextPath}/user/reVoid">reVoid</a><br>
<a href="${pageContext.request.contextPath}/user/reModelAndView">reModelAndView</a><br>
<a href="${pageContext.request.contextPath}/user/forwardOrRedirect">forwardOrRedirect</a><br>

<button id="but">ajax</button>
<button id="but2">ajax2</button>
<br>

<form action="user/fileUpload" method="post" enctype="multipart/form-data">
    name: <input type="text" name="name"/><br>
    sex: <input type="text" name="sex"/><br>
    age: <input type="text" name="age"/><br>
    文件上传: <input type="file" name="upload"/><br>
    <input type="submit" value="上传">
</form>
<br>

<a href="user/testException">测试异常</a><br>
<a href="user/testExceptionHandler">测试异常2</a><br>

</body>
</html>
