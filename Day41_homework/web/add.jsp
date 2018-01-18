<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/17
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <s:form action="addList" method="POST">
        <input type="text" name="list[0]">
        <input type="text" name="list[1]">
        <input type="text" name="list[2]">
        <s:submit/>
    </s:form>
    <s:form action="addMap" method="POST">
        <input type="text" name="map.stu1">
        <input type="text" name="map.stu2">
        <input type="text" name="map.stu3">
        <s:submit/>
    </s:form>
    <s:form action="addBook" method="POST">
        <input type="text" name="book.bname">
        <input type="text" name="book.author">
        <input type="number" name="book.price">
        <s:submit/>
    </s:form>
</body>
</html>
