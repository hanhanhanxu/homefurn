<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/30
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>销量排行</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/admin/index">返回管理员主页</a>
<br>
<br>
<table border="1px">
    <c:forEach var="f" items="${FittingRank}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/fitting/details/${f.fid}">${f.fname}</a></td>
            <td>${f.fprice}</td>
            <td><img style="height: 50px;width: 50px" src="${pageContext.request.contextPath}/coverimg/${f.fimg}" alt="" /></td>
            <td>${f.fsvolume}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
