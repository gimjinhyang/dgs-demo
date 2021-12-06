$(function () {

    var _path = window.location.pathname;

    $("#sidebar-manu").find(".nav-link").each(function (i, v) {
        if ($(this).attr("href") == _path) {
            $(this).addClass('active')
        }
    });

})
