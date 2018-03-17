$(document).ready(function () {
    test();
});
function test() {
    $.get("/store/article/selectById",{id:(Number)(sessionStorage.goods_id)},function (jsondata) {
        var data = jsondata.article;
        console.log("6++++++"+data.goods_id);
        $("#mySwipe").append(
            "<div class='swipe-wrap'>"+
            "<div>" +
            "<img src='"+data.file_id+"' height='180px' width='100%'/>" +
            "</div>"+
            "</div>"
        );
        $(".main").append(
            "<div class='jj_title'>"+data.goods_name+"</div>" +
            "     <ul class='jj_list' style='margin-bottom:48px;'>" +
            "        <li data-id='"+data.goods_id+"'>" +
            "           <ul class='jj_info'>" +
            "              <li><span class='label'>商品售价：</span><span class='red'>￥"+data.price+"</span></li>" +
            "              <li><span class='label'>商品原价：</span><span style=' color:#ccc; text-decoration:line-through'>￥"+data.discount+"</span></li>" +
            "              <li style='padding:4px 3px; overflow:hidden' class='numbar'><span class='label'>选购数量：</span>" +
            "               <input value='—' type='button' class='plus'/><input value='1' type='text' class='in' id='setnum'/>" +
            "               <input value='+' type='button' class='add'/></li>" +
            "              <li><span class='label'>赞助商：</span><span>"+data.sponsor+"</span></li>" +
            "              <li><span class='label'>商品数量：</span><span>"+data.goods_count+"</span></li>" +
            "           </ul>\n" +
            "        </li>\n" +
            "     </ul>"
        );
        var d =parseInt($("#setnum").val())
        $(".plus").click(function () {
            if(d <= 1){
                alert("不能在减了")
            }else {
                console.log(d)
                d-=1
                $("#setnum").val(d)
            }
        })
        $(".add").click(function () {
            d+=1
            $("#setnum").val(d)
        })

        $(".b_nav a").on("click",function () {

            $.get("http://192.168.11.232:8080/insertOrder",{
                    aname:(data.goods_name),acount:(data.goods_count),price:(data.price),uid:(Number)(sessionStorage.getItem("uid")),count:d},
                function (data) {
                    alert(data?"添加成功":"添加失败")
                })
        })
    })

}




// pure JS
var elem = document.getElementById('mySwipe');
window.mySwipe = Swipe(elem, {
    // startSlide: 4,
    auto: 3000,
    continuous: true,
    // disableScroll: true,
    // stopPropagation: true,
    callback: function(index, element) {
        //alert(index);
    },
    // transitionEnd: function(index, element) {}
});

// with jQuery
// window.mySwipe = $('#mySwipe').Swipe().data('Swipe');