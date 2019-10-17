<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/4/27
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>管理员界面</title>
    <%--bootstrap依赖 分页栏--%>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <%--引入layui依赖--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/manage.css">

</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" onclick="index()">家居装饰中心</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a onclick="index()">家居浏览</a></li>
            <li class="layui-nav-item"><a onclick="tag('addjiaju')">新增家具</a></li>
            <li class="layui-nav-item"><a onclick="tag('addstyle')">新增风格</a></li>
            <li class="layui-nav-item"><a onclick="tag('addtype')">新增种类</a></li>
            <li class="layui-nav-item"><a onclick="tag('lookmessage')">查看留言</a></li>
            <li class="layui-nav-item"><a onclick="tag('orderDaifahuo')">待发货订单</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a onclick="index()">
                    ${admin.ausername}
                </a>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/admin/Reception">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">家居管理</a>
                    <dl class="layui-nav-child">
                        <%--<dd><a  onclick="tag('lookjiaju')">查找</a></dd>--%>
                        <dd><a  onclick="tag('addjiaju')">新增</a></dd>
                        <dd><a onclick="tag('lowerjiaju')">下架</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">风格管理</a>
                    <dl class="layui-nav-child">
                        <dd><a onclick="tag('lookstyle')">查看/删除</a></dd>
                        <dd><a onclick="tag('addstyle')">新增</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">种类管理</a>
                    <dl class="layui-nav-child">
                        <dd><a onclick="tag('looktype')">查看/删除</a></dd>
                        <dd><a onclick="tag('addtype')">新增</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">订单管理</a>
                    <dl class="layui-nav-child">
                        <dd><a onclick="tag('ordermanager')">查看全部</a></dd>
                        <dd><a onclick="tag('orderDaifahuo')">待发货</a></dd>
                        <dd><a onclick="tag('orderYifahuo')">已发货</a></dd>
                        <dd><a onclick="tag('orderYishouhuo')">已收货</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item ">
                    <a class="" href="javascript:;">轮播图管理</a>
                    <dl class="layui-nav-child">
                        <dd><a onclick="tag('looklunbotu')">查看/删除</a></dd>
                        <dd><a onclick="tag('addlunbotu')">新增</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" ><a onclick="tag('lookmessage')">查看留言</a></li>
                <li class="layui-nav-item" ><a onclick="tag('xiaoliang')">销量展示</a></li>
            </ul>
        </div>
    </div>

    <%--<div class="layui-body">
        <div style="padding: 15px;">
        内容主体区域
        </div>
    </div>--%>

    <%--内容主体部分 点击不同按钮分别展示不同东西 默认显示家居浏览--%>
    <div class="layui-body">

        <%--家居浏览  进来的默认显示主体内容--%>
        <div id="jiajuzhanshi">
            <%--家居展示--%>
            <div id="jiaju" class="main-contain">
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

        <%--家居管理--%>
        <%--下架家居--%>
            <div id="lowerjiaju" style="display: none">
                <%--列表展示--%>
                <div id="jiaju" class="main-contain">
                    <div id="contain2">
                        <ul>
                            <c:forEach items="${pageInfo.list}" var="f">
                                <li>
                                    <div class="main-panel">
                                        <a href="${pageContext.request.contextPath}/fitting/details/${f.fid}">
                                            <img style="height: 200px;width: 190px" src="${pageContext.request.contextPath}/coverimg/${f.fimg}" alt="" />
                                            <span>${f.fprice}</span>
                                            <div>
                                                ${f.fname}
                                            </div>
                                        </a>
                                        <button onclick="deletefitting('${f.fid}')" class="layui-btn layui-btn-xs layui-btn-normal">下 架</button>
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
        <%--查询家居--%>
        <div id="lookjiaju" style="display: none">
            <%--搜索框--%>
            <div class="layui-input-block" style="align: center">
                <form id="lookjiajuform" onsubmit="return false;" action="##" method="post">
                    <div class="layui-col-md2">
                        <input type="text" id="query" name="q" required lay-verify="required" placeholder="输入关键字" class="layui-input">
                    </div>
                    <div class="layui-col-md1">
                        <button id="btn2"  class="layui-btn" onclick="selectFname();selectFname2();"> 搜 索  </button>
                    </div>
                </form>
                <%--<form id="lookjiajuform" action="${pageContext.request.contextPath}/admin/lookfitting" method="post">
                    <div class="layui-col-md2">
                        <input type="text" id="query" name="q" required lay-verify="required" placeholder="输入关键字" class="layui-input">
                    </div>
                    <div class="layui-col-md1">
                        <button id="btn2"  class="layui-btn" onclick="selectFname2()"> 搜 索  </button>
                    </div>
                </form>--%>
            </div>
            <br>
            <%--显示查询结果区域--%>
            <div id="lookjiaju_res" style="display: none">
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
            </div>
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
                库存:<input type="number" required name="fsnum" value="1000">
                <br><br>
                <br>
                <button type="submit">提交</button>
            </form>
        </div>


        <%--种类管理--%>
        <%--查看种类 删除种类--%>
        <div id="looktype" class="layui-input-block" style="display: none">
            <h3>种类列表</h3>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr style="color:red">
                            <th>种类</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${type}" var="t">
                            <tr>
                                <c:if test="${t.tname!='全部' }">
                                    <th>${t.tname }</th>
                                    <th>
                                        <a onclick="deletetype('${t.tid}','${t.tname}')">删除</a>
                                    </th>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <%--新增种类--%>
        <div id="addtype" class="xinfo" style="display:none;">
            <form action="${pageContext.request.contextPath}/admin/addtypeImpl" method="post" class="form-userInfo">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">种类</span>
                    <input name="typeName" required type="text" class="form-control" placeholder="种类名称" aria-describedby="basic-addon1">
                </div>
                <br>
                <button type="submit" class="btn btn-default">提 交</button>
            </form>
        </div>


        <%--风格管理--%>
        <%--查看风格 删除风格--%>
        <div id="lookstyle" class="layui-input-block" style="display: none">
            <h3>风格列表</h3>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr style="color:red">
                            <th>风格</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${style}" var="s">
                            <tr>
                                <c:if test="${s.sname!='全部' }">
                                    <th>${s.sname } </th>
                                    <th>
                                        <a onclick="deletestyle('${s.sid}','${s.sname}')">删除</a>
                                    </th>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <%--新增风格--%>
        <div id="addstyle" class="xinfo" style="display:none;">
            <form action="${pageContext.request.contextPath}/admin/addstyleImpl" method="post" class="form-userInfo">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">风格</span>
                    <input name="styleName" required type="text" class="form-control" placeholder="风格名称" aria-describedby="basic-addon1">
                </div>
                <br>
                <button type="submit" class="btn btn-default">提 交</button>
            </form>
        </div>


        <%--订单管理--%>
        <%--查看订单--%>
        <div id="ordermanager" class="xxxx" style="display:none;">
            <h3>全部订单</h3>
            <table class="layui-table" lay-skin="line" style="table-layout:fixed;">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>总价</th>
                    <th>下单时间</th>
                    <th>订单状态</th>
                    <th>
                        详细
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfoOrderinfoVoList.list}" var="orderinfoVo">
                    <tr><%--class="info"--%>
                        <td style="word-wrap:break-word;">
                                ${orderinfoVo.orderinfo.ofserial}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rname}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rtel}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofaddress}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofprice}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.stroftime}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofstate}
                        </td>
                        <td>
                            <table>
                                <c:forEach items="${orderinfoVo.orderitemsList}" var="orderitems">
                                    <tr>
                                        <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitems.fid}">${orderitems.fname}</td>
                                        <td>${orderitems.fprice}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br><br>
        </div>
        <%--待发货订单--%>
        <div id="orderDaifahuo" class="xxxx" style="display: none"><%--layui-input-block--%>
            <h3>待发货订单</h3>
            <table class="layui-table" lay-skin="line" style="table-layout:fixed;">
                <colgroup>
                    <%--<col width="150">--%>
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col>
                </colgroup>
                <thead>
                <tr>
                   <%-- <th>操作</th>--%>
                    <th>订单号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>总价</th>
                    <th>下单时间</th>
                    <th>订单状态</th>
                    <th>详细</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfoOrderinfoVoList2.list}" var="orderinfoVo">
                    <tr>
                       <%-- <td>
                            <form action="${pageContext.request.contextPath}/admin/order" method="post">
                                <input type="hidden" name="ofid" value="${orderinfoVo.orderinfo.ofid}">
                                <button type="submit">发 货</button>
                            </form>
                        </td>--%>
                        <td style="word-wrap:break-word;">
                                ${orderinfoVo.orderinfo.ofserial}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rname}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rtel}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofaddress}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofprice}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.stroftime}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofstate}
                                <form action="${pageContext.request.contextPath}/admin/order" method="post">
                                    <input type="hidden" name="ofid" value="${orderinfoVo.orderinfo.ofid}">
                                    <button type="submit">发 货</button>
                                </form>
                        </td>
                        <td>
                            <table>
                                <c:forEach items="${orderinfoVo.orderitemsList}" var="orderitems">
                                    <tr>
                                        <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitems.fid}">${orderitems.fname}</td>
                                        <td>${orderitems.fprice}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%--<div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr style="color:red">
                            <th width="50">订单号</th>
                            <th>收货人姓名</th>
                            <th>电话</th>
                            <th>收货地址</th>
                            <th>总价</th>
                            <th>下单时间</th>
                            <th>订单状态</th>
                            <th>详细</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${pageInfoOrderinfoVoList2.list}" var="orderinfoVo">
                        <tr>
                            <th>
                                    ${orderinfoVo.orderinfo.ofserial}
                            </th>
                            <th>
                                    ${orderinfoVo.orderinfo.rname}
                            </th>
                            <th>
                                    ${orderinfoVo.orderinfo.rtel}
                            </th>
                            <th>
                                    ${orderinfoVo.orderinfo.ofaddress}
                            </th>
                            <th>
                                    ${orderinfoVo.orderinfo.ofprice}
                            </th>
                            <th>
                                    ${orderinfoVo.orderinfo.stroftime}
                            </th>
                            <th>
                                    ${orderinfoVo.orderinfo.ofstate}
                            </th>
                            <th>
                                <table>
                                    <c:forEach items="${orderinfoVo.orderitemsList}" var="orderitems">
                                        <tr>
                                            <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitems.fid}">${orderitems.fname}</td>
                                            <td>${orderitems.fprice}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </th>
                            <th>
                                <form action="${pageContext.request.contextPath}/admin/order" method="post">
                                    <input type="hidden" name="ofid" value="${orderinfoVo.orderinfo.ofid}">
                                    <button type="submit">发 货</button>
                                </form>
                                &lt;%&ndash;<a onclick="">发货</a>&ndash;%&gt;
                            </th>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>--%>
        </div>
        <%--已发货订单--%>
        <div id="orderYifahuo" class="xxxx" style="display: none"><%--layui-input-block--%>
            <h3>已发货订单</h3>
            <table class="layui-table" lay-skin="line" style="table-layout:fixed;">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>总价</th>
                    <th>下单时间</th>
                    <th>订单状态</th>
                    <th>
                        详细
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfoOrderinfoVoList3.list}" var="orderinfoVo">
                    <tr>
                        <td style="word-wrap:break-word;">
                                ${orderinfoVo.orderinfo.ofserial}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rname}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rtel}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofaddress}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofprice}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.stroftime}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofstate}
                        </td>
                        <td>
                            <table>
                                <c:forEach items="${orderinfoVo.orderitemsList}" var="orderitems">
                                    <tr>
                                        <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitems.fid}">${orderitems.fname}</td>
                                        <td>${orderitems.fprice}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%--<div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr style="color:red">
                            <th width="50">订单号</th>
                            <th>收货人姓名</th>
                            <th>电话</th>
                            <th>收货地址</th>
                            <th>总价</th>
                            <th>下单时间</th>
                            <th>订单状态</th>
                            <th>详细</th>
                        </tr>
                        <c:forEach items="${pageInfoOrderinfoVoList3.list}" var="orderinfoVo">
                            <tr>
                                <th>
                                        ${orderinfoVo.orderinfo.ofserial}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.rname}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.rtel}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.ofaddress}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.ofprice}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.stroftime}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.ofstate}
                                </th>
                                <td>
                                    <table>
                                        <c:forEach items="${orderinfoVo.orderitemsList}" var="orderitems">
                                            <tr>
                                                <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitems.fid}">${orderitems.fname}</td>
                                                <td>${orderitems.fprice}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>--%>
        </div>
        <%--已收货订单--%>
        <div id="orderYishouhuo" class="xxxx" style="display: none"><%--layui-input-block--%>
            <h3>已收货订单</h3>
            <table class="layui-table" lay-skin="line" style="table-layout:fixed;">
                <colgroup>
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col width="150">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>地址</th>
                    <th>总价</th>
                    <th>下单时间</th>
                    <th>订单状态</th>
                    <th>
                        详细
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pageInfoOrderinfoVoList4.list}" var="orderinfoVo">
                    <tr>
                        <td style="word-wrap:break-word;">
                                ${orderinfoVo.orderinfo.ofserial}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rname}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.rtel}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofaddress}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofprice}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.stroftime}
                        </td>
                        <td>
                                ${orderinfoVo.orderinfo.ofstate}
                        </td>
                        <td>
                            <table>
                                <c:forEach items="${orderinfoVo.orderitemsList}" var="orderitems">
                                    <tr>
                                        <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitems.fid}">${orderitems.fname}</td>
                                        <td>${orderitems.fprice}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%--<div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr style="color:red">
                            <th width="50">订单号</th>
                            <th>收货人姓名</th>
                            <th>电话</th>
                            <th>收货地址</th>
                            <th>总价</th>
                            <th>下单时间</th>
                            <th>订单状态</th>
                            <th>详细</th>
                        </tr>
                        <c:forEach items="${pageInfoOrderinfoVoList4.list}" var="orderinfoVo">
                            <tr>
                                <th>
                                        ${orderinfoVo.orderinfo.ofserial}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.rname}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.rtel}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.ofaddress}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.ofprice}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.stroftime}
                                </th>
                                <th>
                                        ${orderinfoVo.orderinfo.ofstate}
                                </th>
                                <td>
                                    <table>
                                        <c:forEach items="${orderinfoVo.orderitemsList}" var="orderitems">
                                            <tr>
                                                <td><a href="${pageContext.request.contextPath}/fitting/details/${orderitems.fid}">${orderitems.fname}</td>
                                                <td>${orderitems.fprice}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>--%>
        </div>

        <%--轮播图管理--%>
        <div id="looklunbotu" style="display:none;">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr style="color:red">
                            <th>轮播图</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${lunbo}" var="lb">
                            <tr>
                                <th><img style="width: 100px;height: auto" src="${pageContext.request.contextPath}/lunbotu/${lb.lpic}"></th>
                                <th><a onclick="deletelunbo('${lb.lid}')">删除</a></th>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div id="addlunbotu" style="display:none;">
            <h3>第一张</h3>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test1" value="1">上传图片</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo1" style="width: 100px;height: 100px">
                    <p id="demoText"></p>
                </div>
            </div>
            <h3>第二张</h3>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test2" value="2">上传图片</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo2" style="width: 100px;height: 100px">
                    <p id="demoText2"></p>
                </div>
            </div>
            <h3>第三张</h3>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test3" value="3">上传图片</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo3" style="width: 100px;height: 100px">
                    <p id="demoText3"></p>
                </div>
            </div>
        </div>

        <%--留言管理 查看留言--%>
        <div id="lookmessage" style="display: none">
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table">
                            <tbody>
                            <tr class="success">
                                <td>
                                    用户id
                                </td>
                                <td>
                                    用户昵称
                                </td>
                                <td>
                                    留言内容
                                </td>
                                <td>
                                    留言时间
                                </td>
                            </tr>
                            <c:forEach items="${Messages.list}" var="message">
                                <tr class="info">
                                    <td>
                                            ${message.uid}
                                    </td>
                                    <td>
                                            ${message.nickname}
                                    </td>
                                    <td>
                                            ${message.message}
                                    </td>
                                    <td>
                                            ${message.stime}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <%--销量排行--%>
        <div id="xiaoliang" style="display:none;">
            <h3>销量展示</h3>
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
                                            ￥:${fi.fprice}
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
        </div>

    </div>
    <%--内容主体区域结束--%>


    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>

<script src="${pageContext.request.contextPath}/layui/layui.js"></script>

<%--搜索家居--%>
<script>
    function selectFname2() {
        window.location.reload();
       /* document.getElementById("lookjiaju_res").style.display = "";
        document.getElementById("jiajuzhanshi").style.display="none";*/
    }
    function selectFname() {
        $.ajax({
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "${pageContext.request.contextPath}/admin/lookfitting" ,
            data: $('#lookjiajuform').serialize(),
            async:"true",
            success:function (data) {
                if(data.resCode==200){
                    document.getElementById("lookjiaju_res").style.display = "";
                }
            },
        });
    }
</script>

<%--删除风格、种类--%>
<script type="text/javascript">
    function deletetype(tid,tname){
        var b=window.confirm("确定完全删除该种类？");
        if(tname!="全部")
        if(b){
            window.location="${pageContext.request.contextPath }/admin/deletetype/"+tid;
        }
    }
    function deletestyle(sid,sname){
        var b=window.confirm("确定完全删除该风格？");
        if(sname!="全部")
        if(b){
            window.location="${pageContext.request.contextPath }/admin/deletestyle/"+sid;
        }
    }
</script>
<script>
    /*下架商品*/
    function deletefitting(fid) {
        var b=window.confirm("确定下架商品？");
        if(b){
            window.location="${pageContext.request.contextPath }/admin/deletefitting/"+fid;
        }
    }
</script>

<!--轮播图管理 上传图片 -->
<script>
    function deletelunbo(lid) {
        var b=window.confirm("确定删除该轮播图？");
        if(b){
            window.location="${pageContext.request.contextPath }/admin/lunbo/del/"+lid;
        }
    }
</script>
<script>
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传1
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '${pageContext.request.contextPath}/admin/lunbo/add'
            ,data: { num: 1
                }
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,size: '1024*5'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(json){
                //如果上传失败
                if(json.code == 0){
                    return layer.msg('上传失败!');
                }
                //上传成功
                if(json.code > 0){
                    return layer.msg('上传成功!');
                }
            }
        });
        //普通图片上传2
        var uploadInst2 = upload.render({
            elem: '#test2'
            ,url: '${pageContext.request.contextPath}/admin/lunbo/add'
            ,data: { num: 2
            }
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,size: '1024*5'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo2').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(json){
                //如果上传失败
                if(json.code == 0){
                    return layer.msg('上传失败!');
                }
                //上传成功
                if(json.code > 0){
                    return layer.msg('上传成功!');
                }
            }
        });
        //普通图片上传3
        var uploadInst3 = upload.render({
            elem: '#test3'
            ,url: '${pageContext.request.contextPath}/admin/lunbo/add'
            ,data: { num: 3
            }
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,size: '1024*5'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo3').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(json){
                //如果上传失败
                if(json.code == 0){
                    return layer.msg('上传失败!');
                }
                //上传成功
                if(json.code > 0){
                    return layer.msg('上传成功!');
                }
            }
        });
    });
</script>

<%--点击侧栏--%>
<script>
    function tag(id) {
            document.getElementById("jiajuzhanshi").style.display="none";


            document.getElementById("lowerjiaju").style.display="none";
            document.getElementById("lookjiaju").style.display="none";
            document.getElementById("addjiaju").style.display="none";


            document.getElementById("addtype").style.display="none";
            document.getElementById("looktype").style.display="none";


            document.getElementById("addstyle").style.display="none";
            document.getElementById("lookstyle").style.display="none";


            document.getElementById("ordermanager").style.display="none";
            document.getElementById("orderDaifahuo").style.display="none";
            document.getElementById("orderYifahuo").style.display="none";
            document.getElementById("orderYishouhuo").style.display="none";

            document.getElementById("looklunbotu").style.display="none";
            document.getElementById("addlunbotu").style.display="none";

            document.getElementById("lookmessage").style.display="none";

            document.getElementById("xiaoliang").style.display="none";

            document.getElementById(id).style.display="block";
    }
</script>
<script>
    function index() {
        window.location="${pageContext.request.contextPath}/admin/index";
    }
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
    });
</script>
</body>
</html>
