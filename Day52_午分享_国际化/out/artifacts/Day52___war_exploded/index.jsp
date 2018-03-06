<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/2/1
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  ${sessionScope.name}
  ${sessionScope.gender}
  ${sessionScope.hobby}
  ${sessionScope.param}
  <br>
  <a href="show.action?request_locale=zh_CN">中文</a>
  <a href="show.action?request_locale=ja_JP">日文</a>
  <a href="show.action?request_locale=en_US">英文</a>
  <br>
  <a href="show2.action?request_locale=zh_CN">中文2</a>
  <a href="show2.action?request_locale=ja_JP">日文2</a>
  <a href="show2.action?request_locale=en_US">英文2</a>
  <br>
  <a href="show3.action?request_locale=zh_CN">中文3</a>
  <a href="show3.action?request_locale=ja_JP">日文3</a>
  <a href="show3.action?request_locale=en_US">英文3</a>
  </body>
</html>
