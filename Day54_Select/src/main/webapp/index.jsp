<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>

<body>


<select name="" onchange="show(this,'s')">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
</select>
<select id="s">

</select>

<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    选择文件：
    <input type="file" name="file"/>
    <input type="submit" value="上传">
</form>
<script src="js/jquery-3.2.1.min.js">

</script>
<script type="text/javascript">
    function show(a,b) {
        var value = $(a).val();
        var url = "${pageContext.request.contextPath}/show/"+value;
        $.getJSON(url, function (json,status) {
            if (status==="success"){
                var list = json['list'];
                $('#'+b).find("option").remove();
                $('#'+b).append(
                    $('<option>').attr({"value":"-1"}).text("--请选择--")
                );
                for (var i=0;i<list.length;i++){
                    $('#'+b).append(
                        $('<option>').attr({"value":list[i]}).text(list[i])
                    )
                }
            }
        });
    }
</script>
</body>

</html>
