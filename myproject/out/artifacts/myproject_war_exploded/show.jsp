<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/3
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>书籍详情</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1 class="bname"></h1>
<h1 class="author"></h1>
<h1 class="price"></h1>

</body>
<script type="text/javascript">
    <%--<%--%>
           <%--request.setCharacterEncoding("utf-8");--%>
<%--//           String bname = request.getParameter("bname");--%>
       <%--%>--%>
    function show() {
        var src="<c:url value="/register"/>"+"?bname=${param.bname}";
        $.getJSON(
            src,
            function (JSONData, status) {
                if (status=="success"){
                    $('.bname').text("书名："+JSONData['bname']);
                    $('.author').text("作者："+JSONData['author']);
                    $('.price').text("价格："+JSONData['price']);
                }
            }
        );
    }
    show();
</script>
</html>
