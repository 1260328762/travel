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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/itemlist.js" charset="utf-8"></script>

    <!--<script type="text/javascript" src="../../static/js/admin.js"></script>-->
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        .layui-form-switch {
            width: 55px;
        }
        .layui-form-switch em {
            width: 40px;
        }
        .layui-form-onswitch i {
            left: 45px;
        }
        body{overflow-y: scroll;}
    </style>
</head>

<body>
<div class="weadmin-nav">
			<span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">酒店管理</a>

        <a>
          <cite>酒店列表</cite></a>
      </span>
    <a class="layui-btn layui-btn-sm" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">&#x1002;</i></a>
</div>
<div class="weadmin-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 we-search" onsubmit="return false;">
            酒店搜索：
            <div class="layui-inline">
                <input type="text" id="name" name="name" placeholder="请输入酒店名称关键字" autocomplete="off" class="layui-input">
            </div>
            <button class="layui-btn" lay-submit="" lay-filter="search" data-type="reload"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <div class="weadmin-block demoTable">
        <button class="layui-btn layui-btn-danger" data-type="getCheckData"><i class="layui-icon">&#xe640;</i>批量删除</button>
        <button class="layui-btn" onclick="WeAdminShow('酒店添加','./add',850,500)"><i class="layui-icon">&#xe61f;</i>添加</button>
    </div>

    <table class="layui-hide" id="articleList" ></table>

    <script type="text/html" id="operateTpl">
        <a id="edit"  title="编辑" href="javascript:fn({{d.id}});" value = {{d.id}}>
            <i class="layui-icon edit">&#xe642;</i>
        </a>
        <%--<a title="删除" href="javascript:;">--%>
            <%--<i class="layui-icon">&#xe640;</i>--%>
        <%--</a>--%>
    </script>

    <%----%>
    <%--酒店状态模板 onclick="WeAdminEdit('编辑','./edit', 2, 600, 400)" --%>
    <script type="text/html" id="myTpl">
        <div class="layui-form">
            <input type="checkbox" lay-filter="test" name="itemStatus" id="itemStatus" lay-skin="switch" lay-text="在售|客满" {{1==d.status?'checked':''}}/>
        </div>

    </script>

</div>
<script type="application/javascript">

    var $ ;
    layui.use(['admin', 'jquery', 'table','layer','form'], function () {
        //初始化变量
        var admin = layui.admin,
            table = layui.table,
            form = layui.form,
            layer = layui.layer;
            $ = layui.jquery;
    });


    function fn(id){

        $("#hid").val(id);

        $.post(
            "../../hotel/hotelinfo",
            {id:id},
            function () {
                layer.open({
                    type :2,
                    content:'./edit',
                    area:['700px','500px'],
                    maxmin:true,
                    success:function (layero,index) {

                    }

                });
            }
        );
    }


</script>
</body>

</html>