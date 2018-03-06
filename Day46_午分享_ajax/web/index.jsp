<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/24
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
  <input id="input" type="text" oninput="show()">
  </body>
<script type="text/javascript">
  function show() {
      var val = $("#input").val();
      $.ajax({
          url:"/show",
          data:{"input":val},
          type:"GET",
          dataType:"json",
          //同步操作
          async:true,
          //success后面是方法名,成功后要做什么
          success:success,
          error:error,
          beforeSend:send,
          complete:final,
      })
  }
  function success(allData) {
      $("#input~div").remove();
      $(allData).each(function (index, data) {
          $("#input").after($('<div>').text(data));
      })
  }
  function error() {
      alert("失败");
  }
  function send() {
      $("#input").after($("<h1>").text("正在加载"))
  }
  function final() {
      $("#input~h1").remove();
  }
</script>
</html>
