<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/5
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="user" method="post">
        <input type="hidden" name="method" value="login">
        <input type="text" name="username">
        <input type="text" name="password">
        <input type="submit">
    </form>
</body>
</html>
