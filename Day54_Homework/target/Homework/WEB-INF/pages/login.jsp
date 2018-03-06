<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/5
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input name="username" type="text" value="${login.username}"><br>
        密码：<input name="password" type="password" value="${login.password}"><br>
        <input type="submit" value="登录"><br>
    </form><br>
    <a href="${pageContext.request.contextPath}/index.jsp">注册</a>
</body>
</html>
