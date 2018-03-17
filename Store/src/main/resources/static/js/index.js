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
    }
    // transitionEnd: function(index, element) {}
});

//with jQuery
//window.mySwipe = $('#mySwipe').Swipe().data('Swipe');
$(document).ready(function () {
    $("#spanone").html(sessionStorage.getItem("username")+",&nbsp;&nbsp;")
    test();
    console.log(sessionStorage.phone);
})
function test() {
    $.get("article/selectByHot",function (jsondata) {
        var data=jsondata.articles;
        console.log(data);
        $.each(data,function (index,item) {
            console.log("++++++"+item.goods_id);
//                    $(".pro_list:first").append(
//                        $('<li>').append().attr({"data-id":item.goods_id})
//                            .append(
//                                $('<a href="#">')
//                                    .append(
//                                        $('<div class="pro_pic">')
//                                            .append(
//                                                $('<img>')
//                                                    .attr({"src":item.file_id})
//                                            )
//                                            .append(
//                                                $("<p class='pro_title'>").text(item.goods_name)
//                                            )
//                                    )
//                                    .append(
//                                        $('<div class="pro_info">')
//                                            .append(
//                                                $('<span class="xj">')
//                                                    .text("￥"+item.price)
//                                            )
//                                            .append(
//                                                $('<span class="sczg">')
//                                            )
//                                    )
//                            )
//                    )

            $(".pro_list:first").append(
                "<li data-id='"+item.goods_id+"'>"+
                "<a href='#'>"+
                "<div class='pro_pic'>"+
                "<img src='"+item.file_id+"'/>"+
                "<p class='pro_title'>"+item.goods_name+"</p>"+
                "</div>"+
                "<div class='pro_info'>"+
                "<span class='xj'>￥"+item.price+
                "<span class='yj'>￥"+item.discount+"</span>"+
                "</span>"+
                "<span class='sczg'></span>"+
                "</div>"+
                "</a>"+
                "</li>"
            );
            $(".fl_list li").each(function () {
                $(this).click(function () {
                    console.log(this.dataset.type);
                    sessionStorage.setItem("type",this.dataset.type);
                    window.location="pro_list.html"
                })
            })
            $(".pro_list:first li").on("click",function () {
                console.log("dddddd"+sessionStorage.goods_id);
                sessionStorage.goods_id=this.dataset.id;
                window.location="pro_detail"
            })


        })
    })
    $(".nav_dd a").click(function () {
        if (sessionStorage.getItem("username")==null){
            alert("请先登录");

        }else {
            window.location="wddd.html"
        }
    })

}
