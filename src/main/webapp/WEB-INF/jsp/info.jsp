<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/4/14
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

    <style>
        .info{
            margin-left:auto;
            margin-right:auto;
            margin-TOP:100PX;
            width:20em;
        }
    </style>
</head>
<body>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a href="${pageContext.request.contextPath}/fitting/index">家居装饰中心</a></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="${pageContext.request.contextPath}/user/myinfo">个人中心</a>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/logoff">退出</a></li>
        </ul>
    </div>


    <div class="info">
        <form id="form1"  action="${pageContext.request.contextPath}/user/modifyInfo" method="post" class="form-userInfo">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">昵称</span>
                <input id="nickName" name="nickname" value="${user.nickname}" required type="text" class="form-control" placeholder="昵称" aria-describedby="basic-addon1">
                ${error.nickname}
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">登录账号</span>
                <input id="userName" readonly class="form-control" placeholder="${user.username}" aria-describedby="basic-addon1">
                不可修改
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">邮箱</span>
                <input id="email" name="email" type="email" class="form-control" placeholder="正确填写email才能修改密码" aria-describedby="basic-addon1">
                ${error.email}
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">新密码</span>
                <input id="password" name="password" type="password" class="form-control" placeholder="两次密码输入需一致" aria-describedby="basic-addon1">
                ${error.password}<br>
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">新密码</span>
                <input id="password2" name="password2" type="password" class="form-control" placeholder="两次密码输入需一致" aria-describedby="basic-addon1">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">介绍</span>
                <input id="message" name="intro" type="text" value="${user.intro}" class="form-control" placeholder="介绍" aria-describedby="basic-addon1">
                ${error.intro}<br>
            </div>
            <br>

            <span>${msg}</span>

            <br>
            <br>
            <!--下面是登陆按钮,包括颜色控制-->
            <button type="submit" onclick="check('${user.email}'); return false;" style="width:280px;" class="btn btn-default">确认修改</button>
        </form>

    </div>

</div>

<script>
    function check(email2) {
        var email = document.getElementById("email").value;
        var password  =document.getElementById("password").value;
        var password2  =document.getElementById("password2").value;

        //密码为空  不修改密码，修改nickname和intro
        if((password=="" && password2=="") ){
            var m = document.getElementById("message").value;
            if(m.length>128){
                alert("简介过长，请修改")
            }else{
                document.getElementById("form1").onsubmit();//继续提交
            }
        }else{//密码不全为空，修改nickname,password,intro
            if(email==email2){
                if(password==password2){
                    document.getElementById("form1").onsubmit();//继续提交
                }else{
                    window.confirm("两次密码不一致！");
                }
            }else{
                window.confirm("邮箱填写不正确！");
            }
        }
    }
</script>

</body>
</html>
