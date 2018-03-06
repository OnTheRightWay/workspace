<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
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
        //删除
        function deleteAccount(serviceId) {
            var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
            if (r){
                document.getElementById("operate_result_info").style.display = "block";
                location.href='${pageContext.request.contextPath}/service/deleteService/'+serviceId;
            }
        }
        //开通或暂停
        function setState(status,c) {
            if (status==='2'){
                window.confirm("改业务已删除");
                return;
            }
            var r;
            if (status==='0'){
                r = window.confirm("确定要开通此业务吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
            if (status==='1'){
                r = window.confirm("确定要暂停此业务吗？");
                document.getElementById("operate_result_info").style.display = "block";
            }
            if (r){
                location.href=c;
            }
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
        <li><a href="${pageContext.request.contextPath}/role/findRoleByPage?pc=1" class="role_off"></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/findAdminByPage?pc=1" class="admin_off"></a></li>
        <li><a href="${pageContext.request.contextPath}/cost/findAllCost?pc=1" class="fee_off"></a></li>
        <li><a href="${pageContext.request.contextPath}/account/findAccountByPc?pc=1" class="account_off"></a></li>
        <li><a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=1" class="service_on"></a></li>
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
            <input type="hidden" value="1" name="pc"/>
            <div>OS 账号：<input type="text" value="${pageBean.params.osUsername}" name="osUsername" class="width100 text_search" /></div>
            <div>服务器 IP：<input type="text" value="${pageBean.params.unixHost}" name="unixHost" class="width100 text_search" /></div>
            <div>身份证：<input type="text"  value="${pageBean.params.idcardNo}" name="idcardNo" class="text_search" /></div>
            <div>
                状态：
                <select class="select_search" name="status">
                    <option value=""
                            <c:if test="${pageBean.params.status eq ''}">
                                selected
                            </c:if>
                    >全部</option>
                    <option value="1"
                            <c:if test="${pageBean.params.status eq '1'}">
                                selected
                            </c:if>
                    >开通</option>
                    <option value="0"
                            <c:if test="${pageBean.params.status eq '0'}">
                                selected
                            </c:if>
                    >暂停</option>
                    <option value="2"
                            <c:if test="${pageBean.params.status eq '2'}">
                                selected
                            </c:if>
                    >删除</option>
                </select>
            </div>
            <div><input type="submit" value="搜索" class="btn_search" /></div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/service/toAdd';" />
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th class="width50">业务ID</th>
                    <th class="width70">账务账号ID</th>
                    <th class="width150">身份证</th>
                    <th class="width70">姓名</th>
                    <th>OS 账号</th>
                    <th class="width50">状态</th>
                    <th class="width100">服务器 IP</th>
                    <th class="width100">资费</th>
                    <th class="width200"></th>
                </tr>
                <c:forEach items="${pageBean.lists}" var="service">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/service/ServiceDetail/${service.serviceId}" title="查看明细">${service.serviceId}</a></td>
                        <td>${service.accountId}</td>
                        <td>${service.account.idcardNo}</td>
                        <td>${service.account.realName}</td>
                        <td>${service.osUsername}</td>
                        <c:if test="${service.status eq '0'}">
                            <td>暂停</td>
                        </c:if>
                        <c:if test="${service.status eq '1'}">
                            <td>开通</td>
                        </c:if>
                        <c:if test="${service.status eq '2'}">
                            <td>删除</td>
                        </c:if>
                        <td>${service.unixHost}</td>
                        <td>
                            <a class="summary"  onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">${service.cost.name}</a>
                            <!--浮动的详细信息-->
                            <div class="detail_info">
                                    ${service.cost.descr}
                            </div>
                        </td>
                        <c:if test="${!(service.status eq '2')}">
                            <td class="td_modi">
                                <c:if test="${service.status eq '1'}">
                                    <input type="button" value="暂停" class="btn_pause" onclick="setState('${service.status}','${pageContext.request.contextPath}/service/updateStatus?status=${service.status}&serviceId=${service.serviceId}')"/>
                                </c:if>
                                <c:if test="${service.status eq '0'}">
                                    <input type="button" value="开通" class="btn_pause" onclick="setState('${service.status}','${pageContext.request.contextPath}/service/updateStatus?status=${service.status}&serviceId=${service.serviceId}');" />
                                </c:if>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/service/toModi/${service.serviceId}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteAccount('${service.serviceId}');" />
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
            <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=1${pageBean.param}">首页</a>
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
                    <a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=${pageBean.currentPage - 1}${pageBean.param}">上一页</a>
                </c:if>
                <c:forEach end="${end}" begin="${begin}" var="v">

                    <c:if test="${pageBean.currentPage eq v}">
                        <a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=${v}${pageBean.param}" class="current_page">
                                ${v}
                        </a>
                    </c:if>
                    <c:if test="${pageBean.currentPage != v}">
                        <a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=${v}${pageBean.param}">
                                ${v}
                        </a>
                    </c:if>

                </c:forEach>
                <c:if test="${pageBean.currentPage < pageBean.totalPage}">
                    <a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=${pageBean.currentPage + 1}${pageBean.param}">下一页</a>
                </c:if>
            </c:if>
            <a href="${pageContext.request.contextPath}/service/findServiceByPage?pc=${requestScope.pageBean.totalPage}${pageBean.param}">末页</a>
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
