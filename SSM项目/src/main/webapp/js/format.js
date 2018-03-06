var a1 = false;
var a2 = false;
var a3 = false;
var a4 = false;
var a5 = true;
var c1 = true;
var c2 = true;
var c3 = true;
var c4 = true;
var c5 = true;
function b1() {
    if (!c1){
        return;
    }
    var v = $('#name').val();
    if (/^[\\u4e00-\\u9fa5A-Za-z0-9_]{1,50}$/.test(v)){
        $('#1').css({"display":"none"})
        a1=true;
    }else {
        $('#1').css({"display":"block"})
        a1=false;
    }
}
function b2() {
    if (!c2){
        return;
    }
    var v = $('#baseDuration').val();
    if (v>=1&&v<=600){
        $('#2').css({"display":"none"})
        a2=true;
    }else {
        $('#2').css({"display":"block"})
        a2=false;
    }
}
function b3() {
    if (!c3){
        return;
    }
    var v = $('#baseCost').val();
    if (0<v && v<99999.99){
        $('#3').css({"display":"none"})
        a3=true;
    }else {
        $('#3').css({"display":"block"})
        a3=false;
    }
}
function b4 () {
    if (!c4){
        return;
    }
    var v = $('#unitCost').val();
    if (0<v && v<99999.99){
        $('#4').css({"display":"none"})
        a4=true;
    }else {
        $('#4').css({"display":"block"})
        a4=false;
    }
}
function b5() {
    if (!c5){
        return;
    }
    var v = $('#descr').val();
    if (/^[\\u4e00-\\u9fa5A-Za-z0-9_]{0,100}$/.test(v)){
        $('#5').css({"display":"none"})
        a5=true;
    }else {
        $('#5').css({"display":"block"})
        a5=false;
    }
}
$('#name').blur(b1);
$('#baseDuration').blur(b2);
$('#baseCost').blur(b3);
$('#unitCost').blur(b4);
$('#descr').blur(b5);
$('#ll').click(function () {
    if (c1){
        b1();
    }
    if (c2){
        b2();
    }
    if (c3){
        b3();
    }
    if (c4){
        b4();
    }
    if (c5){
        b5();
    }
    if (a1&&a2&&a3&&a4&&a5){
        $('.main_form').submit();
    }
});
