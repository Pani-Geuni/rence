$(function(){
    $(".type-list").click(function(){
        if($(this).hasClass(".type-desk")){
            location.href = "/rence/list_page?type=desk&condition=date"
        }
        if($(this).hasClass(".type-meeting-room")){
            location.href = "/rence/list_page?type=meeting-room&condition=date"
        }
        if($(this).hasClass(".type-office")){
            location.href = "/rence/list_page?type=office&condition=date"
        }
    });
});