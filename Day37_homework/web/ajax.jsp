<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/14
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ajax分页</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        div{
            width: 30px;
            /*border: solid 1px black;*/
            float: left;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%--<table id="showBook" border="1">--%>

<%--</table>--%>
<script type="text/javascript">
    function show(pc) {
        var url="ajax?pc="+pc;
        $.getJSON(
            url,function (JSONData, status) {
                if(status=="success"){
                    $('table').remove();
                    $('.num').remove();
                    $('body').append($('<table>').attr({"id":"showBook","border":"1"}));
                    $('#showBook').append(
                        $('<tr>').append(
                            $('<th>').text("书名")
                        ).append(
                            $('<th>').text("作者")
                        ).append(
                            $('<th>').text("价格")
                        ).append(
                            $('<th>').text("分类")
                        )
                    );
                    $.each(JSONData['books'],function (index, data) {
                        $('#showBook').append(
                            $('<tr>').append(
                                $('<td>').text(data['bname'])
                            ).append(
                                $('<td>').text(data['author'])
                            ).append(
                                $('<td>').text(data['price'])
                            ).append(
                                $('<td>').text(data['category'])
                            )
                        );
                    });
                    var begin = 1;
                    var end = JSONData['totalPage'];
                    var q = Math.ceil((JSONData['pageSize']-1)/2);
                    var h = Math.floor((JSONData['pageSize']-1)/2);
                    if (JSONData['currentPage']>q){
                        begin=JSONData['currentPage']-q;
                    }
                    if (JSONData['currentPage']<=JSONData['totalPage']-h){
                        end=JSONData['currentPage']+h;
                    }
                    if (begin>JSONData['totalPage']-JSONData['pageSize']){
                        begin=JSONData['totalPage']-JSONData['pageSize'];
                    }
                    if(end<JSONData['pageSize']){
                        end=JSONData['pageSize'];
                    }
                    if (end>JSONData['totalPage']){
                        end=JSONData['totalPage'];
                    }
                    index(begin,end,JSONData['currentPage'],JSONData['totalPage']);
                }
            })
    }
    function index(begin,end,currentPage,totalPage) {
        if(currentPage>1) {
            $('body').append(
                $('<div>').attr({"onclick": "show(" + (currentPage - 1) + ")", "class": "num"}).text("上一页")
            );
        }
        for(var i = begin;i<=end;i++){
            if(currentPage==i) {
                $('body').append(
                    $('<div>').attr({"onclick": "show("+i+")", "class": "num"}).text(i)
                )
            }else {
                $('body').append(
                    $('<div>').attr({"onclick": "show("+i+")", "class": "num"}).text("[" + i + "]")
                )
            }
        }
        if (currentPage<totalPage)
        $('body').append(
            $('<div>').attr({"onclick": "show("+(currentPage+1)+")", "class": "num"}).text("下一页")
        );
    }
    <c:set var="pc" value="${param.pc}"/>
    <c:if test="${param.pc==null||param.pc eq ''}">
        <c:set var="pc" value="1"/>
    </c:if>
    show(${pc})
</script>
<%--<form action="<c:url value="/show"/>" method="get">--%>
    <%--<c:forEach var="p" items="${requestScope.pageBean.params}">--%>
        <%--<input type="hidden" name="${p.key}" value="${p.value}">--%>
    <%--</c:forEach>--%>
    <%--<input type="number" name="pc">/${requestScope.pageBean.totalPage}--%>
    <%--<input type="submit" value="跳页">--%>
<%--</form>--%>
<form action="ajax.jsp" method="get">
    <input type="number" name="pc">
    <input type="submit" value="跳页">
</form>
</body>

</html>
