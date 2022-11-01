/**
 * @author 김예은
 */
$(function(){

    // 문의 리스트 클릭 시, 문의 내용 상세창 SHOW / HIDE
    $(".question-content-wrap").click(function(){
        $(this).siblings(".detail-question-wrap").toggleClass("blind");
    });

});