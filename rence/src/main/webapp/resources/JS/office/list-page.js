/**
 * @author 김예은
 */
$(function(){
    // 다른 공간 보기 버튼 - 메인 페이지로 이동
    $("#go-main-btn").click(function(){
        location.href="/rence/";
    });

    //정렬 셀렉트 클릭 시 커스텀 셀렉트 SHOW
    $(".sort").click(function(){
        $(".sort-select-box-wrap").toggleClass("blind");
    });

    $(".sort-select-list").click(function(){
        var type = location.href.split("?type=")[1].split("&")[0];
        location.href = "/rence/list_page?type=" + type + "&condition=" + $(this).attr("condition");
    });
});