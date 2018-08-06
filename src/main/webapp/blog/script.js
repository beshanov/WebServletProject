$(document).ready(function () {

    $.get("Show", function (responseJson) {
        refreshPostList(responseJson);
    });

    $("#showButton").on("click", function () {
        $("#list").remove();
        $.get("Show", function (responseJson) {
            refreshPostList(responseJson);
        });
    });

    function refreshPostList (jsonResponse) {
        var $ul = $("<ul id = 'list'>").appendTo($("#posts"))
        $.each(jsonResponse, function (index, item) {
            $("<li>").text(item.created).appendTo($ul).append("  :  ").append(item.data);
        })
    }



    //for login.html


});