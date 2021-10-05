//获取所有玩具
function get_toys() {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findAllToys',
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//获取所有工作室
function get_studios() {
    var getData = "";
    $.ajax({
        type: 'GET',
        dataType: 'json',
        //设置为true后return不了data
        async: false,
        url: '../findAllStudio',
        success: function (data) {
            getData = data.data;
        }
    });
    return getData;
}

//玩具填入玩具下拉框
function setup_toys_select(toys) {
    for (var i = 0; i < toys.length; i++) {
        $('#toys_select').append('<option value="'+toys[i].toys_id+'">'+toys[i].toys_name+'</option>');
    }
}

//工作室填入工作室下拉框
function setup_studios_select(studios) {
    for (var i = 0; i < studios.length; i++) {
        $('#studios_select').append('<option value="'+studios[i].studio_id+'">'+studios[i].studio_name+'</option>');
    }
}

//获取登录用户id并填入input
var userid = 0;
if (userInformation.data != null) { 
    userid = userInformation.data[0].id;
}
$('#user_id_input').val(userid);

//获取并填入玩具
var toys = get_toys();
setup_toys_select(toys);

//获取并填入工作室
var studios = get_studios();
setup_studios_select(studios);