var i = 0;
var add;
var rgb;
var number;
$('#add').click(add);


$('#remove').click(function () {
    var t = "."+i--;
    if(i<0){
        i=0;
    }
    $(t).animate({"margin-left":"500px"},1000,function () {
        $(t).remove();
    })
});

$('#small').click(function () {
    // radomAdd();
    for (var b=1;b<=i;b++){
        // var number = Math.ceil(Math.random()*(-100));
        var t="."+b;
        var text = $(t).text();
        if(text>0){
            $(t).fadeOut();
            // $(t).css({"display":"none"});
        }else {
            $(t).fadeIn();
            // $(t).css({"display":"block"});
        }
    }
});

$('#big').click(function () {
    for (var b=1;b<=i;b++){
        // var number = Math.ceil(Math.random()*(-100));
        var t="."+b;
        var text = $(t).text();
        if(text<0){
            $(t).fadeOut();
            // $(t).css({"display":"none"});
        }else {
            $(t).fadeIn();
            // $(t).css({"display":"block"});
        }
    }
});

var flash;
$('#flash').click(flash = function () {
    for (var b=1;b<=i;b++) {
        number=getNumber();
        var t = "." + b;
        $(t).text(number);
    }

    for (var k=1;k<=i;k++) {
        t="." + k;
        rgb=getRGB();
        $(t).attr({"style":rgb});
    }
});
$('#showAll').click(function () {
    for (var b=1;b<=i;b++){
        var t="."+b;
        $(t).fadeIn();
            // $(t).css({"display":"block"});
    }

    // if(i!=5){
    //     $('#block>li').remove();
    //     i=0;
    //     for(var j=1;j<=5;j++){
    //         add();
    //     }
    // }
    // flash();
});
function add() {
    rgb=getRGB();
    $('#block').append($('<li>').attr({"class":++i,"style":rgb}));
    var t = "."+i;
    number=getNumber();
    $(t).text(number);
}
function getRGB() {
    var r = Math.random() * 255;
    var g = Math.random() * 255;
    var b = Math.random() * 255;
    rgb = "background-color:rgb(" + Math.ceil(r) + "," + Math.ceil(g) + "," + Math.ceil(b) + ")";
    return rgb;
}

function getNumber() {
     var number1 = Math.ceil(Math.random() * 100);
    var number2 = Math.ceil(Math.random() * (-100));
    var n = Math.ceil(Math.random() * 2);
    number;
    if (n == 1) {
        number = number1;
    } else {
        number = number2;
    }
    return number;
}
function radomAdd() {
    $('#block>li').remove();
    i=0;
    for(var j=1;j<=Math.ceil(Math.random()*5);j++){
        add();
    }
}
