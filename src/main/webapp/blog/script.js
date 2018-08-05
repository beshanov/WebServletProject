$(document).ready(function () {
    console.log("js is working");
    $("#showButton").on("click", function () {
        console.log("button is working");
        $.get("Show", function (responseJson) {
            var $ul = $("<ul>").appendTo($("#posts"))
            $.each(responseJson, function (index, item) {
                $("<li>").text(item.data).appendTo($ul).append(item.created);
            })
        });
    });
});