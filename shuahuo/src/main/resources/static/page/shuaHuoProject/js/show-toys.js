//获取玩具
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

var Toys = get_toys();
setup_toys(Toys);
//将玩具遍历填入
function setup_toys(Toys) {
    for (var i = 0; i < Toys.length; i++) {
        $('#content-tetle-ul').append('<li class="toys_name" id="toys_name'+i+'"><div>'+Toys[i].toys_name+'</div></li>');
        (function(){
            var index = i;
            $('#toys_name'+index+'').click(function(){
                $('#museum_iframe').attr('src','iframe-views/museum-content.html?id='+Toys[index].toys_id+'');
            });
        }());
    }
    var firstLi = document.getElementsByClassName('toys_name');
    firstLi[0].classList.add('click-li');
    $('#museum_iframe').attr('src','iframe-views/museum-content.html?id=1');
}