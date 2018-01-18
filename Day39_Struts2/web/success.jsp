<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/15
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成功</title>
</head>
<style type="text/css">
    a{
        text-decoration: none;
    }
</style>
<body>
    <table border="1px">
        <tr>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
    <c:forEach var="user" items="${requestScope.users}" >
      <tr>
          <td><a href="">${user.username}</a> </td>
          <td>${user.age}</td>
      </tr>
    </c:forEach>
    </table>
</body>
</html>
