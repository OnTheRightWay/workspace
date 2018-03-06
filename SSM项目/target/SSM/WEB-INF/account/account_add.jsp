<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page language="java" contentType="text/html; utf-8" isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>云科技</title>
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
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

            //显示选填的信息项
            function showOptionalInfo(imgObj) {
                var div = document.getElementById("optionalInfo");
                if (div.className == "hide") {
                    div.className = "show";
                    imgObj.src = "../images/hide.png";
                }
                else {
                    div.className = "hide";
                    imgObj.src = "../images/show.png";
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
            <!--保存成功或者失败的提示消息-->     
            <div id="save_result_info" class="save_fail">保存失败，该身份证已经开通过账务账号！</div>
            <form action="${pageContext.request.contextPath}/account/addAccount" method="post" class="main_form">
                <!--必填项-->
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text"  name="realName" id="realName"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="1">20长度以内的汉字、字母和数字的组合</div>
                </div>
                <div class="text_info clearfix"><span>身份证：</span></div>
                <div class="input_info">
                    <input type="text" name="idcardNo" id="idcardNo"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="2">正确的身份证号码格式</div>
                </div>
                <div class="text_info clearfix"><span>登录账号：</span></div>
                <div class="input_info">
                    <input type="text" name="loginName" id="loginName" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="3">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix" ><span>密码：</span></div>
                <div class="input_info">
                    <input type="password" name="loginPasswd" id="loginPasswd" />
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="4">30长度以内的字母、数字和下划线的组合</div>
                </div>
                <div class="text_info clearfix" ><span>重复密码：</span></div>
                <div class="input_info">
                    <input type="password" id="loginPasswd2"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long" id="5">两次密码必须相同</div>
                </div>     
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name="telephone" id="telephone"/>
                    <span class="required">*</span>
                    <div class="validate_msg_medium" id="6">正确的电话号码格式：手机或固话</div>
                </div>                
                <!--可选项-->
                <div class="text_info clearfix"><span>可选项：</span></div>
                <div class="input_info">
                    <img src="../../images/show.png" alt="展开" onclick="showOptionalInfo(this);" />
                </div>
                <div id="optionalInfo" class="hide">
                    <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
                    <div class="input_info">
                        <input type="text" name="recommenderIdCard" id="recommenderIdCard"/>
                        <div class="validate_msg_long" id="7">正确的身份证号码格式</div>
                    </div>
                    <div class="text_info clearfix"><span>生日：</span></div>
                    <div class="input_info">
                        <input type="text" value="由身份证号计算而来" readonly class="readonly" />
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width350" name="email" id="email"/>
                        <div class="validate_msg_tiny" id="8">50长度以内，合法的 Email 格式</div>
                    </div> 
                    <div class="text_info clearfix"><span>职业：</span></div>
                    <div class="input_info">
                        <select name="occupation">
                            <option value="干部">干部</option>
                            <option value="学生">学生</option>
                            <option value="技术人员">技术人员</option>
                            <option value="其他">其他</option>
                        </select>                        
                    </div>
                    <div class="text_info clearfix"><span>性别：</span></div>
                    <div class="input_info fee_type">
                        <input type="radio" name="gender" checked="checked" id="female" value="女"/>
                        <label for="female">女</label>
                        <input type="radio" name="gender" id="male" value="男"/>
                        <label for="male">男</label>
                    </div> 
                    <div class="text_info clearfix"><span>通信地址：</span></div>
                    <div class="input_info" >
                        <input type="text" class="width350" name="mailaddress" id="mailaddress"/>
                        <div class="validate_msg_tiny" id="9">50长度以内</div>
                    </div> 
                    <div class="text_info clearfix"><span>邮编：</span></div>
                    <div class="input_info">
                        <input type="text" name="zipcode" id="zipcode"/>
                        <div class="validate_msg_long" id="10">6位数字</div>
                    </div> 
                    <div class="text_info clearfix"><span>QQ：</span></div>
                    <div class="input_info">
                        <input type="text" id="qq" name="qq"/>
                        <div class="validate_msg_long" id="11">5到13位数字</div>
                    </div>                
                </div>
                <!--操作按钮-->
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save"
                           <%--onclick="showResult();" --%>
                    />
                    <input type="button" value="取消" class="btn_save" onclick="location.href='${pageContext.request.contextPath}/account/findAccountByPc?pc=1'"/>
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
