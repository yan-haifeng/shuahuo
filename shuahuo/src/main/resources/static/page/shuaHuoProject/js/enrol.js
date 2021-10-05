$('#enrol-ul li').click(function(){
    $('#enrol-ul li').removeClass('click-li');
    $(this).addClass('click-li');
});

$('#enrol_for_phone').click(function(){
    $('#enrol_iframe').attr('src','../views/iframe-views/enrol-phone-form.html');
});
$('#enrol_for_e-mail').click(function(){
    $('#enrol_iframe').attr('src','../views/iframe-views/enrol-mail-form.html');
});
$('#enrol_for_account').click(function(){
    $('#enrol_iframe').attr('src','../views/iframe-views/enrol-account-form.html');
});