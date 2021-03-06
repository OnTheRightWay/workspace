﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存结果的提示
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }

            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }

            //切换资费类型
            function feeTypeChange(type) {
                var inputArray = document.getElementById("main").getElementsByTagName("input");
                document.getElementById("1").style.display='none';
                document.getElementById("2").style.display='none';
                document.getElementById("3").style.display='none';
                document.getElementById("4").style.display='none';
                document.getElementById("5").style.display='none';
                if (type == 1) {
                    c2=false;
                    a2=true;
                    c4=false;
                    a4=true;
                    c3=true;
                    a3=false;
                    inputArray[4].readOnly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readOnly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readOnly = true;
                    inputArray[6].className += " readonly";
                    inputArray[6].value = "";
                }
                else if (type == 2) {
                    c2=true;
                    a2=false;
                    c4=true;
                    a4=false;
                    c3=true;
                    a3=false;
                    inputArray[4].readOnly = false;
                    inputArray[4].className = "width100";
                    inputArray[5].readOnly = false;
                    inputArray[5].className = "width100";
                    inputArray[6].readOnly = false;
                    inputArray[6].className = "width100";
                }
                else if (type == 3) {
                    c2=false;
                    a2=true;
                    c4=true;
                    a4=false;
                    c3=false;
                    a3=true;
                    inputArray[4].readOnly = true;
                    inputArray[4].value = "";
                    inputArray[4].className += " readonly";
                    inputArray[5].readOnly = true;
                    inputArray[5].value = "";
                    inputArray[5].className += " readonly";
                    inputArray[6].readOnly = false;
                    inputArray[6].className = "width100";
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
        <div id="save_result_info" class="save_fail">保存失败，资费名称重复！</div>
        <form action="${pageContext.request.contextPath}/cost/addCost" method="post" class="main_form">
            <div class="text_info clearfix"><span>资费名称：</span></div>
            <div class="input_info">
                <input type="text" class="width300" value="" name="name" id="name"/>
                <span class="required">*</span>
                <div class="validate_msg_short" id="1" style="display: none">50长度的字母、数字、汉字和下划线的组合</div>
            </div>
            <div class="text_info clearfix"><span>资费类型：</span></div>
            <div class="input_info fee_type">
                <input type="radio" name="costType" id="monthly" onclick="feeTypeChange(1);" value="0" />
                <label for="monthly">包月</label>
                <input type="radio" name="costType" checked="checked" id="package" onclick="feeTypeChange(2);" value="1"/>
                <label for="package">套餐</label>
                <input type="radio" name="costType" id="timeBased" onclick="feeTypeChange(3);" value="2"/>
                <label for="timeBased">计时</label>
            </div>
            <div class="text_info clearfix"><span>基本时长：</span></div>
            <div class="input_info">
                <input type="text" value="" class="width100" name="baseDuration" id="baseDuration"/>
                <span class="info">小时</span>
                <span class="required">*</span>
                <div class="validate_msg_long" id="2" style="display: none">1-600之间的整数</div>
            </div>
            <div class="text_info clearfix"><span>基本费用：</span></div>
            <div class="input_info">
                <input type="text" value="" class="width100" name="baseCost" id="baseCost"/>
                <span class="info">元</span>
                <span class="required">*</span>
                <div class="validate_msg_long error_msg" id="3" style="display: none">0-99999.99之间的数值</div>
            </div>
            <div class="text_info clearfix"><span>单位费用：</span></div>
            <div class="input_info">
                <input type="text" value="" class="width100" name="unitCost" id="unitCost"/>
                <span class="info">元/小时</span>
                <span class="required">*</span>
                <div class="validate_msg_long error_msg" id="4" style="display: none">0-99999.99之间的数值</div>
            </div>
            <div class="text_info clearfix"><span>资费说明：</span></div>
            <div class="input_info_high">
                <textarea class="width300 height70" name="descr" id="descr"></textarea>
                <div class="validate_msg_short error_msg" id="5" style="display: none">100长度的字母、数字、汉字和下划线的组合</div>
            </div>
            <div class="button_info clearfix">
                <input type="button" value="保存" class="btn_save" id="ll"/>
                <input type="button" value="取消" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/cost/findAllCost?pc=1'"/>
            </div>
        </form>
    </div>
    <!--主要区域结束-->
    <div id="footer">
        <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
        <br />
        <span>版权所有(C)云科技有限公司 </span>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/format.js" type="text/javascript"></script>
    </body>
</html>
