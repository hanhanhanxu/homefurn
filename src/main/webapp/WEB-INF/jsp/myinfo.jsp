<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/3/27
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的信息</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>





<body>

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a href="${pageContext.request.contextPath}/fitting/index">家居装饰中心</a></div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    ${user.nickname}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/user/info">修改信息</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/user/address">收货地址</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/logoff">退出</a></li>
        </ul>
    </div>


    <div class="main-contain">
        <div class="left">
            <ul>
                <li>昵称：<span>${user.nickname}</span></li>
                <li>账号：<span>${user.username}</span></li>
                <li>介绍：<span>${user.intro}</span></li>
            </ul>
        </div>
        <div class="right">
            <h3>我的装饰：</h3>
            <c:forEach items="${suitVoList}" var="suitVo">
            <div class="main-item">
                    ${suitVo.sname}
                <ul>
                    <li>
                        <span>${suitVo.sprice}￥</span>
                    </li>
                    <li></li>
                    <c:forEach items="${suitVo.collocations}" var="collocation">
                    <li>
                        <div class="main-item-img">
                            <img style="height: 80px;width: 80px" src="${pageContext.request.contextPath}/coverimg/${collocation.fimg}" alt="" />
                            <span>${collocation.fname}</span>
                            <span>${collocation.fprice}</span>
                            <div class="mask">
                                <span class="glyphicon glyphicon-trash" onclick="delCollocation('${collocation.cid}')"></span>  <%--删除--%>
                                <span class="glyphicon glyphicon-option-horizontal" onclick="fittingdetails('${collocation.fid}')"></span>  <%--更多--%>
                            </div>
                        </div>
                    </li>
                    </c:forEach>
                    <li>
                        <form method="post" action="${pageContext.request.contextPath}/user/delSuit">
                            <input type="hidden" name="sid" value="${suitVo.sid}">
                            <button type="submit">删除</button>
                        </form>
                        <br><br><br>
                        <form id="dinggouform" action="${pageContext.request.contextPath}/user/orderSuit" method="post">
                            <input hidden name="sid" value="${suitVo.sid}">
                            <button onclick="checkMo(); return false;" type="submit">订购</button>
                        </form>
                    </li>
                </ul>
            </div>
            </c:forEach>
            <br><br>
            <br><br>

            <h3>我的订单:</h3>
            <h5>1、待发货订单:</h5>
            <c:forEach items="${order}" var="orderinfoVo">
                <table class="layui-table" lay-even="" lay-skin="row">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>收货人</th>
                        <th>${orderinfoVo.orderinfo.rname}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>电话</td>
                        <td>${orderinfoVo.orderinfo.rtel}</td>
                    </tr>
                    <tr>
                        <td>收货地址</td>
                        <td>${orderinfoVo.orderinfo.ofaddress}</td>
                    </tr>
                    <tr>
                        <td>￥</td>
                        <td>${orderinfoVo.orderinfo.ofprice}</td>
                    </tr>
                    <tr>
                        <td>下单时间</td>
                        <td>${orderinfoVo.orderinfo.stroftime}</td>
                    </tr>
                    <tr>
                        <td>状态</td>
                        <td>${orderinfoVo.orderinfo.ofstate}</td>
                    </tr>
                    <tr>
                        <td>订单号</td>
                        <td>${orderinfoVo.orderinfo.ofserial}</td>
                    </tr>
                    </tbody>
                </table>
                <div class="main-item">
                    <ul>
                        <li></li>
                        <li></li>
                        <c:forEach items="${orderinfoVo.orderitemsVoList}" var="OrderitemsVo">
                            <li>
                                <div class="main-item-img">
                                    <img style="height: 80px;width: 80px" src="${pageContext.request.contextPath}/coverimg/${OrderitemsVo.fimg}" alt="" />
                                    <span>${OrderitemsVo.orderitems.fname}</span>
                                    <span>${OrderitemsVo.orderitems.fprice}</span>
                                    <div class="mask" onclick="fittingdetails('${OrderitemsVo.orderitems.fid}')">
                                        <span class="glyphicon glyphicon-option-horizontal"></span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>
            <br><br>

            <h5>2、待收货订单:</h5>
            <c:forEach items="${order2}" var="orderinfoVo">
                <table class="layui-table" lay-even="" lay-skin="row">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>收货人</th>
                        <th>${orderinfoVo.orderinfo.rname}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>电话</td>
                        <td>${orderinfoVo.orderinfo.rtel}</td>
                    </tr>
                    <tr>
                        <td>收货地址</td>
                        <td>${orderinfoVo.orderinfo.ofaddress}</td>
                    </tr>
                    <tr>
                        <td>￥</td>
                        <td>${orderinfoVo.orderinfo.ofprice}</td>
                    </tr>
                    <tr>
                        <td>下单时间</td>
                        <td>${orderinfoVo.orderinfo.stroftime}</td>
                    </tr>
                    <tr>
                        <td>状态</td>
                        <td>${orderinfoVo.orderinfo.ofstate}</td>
                    </tr>
                    <tr>
                        <td>订单号</td>
                        <td>${orderinfoVo.orderinfo.ofserial}</td>
                    </tr>
                    <tr>
                        <td>操作</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/user/receiveGoods" method="post">
                                <input type="hidden" name="ofid" value="${orderinfoVo.orderinfo.ofid}">
                                <button>确认收货</button>
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <div class="main-item">
                    <ul>
                        <li></li>
                        <li></li>
                        <c:forEach items="${orderinfoVo.orderitemsVoList}" var="OrderitemsVo">
                            <li>
                                <div class="main-item-img">
                                    <img style="height: 80px;width: 80px" src="${pageContext.request.contextPath}/coverimg/${OrderitemsVo.fimg}" alt="" />
                                    <span>${OrderitemsVo.orderitems.fname}</span>
                                    <span>${OrderitemsVo.orderitems.fprice}</span>
                                    <div class="mask" onclick="fittingdetails('${OrderitemsVo.orderitems.fid}')">
                                        <span class="glyphicon glyphicon-option-horizontal"></span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>
            <br><br>

            <h5>3、已收货订单:</h5>
            <c:forEach items="${order3}" var="orderinfoVo">
                <table class="layui-table" lay-even="" lay-skin="row">
                    <colgroup>
                        <col width="150">
                        <col width="150">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>收货人</th>
                        <th>${orderinfoVo.orderinfo.rname}</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>电话</td>
                        <td>${orderinfoVo.orderinfo.rtel}</td>
                    </tr>
                    <tr>
                        <td>收货地址</td>
                        <td>${orderinfoVo.orderinfo.ofaddress}</td>
                    </tr>
                    <tr>
                        <td>￥</td>
                        <td>${orderinfoVo.orderinfo.ofprice}</td>
                    </tr>
                    <tr>
                        <td>下单时间</td>
                        <td>${orderinfoVo.orderinfo.stroftime}</td>
                    </tr>
                    <tr>
                        <td>状态</td>
                        <td>${orderinfoVo.orderinfo.ofstate}</td>
                    </tr>
                    <tr>
                        <td>订单号</td>
                        <td>${orderinfoVo.orderinfo.ofserial}</td>
                    </tr>
                    </tbody>
                </table>
                <div class="main-item">
                    <ul>
                        <li></li>
                        <li></li>
                        <c:forEach items="${orderinfoVo.orderitemsVoList}" var="OrderitemsVo">
                            <li>
                                <div class="main-item-img">
                                    <img style="height: 80px;width: 80px" src="${pageContext.request.contextPath}/coverimg/${OrderitemsVo.fimg}" alt="" />
                                    <span>${OrderitemsVo.orderitems.fname}</span>
                                    <span>${OrderitemsVo.orderitems.fprice}</span>
                                    <div class="mask" onclick="fittingdetails('${OrderitemsVo.orderitems.fid}')">
                                        <span class="glyphicon glyphicon-option-horizontal"></span>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>
            <br><br>
        </div>
        <div class="bottom">
            <button class="layui-btn" data-toggle="modal" data-target="#modal">创建我的装饰</button>
        </div>
    </div>

    <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">创建我的装饰</h4>
                </div>
                <div class="modal-body">
                    <%--创建装饰表单--%>
                    <form method="post" action="${pageContext.request.contextPath}/user/addSuit">
                        <label class="layui-form-label">装饰名称：</label>
                        <div class="layui-input-block">
                            <input hidden name="uid" value="${user.uid}">
                            <input type="text" name="sname" required lay-verify="title" autocomplete="off" placeholder="请输入" class="layui-input">
                        </div>
                        <button class="layui-btn" lay-submit="" type="submit" >立即提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/layui/jquery.1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/input.js"></script>
    <script>
        //注意：导航 依赖 element 模块，否则无法进行功能性操作
        layui.use(['element', 'laypage', 'layer'], function () {
            var element = layui.element,
                laypage = layui.laypage,
                layer = layui.layer;
        });
    </script>

    <%--删除搭配表中的具体某个家居--%>
    <script>
        function delCollocation(cid) {
            window.location="${pageContext.request.contextPath}/user/delCollocation/"+cid;
        }
        function fittingdetails(fid) {
            window.location="${pageContext.request.contextPath}/fitting/details/"+fid;
        }

       /* function delCollocations() {
            var cks = document.getElementsByName("cid");
            var str = "";
            for(var i=0;i<cks.length;i++){
                if(cks[i].checked){
                    str += cks[i].value+"&"
                }
            }
            if(str.length>0){
                str = str.substring(0,str.length-1);
                window.location=/user/delCollocations/+str;
            }
        }*/
    </script>

    <script>
        //检查当前用户是否有默认地址
        function checkMo() {
            if(${address!=null}){
                    document.getElementById("dinggouform").onsubmit();
            }else{
                alert("请设置默认收货地址！")
            }
        }
    </script>
</body>

</html>
