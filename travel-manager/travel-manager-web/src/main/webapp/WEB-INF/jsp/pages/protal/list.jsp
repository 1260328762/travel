<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>酒店列表-后台管理系统-Admin 1.0</title>
    <meta name="Description" content="基于layUI数据表格操作"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/weadmin.css">
    <%--<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/itemlist.js" charset="utf-8"></script>--%>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
</head>

<body>

<div class="layui-carousel" id="test1">
    <div carousel-item>
        <c:forEach items="${pics}" var="pic">
            <img src="${pic.url}"/>
        </c:forEach>
    </div>

</div>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>图片设定</legend>
</fieldset>

<button class="layui-btn" onclick="WeAdminShow('添加图片    ','./add',600,500)"><i class="layui-icon">&#xe61f;</i>添加图片</button>
<table class="layui-table" lay-data="{heigth:300,url:'../../picmanager'}" lay-filter="demoEvent">
    <thead>
        <tr>
            <th lay-data="{field:'id',width:100}">ID</th>
            <th lay-data="{field:'groupid',width:100}">组ID</th>
            <th lay-data="{field:'picname'}">图片名称</th>
            <th lay-data="{field:'url'}">图片地址</th>
            <th lay-data="{field:'content'}">图片描述</th>
        </tr>
    </thead>
</table>


<script type="application/javascript">
    layui.extend({
        admin: '{/}../../static/js/admin'
    });

    layui.use(['carousel','table','upload','admin'], function(){
        var carousel = layui.carousel,
            admin = layui.admin,
            table = layui.table,
            upload = layui.upload;

        //建造实例
        carousel.render({
            elem: '#test1'
            ,width: '50%' //设置容器宽度
            ,arrow: 'always' //始终显示箭头
            ,height:'200px'
            //,anim: 'updown' //切换动画方式
        });

        //文件上传接口
        upload.render({
            elem:'#upload1',
            url:'../../uploadimage',
            size:10240,
            done:function (res, index, upload) {
                if(res.code>0){
                    location.reload();
                }
            }
        })
    });


</script>

<script>
    function fn() {
        alert("123")
    }
</script>
</body>

</html>