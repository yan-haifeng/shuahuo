var flag = 0;
$(function () {
    //擅长工艺选择
    var beGoodAtName = "";
    for (var i = 0; i <= 10; i++) {
        (function () {
            var index = i;
            var isclick = false;
            $('#studio_begoodat_li_' + index + '').click(function () {
                if (!isclick) {
                    $(this).addClass('li-click');
                    beGoodAtName = beGoodAtName + "##" + index;
                    $('#studio_begoodat_input').val(beGoodAtName);
                    isclick = true;
                } else {
                    $(this).removeClass('li-click');
                    beGoodAtName = beGoodAtName.replace("##" + index, "");
                    $('#studio_begoodat_input').val(beGoodAtName);
                    isclick = false;
                }
            });
        }());
    }

    //实时监控工作室名字
    $("#studio_name_input").bind("input propertychange", function () {//监控输入框的变化
        var a = $('#studio_name_input').val();//获取输入框1的值
        $('#studio_name_p').text(a)
    });

    //为成员添加上传头像功能
    uploadMembersHeadImg('#members_information_upload_head0', '#member_head_img0', '#member_headimg_input0', '#members_information_r_logoimg0');

    //点击添加新的成员
    $('#add_members_btn').click(function () {
        flag++;
        $('#members_form_wapper').append('<form action="" id="members_form' + flag + '" class="members_form"><div class="members_information clearfloat"><div class="members_information_l"><div class="members_information_text"><p class="studio_text">真实名称</p></div><div class="members_information_l_input"><input type="text" name="studio_member_name" placeholder="请输入您的真实姓名"></div><div class="members_information_text"><p class="studio_text">身份证件号</p></div><div class="members_information_l_input"><input type="text" name="studio_member_id_card" placeholder="请输入您的身份证件号码"></div><div class="members_information_text"><p class="studio_text">联系方式</p><p class="studio_text havecolor">（手机号码）</p></div><div class="members_information_l_input"><input type="text" name="studio_member_phone_num" placeholder="请输入您的联系方式（手机号码）"></div></div><div class="members_information_r"><div class="members_information_r_logoimg" id="members_information_r_logoimg' + flag + '"><img src="../resources/icon/head_icon.png" id="member_head_img' + flag + '"><div class="members_information_upload_head" id="members_information_upload_head' + flag + '">点我上传头像</div><input type="text" name="studio_member_head_img" id="member_headimg_input' + flag + '" class="hidden_input"></div></div></div><div class="members_resume"><p class="studio_text">添加履历（头衔，职称，获奖，匠龄等）</p><div class="members_resume_wapper"><textarea name="studio_member_record" placeholder="输入您的履历（头衔，职称，获奖，匠龄等）"></textarea></div></div><div class="hr-b"></div><input type="text" name="studio_id" id="members_form_studio_id_input' + flag + '" class="hidden_input"></form>');
        uploadMembersHeadImg('#members_information_upload_head' + flag + '', '#member_head_img' + flag + '', '#member_headimg_input' + flag + '', '#members_information_r_logoimg' + flag + '');
        $('#delete_members_btn').css('display', 'inline-block');
    });

    //点击删除新的成员
    $('#delete_members_btn').click(function () {
        $('#members_form' + flag + '').remove();
        flag--;
        if (flag == 0) {
            $('#delete_members_btn').css('display', 'none');
        }
    });
});

//上传logo
layui.use('upload', function () {
    var $ = layui.jquery
        , upload = layui.upload;
    //普通图片上传
    var uploadInst = upload.render({
        elem: '#studio_information_l_btn'
        , url: '../uploadStudioLogoImg'
        , choose: function (obj) {
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#studio_logo').attr('src', result); //图片链接（base64）
                $('#studio_information_l_btn').text(file.name);
            });
        }
        , done: function (res, obj) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
            //上传成功
            $('#studio_logo_input').val(res.msg);
            $('.studio_information_l .layui-upload-file').remove();
        }
    });
});

//上传工作室图片
layui.use('upload', function () {
    var $ = layui.jquery
        , upload = layui.upload;
    var studio_img_num = 0;
    var stuidio_img_name = "";
    //普通图片上传
    var uploadInst = upload.render({
        elem: '#studio_img_btn'
        , url: '../uploadStudioImg'
        , multiple: true
        , number: 4
        , auto: false
        , bindAction: '#become_craftsman_submit_btn'
        , choose: function (obj) {
            var files = obj.pushFile();
            studio_img_num = $('.have_img').length + 1;
            //判断图片是否超过4张，超过按钮消失
            if (studio_img_num >= 4) {
                $('#studio_img_btn').css('display', 'none');
            } else {
                $('#studio_img_btn').css('display', 'block');
            }
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#studio_img_ul').append('<li id="studio_img_li' + index + '"><div class="have_img" id="studio_img_btn"><i class="exit" id="exit' + index + '_btn"></i><img src="' + result + '"></div></li>');
                var suffixName = (file.name).substring((file.name).lastIndexOf("."));//获取文件后缀名
                var filename = createPic() + suffixName;
                //console.log("选择图片名为" + filename);
                obj.resetFile(index, file, filename);
                stuidio_img_name = stuidio_img_name + "##" + filename;
                //删除图片事件
                $('#exit' + index + '_btn').click(function () {
                    $('#studio_img_li' + index + '').remove();
                    delete files[index];
                    studio_img_num = $('.have_img').length
                    if (studio_img_num >= 4) {
                        $('#studio_img_btn').css('display', 'none');
                    } else {
                        $('#studio_img_btn').css('display', 'block');
                    }
                    stuidio_img_name = stuidio_img_name.replace("##" + filename, "");
                    $('#studio_img_input').val(stuidio_img_name);
                });
                $('#studio_img_input').val(stuidio_img_name);
            });
        }
        , done: function (res, obj) {
            //如果上传失败
            if (res.code > 0) {
                return layer.msg('上传失败');
            }
        }
        , allDone: function (obj) {
            //上传成功
            $('.studio_img_ul .layui-upload-file').remove();
            //上传图片成功后才开始上传工作室表单与工作室成员表单
            //获取用户id
            var userid = 0;
            if (userInformation.data != null) {
                userid = userInformation.data[0].id;
            }
            //上传工作室表单
            var studioData = get_StudioInfo(userid);
            var studioId = studioData[0].studio_id;
            var isSuccess = false;
            //上传成员表单
            for (var j = 0; j <= flag; j++) {
                (function () {
                    var index = j;
                    $('#members_form_studio_id_input' + index + '').val(studioId);
                    isSuccess = get_StudioMemberInfo('#members_form' + index + '');
                }());
            }
            //修改用户工作室id
            set_StudioIdForUser(userid,studioId);
            //上传成功
            if (isSuccess) {
                layer.msg('开通工作室成功');
                window.location.href = "community-forum.html"
            } else {
                layer.msg('开通工作室失败');
            }
        }
    });
});

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

//上传工作室信息
function get_StudioInfo() {
    var studioData = "";
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '../addStudio',
        data: $("#studio_information_form").serializeArray(),
        async: false,
        contentType: "application/x-www-form-urlencoded",
        success: function (data) {
            studioData = data.data;
        },
        error: function () {
            layer.msg('开通工作室失败');
        }
    });
    return studioData;
}

//上传成员信息
function get_StudioMemberInfo(memberName) {
    var isSuccess = false;
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '../addStudioMember',
        data: $(memberName).serializeArray(),
        async: false,
        contentType: "application/x-www-form-urlencoded",
        success: function (data) {
            isSuccess = true;
        },
        error: function () {
            isSuccess = false;
        }
    });
    return isSuccess;
}

//获取动态信息
function set_StudioIdForUser(userId,studioId) {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../changeStudioIdForUser?userId='+userId+'&studioId='+studioId,
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//上传工作室成员头像
function uploadMembersHeadImg(elem, imgname, inputName, deletewapper) {
    //上传logo
    layui.use('upload', function () {
        var $ = layui.jquery
            , upload = layui.upload;
        //普通图片上传
        var uploadInst = upload.render({
            elem: elem
            , url: '../uploadStudioMemberHeadImg'
            , choose: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $(imgname).attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res, obj) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                //上传成功
                $(inputName).val(res.msg);
                $(deletewapper + ' ' + '.layui-upload-file').remove();
            }
        });
    });
}