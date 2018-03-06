<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />

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
        <li><a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=1" class="role_off"></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=1" class="admin_on"></a></li>
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
    <form action="${pageContext.request.contextPath}/admin/findAdminByPage" method="post">
        <input type="hidden" name="pc" value="1"/>
        <!--查询-->
        <div class="search_add">
            <div>
                模块：
                <select id="selModules" class="select_search" name="moduleId">
                    <option value="">全部</option>
                    <c:forEach items="${modules}" var="module">
                        <option value="${module.moduleId}"
                                <c:if test="${pageBean.params.moduleId eq module.moduleId}">
                                    selected
                                </c:if>
                        >${module.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div>角色：<input type="text" value="${pageBean.params.name}" name="name" class="text_search width200" /></div>
            <div><input type="submit" value="搜索" class="btn_search"/></div>
            <input type="button" value="密码重置" class="btn_add" onclick="resetPwd();" />
            <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/admin/toAdd';" />
        </div>
        <!--删除和密码重置的操作提示-->
        <div id="operate_result_info" class="operate_fail">
            <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
            <%--<span>删除失败！数据并发错误。</span><!--密码重置失败！数据并发错误。-->--%>
            <span>删除成功！</span><!--密码重置失败！数据并发错误。-->
        </div>
    </form>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th class="th_select_all">
                        <input type="checkbox" onclick="selectAdmins(this);" />
                        <span>全选</span>
                    </th>
                    <th>管理员ID</th>
                    <th>姓名</th>
                    <th>登录名</th>
                    <th>电话</th>
                    <th>电子邮件</th>
                    <th>授权日期</th>
                    <th class="width100">拥有角色</th>
                    <th></th>
                </tr>
                <form id="passwordRst" action="${pageContext.request.contextPath}/admin/resetPassword" method="post">
                    <c:forEach items="${pageBean.lists}" var="admin">
                        <tr>
                            <td><input type="checkbox" name="adminIds" value="${admin.adminId}"/></td>
                            <td>${admin.adminId}</td>
                            <td>${admin.name}</td>
                            <td>${admin.adminCode}</td>
                            <td>${admin.telephone}</td>
                            <td>${admin.email}</td>
                            <td><f:formatDate value="${admin.enrolldate}" type="date"/></td>
                            <td>
                                <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">
                                        ${admin.roles[0].name}
                                    <c:if test="${admin.roles[1]!=null}">
                                        ...
                                    </c:if>
                                </a>
                                <!--浮动的详细信息-->
                                <div class="detail_info">
                                    <c:set var="isFirst" value="true"/>
                                    <c:forEach items="${admin.roles}" var="role">
                                        <c:if test="${!isFirst}">
                                            ,
                                        </c:if>
                                        ${role.name}
                                        <c:set var="isFirst" value="false"/>
                                    </c:forEach>
                                </div>
                            </td>
                            <td class="td_modi">
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/admin/toModi/${admin.adminId}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteAdmin('${admin.adminId}');" />
                            </td>
                        </tr>
                    </c:forEach>
                </form>
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
                    <a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=1${pageBean.param}">首页</a>
                    <a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=${pageBean.currentPage - 1}${pageBean.param}">上一页</a>
                </c:if>
                <c:forEach end="${end}" begin="${begin}" var="v">

                    <c:if test="${pageBean.currentPage eq v}">
                        <a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=${v}${pageBean.param}" class="current_page">
                                ${v}
                        </a>
                    </c:if>
                    <c:if test="${pageBean.currentPage != v}">
                        <a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=${v}${pageBean.param}">
                                ${v}
                        </a>
                    </c:if>

                </c:forEach>
                <c:if test="${pageBean.currentPage < pageBean.totalPage}">
                    <a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=${pageBean.currentPage + 1}${pageBean.param}">下一页</a>
                    <a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=${requestScope.pageBean.totalPage}${pageBean.param}">末页</a>
                </c:if>
            </c:if>

        </div>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <span>版权所有(C)云科技有限公司 </span>
</div>
<script language="javascript" type="text/javascript">
    //显示角色详细信息
    function showDetail(flag, a) {
        var detailDiv = a.parentNode.getElementsByTagName("div")[0];
        if (flag) {
            detailDiv.style.display = "block";
        }
        else
            detailDiv.style.display = "none";
    }
    //重置密码
    function resetPwd() {
        var cbs = document.getElementsByName("adminIds");
        var checkNum = 0;

        for (var i = 0; i < cbs.length; i++) {
            if (cbs[i].checked) {
                checkNum++;
            }
        }
//                alert("选中数量=" + checkNum);
        if (checkNum == 0) {
//                    document.getElementById("1").style.display='block';
            alert("请至少选择一条数据！");
            return;
        }

        for (var i = 0; i < cbs.length; i++) {
            if (cbs[i].checked) {
                console.log(cbs[i].value)
            }
        }
        document.getElementById("passwordRst").submit();
    }
    //删除
    function deleteAdmin(adminId) {
        var r = window.confirm("确定要删除此管理员吗？");
        if (r){
            document.getElementById("operate_result_info").style.display = "block";
            location.href='${pageContext.request.contextPath}/admin/deleteAdmin/'+adminId
        }
    }
    //全选
    function selectAdmins(inputObj) {
        var inputArray = document.getElementById("datalist").getElementsByTagName("input");
        for (var i = 1; i < inputArray.length; i++) {
            if (inputArray[i].type == "checkbox") {
                inputArray[i].checked = inputObj.checked;
            }
        }
    }
</script>
</body>
</html>
