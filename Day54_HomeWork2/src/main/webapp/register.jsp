<%@ taglib prefix="c" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/5
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="register" method="post">
        用户名：<input type="text" name="username" value="${requestScope.register.username}">
        密码：<input type="password" name="password" value="${requestScope.register.password}">
        <input type="submit" value="注册"><br>
    </form>
<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
</body>
</html>
