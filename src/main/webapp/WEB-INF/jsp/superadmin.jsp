<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/22
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>超级管理员界面</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">
            <a href="${pageContext.request.contextPath}/superadmin/logoff">
                家居装饰中心
            </a>
        </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    ROOT
                </a>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/superadmin/logoff">退出</a></li>
        </ul>
    </div>

    <div class="main-body">
        <div class="create">
            <a href="${pageContext.request.contextPath}/superadmin/createAdmin">
                <button class="layui-btn">生成子管理员账户信息</button>
            </a>
        </div>
        <br>
        <br>
        <br>
        <div class="info-form">
            <div> <h3><label>账号：</label><span>${ausername}</span></h3></div>
            <div> <h3><label>密码：</label><span>${apassword}</span></h3></div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use(['element', 'laypage', 'layer'], function () {
        var element = layui.element,
            laypage = layui.laypage,
            layer = layui.layer;
    });
</script>
</body>

</html>
