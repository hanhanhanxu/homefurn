<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11952
  Date: 2019/5/6
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置收货地址</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <%--引入三级联动需要的js--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jsAddress.js"></script>

    <style>
        .info{
            margin-left:auto;
            margin-right:auto;
            margin-TOP:100PX;
            width:30em;
        }
    </style>
</head>
<body>
    <%--<div>
        省：<select id="cmbProvince"></select>
        市：<select id="cmbCity"></select>
        区：<select id="cmbArea"></select>
        <br /><br />
        省：<select id="Select1"></select>
        市：<select id="Select2"></select>
        区：<select id="Select3"></select>
        <script type="text/javascript">
            addressInit('cmbProvince', 'cmbCity', 'cmbArea', '陕西', '宝鸡市', '金台区');
            addressInit('Select1', 'Select2', 'Select3');
        </script>
    </div>--%>

<%--<c:forEach items="${addresses}" var="address">
    <ul>
        <li>${address.uid}</li>
        <li>${address.rpro}</li>
        <li>${address.rcity}</li>
        <li>${address.rinfo}</li>
        <li>${address.rname}</li>
        <li>${address.rtel}</li>
        <li>${address.rmo}</li>
    </ul>
</c:forEach>--%>

    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo"><a href="${pageContext.request.contextPath}/fitting/index">家居装饰中心</a></div>

            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/user/myinfo">个人中心</a>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/logoff">退出</a></li>
            </ul>
            <%--<ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        ${user.nickname}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/user/myinfo">个人中心</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/logoff">退出</a></li>
            </ul>--%>
        </div>

        <%--已存在的地址--%>
        <div class="layui-input-block">
            <h3>地址列表</h3>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover">
                        <tr style="color:red">
                            <th>收货人</th>
                            <th>联系方式</th>
                            <th>地址</th>
                            <th>是否默认</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${addresses}" var="address">
                            <tr>
                                <th>${address.rname}</th>
                                <th>${address.rtel}</th>
                                <th>
                                        ${address.rpro}
                                        ${address.rcity}
                                        ${address.rarea}
                                        ${address.rinfo}
                                </th>
                                <th>${address.rmo}</th>
                                <th>
                                    <a onclick="deleteAddress('${address.rid}')">删除</a>
                                    <a onclick="updateMo('${address.rid}','${address.rmo}')">设为默认</a>
                                </th>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>

        <%--添加新地址--%>
        <div class="info">
            <h2>设置收货地址</h2>
            <div>
                <form id="form1" action="${pageContext.request.contextPath}/user/editaddress" method="post">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">收货人姓名：</span>
                        <input required name="rname" type="text" class="form-control" placeholder="请填写收货人姓名" aria-describedby="basic-addon1">
                    </div>
                    <br><br>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">收货电话：</span>
                        <input id="phone" required name="rtel" type="text" maxlength="11" class="form-control" placeholder="请填写收货人联系方式" aria-describedby="basic-addon1">
                    </div>
                    <br><br>
                    <%--地址：省市县--%>
                    省：<select name="rpro" id="cmbProvince"></select>
                    市：<select name="rcity" id="cmbCity"></select>
                    区：<select name="rarea" id="cmbArea"></select>
                    <script type="text/javascript">
                        addressInit('cmbProvince', 'cmbCity', 'cmbArea','河南','南阳市','宛城区');
                    </script>
                    <br><br>
                    <%--详细地址--%>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">详细地址：</span>
                        <input required name="rinfo" type="text" class="form-control" placeholder="如道路、门牌号、小区、楼栋号、单元室等" aria-describedby="basic-addon1">
                    </div>
                    <br><br>
                    是否为默认收货地址:(是 则会覆盖之前的默认收货地址。如果没有默认收货地址，则当前地址必须为默认收货地址)<br>
                    <label><input name="mo" type="radio" value="true" checked/>是</label>
                    <label><input name="mo" type="radio" value="false" />否</label>
                    <br><br>
                    <button type="submit" onclick="checkMobile(); return false;"  style="width:280px;" class="btn btn-default">确 认</button>
                </form>
            </div>
        </div><%--info--%>
    </div>
<br><br><br>
<script>
    //删除某个收货地址
    function deleteAddress(rid) {
        var b=window.confirm("确定删除吗?");
        if(b){
            window.location="${pageContext.request.contextPath }/user/deleteAddress/"+rid;
        }
    }
    function updateMo(rid,rmo) {
        if(rmo==1){
            alert("已经是默认地址了")
        }else{
            /*alert("不是默认地址，可以修改")*/
            window.location="${pageContext.request.contextPath }/user/updateAddressMo/"+rid;
        }
    }
    //检查手机号
    function checkMobile(){
        var myphone = $("#phone").val();
        var phone=/^[1][3,4,5,7,8][0-9]{9}$/;
       /* var tel=/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/;*/
        if(!(phone.test(myphone))){
            alert("不是正确的11位手机号，请重新填写");
        }else{
            document.getElementById("form1").onsubmit();//继续提交
        }
    }
</script>
</body>
</html>
