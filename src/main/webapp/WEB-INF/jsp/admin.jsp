<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/22
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>子管理员页面</title>
    <!--bootstrap依赖-->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manage.css">
</head>


<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><span><a href="${pageContext.request.contextPath}/admin/index"></a>家居装饰后台</span></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item layui-nav-itemed"><a href="${pageContext.request.contextPath}/admin/index">家居浏览</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">家居风格</a>
                <dl class="layui-nav-child">
                    <c:forEach items="${style}" var="s">
                        <dd><a href="${pageContext.request.contextPath}/fitting/selects/${s.sname}">${s.sname}</a></dd>
                    </c:forEach>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">家居种类</a>
                <dl class="layui-nav-child">
                    <c:forEach items="${type}" var="t">
                        <dd><a href="${pageContext.request.contextPath}/fitting/selectt/${t.tname}">${t.tname}</a></dd>
                    </c:forEach>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    ${admin.ausername}
                </a>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/admin/Reception">退出</a></li>
        </ul>
    </div>

    <%--功能区--%>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item" onclick="myFunction('xiaoliang')"><a href="javascript:;">销量展示</a></li>
                <li class="layui-nav-item"><a href="javascript:;" onclick="tag('addjiaju')">新增家居</a></li>
                <li class="layui-nav-item"><a href="javascript:;" onclick="tag('addstyle')">新增风格</a></li>
                <li class="layui-nav-item"><a href="javascript:;" onclick="tag('addtype')">新增种类</a></li>
                <li class="layui-nav-item" onclick="myFunction('ordermanager')"><a href="javascript:;">订单管理</a></li>
            </ul>
        </div>
    </div>

    <%--家居展示--%>
    <div class="layui-body">
        <div class="main-contain" id="daixianshi">
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
        <div id="fenye">
            <ul class="pagination" style="margin-top: 40px; margin-left: 550px">
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



    <%--默认隐藏区域--%>
    <%--销量排行--%>
    <div id="xiaoliang" style="display:none;">
        <h3>销量展示</h3>
        <c:if test="${FittingRank!=null}">
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table">
                            <tbody>
                            <tr class="info">
                                <td>
                                    家居名称
                                </td>
                                <td>
                                    价格
                                </td>
                                <td>
                                   图片
                                </td>
                                <td>
                                    销量
                                </td>
                            </tr>
                            <c:forEach var="fi" items="${FittingRank}">
                                <tr class="warning">
                                    <td>
                                        <a href="${pageContext.request.contextPath}/fitting/details/${fi.fid}">${fi.fname}</a>
                                    </td>
                                    <td>
                                            ${fi.fprice}
                                    </td>
                                    <td>
                                        <img style="height: 50px;width: 50px" src="${pageContext.request.contextPath}/coverimg/${fi.fimg}" alt="" />
                                    </td>
                                    <td>
                                            ${fi.fsvolume}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>
        <br>
        <br>
        <c:if test="${FittingRank==null}">
            <h4>暂无销量排行，请等待用户购买或刷新网页</h4>
        </c:if>
    </div>

    <%--新增家居--%>
    <div id="addjiaju" style="display:none;">
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
    </div>

    <%--新增种类--%>
    <div id="addtype" style="display:none;">
        <form method="post" action="${pageContext.request.contextPath}/admin/addtypeImpl">
            种类:<input type="text" name="typeName">
            <button type="submit">提交</button>
        </form>
    </div>

    <%--新增风格--%>
    <div id="addstyle" style="display:none;">
        <form method="post" action="${pageContext.request.contextPath}/admin/addstyleImpl">
            风格:<input type="text" name="styleName">
            <button type="submit">提交</button>
        </form>
    </div>

    <%--订单管理--%>
    <div class="xxxx" id="ordermanager" style="display:none;">
        <h3>订单管理</h3>
        <c:if test="${pageInfoOrderVoList.list!=null}">
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table">
                            <tbody>
                            <tr class="success">
                                <td>
                                    用户
                                </td>
                                <td>
                                    时间
                                </td>
                                <td>
                                    总价
                                </td>
                                <td>
                                    详细
                                </td>
                            </tr>
                            <c:forEach items="${pageInfoOrderVoList.list}" var="orderVo">
                            <tr class="info">
                                <td>
                                        ${orderVo.username}
                                </td>
                                <td>
                                        ${orderVo.otime}
                                </td>
                                <td>
                                        ${orderVo.oprice}
                                </td>
                                <td>
                                    <table>
                                        <c:forEach items="${orderVo.orderitems}" var="orderitem">
                                        <tr>
                                            <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitem.fid}">${orderitem.fname}</td>
                                            <td>${orderitem.fprice}</td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                   <%-- <ul>
                                        <c:forEach items="${orderVo.orderitems}" var="orderitem">
                                        <li><a href="${pageContext.request.contextPath}/fitting/details/${orderitem.fid}">${orderitem.fname}</a></li>
                                        <li>${orderitem.fprice}</li>
                                        </c:forEach>
                                    </ul>--%>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:if>
        <br>
        <br>
        <c:if test="${pageInfoOrderVoList==null}">
            <h4>暂无订单，请等待用户下单或刷新网页</h4>
        </c:if>
    </div>

    <%--<div class="layui-footer">
        <!-- 底部固定区域 -->
        <div class="page" id="page">

        </div>
    </div>--%>




</div>



<script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>
<script>
    function tag(id) {
        document.getElementById("daixianshi").innerHTML = document.getElementById(id).innerHTML;

        document.getElementById("fenye").style.display="none";
        document.getElementById("contain").style.display="none";
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
        xmlhttp.open("GET",url,true);
        xmlhttp.send();
    }
    function myFunction(id) {
        var url;
        if(id=="xiaoliang"){
            url = "${pageContext.request.contextPath}/admin/fittingrank";
        }
        if(id=="ordermanager"){
            url = "${pageContext.request.contextPath}/admin/ordermanage";
        }
        loadXMLDoc(url,function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                document.getElementById("daixianshi").innerHTML = document.getElementById(id).innerHTML;

                document.getElementById("fenye").style.display="none";
                document.getElementById("contain").style.display="none";
                //document.getElementById("daixianshi").innerHTML = xmlhttp.responseText;
            }
        });
    }


</script>
<script>
    layui.use(['element', 'laypage', 'layer'], function () {
        var element = layui.element,
            laypage = layui.laypage,
            layer = layui.layer;
        //  分页
        /*laypage.render({
            elem: 'page',
            count: 70,
            jump: function (obj) {
                console.log(obj)

            }
        });*/
    });
</script>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>
