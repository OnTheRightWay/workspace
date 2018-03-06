<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="javascript:document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="<s:url action="staffAction_toAdd"/>">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="<s:url action="staffAction_findByParams"/> " method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    	
	    	<%--<select name="post.department.depId" onchange="changePost(this,'postSelectId')">--%>
			    <%--<option value="">--请选择部门--</option>--%>
				<%--<s:iterator value="#departments" var="dep">--%>
					<%--<option value="<s:property value="#dep.depId"/>" ><s:property value="#dep.depName"/></option>--%>
				<%--</s:iterator>--%>
			<%--</select>--%>
			<s:select name="post.department.depId" list="#request.departments" listKey="depId" listValue="depName"
			headerKey="" headerValue="--请选择部门--" onchange="changePost(this,'postSelectId')"/>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	    	
	    	<select name="post.postId" id="postSelectId">
			    <option value="">--请选择职务--</option>
				<%--<s:iterator value="#posts" var="post">--%>
					<%--<option value="<s:property value="%{#post.postId}"/>"><s:property value="%{#post.postName}"/></option>--%>
				<%--</s:iterator>--%>
			</select>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" ><input type="text" name="staffName" size="12" /></td>
	    <td ></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>

	<c:set var="i" value="0"/>
<s:iterator var="staff" value="#staffs">
	<c:set var="i" value="${i+1}"/>
	<c:if test="${i%2 == 0}" var="v">
		<tr class="tabtd1">
			<td align="center"><s:property value="#staff.staffName"/></td>
			<td align="center"><s:property value="#staff.gender"/></td>
			<td align="center"><s:property value="#staff.onDutyDate"/></td>
			<td align="center"><s:property value="#staff.post.postName"/></td>
			<td align="center"><s:property value="#staff.post.department.depName"/></td>
			<td width="7%" align="center">

				<a href="<s:url value="staffAction_showByStaffId.action?staffId=%{#staff.staffId}"/>"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
			</td>
		</tr>
	</c:if>
	<c:if test="${!v}">
		<tr class="tabtd2">
			<td align="center"><s:property value="#staff.staffName"/></td>
			<td align="center"><s:property value="#staff.gender"/></td>
			<td align="center"><s:property value="#staff.onDutyDate"/></td>
			<td align="center"><s:property value="#staff.post.postName"/></td>
			<td align="center"><s:property value="#staff.post.department.depName"/></td>
			<td width="7%" align="center">

				<a href="<s:url value="staffAction_showByStaffId.action?staffId=%{#staff.staffId}"/>"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
			</td>
		</tr>
	</c:if>

</s:iterator>

</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
</body>
	<script src="<s:url value="/js/core.js"/>" type="text/javascript">

	</script>
</html>
