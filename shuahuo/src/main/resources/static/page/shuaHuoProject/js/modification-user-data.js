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
            getData = data.data;
        }
    });
    return getData;
}

//获取用户所有订单
function get_orders(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findOrderByUserId?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//根据玩具id获取玩具
function get_toys(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findToysById?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//填订单信息
//遍历填充订单
function setup_orders(orders) {
    if (orders == null || orders == "") {
        $('#no_customization').css('display', 'block');
    }
    for (var i = 0; i < orders.length; i++) {
        if (i < 3) {
            //创建订单
            $('#orderlist').append('<div class="customization clearfloat"><div class="customization_l"><img id="order_img' + i + '"></div><div class="customization_r"><p id="order_title' + i + '"></p><p id="order_context' + i + '"></p><p>当前状态</p><div class="customization_now_statu" id="order_statu' + i + '">已接单</div></div><hr class="hr-f"></div>');
            // //处理图片名字
            var strs = new Array();
            strs = (orders[i].order_img).split('##');
            //获取对应玩具信息
            var toys = get_toys(orders[i].toys_id);
            //将内容填入
            $('#order_img' + i + '').attr('src', '../resources/upload/orderimg/' + strs[1]);
            $('#order_title' + i + '').text(toys[0].toys_name);
            $('#order_context' + i + '').text(orders[i].order_requirements);
            //判断订单状态
            if (orders[i].order_statu == 0) {
                $('#order_statu' + i + '').addClass('customization_missdo');
                $('#order_statu' + i + '').text('未接单');
            }
            if (orders[i].order_statu != 0) {
                $('#order_statu' + i + '').addClass('customization_doing');
                $('#order_statu' + i + '').text('已接单');
            }
            if (orders[i].order_statu == 4) {
                $('#order_statu' + i + '').removeClass('customization_finish');
                $('#order_statu' + i + '').text('已完成');
            }
        }
    }
}

var userid = 0;
if (userInformation.data != null) {
    userid = userInformation.data[0].id;
}
//将用户id填入input
$('#user_id_input').val(userid);

$(function () {
    //年龄点击改变li
    $('#user_age_ul li').click(function () {
        $('#user_age_ul li').removeClass('click-li');
        $(this).addClass('click-li');
    });
    $('#user_age_00').click(function () {
        $('#user_age_input').val("0");
    });
    $('#user_age_90').click(function () {
        $('#user_age_input').val("1");
    });
    $('#user_age_80').click(function () {
        $('#user_age_input').val("2");
    });
    $('#user_age_70').click(function () {
        $('#user_age_input').val("3");
    });
    $('#user_age_60').click(function () {
        $('#user_age_input').val("4");
    });
    //职业相关度点击改变
    $('#user_correlation_for_handicraft_ul li').click(function () {
        $('#user_correlation_for_handicraft_ul li').removeClass('click-li');
        $(this).addClass('click-li');
    });
    $('#user_correlation_for_handicraft_0').click(function () {
        $('#user_correlation_for_handicraft_input').val("0");
    });
    $('#user_correlation_for_handicraft_1').click(function () {
        $('#user_correlation_for_handicraft_input').val("1");
    });
    $('#user_correlation_for_handicraft_2').click(function () {
        $('#user_correlation_for_handicraft_input').val("2");
    });
    $('#user_correlation_for_handicraft_3').click(function () {
        $('#user_correlation_for_handicraft_input').val("3");
    });
});


//拿到用户id后向服务器查询用户信息
var user_data = get_userById(userid);
var userName = "";
var passWord = "";
var userHeadName = "default.jpg";
var Name = "还没有名字哦";
var Province = "";
var City = "";
var County = "";
var Sex = 0;
var Age = 0;
var Phonenum = "";
var Qqnum = "";
var E_mail = "";
var Occupation = 0;
var Correlation_for_handicraft = 0;
var Personality_label = "";

//判断账号是否为空
if (user_data[0].username != null) {
    userName = user_data[0].username;
}
//判断密码是否为空
if (user_data[0].password != null) {
    passWord = user_data[0].password;
}
//判断头像是否为空
if (user_data[0].headimg_name != null) {
    userHeadName = user_data[0].headimg_name;
}
//判断姓名是否为空
if (user_data[0].name != null) {
    Name = user_data[0].name;
}
//判断省是否为空
if (user_data[0].province != null) {
    Province = user_data[0].province;
}
//判断市是否为空
if (user_data[0].city != null) {
    City = user_data[0].city;
}
//判断区是否为空
if (user_data[0].county != null) {
    County = user_data[0].county;
}
//判断手机号是否为空
if (user_data[0].phonenum != null) {
    Phonenum = user_data[0].phonenum;
}
//判断QQ号是否为空
if (user_data[0].qqnum != null) {
    Qqnum = user_data[0].qqnum;
}
//判断E-mail是否为空
if (user_data[0].e_mail != null) {
    E_mail = user_data[0].e_mail;
}
//判断职业是否为空
if (user_data[0].occupation != null) {
    Occupation = user_data[0].occupation;
}
//判断个性标签是否为空
if (user_data[0].personality_label != null) {
    Personality_label = user_data[0].personality_label;
}
//获取性别
Sex = user_data[0].sex;
//获取年龄
Age = user_data[0].age;
//获取职业相关度
Correlation_for_handicraft = user_data[0].correlation_for_handicraft;
$(function () {
    //加载用户名
    $('#user_username_input').val(userName);
    //加载密码
    $('#user_password_input').val(passWord);
    //加载用户头像
    $('#user_head_img').attr('src', '../resources/upload/headimg/' + userHeadName);
    //加载名字
    $('#user_name').text(Name);
    $('#user_name_input').val(Name);
    //加载省市区
    $('#user_province_select').attr('data-value', Province);
    $('#user_city_select').attr('data-value', City);
    $('#user_county_select').attr('data-value', County);
    //加载性别
    if (Sex == 0) {
        $('#user_sex_option_0').attr('selected', '');
    } else {
        $('#user_sex_option_1').attr('selected', '');
    }
    //加载年龄
    switch (Age) {
        case 0: $('#user_age_00').addClass('click-li'); break;
        case 1: $('#user_age_90').addClass('click-li'); break;
        case 2: $('#user_age_80').addClass('click-li'); break;
        case 3: $('#user_age_70').addClass('click-li'); break;
        case 4: $('#user_age_60').addClass('click-li'); break;
    }
    $('#user_age_input').val(Age);
    //加载电话
    $('#user_phonenum_input').val(Phonenum);
    //加载QQ号
    $('#user_qqnum_input').val(Qqnum);
    //加载E-mail号
    $('#user_e_mail_input').val(E_mail);
    //加载职业
    switch (Occupation) {
        case "0": $('#user_occuoation_option_0').attr('selected', ''); break;
        case "1": $('#user_occuoation_option_1').attr('selected', ''); break;
        case "2": $('#user_occuoation_option_2').attr('selected', ''); break;
        case "3": $('#user_occuoation_option_3').attr('selected', ''); break;
        case "4": $('#user_occuoation_option_4').attr('selected', ''); break;
        case "5": $('#user_occuoation_option_5').attr('selected', ''); break;
        case "6": $('#user_occuoation_option_6').attr('selected', ''); break;
        case "7": $('#user_occuoation_option_7').attr('selected', ''); break;
        case "8": $('#user_occuoation_option_8').attr('selected', ''); break;
        case "9": $('#user_occuoation_option_9').attr('selected', ''); break;
        case "10": $('#user_occuoation_option_10').attr('selected', ''); break;
        case "11": $('#user_occuoation_option_11').attr('selected', ''); break;
        case "12": $('#user_occuoation_option_12').attr('selected', ''); break;
        case "13": $('#user_occuoation_option_13').attr('selected', ''); break;
    }
    //加载职业相关度
    switch (Correlation_for_handicraft) {
        case 0: $('#user_correlation_for_handicraft_0').addClass('click-li'); break;
        case 1: $('#user_correlation_for_handicraft_1').addClass('click-li'); break;
        case 2: $('#user_correlation_for_handicraft_2').addClass('click-li'); break;
        case 3: $('#user_correlation_for_handicraft_3').addClass('click-li'); break;
    }
    $('#user_correlation_for_handicraft_input').val(Correlation_for_handicraft);
    //加载个性标签
    $('#user_personality_label_input').val(Personality_label);
});

//点击确定按钮修改资料
$(function () {
    $('#user_information_submit_btn').click(function () {
        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '../changeUserData',
            data: $("#user_information_form").serializeArray(),
            contentType: "application/x-www-form-urlencoded",
            success: function () {
                layer.msg('修改成功');
                location.reload();
            },
            error: function () {
                layer.msg('修改失败');
            }
        });
    });
});

//修改头像
layui.use('upload', function () {
    var $ = layui.jquery
        , upload = layui.upload;
    //普通图片上传
    var uploadInst = upload.render({
        elem: '#change_user_head_btn'
        , url: '../uploadHeadImgFile'
        , data: { id: userid }
        , choose: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#user_head_img').attr('src', result); //图片链接（base64）
            });
        }
        , done: function (res, obj) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
            //上传成功
        }
    });
});


//填订单
var orders = get_orders(userid);
setup_orders(orders);
