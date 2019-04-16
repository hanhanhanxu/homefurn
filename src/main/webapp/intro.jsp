<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/25
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>家居详情页面</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
</head>




<body>

<div class="layui-layout layui-layout-admin">

    <%--头部--%>
    <div class="layui-header">
        <div class="layui-logo">
            <c:if test="${admin!=null}"><%--返回管理员主页--%>
                <a href="${pageContext.request.contextPath}/admin/index">家居装饰中心</a>
            </c:if>
            <c:if test="${admin==null}"><%--返回前台主页--%>
                <a href="${pageContext.request.contextPath}/fitting/index">家居装饰中心</a>
            </c:if>
        </div>
        <%--<div class="input-group">
            <input id="solrsearch" name="str" type="text" class="form-control" placeholder="请输入要搜索的宝贝" aria-describedby="basic-addon1">
            <span class="input-group-addon" id="basic-addon1" onclick="search()">
                <span class="glyphicon glyphicon-search"></span>
            </span>
        </div>--%>


        <c:if test="${user.uid==null}">
            <c:if test="${admin.aid!=null}"><%--显示管理员--%>
                <ul class="layui-nav layui-layout-right">
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/admin/index">
                            管理员
                        </a>
                    </li>
                </ul>
            </c:if>
            <c:if test="${admin.aid==null}"><%--显示登陆注册--%>
                <ul class="layui-nav " lay-filter="">
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/login.jsp">登陆</a></li>
                    <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/regist.jsp">注册</a></li>
                </ul>
            </c:if>
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



    <%--家居详情展示--%>
    <div class="main-contain">
        <%--图片--%>
        <div class="main-img">
            <a href="">
                <img src="${pageContext.request.contextPath}/coverimg/${f.fimg}" alt="">
            </a>
        </div>
         <%--详细信息--%>
        <div class="main-info">
            <div class="info-top">
                <h4><b>${f.fname}</b></h4>
                <ul>
                    <li>价格:<span>${f.fprice}</span></li>
                    <li>种类:<span>${f.ftype}</span></li>
                    <li>风格:<span>${f.fstyle}</span></li>
                    <li class="details">详情:<span>${f.fintro}</span></li>
                </ul>
            </div>
            <div class="info-bottom">
                <span>销量：</span>
                <span class="number">${f.fsvolume}</span><br>
                <button onclick="islogin2('zhuangshi'); return false;" class="layui-btn" data-toggle="modal" data-target="#modal">加入我的装饰</button>
                <%--<form action="${pageContext.request.contextPath}/user/QuerySuit/${user.uid}">
                    <button type="submit" onclick="islogin(); return false;" class="layui-btn" data-toggle="modal" data-target="#modal">加入我的装饰</button>
                </form>--%>
            </div>
        </div>

            <%--显示我的装饰列表--%>
       <%-- <c:if test="${suits!=null}">--%>
        <div id="msuit" class="main-suit" style="display: none">
            <form action="${pageContext.request.contextPath}/user/addCollocation" method="post">
                <div style="padding-left: 10px">
                    <table>
                        <c:forEach items="${suits}" var="suit">
                            <tr>
                                <td>
                                <label class="radio">
                                    <input type="radio" name="sid" id="optionsRadios1" value="${suit.sid}">
                                        ${suit.sname}
                                </label>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <input type="hidden" name="fid" value="${f.fid}">
                <input type="hidden" name="fname" value="${f.fname}">
                <input type="hidden" name="fprice" value="${f.fprice}">
                <button class="layui-btn">确定</button>
                <button class="layui-btn">取消</button>
            </form>
        </div>
       <%-- </c:if>--%>




        <%--评论列表--%>
        <div class="main-bottom">
            <%--发表评论--%>
            <div class="layui-form-item">
                <label class="layui-form-label">评论：</label>
                <div class="layui-input-inline">
                    <%--发表评论输入框--%>
                    <form id="form1" method="post" action="${pageContext.request.contextPath}/user/comment">
                        <input type="text" name="content" required placeholder="请输入" autocomplete="off" class="layui-input">

                        <input type="hidden" name="fid" value="${f.fid}">
                        <input type="hidden" name="uid" value="${user.uid}">
                        <input type="hidden" name="nickname" value="${user.nickname}">
                        <button class="layui-btn" onclick="islogin(); return false;">评论</button>
                    </form>
                </div>
            </div>

            <%--显示评论--%>
            <div class="comment">
                <ul>
                    <c:forEach var="c" items="${comments}">
                        <li>
                            <span>${c.nickname}:</span>
                            <span>${c.content}</span>
                            <span>${c.ctime}</span>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

    </div>


    <%--点击 加入我的装饰--%>
    <%--<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">装饰列表</h4>
                </div>
                <div class="modal-body">
                    <ul>
                        <form action="${pageContext.request.contextPath}/user/addCollocation" method="post">
                            <c:forEach items="${suits}" var="suit">
                                <li>
                                    <span><input name="sid" type="radio" value="${suit.sid}">${suit.sname}</span>
                                </li>
                            </c:forEach>
                                <input type="hidden" name="fid" value="${f.fid}">
                                <input type="hidden" name="fname" value="${f.fname}">
                                <input type="hidden" name="fprice" value="${f.fprice}">
                                <button>确定</button><button>取消</button>
                         </form>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>--%>


</div>


<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use(['element', 'laypage', 'layer'], function () {
        var element = layui.element,
            laypage = layui.laypage,
            layer = layui.layer;
    });

    /*点击评论按钮触发，检查是否已登录*/
        function islogin(){
            if(${user.uid==null}){
                window.confirm("请先登录!");
            }else{
                document.getElementById("form1").onsubmit();//继续提交
            }
        }

        /*点击加入我的装饰时触发，检查是否已登录。是，则查询带用户的装饰*/
    function islogin2(id){
        if(${user.uid==null}){
            window.confirm("请先登录!");
        }else{
            //显示div
            document.getElementById("msuit").style = "";
        }
    }


</script>
</body>
</html>
