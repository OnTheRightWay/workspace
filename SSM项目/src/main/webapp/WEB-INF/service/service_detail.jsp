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
    <form action="" method="" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>业务账号ID：</span></div>
        <div class="input_info"><input type="text" value="${service.serviceId}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info"><input type="text" value="${service.accountId}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>客户姓名：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${service.account.realName}" /></div>
        <div class="text_info clearfix"><span>身份证号码：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${service.account.idcardNo}" /></div>
        <div class="text_info clearfix"><span>服务器 IP：</span></div>
        <div class="input_info"><input type="text" value="${service.unixHost}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>OS 账号：</span></div>
        <div class="input_info"><input type="text" value="${service.serviceId}" readonly class="readonly" /></div>
        <div class="text_info clearfix"><span>状态：</span></div>
        <div class="input_info">
            <select disabled>
                <option value="1"
                        <c:if test="${service.status eq '1'}">
                            selected
                        </c:if>
                >开通</option>
                <option value="0"
                        <c:if test="${service.status eq '0'}">
                            selected
                        </c:if>
                >暂停</option>
                <option value="2"
                        <c:if test="${service.status eq '2'}">
                            selected
                        </c:if>
                >删除</option>
            </select>
        </div>
        <div class="text_info clearfix"><span>开通时间：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="<f:formatDate value="${service.createDate}" type="date"/>" /></div>
        <div class="text_info clearfix"><span>资费 ID：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${service.costId}"/></div>
        <div class="text_info clearfix"><span>资费名称：</span></div>
        <div class="input_info"><input type="text" readonly class="width200 readonly" value="${service.cost.name}"/></div>
        <div class="text_info clearfix"><span>资费说明：</span></div>
        <div class="input_info_high">
            <textarea class="width300 height70 readonly" readonly>${service.cost.descr}</textarea>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/service/findServiceByPage?pc=1';" />
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
    <br />
    <span>版权所有(C)云科技有限公司 </span>
</div>
</body>
</html>
