<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/19
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
      .errorMessage ul{
        list-style-type: none;
        display: none;
        padding: 0;
        margin: 0;
      }
      .error{
        width: 200px;
        height: 20px;
        display: inline-block;
        /*border: solid 1px black;*/
      }
    </style>
  </head>
  <body>
  <form action="add.action" method="post">
    姓名：<input type="text" name="name"><div class="error"><s:fielderror fieldName="name"/></div><br>
    年龄：<input type="number" name="age"><br>
    部门：<input type="text" name="department"><br>
    入职时间：<input type="date" name="jointime"><br>
    家庭地址：<input type="text" name="address"><br>
    电话号码：<input type="text" name="telephone"><br>
    <input type="submit" value="提交">
  </form>
  <br>
  <div onclick="show()" style="cursor: pointer">查看员工信息</div>
  <div id="show">

  </div>

  </body>
<script type="text/javascript">
  function show() {
      var url = "<s:url action="findAll"/>";
      $.getJSON(url,function (JSONData, status) {
          if (status=="success"){
              console.log(JSONData);
              $('table').remove();
              $('#show').append(
                  $('<table>').attr({"border":"1px"}).append(
                      $('<tr>').append(
                          $('<th>').text("姓名")
                      ).append(
                          $('<th>').text("年龄")
                      ).append(
                          $('<th>').text("部门")
                      ).append(
                          $('<th>').text("入职时间")
                      ).append(
                          $('<th>').text("家庭地址")
                      ).append(
                          $('<th>').text("电话号码")
                      )
                  )
              );
              console.log(JSONData)
              $.each(JSONData,function (index,data) {
                  $('table').append(
                      $('<tr>').append(
                          $('<td>').text(data['name'])
                      ).append(
                          $('<td>').text(data['age'])
                      ).append(
                          $('<td>').text(data['department'])
                      ).append(
                          $('<td>').text(data['jointime'])
                      ).append(
                          $('<td>').text(data['address'])
                      ).append(
                          $('<td>').text(data['telephone'])
                      ).append(
                          $('<td>').append(
                              $('<a>').attr({"href":"toModify?id="+data['id']}).text("修改信息")
                          )
                      )
                  )
              });
          }
      })
  }
</script>
</html>
