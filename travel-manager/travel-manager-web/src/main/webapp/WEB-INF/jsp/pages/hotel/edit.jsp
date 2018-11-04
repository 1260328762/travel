<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-后台管理系统-Admin 1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/weadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="weadmin-body">
    <form class="layui-form">
        <div class="layui-form-item">

            <label for="name" class="layui-form-label">
                <span class="we-red">*</span>酒店名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="name" value="${hotel.name}" name="name" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
                <input type="hidden" name="id" value="${hotel.id}">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="we-red">*</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="hotel" class="layui-form-label">
                <span class="we-red">*</span>酒店分类
            </label>
            <div class="layui-input-inline">
                <select id="hotel" class="layui-input" name="cid"></select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="content" class="layui-form-label">
                <span class="we-red">*</span>酒店描述
            </label>
            <div class="layui-input-inline">
                <input type="text" id="content" name="content" required=""
                       autocomplete="off" value="${hotel.content}" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="we-red">*</span>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="num" class="layui-form-label">
                <span class="we-red">*</span>房间数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="num" name="num" required="" lay-verify="number"
                       autocomplete="off" value="${hotel.num}" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="we-red">*</span>
            </div>
        </div>


        <div class="layui-form-item">
            <label for="restof" class="layui-form-label">
                <span class="we-red">*</span>剩余数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="restof" name="restof" required="" lay-verify="number"
                       autocomplete="off" value="${hotel.restof}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="price" class="layui-form-label">
                <span class="we-red">*</span>价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="price" name="price" required="" lay-verify="number"
                       autocomplete="off" value="${hotel.price}" class="layui-input">
                <input id="list" type="hidden" value="${list}">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="price" class="layui-form-label">
            </label>
            <button class="layui-btn" lay-filter="add" lay-submit="">
                提交
            </button>
        </div>
    </form>
</div>
<script type="text/javascript">
    layui.extend({
        admin: '{/}../../static/js/admin'
    });
    layui.use(['form','layer','admin','jquery'], function(){
        var form = layui.form,
            admin = layui.admin,
            layer = layui.layer,
            $ = layui.jquery;


        //渲染select框
        $.post(
            "../../hotel/hotelinfo",
            {},
            function (data) {
                var $html = "";
                var cid = ${hotel.cid};
                //console.log(cid);
                for (var i=0;i<data.length;i++){
                    if(cid == data[i].id){
                        $html += "<option selected='selected' value = "+data[i].id+">"+data[i].name+"</option><br/>"
                    }else{
                        $html += "<option value = "+data[i].id+">"+data[i].name+"</option><br/>"
                    }
                }
                $("#hotel").html($html);
                //渲染下拉框
                form.render('select');
            }
        );


        //监听提交
        form.on('submit(add)', function(data){
            //发异步，把数据提交给php
            console.log(data);
            console.log(${hotel.id});
            $.post(
                "../../hotel/hotelmofidy",
                {
                    id:${hotel.id},
                    name:data.field.name,
                    cid:data.field.cid,
                    content:data.field.content,
                    num:data.field.num,
                    restof:data.field.restof,
                    price:data.field.price
                },
                function (res) {
                    if(res>0){
                        parent.layer.msg("修改成功",{
                            time:1000,
                            icon:2
                        });
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        //刷新页面
                        parent.location.reload();
                    }
                }
            );
            return false;
        });

    });
</script>
</body>

</html>