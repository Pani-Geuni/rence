$(function(){
  let test = 1;

  /***** ************** *****/ 
  /***** 슬라이드 이미지 *****/ 
  /***** ************** *****/ 
  $(".next").click(function () {
    if (test == 1) {
      $(".slideContainer").css("transform", "translateX(-100vw)");
      test = test + 1;
    } else if (test == 2) {
      $(".slideContainer").css("transform", "translateX(-200vw)");
      test = test + 1;
    }
  });

  $(".prev").click(function () {
    if (test == 3) {
      $(".slideContainer").css("transform", "translateX(-100vw)");
      test = test - 1;
    } else if (test == 2) {
      $(".slideContainer").css("transform", "translateX(0vw)");
      test = test - 1;
    }
  });


  /***** ************** *****/ 
  /***** DATEPICKER부분 *****/ 
  /***** ************** *****/ 
  $(".time-input").datetimepicker({
    dateFormat:'yy/mm/dd',
    monthNamesShort:[ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
    dayNamesMin:[ '일', '월', '화', '수', '목', '금', '토' ],
    showMonthAfterYear:true,

    // timepicker 설정
    timeFormat:'HH:mm:ss',
    controlType:'select',
    oneLine:true,
  });


  /***** *** ******* *****/ 
  /***** 고정된 부분 *****/ 
  /***** *** ******* *****/ 
  // 예약 시간 실패 팝업창 닫기 버튼 클릭
  $("#time-fail-close-btn").click(function(){
    $(".fixed-popup").addClass("blind");
  });


  /***** *** ********** *****/ 
  /***** 고정 안 된 부분 *****/ 
  /***** *** ********** *****/ 

  /****** 메뉴 섹션 ******/
  $(".menu").click(function(){
    $(".menu").removeClass("click-menu");
    $(this).addClass("click-menu");
    
    if($(this).attr("menu") == "info"){
      $(".space-description-wrap").removeClass("blind");
      $(".question-wrap:eq(0)").addClass("blind");
      $("#review-wrap").addClass("blind");
    }
    else if($(this).attr("menu") == "qna"){
      $(".space-description-wrap").addClass("blind");
      $(".question-wrap:eq(0)").removeClass("blind");
      $("#review-wrap").addClass("blind");
    }
    else if($(this).attr("menu") == "review"){
      $(".space-description-wrap").addClass("blind");
      $(".question-wrap:eq(0)").addClass("blind");
      $("#review-wrap").removeClass("blind");
    }
  });

  /****** 문의 섹션 ******/
  $("#question-create-btn").click(function(){
    $("#question-popup").removeClass("blind");
  });


  /***** *** ******** *****/ 
  /***** REVIEW POPUP *****/ 
  /***** *** ******** *****/ 
  $(".review-upload-btn").click(function(){
    $(".file").click();
  });

  $(".file").on('change',function(){
    var fileName = $(".file").val();
    var fArr = fileName.split("\\");

    $(".review-upload-value").val(fArr[fArr.length - 1]);
  });


  /***** ************** *****/ 
  /***** QUESTION POPUP *****/ 
  /***** ************** *****/ 
  $("#question-close-btn").click(function(){
    // TEXTAREA 초기화
    $("#question-write").val("");

    $(".question-popup-select").addClass("blind");
    $(".question-popup-select-value").text("타입을 선택해 주세요");
    $(".question-popup-select-val-wrap").removeClass("open-select");
    
    // 팝업 닫기
    $("#question-popup").addClass("blind");
  });

  $(".question-popup-select-val-wrap").click(function(){
    if($(".question-popup-select").hasClass("blind")){
      $(".question-popup-select-val-wrap").addClass("open-select");
      $(".question-popup-select").removeClass("blind");
    }
    else{
      $(".question-popup-select-val-wrap").removeClass("open-select");
      $(".question-popup-select").addClass("blind");
    }
  });
});