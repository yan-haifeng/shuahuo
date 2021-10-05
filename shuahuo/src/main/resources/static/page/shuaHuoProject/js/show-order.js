//获取所有订单
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

//完成订单
function finish_order(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../finishOrder?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//遍历填充订单
function setup_orders(orders) {
    if(orders==null||orders==""){
        $('#no_order').css('display','block');
        return null;
    }
    for (var i = 0; i < orders.length; i++) {
        //创建订单
        $('#orderlist').append('<div class="order"><div class="order_main_content"><div class="order_img"><img id="order_img' + i + '"></div><div class="order_text"><p id="order_title' + i + '"></p><p id="order_context' + i + '"></p></div><div class="order_location"><span></span><p>杭州</p></div><div class="hr-d order_hr_location_a"></div><div class="order_price"><div><p>￥</p><p id="order_price' + i + '">1000.00</p></div></div><div class="hr-d order_hr_location_b"></div><div class="accept_details" id="order_mode' + i + '">未接单</div><a class="accept_details_a" id="order_link' + i + '">查看订单详情</a><span class="contact_craftsman_icon"></span><a class="contact_craftsman" id="order_link_craftsman' + i + '">联系匠人</a><div class="hr-d order_hr_location_c"></div><div class="finish_btn" id="order_finish_btn' + i + '">定制完成</div></div><div class="hr-b"></div></div>');
        // //处理图片名字
        var strs = new Array();
        strs = (orders[i].order_img).split('##');
        //获取对应玩具信息
        var toys = get_toys(orders[i].toys_id);
        //将内容填入
        $('#order_img' + i + '').attr('src', '../resources/upload/orderimg/' + strs[1]);
        $('#order_title' + i + '').text(toys[0].toys_name);
        $('#order_context' + i + '').text(orders[i].order_requirements);
        $('#order_price' + i + '').text(orders[i].order_price);
        //判断订单状态
        if (orders[i].order_statu != 0) {
            $('#order_mode' + i + '').addClass('accepted');
            $('#order_mode' + i + '').text('已接单');
        }
        if (orders[i].order_statu == 4) {
            $('#order_mode' + i + '').removeClass('accepted');
            $('#order_mode' + i + '').text('已完成');
        }
        //添加订单详情链接
        $('#order_link' + i + '').attr('href', 'order-details.html?id=' + orders[i].order_id);
        (function(){
            $('#order_link_craftsman' + i + '').click(function(){
                layui.use('layer', function () {
                    var layer = layui.layer;
                    layer.open({
                        type: 2,
                        content: ['iframe-views/order_craftsman.html?id='+userInformation.data[0].id, 'no'],
                        title: '联系匠人',
                        area: ['335px', '480px']
                    });
                });
            });
        }());
        (function () {
            var flag = i;
            if (orders[i].order_statu != 4) {
                $('#order_finish_btn' + flag + '').click(function () {
                    layer.open({
                        content: '确定该订单已定制完成？'
                        , btn: ['确定', '取消']
                        , yes: function (index) {
                            //按钮【按钮一】的回调
                            finish_order(orders[flag].order_id);
                            layer.close(index);
                        }
                    });
                });
            }else{
                $('#order_finish_btn' + flag + '').text("该订单已完成");
            }
        }());
    }
}

var userid = 0;
if (userInformation.data != null) {
    userid = userInformation.data[0].id;
}
var orders = get_orders(userid);
setup_orders(orders);