<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/23
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增家居</title>
</head>
<body>
<h2>新增家居页面</h2>
<a href="${pageContext.request.contextPath}/admin/index">返回管理员主页</a>
<br><br>
    <form action="${pageContext.request.contextPath}/admin/addfittingImpl" method="post" enctype="multipart/form-data">
        名字:<input type="text" name="fname"><br><br>
        种类:
        <select name="ftype">
            <c:forEach var="t" items="${type}">
                <option value="${t.tname}">${t.tname}</option>
            </c:forEach>
        </select>

        风格:
        <select name="fstyle">
            <c:forEach var="s" items="${style}">
                <option value="${s.sname}">${s.sname}</option>
            </c:forEach>
        </select>
        <br><br>
        价格:<input type="number" name="fprice" ><br><br>

        <!--图片-->
        图片:
        <input type="file" name="preimg" >
        <img src="" height="100px">
        <!--预览图片-->
        <script type="text/javascript">
            $("[name='preimg']").change(function(){
                $(this).siblings('img').attr('src',URL.createObjectURL($(this)[0].files[0]));
            });
        </script>
        <br><br>

        详情:<textarea name="fintro" ></textarea>
        100字以内
        <br><br>

        <br>
        <button type="submit">提交</button>
    </form>
</body>
</html>