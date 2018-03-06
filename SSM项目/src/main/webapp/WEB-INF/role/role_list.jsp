<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            function deleteRole(roleId) {
                var r = window.confirm("确定要删除此角色吗？");
                document.getElementById("operate_result_info").style.display = "block";
                location.href='${pageContext.request.contextPath}/role/deleteRole/'+roleId;
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../images/logo.png" alt="logo" class="left"/>
            <a href="${pageContext.request.contextPath}/quit">[退出]</a>
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="/index.jsp" class="index_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=1" class="role_on"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=1" class="admin_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/cost/findAllCost?pc=1" class="fee_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/account/findAccountByPc?pc=1" class="account_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=1" class="service_off"></a></li>
                <li><a href="bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="report/report_list.html" class="report_off"></a></li>
                <li><a href="user/user_info.html" class="information_off"></a></li>
                <li><a href="user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/role/toAdd';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>
                        <c:forEach items="${pageBean.lists}" var="role">
                            <tr>
                                <td>${role.roleId}</td>
                                <td>${role.name}</td>
                                <td>
                                    <c:set var="isFirst" value="true"/>
                                    <c:forEach items="${role.modules}" var="module">
                                        <c:if test="${!isFirst}">
                                            、
                                        </c:if>
                                        ${module.name}
                                        <c:set var="isFirst" value="false"/>
                                    </c:forEach>
                                </td>
                                <td>
                                    <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/role/toModi/${role.roleId}';"/>
                                    <input type="button" value="删除" class="btn_delete" onclick="deleteRole(${role.roleId});" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">

                    <c:if test="${pageBean!=null}">

                        <f:formatNumber var="left" value="${(pageBean.pageSize-1)/2}" maxFractionDigits="0" pattern="#"/>
                        <f:formatNumber var="right" value="${(pageBean.pageSize-1)/2+0.1}" maxFractionDigits="0" pattern="#"/>

                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="${pageBean.totalPage}"/>

                        <c:if test="${pageBean.currentPage>right}">
                            <c:set var="begin" value="${pageBean.currentPage - right}"/>
                        </c:if>
                        <c:if test="${pageBean.currentPage < (pageBean.totalPage - left)}">
                            <c:set var="end" value="${pageBean.currentPage+left}"/>
                        </c:if>
                        <c:if test="${end<pageBean.pageSize}">
                            <c:set var="end" value="${pageBean.pageSize}"/>
                        </c:if>
                        <c:if test="${begin>(end-pageBean.pageSize+1)}">
                            <c:set var="begin" value="${end-pageBean.pageSize+1}"/>
                        </c:if>
                        <c:if test="${end>pageBean.totalPage}">
                            <c:set var="end" value="${pageBean.totalPage}"/>
                        </c:if>

                        <c:if test="${pageBean.currentPage > 1}">
                            <a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=1${pageBean.param}">首页</a>
                            <a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=${pageBean.currentPage - 1}${pageBean.param}">上一页</a>
                        </c:if>
                        <c:forEach end="${end}" begin="${begin}" var="v">

                            <c:if test="${pageBean.currentPage eq v}">
                                <a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=${v}${pageBean.param}" class="current_page">
                                        ${v}
                                </a>
                            </c:if>
                            <c:if test="${pageBean.currentPage != v}">
                                <a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=${v}${pageBean.param}">
                                        ${v}
                                </a>
                            </c:if>

                        </c:forEach>
                        <c:if test="${pageBean.currentPage < pageBean.totalPage}">
                            <a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=${pageBean.currentPage + 1}${pageBean.param}">下一页</a>
                            <a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=${requestScope.pageBean.totalPage}${pageBean.param}">末页</a>
                        </c:if>
                    </c:if>

                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)云科技有限公司 </p>
        </div>
    </body>
</html>
