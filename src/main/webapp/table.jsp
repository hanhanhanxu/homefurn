<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/5/9
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-md-6">
        <table class="table table-hover">
            <tr style="color:red">
                <th>家居名称</th>
                <th>家居价格</th>
            </tr>
            <c:forEach items="${resjiaju}" var="resf">
                <tr>
                    <td>${resf.fname }</td>
                    <td>${resf.fprice}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
