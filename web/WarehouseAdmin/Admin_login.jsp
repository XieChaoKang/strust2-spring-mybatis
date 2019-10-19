<%--
  Created by IntelliJ IDEA.
  User: 谢朝康
  Date: 2019/9/14
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@page isELIgnored="false"%>
${msg}
<form id="login" action="AdminLogin.action" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="text" name="admin.id"></td>
        </tr>
        <tr>
            <td>psw:</td>
            <td><input type="password" name="admin.password"></td>
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
