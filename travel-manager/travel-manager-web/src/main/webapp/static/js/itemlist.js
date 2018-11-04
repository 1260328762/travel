//引入admin.js(webapp/static/js/admin.js)
//itemlist.js(webapp/static/js/itemlist.js)
layui.extend({
    admin: '{/}../../static/js/admin'
});
//按需加载admin.js
layui.use(['admin', 'jquery', 'table','layer','form'], function () {
    //初始化变量
    var admin = layui.admin,
        $ = layui.jquery,
        table = layui.table,
        form = layui.form,
        layer = layui.layer;
    //对表格进行渲染
    table.render({
        //什么是表格属性：page,elem,url,cols
        //什么是列属性：type,field,title
        //开启分页
        page: true,
        //渲染的容器是谁
        elem: '#articleList',
        //异步提交请求给后台返回JSON
        url: '../../hotel/hotellist',
        //要显示的表头是什么
        cols: [[
            {type: 'checkbox'},
            {field: 'id', title: '酒店编号'},
            {field: 'name', title: '酒店名称'},
            {field: 'num',title: '房间数'},
            {field: 'restof',title: '剩余房间'},
            {field: 'content',title:'酒店描述'},
            {field: 'price', title: '酒店价格'},
            {field : 'created',title: '发布时间',
                templet:function (row) {
                    return createTime(row.created)
                }},
            {field: 'status', title: '酒店状态', templet: '#myTpl'},
            {title:'操作',toolbar:"#operateTpl"}
        ]]
    });

    //时间戳的处理
    function createTime(v) {
        var date = new Date(v);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? '0' + m : m;
        var d = date.getDate();
        d = d < 10 ? ("0" + d) : d;
        var h = date.getHours();
        h = h < 10 ? ("0" + h) : h;
        var M = date.getMinutes();
        M = M < 10 ? ("0" + M) : M;
        var str = y + "-" + m + "-" + d + " " + h + ":" + M;
        return str;
    }


    // 方法的封装
        var active={

        getCheckData:function(){
            // 获取用户选中的表格,判断有没有选中数据
            var data = table.checkStatus("articleList").data;
            if(data.length>0){
                //大于0说明选中行,弹出确认框
                layer.confirm("确认删除所选数据?",function (obj) {
                    //确认删除
                    var ids = [];
                    for(var i=0;i<data.length;i++){
                        //获取要删除的id
                        ids.push(data[i].id);
                    }
                    console.log(ids);
                    console.log(data);
                    //异步请求
                    $.post(
                        "../../hotel/updatebatch",
                        {'ids[]': ids},
                        function (res) {
                            if(res>0){
                                //停留在原来页面刷新
                                $('.layui-laypage-btn').click();
                                layer.msg("删除成功",{
                                    time:1000,
                                    icon:1
                                })
                            }else{
                                layer.msg("删除失败",{
                                    time:1000,
                                    icon:2
                                })
                            }
                        }
                    );
                });
            }else{
                layer.msg("请先选中一行再删除",{
                    time:1000,
                    icon :2
                })
            }
        },
        reload:function () {
            var title = $("#name").val();
            if($.trim(title).length>0){
                table.reload("articleList",{
                    page:{curr:1},
                    where:{name: title}
                });
            }
        }
    };


    //修改酒店状态触发的事件
    form.on('switch(test)', function(obj){
        //当前元素
        //根据当前元素获取到这一列的id值
        var id = $(obj.elem).parents('tr').first().find("td").eq(1).text();

        var flg = obj.elem.checked;
        //console.log(flg)
        $.post(
            "../../hotel/chhotelstatus",
            {id:id,flg:flg},
            function (data) {
                if(data>0){
                    layer.msg("修改成功",{
                        time:1000,
                        icon :6
                    })
                }else{
                    layer.msg("修改失败",{
                        time:1000,
                        icon:5
                    });
                }
            }
        )
    });

    //点击"批量删除"按钮触发的事件
    $(".demoTable .layui-btn-danger").on('click',function(){
        //获取按钮的data-type值
        var data = $(this).attr("date-type");
        //判断data的值是否和active的属性符合,符合就调用其中的方法
        active[data]? active[data].call(this) : "";

    });


    //点击"模糊查询"按钮触发的事件
    $(".weadmin-body .layui-btn").on('click',function () {
        var type = $(this).data("type");//reload
        active[type]?active[type].call(this):'';
    });

});