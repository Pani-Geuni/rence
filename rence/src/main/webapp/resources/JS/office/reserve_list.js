$(function(){
    $(".reserve-box").click(function(){
        if($(this).hasClass("before")){
            location.href = "/rence/reserve_detail_before?reservation_no="+$(this).attr("idx");
        }else{
            location.href = "/rence/reserve_detail_now?reservation_no="+$(this).attr("idx");
        }
    });
});