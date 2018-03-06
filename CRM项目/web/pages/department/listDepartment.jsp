<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[部门管理]</td>
   
    <td width="57%"align="right">
    	<%--添加部门 --%>
       <a href="<s:url action="departmentAction_toEdit?depId=%{#dep.depId}"/>">
       		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
       </a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="6%" align="center">部门名称</td>
    <td width="7%" align="center">编辑</td>
  </tr>
    <s:set var="i" value="0"/>
  <s:iterator value="%{#request.pageBean.lists}" var="dep">
      <tr
              <s:set var="i" value="%{#i+1}"/>
              <s:if test="%{#i%2 == 0}">
              class="tabtd2"
              </s:if>
              <s:else>
                  class="tabtd1"
              </s:else>
      >
          <td align="center"><s:property value="%{#dep.depName}"/> </td>
          <td width="7%" align="center">
              <a href="<s:url action="departmentAction_toEdit?depId=%{#dep.depId}"/> "><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
          </td>
      </tr>
  </s:iterator>
</table>



 <table border="0" cellspacing="0" cellpadding="0" align="center">
     <tr>
         <td align="right">
             <span>第${requestScope.pageBean.currentPage}/${requestScope.pageBean.totalPage}页</span>
             <span>
			<c:set var="pageBean" value="${requestScope.pageBean}"/>
    <c:if test="${pageBean!=null}">


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

        <a href="courseTypeAction_findAllByPage.action?pc=1">[首页]</a>

        <c:if test="${requestScope.pageBean.currentPage > 1}">
            <a href="courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage - 1}${requestScope.pageBean.param}">上一页</a>
        </c:if>
        <c:forEach end="${end}" begin="${begin}" var="v">

        <a href="courseTypeAction_findAllByPage.action?pc=${v}${requestScope.pageBean.param}">
          <c:if test="${requestScope.pageBean.currentPage eq v}">
              ${v}
          </c:if>
          <c:if test="${requestScope.pageBean.currentPage != v}">
              [${v}]
          </c:if>
        </a>
        </c:forEach>
        <c:if test="${requestScope.pageBean.currentPage < requestScope.pageBean.totalPage}">
            <a href="courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage + 1}${requestScope.pageBean.param}">下一页</a>
        </c:if>
    </c:if>
            <a href="courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.totalPage}">[尾页]</a>
        </span>
         </td>
     </tr>
 </table>
</body>
</html>
