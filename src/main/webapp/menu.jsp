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

    <%--2205 460--%>

    <%--轮播图--%>
    <div class="layui-carousel" id="test10"><%--轮播容器--%>
        <div carousel-item="">
            <c:forEach items="${lunbopics}" var="lbpic">
                <div><img src="${pageContext.request.contextPath}/lunbotu/${lbpic.lpic}"></div>
            </c:forEach>
        </div>
    </div>




    <div class="main">
        <div class="main-nav" style="width:15%; margin-top: 35px">
            <%--条件筛选--%>
            <div>
                <ul class="layui-nav layui-nav-tree" lay-filter="test" style="margin-top: 400px">
                    <li class="layui-nav-item ">
                        <a href="javascript:;">家居风格</a>
                        <dl class="layui-nav-child">
                            <c:forEach items="${style}" var="s">
                                <dd><a href="${pageContext.request.contextPath}/fitting/selects/${s.sname}">${s.sname}</a></dd>
                            </c:forEach>
                        </dl>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;">家具种类</a>
                        <dl class="layui-nav-child">
                            <c:forEach items="${type}" var="t">
                                <dd><a href="${pageContext.request.contextPath}/fitting/selectt/${t.tname}">${t.tname}</a></dd>
                            </c:forEach>
                        </dl>
                    </li>
                </ul>
            </div>

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
                                    <span>￥:${f.fprice}</span>
                                    <div>${f.fname}</div>
                                </a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
<%--图片大小200 190--%>

        <%--热销榜--%>
        <div style="margin-left: 85%;">
            <img height="117" width="199" src="${pageContext.request.contextPath}/static/top.jpg">
            <c:forEach items="${topfittings}" var="topfitting">
                <div id="topimg" style="width: 199px;height: 117px;border-top:1px dashed #CCCCCC;overflow: hidden;">
                    <a href="${pageContext.request.contextPath}/fitting/details/${topfitting.fid}">
                        <img style="display:inline;float:left;height: 100px;width:100px;" src="${pageContext.request.contextPath}/coverimg/${topfitting.fimg}">
                        <div style="
                        border-left: 15px solid red;
                        border-right: 15px solid red;
                        border-bottom: 10px solid transparent;
                        ">
                        </div>
                        <ul>
                            <li><span style="font-size: 16px;color: #EA2000;">已售:${topfitting.fsvolume}</span></li>
                            <li><span style="font-size: 16px;color: #EA2000;">￥：${topfitting.fprice}</span></li>
                            <li style="font-size: 12px;height: 38px;">${topfitting.fname}</li>
                        </ul>
                    </a>
                </div>
            </c:forEach>
        </div>

        <%--分页--%>
        <div><%-- style="margin-top:5%" margin-top: 100px;--%>
        <ul class="pagination" style="margin-top: 100px; margin-left: 600px">
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

    <%--留言--%>
    <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/message/add" method="post">
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">留言</label>
            <div class="layui-input-block">
                <textarea name="textmessage" placeholder="感谢您的建议和意见，我们才能做的更好" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <button data-method="offset" data-type="auto" class="layui-btn" lay-submit="" lay-filter="demo2" onclick="islogin(); return false;">提 交</button>
        </div>
    </form>



</div>


<script type="text/javascript">

    /*全局搜索*/
    function search() {
        var str = document.getElementById("solrsearch").value;
        if(str.length>0)
            window.location = "${pageContext.request.contextPath}/fitting/search/"+str;
    }

    /*点击评论按钮触发，检查是否已登录*/
    function islogin(){
        if(${user.uid==null}){
            window.confirm("请先登录!");
        }else{
            document.getElementById("form1").onsubmit();//继续提交
        }
    }

</script>

<%--轮播图--%>
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //图片相关
        carousel.render({
            elem: '#test10'
            ,width: '100%'
            ,height: '400px'
            ,autoplay: 'true'
            ,interval: 4000
        });
    });

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