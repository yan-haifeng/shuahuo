//获取工作室
function get_studio(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findStudioById?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//获取工作室人员
function get_studioMember(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findStudioMemberByStudioId?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//获取订单
function get_orders(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findOrderByStudioId?id=' + id,
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

//接受订单
function acceptedOrder(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../acceptedOrder?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//拒绝订单
function refuseOrder(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../refuseOrder?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//修改订单状态
function changeOrderStatu(id, statu) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../changeOrderStatu?id=' + id + '&statu=' + statu,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}



//拿到url上的id
function get_id() {
    //1、location.search获取get请求的参数   获取到的数据，是以?开头的
    var search = location.search;
    //2、如果还想要获取确定的数据，可以解析字符串
    function parse(search) {
        //从第二个字符开始截取   ，获取到第二个开始后面所有的字符
        var str = search.substring(1);
        var result = {};
        //分割字符串  -->产生字符串数组
        var strs = str.split("&");
        //遍历数组中的每一个元素
        strs.forEach(function (v) {
            //伪代码：v="age=18"
            var keyvalue = v.split("=");
            var name = keyvalue[0];
            var value = keyvalue[1];
            result[name] = value;
        })
        return result;
    }
    var r = parse(search);
    return r;
}

//资源填入页面
function setup_studio(studio) {
    //拿到工作室人员
    var studioMember = get_studioMember(studio[0].studio_id);
    //拿到订单资源
    var orders = get_orders(studio[0].studio_id);
    //处理工作类型
    var begoodat = "";
    var strs = new Array();
    strs = (studio[0].studio_begoodat).split('##');
    for (var i = 1; i < strs.length; i++) {
        switch (strs[i]) {
            case "0": begoodat = begoodat + "、" + "陶泥"; break;
            case "1": begoodat = begoodat + "、" + "布、纸"; break;
            case "2": begoodat = begoodat + "、" + "竹木"; break;
            case "3": begoodat = begoodat + "、" + "石头"; break;
            case "4": begoodat = begoodat + "、" + "金属"; break;
            case "5": begoodat = begoodat + "、" + "编结"; break;
            case "6": begoodat = begoodat + "、" + "缝纫"; break;
            case "7": begoodat = begoodat + "、" + "裱札"; break;
            case "8": begoodat = begoodat + "、" + "陶埏"; break;
            case "9": begoodat = begoodat + "、" + "塑作"; break;
            case "10": begoodat = begoodat + "、" + "其他"; break;
        }
    }
    begoodat = begoodat.substr(1, begoodat.length);
    //处理工作室图片
    var imgs = new Array();
    imgs = (studio[0].studio_img).split('##');

    $('#studio_head_img').attr('src', '../resources/upload/studiologoimg/' + studio[0].studio_logo);
    $('#studio_name').text(studio[0].studio_name);
    $('#studio_member_num').text(studioMember.length);
    $('#studio_begoodat').text(begoodat);
    $('#studio_introduction').text(studio[0].studio_introduction);

    //填工作室图片
    for (var k = 1; k < imgs.length; k++) {
        $('#studio_img_wapper').append('<div><img id="studio_img' + k + '"></div>');
        $('#studio_img' + k + '').attr('src', '../resources/upload/studioimg/' + imgs[k]);
    }

    

    //填成员信息
    for (var j = 0; j < studioMember.length; j++) {
        if (j < 6) {
            $('#studio_member_wapper').append('<div class="photo_album_photo"><img id="studio_member_head_img' + j + '"><p id="studio_member_name' + j + '"></p></div>');
            $('#studio_member_head_img' + j + '').attr('src', '../resources/upload/memberheadimg/' + studioMember[j].studio_member_head_img);
            $('#studio_member_name' + j + '').text(studioMember[j].studio_member_name);
        }
    }

    //填订单信息
    for (var t = 0; t < orders.length; t++) {
        //处理图片信息
        var orderimgs = new Array();
        orderimgs = (orders[t].order_img).split('##');
        $('#order_box').append('<div class="order"><div class="order_top_wapper clearfloat"><p class="l_order_top_wapper_p" id="studio_order_num' + t + '">第10972单</p><p class="r_order_top_wapper_p" id="order_code' + t + '">交易进行中</p></div><div class="order_mid_wapper"><p class="order_title" id="order_title' + t + '">拨浪鼓</p><div class="order_price"><p>报价：￥</p><p id="order_price' + t + '">600</p></div><div class="order_requirements"><p>具体要求：</p><p id="order_requirements' + t + '">要安全讲课</p></div><div class="order_img_wapper" id="order_img_wapper' + t + '"></div><div class="order_btn_wapper clearfloat"><div class="order_btn_box" id="order_btn_box' + t + '"><div class="order_btn" id="order_accepted_btn' + t + '">接受</div><div class="order_btn" id="order_refuse_btn' + t + '">拒绝</div></div><div class="order_statu_select_wapper" id="order_statu_select_wapper' + t + '"><form class="layui-form" id="order_form' + t + '"><div class="layui-input-block"><select name="order_statu" lay-verify="required" lay-filter="order_statu' + t + '" id="order_statu' + t + '"><option value="1" id="order_option_accepted' + t + '">已接单</option><option value="2" id="order_option_making' + t + '">制作中</option><option value="3" id="order_option_delivery' + t + '">交付中</option></select></div></form></div><div class="finish_wapper" id="finish_wapper' + t + '"><p>已完成</p></div><div class="refuse_wapper" id="refuse_wapper' + t + '"><p>已拒绝</p></div></div></div><hr></div>');
        //获取玩具
        var toys = get_toys(orders[t].toys_id);
        $('#order_title' + t + '').text(toys[0].toys_name);
        $('#order_price' + t + '').text(orders[t].order_price);
        $('#order_requirements' + t + '').text(orders[t].order_requirements);

        for (var y = 1; y < orderimgs.length; y++) {
            $('#order_img_wapper' + t + '').append('<div class="order_img"><img id="order_img' + t + y + '"></div>');
            $('#order_img' + t + y + '').attr('src', '../resources/upload/orderimg/' + orderimgs[y]);
        }

        $('#order_img_wapper' + t + '').viewer();

        //判断订单状态
        var statu = orders[t].order_statu;
        switch (statu) {
            case 0: $('#order_btn_box' + t + '').css('display', 'block'); break;
            case 1: $('#order_statu_select_wapper' + t + '').css('display', 'block'); $('#order_option_accepted' + t + '').attr('selected', ''); break;
            case 2: $('#order_statu_select_wapper' + t + '').css('display', 'block'); $('#order_option_making' + t + '').attr('selected', ''); break;
            case 3: $('#order_statu_select_wapper' + t + '').css('display', 'block'); $('#order_option_delivery' + t + '').attr('selected', ''); break;
            case 4: $('#finish_wapper' + t + '').css('display', 'block'); $('#order_code' + t + '').text('交易已完成'); break;
            case 5: $('#refuse_wapper' + t + '').css('display', 'block'); $('#order_code' + t + '').text('交易已拒绝'); break;
        }

        //给订单绑定功能
        (function () {
            var flag = t;
            //接受按钮
            $('#order_accepted_btn' + flag + '').click(function () {
                layer.open({
                    content: '确定接受该订单'
                    , btn: ['确定', '取消']
                    , yes: function (index) {
                        //按钮【按钮一】的回调
                        acceptedOrder(orders[flag].order_id);
                        layer.close(index);
                        $('#order_btn_box' + flag + '').css('display', 'none');
                        $('#order_statu_select_wapper' + flag + '').css('display', 'block');
                    }
                });
            });
            //拒绝按钮
            $('#order_refuse_btn' + flag + '').click(function () {
                layer.open({
                    content: '确定拒绝该订单'
                    , btn: ['确定', '取消']
                    , yes: function (index) {
                        //按钮【按钮一】的回调
                        refuseOrder(orders[flag].order_id);
                        layer.close(index);
                        $('#order_btn_box' + flag + '').css('display', 'none');
                        $('#refuse_wapper' + flag + '').css('display', 'block');
                        $('#order_code' + flag + '').text('交易已拒绝');
                    }
                });
            });
            layui.use('form', function () {
                var form = layui.form;
                //各种基于事件的操作，下面会有进一步介绍
                form.render(); //更新全部
                form.on('select(order_statu' + flag + ')', function (data) {
                    changeOrderStatu(orders[flag].order_id, data.value);
                });
            });
        }());
    }
}







