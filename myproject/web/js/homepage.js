function getUser(){
    var url="http://localhost:8080/Day29/query";
    $.get(
        url,function (data) {
            $('#user').text("用户:"+data);
        }
    );
}
getUser();