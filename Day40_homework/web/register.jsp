
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/16
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="register.action" method="post">
        用户名：<input type="text" name="username" value="${requestScope.user.username}"><s:fielderror fieldName="username"/><br>
        密码：<input type="password" name="password" value="${requestScope.user.password}"><s:fielderror fieldName="password"/><br>
        确认密码:<input type="password" name="valPassword" value="${requestScope.valPassword}"><s:fielderror fieldName="valPassword"/> <br>
        电话：<input type="text" name="tele" value="${requestScope.user.tele}"><s:fielderror fieldName="tele"/> <br>
        邮箱：<input type="text" name="email" value="${requestScope.user.email}"><s:fielderror fieldName="email"/> <br>
        验证码：<input type="text" name="verify" value="${requestScope.verify}"><img src="codeImg.action"><s:fielderror fieldName="verify"/> <br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
