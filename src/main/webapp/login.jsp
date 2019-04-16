<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/22
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
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
</head>
<body>
<%--
${msg}
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input name="username" type="text" ><br>
        <input name="password" type="password"><br>
        <button type="submit">登录</button>
    </form>--%>



<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a href="${pageContext.request.contextPath}/fitting/index">家居装饰中心</a></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/regist.jsp">注册</a></li>
        </ul>
    </div>

    <div class="login">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <!--下面是用户名输入框-->
            <div class="input-group">
               <%-- <span class="input-group-addon" id="basic-addon1">@</span>--%>
                <span class="input-group-addon" id="basic-addon2">
                        <span class="glyphicon glyphicon-user"></span>
                </span>
                <input id="userName" name="username" value="${user.username}" type="text" required class="form-control" placeholder="登录账号" aria-describedby="basic-addon1">
            </div>
            <br>

            <!--下面是密码输入框-->
            <div class="input-group">
                <%--<span class="input-group-addon" id="basic-addon1">@</span>--%>
                <span class="input-group-addon" id="basic-addon3">
                        <span class="glyphicon glyphicon-lock"></span>
                </span>
                <input id="passWord" name="password" value="${user.password}" type="password" required class="form-control" placeholder="密码" aria-describedby="basic-addon1">
            </div>
            <br>

            <span>${msg}</span>

            <br>
            <br>
            <!--下面是登陆按钮,包括颜色控制-->
            <button type="submit" style="width:280px;" class="btn btn-default">登 录</button>
        </form>

    </div>

</div>

</body>
</html>
