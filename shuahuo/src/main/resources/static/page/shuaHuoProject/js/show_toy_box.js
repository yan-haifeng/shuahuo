
function show_box(url) {
    exit_btn();
    $('body',window.parent.window.parent.document).append('<div class="show_box" id="show_box"><div class="exit_btn" id="exit_btn"></div></div>');
    $(document).click(function () {
        exit_btn();
    });
    $(window.parent.window.parent.document).click(function () {
        exit_btn();
    });
    $('#show_box',window.parent.window.parent.document).click(function(event){
        event.stopPropagation();
    });
    $('#show_box',window.parent.window.parent.document).css('background-image', 'url(' + url + ')');
    $('#exit_btn',window.parent.window.parent.document).click(function () {
        exit_btn();
    });
}

function exit_btn() {
    $('#show_box',window.parent.window.parent.document).remove();
}

function show_boxs(url) {
    exit_btns();
    $('body',window.parent.document).append('<div class="show_box" id="show_box"><div class="exit_btn" id="exit_btn"></div></div>');
    $(document).click(function () {
        exit_btns();
    });
    $(window.parent.document).click(function () {
        exit_btns();
    });
    $('#show_box',window.parent.document).click(function(event){
        event.stopPropagation();
    });
    $('#show_box',window.parent.document).css('background-image', 'url(' + url + ')');
    $('#exit_btn',window.parent.document).click(function () {
        exit_btns();
    });
}

function exit_btns() {
    $('#show_box',window.parent.document).remove();
}


