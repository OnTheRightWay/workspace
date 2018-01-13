<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/12
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="show" method="get">
    <input type="hidden" name="pc" value="1">
    书名：<input type="text" name="bname"><br>
    作者：<input type="text" name="author"><br>
    价格：<input type="number" name="price"><br>
    类型：<input type="text" name="category"><br>
    <input type="submit" value="查询">
  </form>


    <c:set var="pageBean" value="${requestScope.pageBean}"/>
    <c:if test="${pageBean!=null}">
    <table border="1">
      <tr>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
        <th>分类</th>
      </tr>
      <c:forEach var="book" items="${requestScope.pageBean.books}">
        <tr>
          <td>${book.bname}</td>
          <td>${book.author}</td>
          <td>${book.price}</td>
          <td>${book.category}</td>
        </tr>
      </c:forEach>

      <c:set var="begin" value="1"/>
      <c:set var="end" value="${requestScope.pageBean.totalPage}"/>

      <c:if test="${requestScope.pageBean.currentPage>5}">
        <c:set var="begin" value="${requestScope.pageBean.currentPage - 5}"/>
      </c:if>
      <c:if test="${requestScope.pageBean.currentPage < (requestScope.pageBean.totalPage - 4)}">
        <c:set var="end" value="${requestScope.pageBean.currentPage+4}"/>
      </c:if>
      <c:if test="${end<requestScope.pageBean.pageSize}">
        <c:set var="end" value="${requestScope.pageBean.pageSize}"/>
      </c:if>
      <c:if test="${begin>(end-requestScope.pageBean.pageSize+1)}">
        <c:set var="begin" value="${end-requestScope.pageBean.pageSize+1}"/>
      </c:if>
      <c:if test="${end>requestScope.pageBean.totalPage}">
        <c:set var="end" value="${requestScope.pageBean.totalPage}"/>
      </c:if>


      <c:if test="${requestScope.pageBean.currentPage > 1}">
        <a href="show?pc=${requestScope.pageBean.currentPage - 1}${requestScope.pageBean.param}">上一页</a>
      </c:if>
      <c:forEach end="${end}" begin="${begin}" var="v">

        <a href="show?pc=${v}${requestScope.pageBean.param}">
          <c:if test="${requestScope.pageBean.currentPage eq v}">
            ${v}
          </c:if>
          <c:if test="${requestScope.pageBean.currentPage != v}">
            [${v}]
          </c:if>
        </a>
      </c:forEach>
      <c:if test="${requestScope.pageBean.currentPage < requestScope.pageBean.totalPage}">
        <a href="show?pc=${requestScope.pageBean.currentPage + 1}${requestScope.pageBean.param}">下一页</a>
      </c:if>
    </table>
    </c:if>
  <form action="<c:url value="/show"/>" method="get">
    <c:forEach var="p" items="${requestScope.pageBean.params}">
      <input type="hidden" name="${p.key}" value="${p.value}">
    </c:forEach>
    <input type="number" name="pc">/${requestScope.pageBean.totalPage}
    <input type="submit" value="跳页">
  </form>
  </body>
</html>
