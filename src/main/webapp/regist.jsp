<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/22
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

    <style>
        .login{
            margin-left:auto;
            margin-right:auto;
            margin-TOP:100PX;
            width:20em;
        }
    </style>

    <script type="text/javascript">
        function changeImage(img){
            img.src = img.src + "?" + new Date().getTime();
        }
    </script>
</head>
<body>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a href="${pageContext.request.contextPath}/fitting/index">家居装饰中心</a></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
        </ul>
    </div>

    <div class="login">
        <form id="form1" action="${pageContext.request.contextPath}/regist" method="post">
            <!--下面是用户名输入框-->
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">账号</span>
                <input id="userName" name="username" value="${user.username}" type="text" class="form-control" placeholder="登录账号" aria-describedby="basic-addon1">
                ${user.errors.username}<br>
            </div>
            <br>

            <!--下面是密码输入框-->
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">密码</span>
                <input id="passWord" name="password" value="${user.password}" type="text" class="form-control" placeholder="密码" aria-describedby="basic-addon1">
                ${user.errors.password}<br>
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">密码</span>
                <input id="passWord2" name="password2" type="text" class="form-control" placeholder="确认密码" aria-describedby="basic-addon1">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">昵称</span>
                <input id="nickName" name="nickname" value="${user.nickname}" type="text" class="form-control" placeholder="昵称" aria-describedby="basic-addon1">
                ${user.errors.nickname}<br>
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">邮箱</span>
                <input id="email" name="email" type="email" value="${user.email}" class="form-control" placeholder="邮箱" aria-describedby="basic-addon1">
                ${user.errors.email}<br>
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">介绍</span>
                <input id="intro" name="intro" type="text" value="${user.intro}" class="form-control" placeholder="简介" aria-describedby="basic-addon1">
                ${user.errors.intro}<br>
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">验证</span>
                <input id="checkcode" name="checkcode" type="text" class="form-control" placeholder="请输入图片中的数字" aria-describedby="basic-addon1">
                <img src="${pageContext.request.contextPath}/IdentifyCode" onclick="changeImage(this)" title="换一张" style="cursor:pointer">
                ${user.errors.checkcode}<br>
            </div>
            <br>

            <span>${msg}</span>

            <br>
            <br>
            <!--下面是登陆按钮,包括颜色控制-->
            <button type="submit" onclick="check(); return false;" style="width:280px;" class="btn btn-default">注 册</button>
        </form>

    </div>

</div>
<script>
    function check() {
        var password = document.getElementById("passWord").value;
        var password2 = document.getElementById("passWord2").value;
        if(password==password2){
            document.getElementById("form1").onsubmit();//继续提交
        }else{
            window.confirm("两次密码输入不一致！");
        }
    }
</script>
</body>
</html>
