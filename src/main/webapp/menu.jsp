<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/24
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览家居页面</title>
    <!--bootstrap依赖  分页-->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
</head>




<body>

<div class="layui-layout layui-layout-admin">

    <%--头部--%>
    <div class="layui-header">
        <div class="layui-logo"><a href="${pageContext.request.contextPath}/fitting/index">家居装饰中心</a></div>
        <div class="input-group" >
            <input id="solrsearch" name="str" type="text" class="form-control" placeholder="请输入要搜索的宝贝" aria-describedby="basic-addon1">
            <span class="input-group-addon" id="basic-addon1" onclick="search()">
                <span class="glyphicon glyphicon-search"></span>
            </span>
        </div>

        <c:if test="${user.uid==null}"><%--显示登陆注册--%>
            <ul class="layui-nav " lay-filter="">
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/login.jsp" >
                        登陆
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/regist.jsp" >
                        注册
                    </a>
                </li>
            </ul>
        </c:if>
        <c:if test="${user.uid!=null}"><%--显示用户--%>
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
        </c:if>

    </div>


    <%--条件筛选--%>
    <div class="main">
        <div class="main-nav">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;">家居风格</a>
                    <dl class="layui-nav-child">
                        <c:forEach items="${style}" var="s">
                            <dd><a href="${pageContext.request.contextPath}/fitting/selects/${s.sname}">${s.sname}</a></dd>
                        </c:forEach>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">家具种类</a>
                    <dl class="layui-nav-child">
                        <c:forEach items="${type}" var="t">
                            <dd><a href="${pageContext.request.contextPath}/fitting/selectt/${t.tname}">${t.tname}</a></dd>
                        </c:forEach>
                    </dl>
                </li>
            </ul>
        </div>


        <%--家居展示--%>
        <div class="main-contain">
            <div id="contain">
                <ul>
                    <c:forEach items="${pageInfo.list}" var="f">
                        <li>
                            <div class="main-panel">
                                <a href="${pageContext.request.contextPath}/fitting/details/${f.fid}">
                                    <img style="height: 200px;width: 190px" src="${pageContext.request.contextPath}/coverimg/${f.fimg}" alt="" />
                                    <span>${f.fprice}</span>
                                    <div>${f.fname}</div>
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>


        <%--分页--%>
      <div>
        <ul class="pagination" style="margin-top: 550px; margin-left: 600px">
            <li><a href="${pageContext.request.contextPath }/fitting/fittings/1">首页</a></li>
            <c:if test="${pageInfo.hasPreviousPage }">
                <li><a href="${pageContext.request.contextPath }/fitting/fittings/${pageInfo.pageNum-1}"
                       aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                </a></li>
            </c:if>

            <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                <c:if test="${page_Num == pageInfo.pageNum }">
                    <li class="active"><a href="#">${page_Num }</a></li>
                </c:if>
                <c:if test="${page_Num != pageInfo.pageNum }">
                    <li><a href="${pageContext.request.contextPath }/fitting/fittings/${page_Num }">${page_Num }</a></li>
                </c:if>
            </c:forEach>

            <c:if test="${pageInfo.hasNextPage }">
                <li><a href="${pageContext.request.contextPath }/fitting/fittings/${pageInfo.pageNum+1 }"
                       aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a></li>
            </c:if>
            <li><a href="${pageContext.request.contextPath }/fitting/fittings/${pageInfo.pages}">末页</a></li>
        </ul>
      </div>

    </div>

</div>




<script type="text/javascript">
    <%--验证码--%>
    function changeImage(img){
        img.src = img.src + "?" + new Date().getTime();
    }

    /*全局搜索*/
    function search() {
        var str = document.getElementById("solrsearch").value;
        window.location = "${pageContext.request.contextPath}/fitting/search/"+str;
    }

</script>

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