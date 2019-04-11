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
            <%--<form method="post" action="${pageContext.request.contextPath}/fitting/search">
                <input id="searchName" name="str" type="text" class="form-control" placeholder="请输入要搜索的宝贝" aria-describedby="basic-addon1">
                <button type="submit">
                <span class="input-group-addon" id="basic-addon1">
                    <span class="glyphicon glyphicon-search"></span>
                </span>
                </button>
            </form>--%>
        </div>

        <c:if test="${user.uid==null}"><%--显示登陆注册--%>
            <ul class="layui-nav " lay-filter="">
                <li class="layui-nav-item">
                    <a data-toggle="modal" data-target="#loginModal">
                        登陆
                    </a>
                </li>
                <li class="layui-nav-item"><a data-toggle="modal" data-target="#registerModal">注册</a></li>
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



    <!-- 登录 -->
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">登录页面</h4>
                </div>

                <%--登录表单--%>
                <div class="modal-body">
                    <form class="modal-loginform" action="${pageContext.request.contextPath}/login" method="post">
                        <%--<form class="modal-loginform">--%>
                        <div class="input-group">
                                <span class="input-group-addon" id="basic-addon2">
                                        <span class="glyphicon glyphicon-user"></span>
                                </span>
                            <input id="username" name="username" type="text" required class="form-control"  placeholder="账号" aria-describedby="basic-addon2">
                        </div>
                        <div class="input-group">
                                <span class="input-group-addon" id="basic-addon3">
                                        <span class="glyphicon glyphicon-lock"></span>
                                </span>
                            <input id="password" name="password" type="password" required class="form-control"  placeholder="密码" aria-describedby="basic-addon3">
                        </div>
                        ${msg}
                        <div class="input-group">
                            <button type="submit" class="btn btn-primary">登陆</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <!-- 注册 -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">注册页面</h4>
                </div>
                <%--注册表单--%>
                <div class="modal-body">
                    <form class="modal-registerform" action="${pageContext.request.contextPath}/regist" method="post">
                        <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon2">
                                            <span class="glyphicon glyphicon-user"></span>
                                    </span>
                            <input name="username" value="${user.username}" required type="text" class="form-control"  placeholder="账号" aria-describedby="basic-addon2">
                        </div>
                        <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon3">
                                            <span class="glyphicon glyphicon-lock"></span>
                                    </span>
                            <input name="password" value="${user.password}" required type="password" class="form-control"  placeholder="密码" aria-describedby="basic-addon3">
                        </div>
                        <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon4">
                                            <span class="glyphicon glyphicon-user"></span>
                                    </span>
                            <input name="nickname" value="${user.nickname}" required type="text" class="form-control"  placeholder="昵称" aria-describedby="basic-addon4">
                        </div>
                        <div class="input-group">
                                        <span class="input-group-addon" id="basic-addon5">
                                                <span class="glyphicon glyphicon-envelope"></span>
                                        </span>
                            <input name="email" value="${user.email}" type="text" required class="form-control"  placeholder="邮箱" aria-describedby="basic-addon5">
                        </div>
                        <div class="input-group">
                            <label for="textarea">介绍：</label><br>
                            <textarea name="intro" value="${user.intro}" cols="36" rows="4"></textarea>
                        </div>
                        <div class="input-group">
                            <label for="input">验证码：</label><br>
                            <input type="text" name="checkcode">
                            <img src="${pageContext.request.contextPath}/IdentifyCode" onclick="changeImage(this)" title="换一张" style="cursor:pointer">
                            ${user.errors.checkcode}<br>
                        </div>
                        <div class="input-group">
                            <button type="submit" class="btn btn-primary">注册</button>
                        </div>

                    </form>
                </div>
            </div>
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


    var xmlhttp;
    function loadXMLDoc(url,cfunc)
    {
        if (window.XMLHttpRequest)
        {// IE7+, Firefox, Chrome, Opera, Safari 代码
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// IE6, IE5 代码
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=cfunc;
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;

        xmlhttp.open("POST",url,true);
        xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xmlhttp.send("username="+username+"&password="+password);
    }
    function loginpd() {
        var url = "${pageContext.request.contextPath}/login";
        loadXMLDoc(url,function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
            }
        });
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
