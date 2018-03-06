<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sys.css" type="text/css"/>
<title>班级管理</title>
</head>
<body>
<!--距离页面顶端5px-->
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<form name="createForm" action="" method="post">
<table border="0" cellspacing="0" cellpadding="0" class="wukuang">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="20%" align="left">[班级管理]</td>
    <td width="42%"align="center">&nbsp;</td>
    <td width="36%"align="right">
    	<%--添加班级  /html/classesm/addClass.jsp--%>
    	<a href="<s:url action="classesAction_toEdit"/>?classId=">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" class="img"/>
    	</a>
    	<%--高级查询 
        <a href="queryClass.html"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" class="img"/></a>
    	--%>
    </td>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
</form>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="topg"></td>
  </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="97%" border="1">
<thead>
  <tr class="henglan" style="font-weight:bold;">
	<th width="150px" align="center">班级名称</th>
    <th width="200px" align="center">所属课程</th>
    <th width="80px" align="center">开班时间</th>
    <th width="80px" align="center">毕业时间</th>
    
    <th width="80px" align="center">状态</th>
    <th width="70px" align="center">学生总数</th>
    <th width="70px" align="center">升学数</th>
    <th width="70px" align="center">转班数</th>
    <th width="50px" align="center">编辑</th>
	<th width="50px" align="center">查看</th>
	<th align="center">课程表</th>
  </tr>
  </thead>

  <tbody>

  <c:set var="i" value="0"/>
  	<s:iterator var="classes" value="#request.pageBean.lists">
		<c:set var="i" value="${i+1}"/>
		<c:if test="${i%2==0}" var="t">
		<tr class="tabtd2">
			<td align="center">${classes.name}</td>
			<td align="center">${classes.courseType.courseName}</td>
			<td align="center">${classes.beginTime}</td>
			<td align="center">${classes.endTime}</td>
			<td align="center">${classes.status}</td>
			<td align="center">${classes.totalCount}</td>
			<td align="center">${classes.upgradeCount}</td>
			<td align="center">${classes.changeCount}</td>
			<td align="center">
				<a href="<s:url action="classesAction_toEdit"/>?classId=${classes.classId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
			</td>
			<td align="center">
				<a href="${pageContext.request.contextPath}/pages/classesm/showClass.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
			</td>
			<td align="center" title="上次上传时间：${classes.uploadTime}">
				<a href="<s:url value="classesAction_toUpload.action"/>?classId=${classes.classId}">上传</a>
				<a href="<s:url value="classesAction_download.action"/>?classId=${classes.classId}">下载</a> <br/>
			</td>
		</tr>
		</c:if>
		<c:if test="${!t}">
			<tr class="tabtd1">
				<td align="center">${classes.name}</td>
				<td align="center">${classes.courseType.courseName}</td>
				<td align="center">${classes.beginTime}</td>
				<td align="center">${classes.endTime}</td>
				<td align="center">${classes.status}</td>
				<td align="center">${classes.totalCount}</td>
				<td align="center">${classes.upgradeCount}</td>
				<td align="center">${classes.changeCount}</td>
				<td align="center">
					<a href="<s:url action="classesAction_toEdit"/>?classId=${classes.classId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
				</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/pages/classesm/showClass.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
				</td>
				<td align="center" title="上次上传时间：${classes.uploadTime}">
					<a href="<s:url value="classesAction_toUpload.action"/>?classId=${classes.classId}">上传</a>
					<a href="<s:url action="classesAction_download"/>?classId=${classes.classId}">下载</a> <br/>
				</td>
			</tr>
		</c:if>

	</s:iterator>



	  <%--<tr class="tabtd2">--%>
	    <%--<td align="center">J161001期</td>--%>
	    <%--<td align="center">JavaEE </td>--%>
	    <%--<td align="center">2016-10-10</td>--%>
	    <%--<td align="center">2016-11-1</td>--%>
	    <%--<td align="center">已结束</td>--%>
	    <%--<td align="center">1 </td>--%>
	    <%--<td align="center">2 </td>--%>
	    <%--<td align="center">0 </td>--%>
	    <%--<td align="center">--%>
	    	<%--<a href="${pageContext.request.contextPath}/pages/classesm/addOrEditClass.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>--%>
	    <%--</td>--%>
		<%--<td align="center">--%>
	    	<%--<a href="${pageContext.request.contextPath}/pages/classesm/showClass.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>--%>
		<%--</td>--%>
		<%--<td align="center" title="上次上传时间：2015-04-02">   --%>
			<%--<a href="${pageContext.request.contextPath}/pages/classesm/uploadClass.jsp">上传</a>--%>
			<%--<a href="${pageContext.request.contextPath}/pages/classesm/downloadClass">下载</a> <br/>--%>
		<%--</td>--%>
	  <%--</tr>--%>




	  <%--<tr class="tabtd1">--%>
	    <%--<td align="center">J161002期</td>--%>
	    <%--<td align="center">JavaEE </td>--%>
	    <%--<td align="center">2016-11-10</td>--%>
	    <%--<td align="center">2016-12-10</td>--%>
	    <%--<td align="center">已开班</td>--%>
	    <%--<td align="center">0 </td>--%>
	    <%--<td align="center">0 </td>--%>
	    <%--<td align="center">0 </td>--%>
	    <%--<td align="center">--%>
	    	<%--<a href="${pageContext.request.contextPath}/classesm/classAction_preAddOrEdit.action?classId=2c9091c14c78e58b014c78e9106e000b"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>--%>
	    <%--</td>--%>
		<%--<td align="center">--%>
	    	<%--<a href="${pageContext.request.contextPath}/classesm/classAction_findById.action?classId=2c9091c14c78e58b014c78e9106e000b"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>--%>
		<%--</td>--%>
		<%--<td align="center" title="上次上传时间：">   --%>
			<%--<a href="${pageContext.request.contextPath}/classesm/classAction_preUpload.action?classId=2c9091c14c78e58b014c78e9106e000b">上传</a>--%>
			 <%--暂无--%>
		<%--</td>--%>
	  <%--</tr>--%>
  
  </tbody>
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

		<a href="classesAction_findAllByPage.action?pc=1">[首页]</a>

		<c:if test="${requestScope.pageBean.currentPage > 1}">
			<a href="classesAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage - 1}${requestScope.pageBean.param}">上一页</a>
		</c:if>
		<c:forEach end="${end}" begin="${begin}" var="v">

        <a href="classesAction_findAllByPage.action?pc=${v}${requestScope.pageBean.param}">
          <c:if test="${requestScope.pageBean.currentPage eq v}">
			  ${v}
		  </c:if>
          <c:if test="${requestScope.pageBean.currentPage != v}">
			  [${v}]
		  </c:if>
        </a>
		</c:forEach>
		<c:if test="${requestScope.pageBean.currentPage < requestScope.pageBean.totalPage}">
			<a href="classesAction_findAllByPage.action?pc=${requestScope.pageBean.currentPage + 1}${requestScope.pageBean.param}">下一页</a>
		</c:if>
	</c:if>
            <a href="classesAction_findAllByPage.action?pc=${requestScope.pageBean.totalPage}">[尾页]</a>
        </span>
		</td>
	</tr>
</table>

</body>
</html>
