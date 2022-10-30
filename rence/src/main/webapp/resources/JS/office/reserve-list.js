$(function(){
    $(".reserve-box").click(function(){
        if($(this).hasClass("before")){
            location.href = "/rence/before-reserve-detail?reserve_no="+$(this).attr("idx");
        }else{
            location.href = "/rence/now-reserve-detail?reserve_no="+$(this).attr("idx");
        }
    });
});