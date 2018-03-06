<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="<c:url value="/styles/global.css"/>"/>
        <link type="text/css" rel="stylesheet" media="all" href="<c:url value="/styles/global_color.css"/>"/>
        <script src="<c:url value="js/jquery-3.2.1.min.js"/>"></script>
    </head>
    <body class="index">
        <div class="login_box">
            <form id="login" action="${pageContext.request.contextPath}/admin/login" method="post">
            <table>
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="adminCode" type="text" class="width150" value="${admin.adminCode}"/></td>
                    <td class="login_error_info"><span class="required">${requestScope.adminCode}</span></td>
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input name="password" type="password" class="width150" value="${admin.password}"/></td>
                    <td><span class="required">${requestScope.password}</span></td>
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input name="vCode" type="text" class="width70" /></td>
                    <td><img id="code" src="${pageContext.request.contextPath}/admin/codeImg" alt="验证码" title="点击更换" /></td>
                    <td><span class="required">${requestScope.vCode}</span></td>
                </tr>            
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                        <a href="javascript:document:login.submit();"><img src="/images/login_btn.png" /></a>
                    </td>    
                    <td><span class="required">${requestScope.login}</span></td>
                </tr>
            </table>
            </form>
        </div>
    </body>
<script type="text/javascript">

</script>
</html>
