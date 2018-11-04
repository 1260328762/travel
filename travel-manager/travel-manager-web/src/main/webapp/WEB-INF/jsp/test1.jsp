<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>开始使用layui</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui/css/layui.css">
</head>
<body>

<table id="demo" lay-filter="test"></table>

<script src="${pageContext.request.contextPath}/lib/layui/layui.js"></script>


<script>
    layui.use('table',function () {
        var table = layui.table;
        table.render({
            elem:'#demo',
            url:'./items',
            page:true,
            cols:[[
                {field:'id',title:'商品编号'},
                {field:'title',title:'商品名称'},
                {field:'sellPoint',title:'商品卖点'}
            ]]

        });
    });

</script>
</body>
</html>
