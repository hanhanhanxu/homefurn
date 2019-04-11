<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/30
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/admin/index">返回管理员主页</a>
<br>
<br>
<%--订单展示--%>
<table border="1px">
    <tr>
        <td>订单用户</td>
        <td>订单时间</td>
        <td>订单总价</td>
    </tr>
    <c:forEach items="${pageInfoOrderVoList.list}" var="orderVo">
        <tr>
            <td>${orderVo.uid}</td>
            <td>${orderVo.otime}</td>
            <td>${orderVo.oprice}</td>
            <td>
                <ul>
                    <c:forEach items="${orderVo.orderitems}" var="orderitem">
                        <li><a href="${pageContext.request.contextPath}/fitting/details/${orderitem.fid}">${orderitem.fname}</a></li>
                        <li>${orderitem.fprice}</li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
