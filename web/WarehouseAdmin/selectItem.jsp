<%--
  Created by IntelliJ IDEA.
  User: 谢朝康
  Date: 2019/10/7
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>通过仓库编号查询物品</title>
</head>
<body>
<form id="login" action="QueryAllItemByid.action" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="text" name="warehouse.id"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="login"></td>
        </tr>
    </table>
</form>
<br><br>

</body>
</html>
