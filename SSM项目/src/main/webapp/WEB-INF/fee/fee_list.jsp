<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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
        <li><a href="${pageContext.request.contextPath}/cost/findAllCost?pc=1" class="fee_on"></a></li>
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
        <!--排序-->
        <div class="search_add">
            <div>
                <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                <input type="button" value="基费" class="sort_asc"
                        <c:if test="${pageBean.params.byCost == null||pageBean.params.byCost eq ''}" var="byCostUp">
                            onclick="location.href='${pageContext.request.contextPath}/cost/findAllCost?pc=1&byCost=1&byDuration=${pageBean.params.byDuration}';"
                        </c:if>
                        <c:if test="${!byCostUp}">
                            onclick="location.href='${pageContext.request.contextPath}/cost/findAllCost?pc=1&byCost=&byDuration=${pageBean.params.byDuration}';"
                        </c:if>
                       id="byCost"/>
                <input type="button" value="时长" class="sort_asc"
                        <c:if test="${pageBean.params.byDuration == null||pageBean.params.byDuration eq ''}" var="byDurationUp">
                            onclick="location.href='${pageContext.request.contextPath}/cost/findAllCost?pc=1&byCost=${pageBean.params.byCost}&byDuration=1';"
                        </c:if>
                        <c:if test="${!byDuration}">
                            onclick="location.href='${pageContext.request.contextPath}/cost/findAllCost?pc=1&byCost=${pageBean.params.byCost}&byDuration=';"
                        </c:if>
                       id="byDuration"/>
            </div>
            <input type="button" value="增加" class="btn_add" onclick="location.href='/goto?name=WEB-INF/fee/fee_add';" />
        </div>
        <!--启用操作的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>资费ID</th>
                    <th class="width100">资费名称</th>
                    <th>基本时长</th>
                    <th>基本费用</th>
                    <th>单位费用</th>
                    <th>创建时间</th>
                    <th>开通时间</th>
                    <th class="width50">状态</th>
                    <th class="width200"></th>
                </tr>
                <c:forEach var="cost" items="${pageBean.lists}">
                    <tr>
                        <td>${cost.costId}</td>
                        <td><a href="detail/${cost.costId}">${cost.name}</a></td>
                        <td>${cost.baseDuration}</td>
                        <td>${cost.baseCost}</td>
                        <td>${cost.unitCost}</td>
                        <td><f:formatDate value="${cost.creatime}" type="both"/></td>
                        <td><f:formatDate value="${cost.startime}" type="both"/></td>
                        <c:if test="${cost.status=='0'}" var="status">
                            <td>暂停</td>
                        </c:if>

                        <c:if test="${!status}">
                            <td>开通</td>
                        </c:if>
                        <td>
                        <c:if test="${status}">

                                <input type="button" value="启用" class="btn_start" onclick="startFee('${cost.costId}');" />
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toModi/${cost.costId}';" />
                                <input type="button" value="删除" class="btn_delete" onclick="deleteFee('${cost.costId}')" />

                        </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>业务说明：<br />
                1、创建资费时，状态为暂停，记载创建时间；<br />
                2、暂停状态下，可修改，可删除；<br />
                3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
            </p>
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
                    <a href="${pageContext.request.contextPath}/cost/findAllCost?pc=${pageBean.currentPage - 1}${pageBean.param}">上一页</a>
                </c:if>
                <c:forEach end="${end}" begin="${begin}" var="v">

                    <c:if test="${pageBean.currentPage eq v}">
                        <a href="${pageContext.request.contextPath}/cost/findAllCost?pc=${v}${pageBean.param}" class="current_page">
                                ${v}
                        </a>
                    </c:if>
                    <c:if test="${pageBean.currentPage != v}">
                        <a href="${pageContext.request.contextPath}/cost/findAllCost?pc=${v}${pageBean.param}">
                                ${v}
                        </a>
                    </c:if>

                </c:forEach>
                <c:if test="${pageBean.currentPage < pageBean.totalPage}">
                    <a href="${pageContext.request.contextPath}/cost/findAllCost?pc=${pageBean.currentPage + 1}${pageBean.param}">下一页</a>
                </c:if>
            </c:if>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
    <p>版权所有(C)云科技有限公司</p>
</div>
<script src="../../js/jquery-3.2.1.min.js"></script>
<script language="javascript" type="text/javascript">
    //排序按钮的点击事件
    function sort() {
        if (${pageBean.params.byCost==null||pageBean.params.byCost eq ''}){
            $('#byCost').attr({"class":"sort_desc"})
        }else {
            $('#byCost').attr({"class":"sort_asc"})
        }
        if (${pageBean.params.byDuration==null||pageBean.params.byDuration eq ''}){
            $('#byDuration').attr({"class":"sort_desc"})
        }else {
            $('#byDuration').attr({"class":"sort_asc"})
        }
//            if (btnObj.className == "sort_desc")
//                btnObj.className = "sort_asc";
//            else
//                btnObj.className = "sort_desc";
    }

    //启用
    function startFee(costId) {
        var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
        if (r===true){
            window.location.href='${pageContext.request.contextPath}/cost/updateStatus/'+costId;
        }
    }
    //删除
    function deleteFee(costId) {
        var r = window.confirm("确定要删除此资费吗？");
        if (r===true){
            window.location.href='${pageContext.request.contextPath}/cost/deleteCost/'+costId;
        }
    }
    sort();
</script>
</body>
</html>
