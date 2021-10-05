//上传样张图片
layui.use('upload', function () {
    var $ = layui.jquery
        , upload = layui.upload;
    var sample_img_num = 0;
    var sample_img_name = "";
    //普通图片上传
    var uploadInst = upload.render({
        elem: '#sample_img_btn'
        , url: '../uploadOrderImg'
        , multiple: true
        , number: 4
        , auto: false
        , bindAction: '#submit_order_btn'
        , choose: function (obj) {
            var files = obj.pushFile();
            sample_img_num = $('.have_img').length + 1;
            //判断图片是否超过4张，超过按钮消失
            if (sample_img_num >= 4) {
                $('#sample_img_btn').css('display', 'none');
            } else {
                $('#sample_img_btn').css('display', 'block');
            }
            //预读本地文件示例，不支持ie8
            obj.preview(function (index, file, result) {
                $('#sample_img_ul').append('<li id="sample_img_li' + index + '"><div class="have_img" id="sample_img_btn"><i class="exit" id="exit' + index + '_btn"></i><img src="' + result + '"></div></li>');
                var suffixName = (file.name).substring((file.name).lastIndexOf("."));//获取文件后缀名
                var filename = createPic() + suffixName;
                //console.log("选择图片名为" + filename);
                obj.resetFile(index, file, filename);
                sample_img_name = sample_img_name + "##" + filename;
                //删除图片事件
                $('#exit' + index + '_btn').click(function () {
                    $('#sample_img_li' + index + '').remove();
                    delete files[index];
                    sample_img_num = $('.have_img').length
                    if (sample_img_num >= 4) {
                        $('#sample_img_btn').css('display', 'none');
                    } else {
                        $('#sample_img_btn').css('display', 'block');
                    }
                    sample_img_name = sample_img_name.replace("##" + filename, "");
                    $('#sample_img_input').val(sample_img_name);
                });
                $('#sample_img_input').val(sample_img_name);
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
            $('.sample_img_ul .layui-upload-file').remove();
            //上传图片成功后才开始上传订单表单
            set_order('#order_form');
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

//上传订单
function set_order(fromName){
    var getData = "";
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: '../addOrder',
        data: $(fromName).serializeArray(),
        contentType: "application/x-www-form-urlencoded",
        success: function (data) {
            layer.msg('提交成功');
            window.location.href = "myorder.html"
        },
        error: function (data) { }
    });
    return getData;
}