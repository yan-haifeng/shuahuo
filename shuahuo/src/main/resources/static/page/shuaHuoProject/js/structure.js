/**
 * 主体框架js
 * 控制登陆注册样式及功能
 * 基于jquery,使用请引入jquery.js文件
 */

//控制遮罩

function setMask() {
    //控制遮罩高度与宽度
    //获取当期浏览器宽度
    var browserWidth = document.documentElement.clientWidth
    //获取当前浏览器高度
    var browserHeight = document.documentElement.clientHeight;
    //改变遮罩宽度与高度
    $(function () {
        $(".mask").css("width", browserWidth + 'px');
        $(".mask").css("height", browserHeight + 'px');
    });
}
setMask();
//事件 
$(function () {
    //改变窗口尺寸事件
    $(window).resize(setMask);
    //点击注册打开遮罩事件
    $(".enrol-btn").click(function () {
        $(".mask").css("display", "block");
    });
    //点击按钮关闭遮罩事件
    $(".exitbtn span").click(function () {
        $(".mask").css("display", "none");
    });
});

//搜索功能（百度）（因使用类选择器可能会造成搜索bug）
function search_from_baidu(val){
    window.open("http://www.baidu.com/s?wd="+val);
}

//搜索事件
$('.middle-nav-search-btn').click(function(){
    var search_val = "";
    search_val = $('.middle-nav-search-input form input').val();
    search_from_baidu(search_val);
});




