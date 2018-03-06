<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="<s:url action="staffAction_edit"/> " method="post">
	
	<input type="hidden" name="staffId" value="${requestScope.staff.staffId}"/>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="${requestScope.staff.loginName}"/> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" value="${requestScope.staff.loginPwd}"/> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="${requestScope.staff.staffName}" /> </td>
	    <td>性别：</td>
	    <td>

			<input type="radio" name="gender"
				<c:if test="${requestScope.staff.gender eq '男'}" var="gender">
					   checked="checked"
				</c:if>
					   value="男"/>男

				<input type="radio" name="gender"
				<c:if test="${!gender}">
					   checked="checked"
				</c:if>
					   value="女"/>女

	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
			<s:select name="post.department.depId" list="#request.departments" listKey="depId" listValue="depName"
					  headerKey="" headerValue="--请选择部门--" onchange="changePost(this,'postSelectId')" />

			<%--<select name="post.crmDepartment.depId" onchange="changePost(this,'postSelectId')" id="dep">--%>
				<%--<option value="">----请--选--择----</option>--%>
				<%--<s:iterator var="department1" value="#request.departments">--%>
					<%--<option value="${department1.depId}"--%>
							<%--<c:if test="${department1.depId eq requestScope.department.depId}">--%>
								<%--selected="selected"--%>
							<%--</c:if>--%>
					<%-->${department1.depName}</option>--%>
				<%--</s:iterator>--%>
			<%--</select>--%>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select name="post.postId" id="postSelectId">
			    <option value="">----请--选--择----</option>
				<%--<s:iterator var="post" value="#request.posts">--%>
					<%--<option value="${post.postId}"--%>
							<%--<c:if test="${post.postId eq requestScope.staff.postId}">--%>
								<%--selected="selected"--%>
							<%--</c:if>--%>
					<%-->${post.postName}</option>--%>
				<%--</s:iterator>--%>
			</select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="${requestScope.staff.onDutyDate}" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>

</body>
<script src="${pageContext.request.contextPath}/js/core.js" type="text/javascript">

</script>
<script type="text/javascript">
    function init() {
        var element = document.getElementById("dep");
        changePost(element,'postSelectId');
        var depId = "${requestScope.department.depId}";
    }
    init();
</script>

</html>
