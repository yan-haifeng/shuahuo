//检测用户是否登录
var userInformation = "";
function islogin() {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        async: false,
        url: '../islogin',
        success: function (data) {
            if (data.code == -1 || data.data == null) {
                getData = "";
            }
            if (data.data != null) {
                getData = data.data
                
            }
        }
    });
    return getData;
}
var islogin =  islogin();
if(islogin==""){
    $(".login-btn").text("登录");
    $(".login-btn").attr("href", "login.html");
}else if(islogin!=""){
    var user = get_userById(islogin[0].id);
    userInformation = user;
    var login_username = user.data[0].name;
    $(".login-btn").text("注销");
    $(".top-nav-center-sign ul").prepend($("<li><a href='uilt-views/toMyHomePage.html'>"+login_username+"</a></li>"));
    $(".login-btn").removeAttr("href");
    $(".login-btn").click(function () {
        exitlogin();
    });
}

function exitlogin() {
    $.ajax({
        type: 'GET',
        dataType: 'text',
        url: '../exitlogin',
        success: function (data) {
            window.location.reload();
        }
    });
}

//获取用户信息
function get_userById(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findUserById?id=' + id,
        success: function (data) {
            getData = data;
        }
    });
    return getData;
}