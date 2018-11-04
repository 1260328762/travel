layui.extend({
    admin: '{/}../../static/js/admin'
});

layui.use(['form', 'table', 'jquery', 'admin'], function () {
    var form = layui.form,
        table = layui.table,
        $ = layui.jquery,
        admin = layui.admin;

    $("#btnImport").click(function(){
        //点击后禁用的代码自己完成
        $("#btnImport").addClass("layui-btn-disabled");
        $.post(
            '../../hotel/indexlib/import',
            null,
            function(data){
                if(data==1){
                    layer.msg("导入成功")
                }else{
                    layer.msg("导入失败")
                }
                $("#btnImport").removeClass("layui-btn-disabled");

            },
            'json'
        );
    });


});