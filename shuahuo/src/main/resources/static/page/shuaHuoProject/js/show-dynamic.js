//获取动态信息
function get_dynamic(url) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: url,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
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
            getData = data.data;
        }
    });
    return getData;
}

//获取工作室信息
function get_studioById(id) {
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

//增加点赞数目
function add_dianzan(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../addDianzan?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//减少点赞数目
function reduce_dianzan(id) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../reduceDianzan?id=' + id,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//获取评论信息
function get_comment(dynamicId) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findCommentByDynamicId?dynamicid=' + dynamicId,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//发送评论信息
function add_comment(fromName) {
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '../addComment',
        data: $(fromName).serializeArray(),
        contentType: "application/x-www-form-urlencoded",
        success: function (data) {
            layer.msg('评论成功');
            //创建动态
            $('#comment_wapper').append('<div class="comment_personal_data clearfloat"><div class="l_comment_personal_data"><div class="l_comment_personal_head_box"><img src="../resources/img/touxaing.jpg" id="comment_personal_data_headimg"></div></div><div class="r_comment_personal_data"><p class="comment_personal_data_username" id="comment_personal_data_username"></p><p>：</p><span class="comment_personal_data_text" id="comment_personal_data_text"></span><div class="comment_personal_data_statu_box clearfloat"><div class="comment_personal_data_statu_box_time" id="comment_personal_data_statu_box_time"></div></div></div></div>');
            //填入内容
            $('#comment_personal_data_text').append($('#comment_input').val());
            //填入时间
            $('#comment_personal_data_statu_box_time').append($('#comment_creation_time').val());
            //填入用户名
            $('#comment_personal_data_username').append(userInformation.data[0].name);
            //填入头像
            $('#comment_personal_data_headimg').attr('src','../resources/upload/headimg/'+userInformation.data[0].headimg_name+'');
            //将符号置换为表情
            $('#comment_input').val("");
        },
        error: function (data) { }
    });
}


//遍历动态条数拿到用户信息并创建动态
function setup_dynamic(dynamics) {
    if(dynamics==null|dynamics==""){
        $('#no_dynamic').css('display','block');
        return null;
    }
    for (var i = 0; i < dynamics.length; i++) {
        //创建图片视频都有的公共的动态
        $('.dynamic_box').append('<div class="dynamic_personal_data clearfloat"><div class="dynamic_wapper clearfloat"><div class="l_dynamic_box"><div class="head_img" id="head_img' + i + '"></div></div><div class="r_dynamic_box"><div class="name_box"><p id="name' + i + '"></p><span id="dynamic_time' + i + '"></span><span>发布于</span><span>杭州</span></div><div class="text_contest"><span id="text_contest' + i + '"></span></div><ul class="dynamic_img_box clearfloat" id="dynamic_img_box' + i + '"></ul></div></div><div class="b_dynamic_box "><ul class="clearfloat"><li><span class="b_dynamic_box_shoucang"></span><p>收藏</p></li><li><span class="b_dynamic_box_zhuanfa"></span><p>转发</p></li><li id="b_dynamic_box_pinglun_li' + i + '"><span class="b_dynamic_box_pinglun" id="b_dynamic_box_pinglun' + i + '"></span><p>评论</p></li><li class="no-border" id="b_dynamic_box_dianzan_li' + i + '"><span class="b_dynamic_box_dianzan" id="b_dynamic_box_dianzan' + i + '"></span><p>点赞</p><p>(</p><p id="b_dynamic_box_dianzan_num' + i + '">0</p><p>)</p></li></ul></div><div class="weibo_c_icon"><span><img src="../resources/icon/weibo_c.png"></span></div><div class="comment_box" id="comment_box' + i + '"></div></div>');
        //填入动态信息
        $('#text_contest' + i + '').append(dynamics[i].dynamic_text);
        $('#dynamic_time' + i + '').append(dynamics[i].dynamic_creation_time);
        //判断是否有视频或者图片
        //视频
        if (dynamics[i].dynamic_videonum == 1) {
            $('#dynamic_img_box' + i + '').append('<div class="dynamic_video"><video src="../resources/upload/video/' + dynamics[i].dynamic_videoname + '" controls="controls">Your browser does not support the video tag.</video></div>');
        }
        //1张图片
        if (dynamics[i].dynamic_imgnum == 1) {
            //处理图片名字
            var oneImgeName = (dynamics[i].dynamic_imgname).replace('##', "");
            $('#dynamic_img_box' + i + '').append('<div class="one_img"><img src="../resources/upload/img/' + oneImgeName + '"></div>');
        }
        //多张图片
        if (dynamics[i].dynamic_imgnum > 1 && dynamics[i].dynamic_imgnum < 10) {
            //处理图片名字
            var strs = new Array();
            strs = (dynamics[i].dynamic_imgname).split('##');
            for (var j = 1; j <= dynamics[i].dynamic_imgnum; j++) {
                $('#dynamic_img_box' + i + '').append('<li class="many_img"><img src="../resources/upload/img/' + strs[j] + '"></lo>');
            }
        }

        $('#dynamic_img_box'+i+'').viewer();
        //填入点赞数目
        $('#b_dynamic_box_dianzan_num' + i + '').text(dynamics[i].dynamic_dianzan_num);

        //向服务器拿用户信息
        var dynamicUserInformation = get_userById(dynamics[i].u_id);
        //填入用户名字
        $('#name' + i + '').append(dynamicUserInformation[0].name);

        //填入用户头像
        $('#head_img' + i + '').css('background-image', 'url(../resources/upload/headimg/' + dynamicUserInformation[0].headimg_name + ')');
        //把每个动态绑定并创建评论功能
        //因作用域问题，需使用立即执行函数
        (function () {
            var index = i;
            var dynamicId = dynamics[index].dynamic_id;
            var myuserId = "";
            var myuserHead = "default.jpg";
            if (userInformation.data != null) {
                myuserId = userInformation.data[0].id;
            }
            if (userInformation.data != null) {
                myuserHead = userInformation.data[0].headimg_name;
            }

            //点赞
            $(function () {
                var clickdianzan = false;
                var dianzanText = $('#b_dynamic_box_dianzan_num' + index + '').text();
                $('#b_dynamic_box_dianzan_li' + index + '').click(function () {
                    if (!clickdianzan) {
                        $('#b_dynamic_box_dianzan' + index + '').css('background-image', 'url(../resources/icon/dianzan_b.png)');
                        $('#b_dynamic_box_dianzan_li' + index + ' p').css('color', '#fc6766');
                        dianzanText++;
                        $('#b_dynamic_box_dianzan_num' + index + '').text(dianzanText);
                        //增加点赞数
                        add_dianzan(dynamicId);
                        clickdianzan = true;
                    } else if (clickdianzan) {
                        $('#b_dynamic_box_dianzan' + index + '').css('background-image', 'url(../resources/icon/dianzan_a.png)');
                        $('#b_dynamic_box_dianzan_li' + index + ' p').css('color', '#808080');
                        dianzanText--;
                        $('#b_dynamic_box_dianzan_num' + index + '').text(dianzanText);
                        reduce_dianzan(dynamicId);
                        clickdianzan = false;
                    }
                });
            });

            //评论
            $(function () {
                var clickpinglun = false;
                $('#b_dynamic_box_pinglun_li' + index + '').click(function () {
                    if (!clickpinglun) {
                        //改变评论颜色
                        $('#b_dynamic_box_pinglun' + index + '').css('background-image', 'url(../resources/icon/pinglun_b.png)');
                        $('#b_dynamic_box_pinglun_li' + index + ' p').css('color', '#fc6766');
                        //恢复初始
                        $('.comment_box').empty();
                        $('.comment_box').css('display', 'none');
                        //创建评论框
                        $('#comment_box' + index + '').css('display', 'block');
                        $('#comment_box' + index + '').append('<div class="comment_input_wapper" id="comment_input_wapper"><form action="" id="comment_form' + index + '"><div class="comment_input_wapper_box clearfloat"><div class="comment_box_head_box"><img src="../resources/img/touxaing.jpg" id="comment_user_headimg"></div><div class="comment_input_box"><input type="text" name="comment_text" id="comment_input" class="comment_input"><input type="text" name="dynamic_id" id="comment_dynamic_id" class="hidden_input"><input type="text" name="u_id" id="comment_u_id" class="hidden_input value="0"><input type="text" name="comment_creation_time" id="comment_creation_time" class="hidden_input value="2019-01-01 00:00:00"></div></div></form><div class="comment_func_area clearfloat"><div class="l_comment_func_area"><ul><li><button class="comment_emoji_btn" id="comment_emoji_btn' + index + '"></button></li></ul></div><div class="r_comment_func_area"><div class="comment_subumit_btn" id="comment_subumit_btn">评论</div></div></div></div>');
                        //将基本数据填入评论框
                        $('#comment_dynamic_id').val(dynamicId);
                        //$('#comment_u_id').val('2');
                        $('#comment_u_id').val(myuserId);
                        //填入用户头像
                        $('#comment_user_headimg').attr('src','../resources/upload/headimg/'+myuserHead+'');
                        //绑定表情
                        addEmojiBox('#comment_input', '#comment_emoji_btn' + index + '');
                        //点击评论按钮进行评论
                        $('#comment_subumit_btn').click(function () {
                            //console.log(myuserId);
                            //console.log(('#comment_input').val());
                            if (myuserId == "") {
                                layer.msg('亲！请先登录');
                            } else if ($('#comment_input').val() == "") {
                                layer.msg('请说点什么吧');
                            } else {
                                $('#comment_creation_time').val(getNowFormatDate() + "");
                                add_comment('#comment_form' + index + '');
                            }
                        });
                        //创建该动态的评论内容框
                        $('#comment_box' + index + '').append('<div class="comment_wapper" id="comment_wapper"></div>');
                        //遍历获取评论
                        var comments = get_comment(dynamicId);
                        for (var k = 0; k < comments.length; k++) {
                            //创建动态
                            $('#comment_wapper').append('<div class="comment_personal_data clearfloat"><div class="l_comment_personal_data"><div class="l_comment_personal_head_box"><img src="../resources/img/touxaing.jpg" id="comment_personal_data_headimg_name' + k + '"></div></div><div class="r_comment_personal_data"><p class="comment_personal_data_username" id="comment_personal_data_username' + k + '"></p><p>：</p><span class="comment_personal_data_text" id="comment_personal_data_text' + k + '"></span><div class="comment_personal_data_statu_box clearfloat"><div class="comment_personal_data_statu_box_time" id="comment_personal_data_statu_box_time' + k + '"></div></div></div></div>');
                            //填入内容
                            $('#comment_personal_data_text' + k + '').append(comments[k].comment_text);
                            //填入时间
                            $('#comment_personal_data_statu_box_time' + k + '').append(comments[k].comment_creation_time);
                            //向服务器拿评论用户信息
                            var commentUserInformation = get_userById(comments[k].u_id);
                            //填入用户名
                            $('#comment_personal_data_username' + k + '').append(commentUserInformation[0].name);
                            //填入头像
                            $('#comment_personal_data_headimg_name' + k + '').attr('src', '../resources/upload/headimg/' + commentUserInformation[0].headimg_name + '');
                            //将符号置换为表情
                            parseEmoji('#comment_personal_data_text' + k + '');
                            clickpinglun = true;
                        }
                    } else if (clickpinglun) {
                        //改变评论颜色
                        $('#b_dynamic_box_pinglun' + index + '').css('background-image', 'url(../resources/icon/pinglun_a.png)');
                        $('#b_dynamic_box_pinglun_li' + index + ' p').css('color', '#808080');

                        $('.comment_box').empty();
                        $('.comment_box').css('display', 'none');

                        clickpinglun = false;
                    }
                });
            });
        })();
    }
}

//添加工作室信息
function setup_studio(studio){
    $('#studio_img').attr('src','../resources/upload/studiologoimg/'+studio[0].studio_logo);
    $('#studio_name').text(studio[0].studio_name);
    $('#studio_link').click(function(){
        window.location.href = 'studiohomepage.html?id='+studio[0].studio_id;
    });
}

