<%--
  Created by IntelliJ IDEA.
  User: 谢朝康
  Date: 2019/10/2
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员删除物品入库信息</title>
</head>
<body>
<form id="delete" action="Admin_delete.action" method="post">
    <table>
        <tr>
            <td>入库单编号:</td>
            <td><input type="text" name="goodsWarehouse.number"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="delete"></td>
        </tr>
    </table>
</form>
<br><br>
</body>
</html>
