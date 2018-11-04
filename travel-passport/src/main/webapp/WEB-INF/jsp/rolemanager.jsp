<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body>

<table id="rolemanager" class="layui-table" lay-data="{height:315,url:'../role/rolelist',page:true}">
    <thead>
    <tr>
        <th lay-data="{field:'id'}">ID</th>
        <th lay-data="{field:'roleName'}">角色</th>
        <th lay-data="{field:'description'}">描述</th>
        <th lay-data="{field:'locked',templet:'#status'}">状态</th>
    </tr>
    </thead>
</table>

</body>
<script type="text/html" id="status">
    {{#  if(d.locked == 0){ }}
        锁定
    {{#  } else { }}
        正常
    {{#  } }}
</script>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use(['layer','form','table'],function(){
        var layer = layui.layer,
            form = layui.form,
            table = layui.table;
    });
</script>
<script>

</script>
</html>
