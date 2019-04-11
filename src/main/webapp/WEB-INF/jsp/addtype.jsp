<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/23
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增家居种类</title>
</head>
<body>
<h2>新增家居种类页面</h2>
<a href="${pageContext.request.contextPath}/admin/index">返回管理员主页</a>
${msg}
    <form method="post" action="${pageContext.request.contextPath}/admin/addtypeImpl">
        <input type="text" name="typeName">
        <button type="submit">提交</button>
    </form>


</body>
</html>
