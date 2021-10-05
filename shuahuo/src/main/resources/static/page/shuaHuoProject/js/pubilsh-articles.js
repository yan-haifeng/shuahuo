var userid = 0;
if (userInformation.data != null) { 
    userid = userInformation.data[0].id;
}
$('#u_id').val(userid);
//点击提交按钮事件
$(function () {
    $("#published").click(
        function () {
            if ($('#u_id').val() == 0) {
                layer.msg('亲！请先登录');
            } else {
                var nowtime = getNowFormatDate() + "";
                $("#dynamic_creation_time").val(nowtime);
                if ($("#editor").val() == "") {
                    //
                    layer.msg('请说点什么吧');
                } else {
                    $.ajax({
                        type: 'POST',
                        dataType: 'json',
                        url: '../addDynamic',
                        data: $("#dynamic_form").serializeArray(),
                        contentType: "application/x-www-form-urlencoded",
                        success: function () {
                            //console.log('成功');
                            layer.msg('发表内容成功');

                            //添加发布内容
                            $('.dynamic_box').prepend('<div class="dynamic_personal_data clearfloat"><div class="dynamic_wapper clearfloat"><div class="l_dynamic_box"><div class="head_img" id="head_img_ajax"></div></div><div class="r_dynamic_box"><div class="name_box"><p id="name_ajax"></p><span id="dynamic_time_ajax"></span><span>发布于</span><span>杭州</span></div><div class="text_contest"><span id="text_contest_ajax"></span></div><div class="dynamic_img_box clearfloat" id="dynamic_img_box_ajax"></div></div></div><div class="b_dynamic_box "><ul class="clearfloat"><li><span class="b_dynamic_box_shoucang"></span><p>收藏</p></li><li><span class="b_dynamic_box_zhuanfa"></span><p>转发</p></li><li><span class="b_dynamic_box_pinglun"></span><p>评论</p></li><li class="no-border"><span class="b_dynamic_box_dianzan"></span><p>点赞</p></li></ul></div><div class="weibo_c_icon"><span><img src="../resources/icon/weibo_c.png"></span></div></div>');
                            $('#text_contest_ajax').append($("#editor").val());
                            $('#dynamic_time_ajax').append($('#dynamic_creation_time').val());

                            //判断是否有视频或者图片
                            //视频
                            if ($('#dynamic_videonum').val() == 1) {
                                $('#dynamic_img_box_ajax').append('<div class="dynamic_video"><video src="../resources/upload/video/' + $('#dynamic_videoname').val() + '" controls="controls">Your browser does not support the video tag.</video></div>');
                            }
                            //1张图片
                            if ($('#dynamic_imgnum').val() == 1) {
                                //处理图片名字
                                var oneImgeName = ($('#dynamic_imgname').val()).replace('##', "");
                                $('#dynamic_img_box_ajax').append('<div class="one_img"><img src="../resources/upload/img/' + oneImgeName + '"></div>');
                            }
                            //多张图片
                            if ($('#dynamic_imgnum').val() > 1 && $('#dynamic_imgnum').val() < 10) {
                                //处理图片名字
                                var strs = new Array();
                                strs = ($('#dynamic_imgname').val()).split('##');
                                for (var j = 1; j <= $('#dynamic_imgnum').val(); j++) {
                                    $('#dynamic_img_box_ajax').append('<div class="many_img"><img src="../resources/upload/img/' + strs[j] + '"></div>');
                                }
                            }
                            //填入用户名字
                            $('#name_ajax').append(userInformation.data[0].name);
                            //填入用户头像
                            $('#head_img_ajax').css('background-image','url("../resources/upload/headimg/'+userInformation.data[0].headimg_name+'")');

                            //清空输入控件
                            $("#editor").val("");
                            $('#dynamic_creation_time').val("2019-01-01 00:00:00");
                            $('#dynamic_videonum').val('0');
                            $('#dynamic_videoname').val("");

                            $('#upload-video').css('border', '1px #999999 dashed');
                            $('#upload-video').attr('src', '#');
                            $('#upload-video').removeAttr('controls');
                            $('.cancel_video_btn').css('display', 'none');

                            $('#upload-img-btn').css('display', 'block');
                            $('.loadimg-wapper').remove();
                            $('#dynamic_imgnum').val(0);
                            $('#dynamic_imgname').val("");
                        },
                        error: function () {
                            console.log('失败')
                            layer.msg('发表失败了');
                        }
                    });
                }
            }

        }
    );
});

//上传图片窗口控制
//任何点击都隐藏上传图片窗口
$(document).click(function () {
    $(".iframe_wapper_img").css("display", "none");
});
//上传图片窗口出现
$(function () {
    $("#loadimg_btn").click(function (event) {
        event.stopPropagation();
        $(".iframe_wapper_video").css("display", "none");
        //判断用户是否同时上传视频
        if ($('#dynamic_videonum').val() == 1) {
            layer.confirm('确定放弃上传视频？', {
                btn: ['是的', '取消'] //按钮
            }, function () {
                //点击确定回调
                $('#dynamic_videonum').val('0');
                $('#dynamic_videoname').val("");

                $('#upload-video').css('border', '1px #999999 dashed');
                $('#upload-video').attr('src', '#');
                $('#upload-video').removeAttr('controls');
                $('.cancel_video_btn').css('display', 'none');
                layer.msg('已放弃上传视频，请再次点击上传图片', { icon: 1 });
            }, function () {
                //点击取消回调
            });
        } else {
            $("#emoji_container_1").css("display", "none");
            $(".iframe_wapper_img").css("display", "block");
            uploadImg();
        }

    });
    $(".iframe_wapper_img").click(function (event) {
        event.stopPropagation();
    });
});



//上传视频窗口控制
//任何点击都隐藏上传视频窗口
$(document).click(function () {
    $(".iframe_wapper_video").css("display", "none");
});
//上传视频窗口出现
$(function () {
    $("#loadvideo_btn").click(function (event) {
        event.stopPropagation();
        $(".iframe_wapper_img").css("display", "none");
        //判断用户是否同时上传视频
        if ($('#dynamic_imgnum').val() != 0) {
            layer.confirm('确定放弃上传图片？', {
                btn: ['是的', '取消'] //按钮
            }, function () {
                //点击确定回调
                $('#upload-img-btn').css('display', 'block');
                $('.loadimg-wapper').remove();
                $('#dynamic_imgnum').val(0);
                $('#dynamic_imgname').val("");
                layer.msg('已放弃上传图片，请再次点击上传视频', { icon: 1 });
            }, function () {
                //点击取消回调
            });
        } else {
            $("#emoji_container_1").css("display", "none");
            $(".iframe_wapper_video").css("display", "block");
            uploadVideo();
        }
    });
    $(".iframe_wapper_video").click(function (event) {
        event.stopPropagation();
    });
});



//上传图片事件
var dynamic_imgname = "";
var dynamic_imgnum = 0;
function uploadImg() {
    layui.use('upload', function () {
        var $ = layui.jquery
            , uploads = layui.upload;
        //多图片上传
        uploads.render({
            elem: '#upload-img-btn'
            , url: '../uploadImgFile'
            , multiple: true
            , number: 9
            , accept: 'images'
            , auto: false
            , bindAction: "#published"
            , size: 10240
            , choose: function (obj) {
                var files = obj.pushFile();
                //选择文件后事件
                //判断选择图片数量
                dynamic_imgnum = $(".loadimg-wapper").length + 1;
                //console.log("已选择图片数量" + dynamic_imgnum);
                //判断选择9张图片后选择按钮消失
                if (dynamic_imgnum >= 9) {
                    $('#upload-img-btn').css('display', 'none');
                } else {
                    $('#upload-img-btn').css('display', 'block');
                }

                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    //添加图片
                    $('#upload-img-wapper').append('<div class="loadimg-wapper" id="' + index + '-imgwapper"><img src="' + result + '" alt="' + file.name + '" class="layui-upload-img"><div class="del-img"><span class="del-img-btn"></span></div></div>');
                    $('#' + index + '-imgwapper .layui-upload-img').mouseover(function () {
                        $('#' + index + '-imgwapper .del-img').css("display", "block");
                    });
                    $('#' + index + '-imgwapper .del-img').mouseout(function () {
                        $('#' + index + '-imgwapper .del-img').css("display", "none");
                    });

                    //图片名随机
                    var suffixName = (file.name).substring((file.name).lastIndexOf("."));//获取文件后缀名
                    var filename = createPic() + suffixName;
                    //console.log("选择图片名为" + filename);
                    obj.resetFile(index, file, filename);
                    dynamic_imgname = dynamic_imgname + "##" + filename;
                    //console.log("文件名为"+dynamic_imgname);
                    //删除图片事件
                    $('#' + index + '-imgwapper .del-img .del-img-btn').click(function () {
                        $('#' + index + '-imgwapper').remove();
                        delete files[index];
                        //判断选择图片数量
                        dynamic_imgnum = $(".loadimg-wapper").length;
                        //console.log("删除后图片数量" + dynamic_imgnum);
                        //判断选择9张图片后选择按钮消失
                        if (dynamic_imgnum >= 9) {
                            $('#upload-img-btn').css('display', 'none');
                        } else {
                            $('#upload-img-btn').css('display', 'block');
                        }
                        //替换不能写作dynamic_imgname.replace("##"+filename,"");
                        //应该写作dynamic_imgname = dynamic_imgname.replace("##"+filename,"");
                        dynamic_imgname = dynamic_imgname.replace("##" + filename, "");
                        //console.log("删除的图片是"+"##"+filename);
                        //console.log("删除后文件名为"+dynamic_imgname);
                        //将图片名交给input
                        $('#dynamic_imgname').val(dynamic_imgname);
                        //console.log("删除后input的value"+$('#dynamic_imgname').val());
                        $('#dynamic_imgnum').val(dynamic_imgnum);
                        //console.log("删除后input的value："+$('#dynamic_imgnum').val());
                    });
                    //将图片名交给input
                    $('#dynamic_imgname').val(dynamic_imgname);
                    //console.log("input的value"+$('#dynamic_imgname').val());
                    //将图片数量交给input
                    $('#dynamic_imgnum').val(dynamic_imgnum);
                    //console.log("input的value："+$('#dynamic_imgnum').val());
                });
            }
            , done: function (res) {
                //上传完毕
                //console.log(res);
            }
        });
    });
}



var dynamic_videoname = "";
var dynamic_videonum = 0;
function uploadVideo() {
    //上传视频
    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;
        upload.render({
            elem: '#upload_video_btn'
            , url: '../uploadVideoFile'
            , auto: false
            , bindAction: "#published"
            , accept: 'video' //视频
            , size: 30720
            , multiple: false
            , choose: function (obj) {
                var files = obj.pushFile();
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    dynamic_videonum = 1;
                    $('#upload-video').css('border', 'none');
                    $('.cancel_video_btn').css('display', 'inline-block');
                    $('#upload-video').attr('src', result);
                    $('#upload-video').attr('controls', 'true');

                    //视频名随机
                    var suffixName = (file.name).substring((file.name).lastIndexOf("."));//获取文件后缀名
                    var filename = createPic() + suffixName;
                    obj.resetFile(index, file, filename);
                    dynamic_videoname = filename;
                    //再次点击按钮时清除之前选中的视频
                    $('#upload_video_btn').click(function () {
                        delete files[index];
                    });
                    //删除事件
                    $('#cancel_video_btn').click(function () {
                        delete files[index];
                        dynamic_videonum = 0;
                        $('#upload-video').css('border', '1px #999999 dashed');
                        $('#upload-video').attr('src', '#');
                        $('#upload-video').removeAttr('controls');
                        $('.cancel_video_btn').css('display', 'none');
                        dynamic_videoname = dynamic_videoname.replace(filename, "");
                        //将视频名交给input
                        $('#dynamic_videoname').val(dynamic_videoname);
                        //将视频数量交给input
                        $('#dynamic_videonum').val(dynamic_videonum);
                    });
                    //将视频名交给input
                    $('#dynamic_videoname').val(dynamic_videoname);
                    //将视频数量交给input
                    $('#dynamic_videonum').val(dynamic_videonum);
                });
            }
            , done: function (res) {
                //console.log(res)
            }
        });
    });
}

//产生随机图片名称
function createPic() {
    len = 8;
    var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';    /****默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1****/
    var maxPos = $chars.length;
    var randomstr = '';
    for (i = 0; i < len; i++) {
        randomstr += $chars.charAt(Math.floor(Math.random() * maxPos));
    }
    var now = new Date();
    var year = now.getFullYear(); //得到年份
    var month = now.getMonth();//得到月份
    var date = now.getDate();//得到日期
    var hour = now.getHours();//得到小时
    var minu = now.getMinutes();//得到分钟
    month = month + 1;
    if (month < 10) month = "0" + month;
    if (date < 10) date = "0" + date;
    var time = year + month + date + hour + minu;
    return time + "_" + randomstr;
}


//获取当前时间
function getNowFormatDate() {
    var now = new Date();
    var year = now.getFullYear();       //年
    var month = now.getMonth() + 1;     //月
    var day = now.getDate();            //日        
    var hh = now.getHours();            //时
    var mm = now.getMinutes();          //分
    var ss = now.getSeconds();           //秒        
    var clock = year + "-";
    if (month < 10)
        clock += "0";
    clock += month + "-";
    if (day < 10)
        clock += "0";
    clock += day + " ";
    if (hh < 10)
        clock += "0";
    clock += hh + ":";
    if (mm < 10) clock += '0';
    clock += mm + ":";
    if (ss < 10) clock += '0';
    clock += ss;
    return (clock);
} 
