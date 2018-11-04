<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加酒店-后台管理系统-Admin 1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/weadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/treeselect.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/treeselect.js" charset="utf-8"></script>--%>
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
            <label for="cid" class="layui-form-label">
                <span class="we-red">*</span>酒店类型
            </label>
            <div class="layui-input-inline">
                <%--<input type="text" id="cid" lay-filter="demo" autocomplete="off" class="layui-input">--%>
                    <input type="text" id="cid" name="cid" required="" lay-verify="required" autocomplete="off"
                           class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="title" class="layui-form-label">
                <span class="we-red">*</span>酒店名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="title" name="name" required="" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="priceView" class="layui-form-label">
                <span class="we-red">*</span>酒店价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="priceView" name="priceView" required="" lay-verify="number" autocomplete="off"
                       class="layui-input">
                <input type="hidden" id="price" name="price">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="num" class="layui-form-label">
                <span class="we-red">*</span>房间数
            </label>
            <div class="layui-input-inline">
                <input type="text" id="num" name="num" required="" lay-verify="number" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label for="content" class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <%--第一步--%>
                <textarea id="content" name="content" class="layui-textarea" style="display: none"></textarea>
            </div>
            <input type="hidden" value="" id="image" name="image"/>
            <div  id="div" style="display: none">

            </div>
        </div>
        <div class="layui-form-item">
            <label for="add" class="layui-form-label">
            </label>
            <button id="add" class="layui-btn" lay-filter="add" lay-submit="">增加</button>
        </div>
    </form>
</div>
<script>
    layui.extend({
        admin: '{/}../../static/js/admin',
        treeselect: '{/}../../static/js/treeselect'
    });
    layui.use(['form', 'admin','layer', 'layedit', 'treeselect','jquery'], function () {
        var form = layui.form,
            admin = layui.admin,
            layer = layui.layer,
            layedit = layui.layedit,
            treeselect = layui.treeselect,
            $ = layui.jquery;

        var iparent = parent.$("#articleList");

        treeselect.render(
            {
                // css选择器，推荐使用id
                elem: '#cid',
                // 请求地址
                data: '../../hotel/showcat',
                // ajax请求方式：post/get
                type: 'post',
                click: function (d) {
                    alert(d)
                }
            }
        );


        //第二步
        //初始化富文本编辑器
        var index = layedit.build('content', {
            height: 100,//设置编辑器高度
            uploadImage:{
                url:'../../uploadimage2',
                type:'post',
                done:function (res) {
                    console.log(res);
                }
            }
        });



        
        //监听提交
        form.on('submit(add)', function (data) {
            var obj = data.field;
            console.log(obj);
            var content = layedit.getText(index);
            var strImage = layedit.getContent(index);
            var str = strImage.substring(strImage.indexOf("<"),strImage.indexOf(">")+1);
            $("#div").html(str);
            var image = $("#div img").attr("src");
            $.post(
                "../../hotel/hoteladd",
                {
                    name:obj.name,
                    content: content,
                    price:obj.priceView,
                    num:obj.num,
                    cid:obj.cid,
                    image:image
                },
                function (data) {
                    if(data>0){
                        layer.alert("增加成功",function () {
                            parent.location.reload();
                        });

                    }else{
                        layer.msg("添加失败",{
                            icon :5
                        })
                    }
                }
            );
            return false;
        });
    });


</script>
</body>

</html>