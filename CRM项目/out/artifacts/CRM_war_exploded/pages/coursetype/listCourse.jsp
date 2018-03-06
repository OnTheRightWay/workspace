<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <td width="39%" align="left">[课程类别]</td>
   
    <td width="57%"align="right">
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();">
			<img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" />
		</a>      
    	<%--编辑前：添加类别 --%>
    	<a href="${pageContext.request.contextPath}/pages/coursetype/addOrEditCourse.jsp">
	       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>


<%--条件查询 start --%>

<form action="<s:url action="courseTypeAction_findAllByPage?pc=1"/>" method="post">
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	  <tr>
	    <td width="10%">课程类别：</td>
	    <td><input type="text" name="courseName" size="30" value="${requestScope.pageBean.params.courseName}" /></td>
	  </tr>
	  <tr>
	    <td >课程简介：</td>
	    <td > <input type="text" name="remark" size="30" value="${requestScope.pageBean.params.remark}" /></td>
	  </tr>
	  <tr>  
	    <td >总学时：</td>
	    <td ><input type="text" name="mintotal" size="12" value="${requestScope.pageBean.params.mintotal}" />  至  <input type="text" name="maxtotal" size="12" value="${requestScope.pageBean.params.maxtotal}" /></td>
	  </tr>
	  <tr>
	    <td>课程费用：</td>
	    <td ><input type="text" name="minCourseCost" size="12" value="${requestScope.pageBean.params.minCourseCost}" /> 至 <input type="text" name="maxCourseCost" size="12" value="${requestScope.pageBean.params.maxCourseCost}" /></td>
	  </tr>
	</table>
</form>

<%--条件查询 end --%>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="97%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">
    <td width="14%" align="center">名称</td>
    <td width="33%" align="center">简介</td>
    <td width="13%" align="center">总学时</td>
    <td width="18%" align="center">收费标准</td>
	<td width="11%" align="center">编辑</td>
  </tr>
	<c:set var="i" value="0"/>
	<c:forEach var="courseType" items="${requestScope.pageBean.lists}">
		<c:set var="i" value="${i+1}"/>
		<c:if test="${i%2 == 0}" var="t">
			<tr class="tabtd2">
				<td>${courseType.courseName}</td>
				<td>${courseType.remark}</td>
				<td>${courseType.total}</td>
				<td>${courseType.courseCost}</td>
				<td width="11%" align="center">
					<a href="<s:url action="courseTypeAction_toEdit"/>?courseTypeId=${courseType.courseTypeId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
				</td>
			</tr>
		</c:if>
		<c:if test="${!t}">
			<tr class="tabtd1">
				<td>${courseType.courseName}</td>
				<td>${courseType.remark}</td>
				<td>${courseType.total}</td>
				<td>${courseType.courseCost}</td>
				<td width="11%" align="center">
					<a href="<s:url action="courseTypeAction_toEdit"/>?courseTypeId=${courseType.courseTypeId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
				</td>
			</tr>
		</c:if>
	</c:forEach>
 
</table>

<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第${requestScope.pageBean.currentPage}/${requestScope.pageBean.totalPage}页</span>
        <span>
			<c:set var="pageBean" value="${requestScope.pageBean}"/>
    <c:if test="${pageBean!=null}">

		<f:formatNumber var="left" value="${(requestScope.pageBean.pageSize-1)/2}" maxFractionDigits="0" pattern="#"/>
		<f:formatNumber var="right" value="${(requestScope.pageBean.pageSize-1)/2+0.1}" maxFractionDigits="0" pattern="#"/>

      <c:set var="begin" value="1"/>
      <c:set var="end" value="${requestScope.pageBean.totalPage}"/>

      <c:if test="${requestScope.pageBean.currentPage>right}">
		  <c:set var="begin" value="${requestScope.pageBean.currentPage - right}"/>
	  </c:if>
      <c:if test="${requestScope.pageBean.currentPage < (requestScope.pageBean.totalPage - left)}">
		  <c:set var="end" value="${requestScope.pageBean.currentPage+left}"/>
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

        	<a href="courseTypeAction_findAllByPage.action?pc=1${requestScope.pageBean.param}">[首页]</a>

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
            <a href="courseTypeAction_findAllByPage.action?pc=${requestScope.pageBean.totalPage}${requestScope.pageBean.param}">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
</body>
</html>
