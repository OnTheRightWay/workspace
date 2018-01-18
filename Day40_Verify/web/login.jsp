<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/16
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="" method="post">
        username:<input><br>
        password:<input><br>
        验证码:<input>
        <img src="${pageContext.request.contextPath}/codeImg.action">
        <input type="submit" value="登录">
    </form>
</body>
</html>
