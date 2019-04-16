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
   <%-- <style type="text/css">
        .Content-Main{
            max-width: 500px;
            margin: auto;
            border: none;
            border-radius: 5px;
            -moz-border-radius: 5px;
            -webkit-border-radius: 5px;
            font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;
            text-shadow: 1px 1px 1px #444;
            color: #D3D3D3;
            background: #555;
        }
        .Content-Main h1{
            padding: 8px 0px 40px 10px;
            display: block;
            border-bottom: 1px solid #444;
        }
        .text1{
            margin-left: 3px;
        }
        .Content-Main label{
            margin: 0px 0px 5px;
            display: block;
        }
        .fileInputContainer{
            height: 99px;
            width: 99px;
            margin: 20px 20px 20px 20px ;
            border: none;
            background: url("img/Example.jpg");
            overflow: hidden;
            position: relative;
        }
        .fileInput{
            height: 106px;
            border: none;
            font-size: 300px;
            opacity: 0;
            filter:alpha(opacity=0);
            cursor: pointer;
            position: absolute;
        }
        .Content-Main label>span{
            width: 20%;
            float: left;
            text-align: right;
            padding-right: 10px;
            margin-top: 10px;
            font-weight: bold;
        }
        .Main-sex{
            padding-right: 13px;
            padding-bottom: 13px;
            font-weight: bold;
            line-height: 4px;
        }
        .Main-sex input[type=checkbox]{
            margin-top:6px;
            vertical-align:middle;
        }
        .Content-Main input[type="text"],.Content-Main input[type="email"],.Content-Main textarea{
            height: 25px;
            width: 70%;
            line-height: 15px;
            padding: 5px 0px 5px 5px;
            margin-bottom: 16px;
            margin-right: 6px;
            margin-top: 2px;
            border: none;
            border-radius:2px;
            -webkit-border-radius:2px;
            -moz-border-radius:2px;
            outline: 0 none;
            background:  #DFDFDF;
            color: #525252;
        }
        .Content-Main textarea{
            height: 100px;
            width: 70%;
            padding: 5px 0px 0px 5px;
        }
        .Content-Main .button{
            padding: 8px 24px 8px 24px;
            margin-bottom: 8px;
            border: none;
            border-radius: 4px;
            -moz-border-radius: 4px;
            -webkit-border-radius: 4px;
            font-weight: bold;
            text-shadow: 1px 1px 1px #FFE477;
            box-shadow: 1px 1px 1px  #3D3D3D;
            -moz-box-shadow: 1px 1px 1px  #3D3D3D;
            -webkit-box-shadow: 1px 1px 1px  #3D3D3D;
            color: #585858;
            background: #f6ff0a;
        }
        .Content-Main .button:hover{
            color:  #333;
            background-color:  #EBEBEB ;
        }
    </style>--%>

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
                <a href="javascript:;">
                    ${user.nickname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/user/myinfo">个人中心</a></dd>
                </dl>
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


    <%--<div class="Content-Main">
        <form id="form1"  action="${pageContext.request.contextPath}/user/modifyInfo" method="post" class="form-userInfo">
            <h1>修改个人信息</h1>
            <label>
                <span>昵称:</span>
                <input type="text"  name="nickname" value="${user.nickname}" required>
                ${error.nickname}
            </label>
            <label>
                <span>登录账号:</span>
                <input type="text"  name="username" placeholder="${user.username} 不可修改" readonly>
            </label>
            <label>
                <span>邮箱:</span>
                <input id="email" type="email" name="email" placeholder="正确填写email才能修改密码">
                ${error.email}
            </label>
            <label>
                <span>新密码:</span>
                <input id="password" type="text"  name="password" placeholder="两次密码输入需一致">
                <br>${error.password}
            </label>
            <label>
                <span>确认新密码:</span>
                <input id="password2" type="text"  name="password2" placeholder="两次密码输入需一致">
            </label>
            <label>
                <span>简介:</span>
                <textarea id="message" name="intro">${user.intro}</textarea>
            </label>
            <label>
                <button class="button"  onclick="check('${user.email}'); return false;" >提交</button>
            </label>
        </form>
    </div>--%>

</div>

<script>
    function check(email2) {
        var email = document.getElementById("email").value;
        var password  =document.getElementById("password").value;
        var password2  =document.getElementById("password2").value;

        //密码为空  不修改密码，修改nickname和intro
        if((password=="" && password2=="") ){
            document.getElementById("form1").onsubmit();//继续提交
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
