<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/28
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户信息</title>
  <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<button id="btn" style="width: 90px;height: 30px;background-color: burlywood">点击查询</button>
<table border="1" >

</table>
</body>
<script type="text/javascript">
    $('#btn').click(function () {
//          $('table>tr').remove();
        $.get("http://localhost:8080/book",
            function (data, status) {
                if (status=="success"){
                    console.log("2");
                    var jsonData=$.parseJSON(data);
                    if (jsonData!=null){
                        console.log("3");
                        $('tr').remove();
                        $('table').append(
                            $('<tr>').append(
                                $('<td>').text("Uid")
                            ).append(
                                $('<td>').text('用户名')
                            ).append(
                                $('<td>').text('年龄')
                            ).append(
                                $('<td>').text('城市')
                            )
                        )

                        $.each(jsonData,function (index, obj) {
                            $('table').append(
                                $('<tr>').append(
                                    $('<td>').text(obj['bkid'])
                                ).append(
                                    $('<td>').text(obj['bkname'])
                                ).append(
                                    $('<td>').text(obj['author'])
                                ).append(
                                    $('<td>').text(obj['tid'])
                                )
                            )
                        })
                    }

                }
            }
        )
    })
</script>
</html>
