/**
 * @author 김예은
 */
$(function(){
  let test = 1;

  /***** ************** *****/ 
  /***** 슬라이드 이미지 *****/ 
  /***** ************** *****/ 
  let position = 0;
  $(".next").click(function () {
    if (test < $(".img").length) {
      position += 960;
      $(".container").css("transform", "translateX(-"+position+"px)");
      test = test + 1;
    }
  });

  $(".prev").click(function () {
    if (test != 1) {
      position -= 960;
      $(".container").css("transform", "translateX(-"+position+"px)");
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
    minDate: new Date().toLocaleDateString().replaceAll(". ", "/"),

    // timepicker 설정
    timeFormat:'HH:mm:ss',
    controlType:'select',
    oneLine:true,
  });


  /***** *** ******* *****/ 
  /***** 고정된 부분 *****/ 
  /***** *** ******* *****/ 
  /*** 예약 시간 실패 팝업창 닫기 버튼 클릭 ***/
  $("#time-fail-close-btn").click(function(){
    $(".fixed-popup").addClass("blind");
  });

  /*** 예약 타입 셀렉트 클릭 시 -> 커스텀 셀렉트 SHOW ***/
  $(".type-border").click(function(){
    if($(".custom-select-type").hasClass("blind")){
      $(".custom-select-type").removeClass("blind");
      $(".type-border").addClass("open-select");
    }else{
      $(".custom-select-type").addClass("blind");
      $(".type-border").removeClass("open-select");
    }
  });
  
  /*** 예약 타입 리스트 클릭 ***/
  $(".custom-select-type-list").click(function(){
    $(".type-border-txt").text($(this).children(".room-name").text());
    $(".type-border-txt").prop("check", true);
    
    let attr_room_no = $(this).children(".room-name").attr("room_no");
    $("#type-choice-value").attr("room_no", attr_room_no);
    
    $(".custom-select-type").addClass("blind");
    $(".type-border").removeClass("open-select");
  });

  /*** 예약 가능 여부 버튼 클릭 ***/
  $("#check_available").click(function(){
    // 예약 타입 선택 O
    if($(".type-border-txt").prop("check")){
      if($(".time-input:eq(0)").val() != '' && $(".time-input:eq(1)").val() != ''){
        // 예약 가능 확인 로직

        // ================
        // 예약 가능 테스트 코드
        // ================
        
        let query = location.search;
        let param = new URLSearchParams(query);
        let backoffice_no = param.get('backoffice_no');
        let room_no = $("#type-choice-value").attr("room_no");
        let reserve_stime = $(".time-input:eq(0)").val();
        let reserve_etime = $(".time-input:eq(1)").val();
        
        console.log("room no :: ", room_no);
        
        $.ajax({
        	url : "/rence/reserve_checkOK",
        	type : "GET",
        	dataType : "json",
        	data : {
        		reserve_stime : reserve_stime,
        		reserve_etime : reserve_etime,
        		room_no : room_no,
        		backoffice_no : backoffice_no,
        		user_no : $.cookie("user_no")
        	},
        	
        	success : function(res) {
        		
				if (res.result == 1) {
					console.log("success");
					// location.href = "/rence/"
				} else if (res.result == 0) {
					console.log("fail");
					$(".fixed-popup").removeClass("blind");
        			$(".using-time-fail-txt").html("해당 시간은 예약 할 수 없습니다.");
				}
        	},
        	error : function(error) {
        		console.log(error)
        	}
        	
        });
        
        // ==================
        // 예약 가능 테스트 코드 끝
        // ==================
      }
      // 예약 타입 선택 O, 체크인 or 체크아웃 시간 X
      else{
        $(".fixed-popup").removeClass("blind");
        $(".using-time-fail-txt").html("체크인 시간과 체크아웃 시간을<br><br>모두 선택하여 주십시오.");
      }
    }
    // 예약 타입 선택 X
    else{
      $(".fixed-popup").removeClass("blind");
      $(".using-time-fail-txt").html("예약 타입을 선택하여 주십시오.");
    }
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

  /****** 후기 섹션 ******/
  $("#review-write-btn").click(function(){
    $("#review-popup").removeClass("blind");
  });


  /***** *** ******** *****/ 
  /***** REVIEW POPUP *****/ 
  /***** *** ******** *****/
  /** 팝업 닫기 버튼 클릭 이벤트 */ 
  $("#review-close-btn").click(function(){
    // TEXTAREA 초기화
    $("#review-write").val("");
    // 글자수 초기화
    $(".review-length").text("0");
    //선택한 셀렉트 값 초기화
    $("#question-select-choice").text
    // 팝업 닫기
    $("#review-popup").addClass("blind");
  });

  /** 이미지 등록 버튼 클릭 이벤트 */
  $(".review-upload-btn").click(function(){
    $(".file").click();
  });

  /** 팝업 셀렉트 리스트 클릭 이벤트 */
  $(".question-popup-select-li").click(function(){
    $("#question-select-choice").val($(this).val());
    $(".question-popup-select").addClass("blind");
    $(".question-popup-select").removeClass("open-select");
  });

  /** 이미지 등록 시 파일명 SHOW */
  // $(".file").on('change',function(){
  //   var fileName = $(".file").val();
  //   var fArr = fileName.split("\\");

  //   $(".review-upload-value").val(fArr[fArr.length - 1]);
  // });

  /** 문의글 작성 시 글자수 제한 */
  $("#review-write").on("keydown keyup", function(){
    if($(this).val().length > 500){
      $(this).val($(this).val().substring(0,500));
    }
    $(".review-length").text($(this).val().length);
  });


  /***** ************** *****/ 
  /***** QUESTION POPUP *****/ 
  /***** ************** *****/
  /*** 팝업 닫기 버튼 클릭  ***/
  $("#question-close-btn").click(function(){
    // TEXTAREA 초기화
    $("#question-write").val("");
    // 글자수 초기화
    $(".qna-length").text("0");

    $(".question-popup-select").addClass("blind");
    $(".question-popup-select-value").text("타입을 선택해 주세요");
    $(".question-popup-select-val-wrap").removeClass("open-select");
    
    // 팝업 닫기
    $("#question-popup").addClass("blind");
  });

  /*** 문의 작성 글자수 제한  ***/
  $("#question-write").on("keydown keyup", function(){
    if($(this).val().length > 500){
      $(this).val($(this).val().substring(0,500));
    }
    $(".qna-length").text($(this).val().length);
  });

  $("#question-popup").click(".question-popup-select-val-wrap", function(){
    if($(".question-popup-select").hasClass("blind")){
      $(".question-popup-select-val-wrap").addClass("open-select");
      $(".question-popup-select").removeClass("blind");
    }
    else{
      $(".question-popup-select-val-wrap").removeClass("open-select");
      $(".question-popup-select").addClass("blind");
    }
  });

  /** 팝업 셀렉트 리스트 클릭 이벤트 */
  $(".question-popup-select-li").click(function(){
    $("#question-select-choice").text($(this).text());
    $(".question-popup-select-val-wrap").removeClass("open-select");
    $(".question-popup-select").addClass("blind");
  });
});