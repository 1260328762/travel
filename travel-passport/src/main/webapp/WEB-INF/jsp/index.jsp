<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body>
登陆成功
<a href="./user/logout">退出登录</a>
<shiro:hasRole name="admin">
    <a href="#">具有admin权限</a>
</shiro:hasRole>

<shiro:hasPermission name="user:list">
    <a href="#">用户列表</a>
</shiro:hasPermission>
<br>
<a href="javascript:fn()">菜单增加</a>

<a href="./role/rolemanager">角色管理</a>
</body>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use(['layer','form'],function(){
        var layer = layui.layer,
            form = layui.form;

        layer.msg("欢迎使用layui");

    });
</script>
<script>
    function fn() {
        layer.msg("欢迎使用layui")
    }
</script>
</html>
