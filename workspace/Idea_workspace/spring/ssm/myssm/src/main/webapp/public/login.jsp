<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>LCL后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form">
        <input id="username" name="username" placeholder="用户名" type="text" lay-verify="required" class="layui-input" value="li">
        <hr class="hr15">
        <input id="password" name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input" value="li1234">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>

    <a href="${pageContext.request.contextPath}/public/userLogin.jsp">用户登陆</a>
</div>

<script>
    $(function () {
        layui.use('form', function () {
            var form = layui.form;
            // layer.msg('玩命卖萌中', function(){
            //   //关闭后的操作
            //   });
            //监听提交
            form.on('submit(login)', function (data) {
                // alert(888)
                $.post(
                    "${pageContext.request.contextPath}/admin/login",
                    {
                        username: $("#username").val(),
                        pwd: $("#password").val()
                    }, function (result) {
                        if (result == 1) {
                            layer.msg("登陆成功", function () {
                                location.href = '${pageContext.request.contextPath}/view/index.jsp'
                            });
                        } else if (result == 0) {
                            layer.msg("用户不存在", function () {
                                location.href = '${pageContext.request.contextPath}/public/login.jsp'
                            });

                        } else {
                            layer.msg("密码错误", function () {
                                location.href = '${pageContext.request.contextPath}/public/login.jsp'
                            });
                        }
                    }
                );
                // layer.msg(JSON.stringify(data.field), function () {
                //     location.href = 'index.html'
                // });
                return false;
            });
        });
    })
</script>
<!-- 底部结束 -->
<script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>