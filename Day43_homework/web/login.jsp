<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/19
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="login.action" method="post">
        用户名：<input type="text" name="username"><s:fielderror fieldName="username"/><br>
        密码：<input type="password" name="password"><s:fielderror fieldName="password"/><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
