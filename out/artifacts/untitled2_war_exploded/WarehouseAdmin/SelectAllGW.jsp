<%--
  Created by IntelliJ IDEA.
  User: 谢朝康
  Date: 2019/10/6
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>layui表格查询所有入库订单信息</title>
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <script src="../layui/layui.js"></script>
</head>
<body>
<table id="demo" lay-filter="test"></table>
<script>
    layui.use('table', function(){
        var table = layui.table,
            form=layui.form;

        //第一个实例
        table.render({
            elem: '#demo'
            ,height: 312
            ,even:true
            ,url: 'action/AdminAction/AllGW.action' //数据接口
            ,page: true //开启分页
            ,limit:10
            ,cols: [[ //表头
                {field: 'number', title: 'ID', width:80, sort: true, fixed: 'left'}
                ,{field: 'data', title: '入库日期', width:80}
                ,{field: 'warehouse_number', title: '仓库编号', width:80, sort: true}
                ,{field: 'item_number', title: '物品编号', width:80}
                ,{field: 'quantity', title: '数量', width: 177}
            ]]
        });

    });
</script>
</body>
</html>
