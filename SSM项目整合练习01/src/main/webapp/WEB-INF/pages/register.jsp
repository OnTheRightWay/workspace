<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/register"
      method="post">
    <input type="text" name="username">
    <input type="submit">
</form>
</body>
</html>