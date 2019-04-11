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
    <!--引入bootstrap-->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
${msg}
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input name="username" type="text" ><br>
        <input name="password" type="password"><br>
        <button type="submit">登录</button>
    </form>
</body>
</html>
