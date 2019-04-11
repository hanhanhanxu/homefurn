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
    <script type="text/javascript">
        function changeImage(img){
            img.src = img.src + "?" + new Date().getTime();
        }
    </script>
</head>
<body>
${msg}
    <form action="${pageContext.request.contextPath}/regist" method="post">
        账号:
        <input type="text" name="username" value="${user.username}">
        ${user.errors.username}<br>
        密码:
        <input type="password" name="password" value="${user.password}">
        ${user.errors.password}<br>
        昵称:
        <input type="text" name="nickname" value="${user.nickname}">
        ${user.errors.nickname}<br>
        邮件:
        <input type="text" name="email" value="${user.email}">
        ${user.errors.email}<br>
        介绍:
        <input type="text" name="intro" value="${user.intro}"><br>
        验证:
        <input type="text" name="checkcode">
        <img src="${pageContext.request.contextPath}/IdentifyCode" onclick="changeImage(this)" title="换一张" style="cursor:pointer">
        ${user.errors.checkcode}<br>


        <button type="submit">提交</button>
    </form>
</body>
</html>
