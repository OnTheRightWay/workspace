<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../../images/logo.png" alt="logo" class="left" />
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
                <li><a href="${pageContext.request.contextPath}/account/findAccountByPc?pc=1" class="account_on"></a></li>
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
            <form action="" method=post"" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>账务账号ID：</span></div>
                <div class="input_info"><input type="text" value="${account.accountId}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info"><input type="text" value="${account.realName}" readonly class="readonly" /></div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" value="${account.idcardNo}" readonly class="readonly" />
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input type="text" value="${account.loginName}" readonly class="readonly" />
                </div>                   
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200 readonly" readonly value="${account.telephone}" />
                </div>
                <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.recommenderId}" /></div>
                <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${idcardNo}" /></div>
                <div class="text_info clearfix"><span>状态：</span></div>
                <div class="input_info">
                    <select class="select_search" name="status" onfocus="this.defaultIndex=this.selectedIndex;"
                            onchange="this.selectedIndex=this.defaultIndex;">
                        <option value=""
                                <c:if test="${account.status eq ''}">
                                    selected
                                </c:if>
                        >全部</option>
                        <option value="1"
                                <c:if test="${account.status eq '1'}">
                                    selected
                                </c:if>
                        >开通</option>
                        <option value="0"
                                <c:if test="${account.status eq '0'}">
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
                <div class="text_info clearfix"><span>开通/暂停/删除时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="<f:formatDate value="${account.createDate}" type="both"/>" /></div>

                <div class="text_info clearfix"><span>上次登录时间：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="<f:formatDate value="${account.lastLoginTime}" type="both"/>" /></div>
                <div class="text_info clearfix"><span>上次登录IP：</span></div>
                <div class="input_info"><input type="text" readonly class="readonly" value="${account.lastLoginIp}" /></div>
                <!--可选项数据-->
                <div class="text_info clearfix"><span>生日：</span></div>
                <div class="input_info">
                    <input type="text" readonly class="readonly" value="<f:formatDate value="${account.birthdate}" type="date"/>" />
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width350 readonly" readonly value="${account.email}" />
                </div>

                <div class="text_info clearfix"><span>职业：</span></div>
                <div class="input_info">
                    <select name="occupation" onfocus="this.defaultIndex=this.selectedIndex;"
                            onchange="this.selectedIndex=this.defaultIndex;">
                        <option
                                <c:if test="${account.occupation eq '干部'}">
                                    selected
                                </c:if>
                                value="干部"
                        >干部</option>
                        <option
                                <c:if test="${account.occupation eq '学生'}">
                                    selected
                                </c:if>
                                value="学生"
                        >学生</option>
                        <option
                                <c:if test="${account.occupation eq '技术人员'}">
                                    selected
                                </c:if>
                                value="技术人员"
                        >技术人员</option>
                        <option
                                <c:if test="${account.occupation eq '其他'}">
                                    selected
                                </c:if>
                                value="其他"
                        >其他</option>
                    </select>
                </div>
                <div class="text_info clearfix"><span>性别：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="gender"
                            <c:if test="${account.gender eq '女'}">
                                checked="checked"
                            </c:if>
                           value="女"
                           disabled
                           id="female" onclick="feeTypeChange(1);" />
                    <label for="female">女</label>
                    <input type="radio" name="gender"
                            <c:if test="${account.gender eq '男'}">
                                checked="checked"
                            </c:if>
                           value="男"
                           disabled
                           id="male" onclick="feeTypeChange(2);" />
                    <label for="male">男</label>
                </div> 
                <div class="text_info clearfix"><span>通信地址：</span></div>
                <div class="input_info"><input type="text" class="width350 readonly" readonly value="${account.mailaddress}" /></div>
                <div class="text_info clearfix"><span>邮编：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${account.zipcode}" /></div>
                <div class="text_info clearfix"><span>QQ：</span></div>
                <div class="input_info"><input type="text" class="readonly" readonly value="${account.qq}" /></div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="button" value="返回" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/findAccountByPc?pc=1';" />
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
