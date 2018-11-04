<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加分类-后台管理系统-Admin 1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon" />
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

<form class="layui-form" id="form">
    <div class="layui-form-item">
        <label class="layui-form-label">图片描述</label>
        <div class="layui-input-inline">
            <input type="text" name="content" lay-verify="required" required class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">组ID</label>
        <div class="layui-input-inline">
            <input type="text" name="groupid" lay-verify="required" required class="layui-input"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">图片上传</label>
        <div class="layui-input-block">
            <button type="button" class="layui-btn" id="test1">
                <i class="layui-icon">&#xe67c;</i>上传图片
            </button>
        </div>
        <input id="url" name="url" lay-verify="url" type="hidden" value="">
        <input id="picname" name="picname" type="hidden" value=""/>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="add">提交</button>
        </div>
    </div>

</form>

<script>
    layui.use(['form','layer','upload','jquery'], function(){
        var form = layui.form,
            layer = layui.layer,
            upload = layui.upload,
            $ = layui.jquery;


        //监听提交
        form.on('submit(add)', function(data){
            //异步提交
            $.post(
                '../../addpic',
                {
                    picname:data.field.picname,
                    url:data.field.url,
                    content:data.field.content,
                    groupid:data.field.groupid
                },
                function (res) {
                    if(res>0){
                        layer.alert("数据添加成功",function (index) {
                            parent.location.reload();
                        });
                    }
                }
            );
            return false;
        });


        //文件上传
        upload.render({
            elem:'#test1',
            url:'../../uploadimage',
            size:10240,
            before:function (obj) {
                layer.load(2,{time: 10*1000});
            },
            done:function (res, index, upload) {
                if(res.code==0){
                    parent.layer.msg("图片上传成功");
                    layer.closeAll('loading');
                    $("#url").val(res.data.src);
                    $("#picname").val(res.data.title);
                }
            }

        });

        //表单验证
        form.verify({
            url:function (value,item) {
                if (value == '' || value == null) {
                    return "未检测到图片";
                }
            }
        })

    });
</script>
</body>

</html>