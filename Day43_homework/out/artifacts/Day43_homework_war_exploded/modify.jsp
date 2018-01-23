<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/20
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <style type="text/css">
        .errorMessage ul{
            list-style-type: none;
            display: none;
            padding: 0;
            margin: 0;
        }
        .error{
            width: 200px;
            height: 20px;
            display: inline-block;
            /*border: solid 1px black;*/
        }
    </style>
</head>
<body>
<form action="modify.action" method="post">
    <input type="hidden" name="id" value="<s:property value="#employee.id"/>">
    姓名：<input type="text" name="name" value="<s:property value="#employee.name"/> "><div class="error"><s:fielderror fieldName="name" cssClass="error"/></div><br>
    年龄：<input type="number" name="age" value="<s:property value="#employee.age"/> "><br>
    部门：<input type="text" name="department" value="<s:property value="#employee.department"/> "><br>
    入职时间：<input type="date" name="jointime" value="<s:property value="#employee.jointime"/> "><br>
    家庭地址：<input type="text" name="address" value="<s:property value="#employee.address"/> "><br>
    电话号码：<input type="text" name="telephone" value="<s:property value="#employee.telephone"/> "><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
