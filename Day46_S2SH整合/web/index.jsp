<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/24
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="findById.action" method="post">
    查找id为<input type="text" name="id">的：<s:property value="#request.user"/>
    <input type="submit">
  </form>
  <form action="add.action" method="post">
    用户名：<input type="text" name="username">
    密码：<input type="text" name="password">
    <input type="submit">
  </form>
  </body>
</html>
