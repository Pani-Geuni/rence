/**
* @author : 전판근, 김예은
*/
$(function () {
  /** 공용 알러트 창닫기 버튼 */ 
  $("#common-alert-btn").click(function(){
    $(".popup-background:eq(1)").addClass("blind");
    $("#common-alert-popup").addClass("blind");
  });

  /******************************* */
  /***********로그인 팝업 ********* */
  /******************************* */
  // 로그인 인풋 클릭 시 경고 테두리 제거
  $(".login-popup-input").click(function(){
    if($(this).hasClass("null-input-border")){
        $(this).removeClass("null-input-border");
    }
  });
  $("#login-btn").click(function(){
    if($("#login-id").val().trim().length == 0){
      $("#login-id").addClass("null-input-border");
    }
    if($("#login-pw").val().trim().length == 0){
      $("#login-pw").addClass("null-input-border");
    }

    if($("#login-id").val().trim().length > 0 && $("#login-pw").val().trim().length > 0){
      $.ajax({
        url : "/rence/backoffice_loginOK",
        type : "POST",
        dataType : 'json',
        data : {
          backoffice_id : $("#login-id").val().trim(),
          backoffice_pw : CryptoJS.SHA256($("#login-pw").val().trim()).toString()
        },
        success : function(res) {
          // 로그인 성공
          if(res.result == 1){
              //INPUT 초기화
              $("#login-id").val("");
              $("#login-pw").val("");

              $("#login-id").removeClass("null-input-border");
              $("#login-pw").removeClass("null-input-border");

              // 팝업 관련창 닫음
              $('.popup-background:eq(0)').addClass('blind');
              $('#login-section').addClass('blind');

              location.href = '/rence/backoffice_main?backoffice_no=' + $.cookie("backoffice_no");
          }else{
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("로그인에 실패하였습니다.");
          }
      },
      error : function(error) {
          console.log(error);
          $(".popup-background:eq(1)").removeClass("blind");
          $("#common-alert-popup").removeClass("blind");
          $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
        }
      });
    }
  });
    
  /** 비밀번호 찾기 버튼 클릭 */
  $("#go-find-pw").click(function(){
    $('#login-section').addClass('blind');
    $("#find-pw-section").removeClass("blind");
  });

  /** 로그인 팝업 창닫기 */
  $("#host-login-close").click(function(){
    //INPUT 초기화
    $("#login-id").val("");
    $("#login-pw").val("");

    $("#login-id").removeClass("null-input-border");
    $("#login-pw").removeClass("null-input-border");

    // 팝업 관련창 닫음
    $('.popup-background:eq(0)').addClass('blind');
    $('#login-section').addClass('blind');
  });


  /********************************* */
  /******** 비밀번호 찾기 팝업 ********/
  /********************************* */
  // 비밀번호 찾기 인풋 클릭 시 경고 테두리 제거
  $(".find-popup-input").click(function(){
    if($(this).hasClass("null-input-border")){
        $(this).removeClass("null-input-border");
    }
  });

  // 비밀번호 창닫기 버튼
  $("#find-pw-close").click(function(){
    $(".popup-background:eq(0)").addClass("blind");
    $("#find-pw-section").addClass("blind");
  });

  //비밀번호 찾기 버튼
  $("#find-pw-btn").click(function(){
    if($("#find-pw-email").val().trim().length == 0){
      $("#find-pw-email").addClass("null-input-border");
    }
    if($("#find-pw-backoffice-code").val().trim().length == 0){
      $("#find-pw-backoffice-code").addClass("null-input-border");
    }

    if($("#find-pw-email").val().trim().length > 0 && $("#find-pw-backoffice-code").val().trim().length > 0){
      $.ajax({
        url : "/rence/backoffice_reset_pw",
        type : "GET",
        dataType : 'json',
        data : {
          backoffice_id : $("#find-pw-backoffice-code").val().trim(),
          backoffice_email : $("#find-pw-email").val().trim()
        },
        success : function(res) {
          // 비밀번호찾기 성공
          if(res.result == 1){
              //INPUT 초기화
              $("#find-pw-email").val("");
              $("#find-pw-backoffice-code").val("");

              $("#find-pw-email").removeClass("null-input-border");
              $("#find-pw-backoffice-code").removeClass("null-input-border");

              // 팝업 관련창 닫음
              $(".popup-background:eq(0)").addClass("blind");
              $("#find-pw-section").addClass("blind");

              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("이메일로 비밀번호를 발송해드렸어요!");
          }else{
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("해당 정보로 가입된 호스트가 없습니다.");
          }
      },
      error : function() {
          $(".popup-background:eq(1)").removeClass("blind");
          $("#common-alert-popup").removeClass("blind");
          $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
        }
      });
    }
  });


  
  /********************************* */
  /***********로그아웃 팝업 ********* */
  /********************************* */
  $("#logout-btn").click(function(){
    location.href="/rence/backoffice_logout";
  });
  $("#logout-closeBtn").click(function(){
    $('.popup-background:eq(0)').removeClass('blind');
    $('#logout-popup').removeClass('blind');
  });



  $('#join-btn').click(function(){
    $('.popup-background:eq(0)').addClass('blind');
    $('#join-section').addClass('blind');
  });

  $('#success-alert-btn').click(function(){
    $('.popup-background:eq(0)').addClass('blind');
    $('#success-alert-popup').addClass('blind');
  });
  $('#fail-alert-btn').click(function(){
    $('.popup-background:eq(0)').addClass('blind');
    $('#fail-alert-popup').addClass('blind');
  });

  $('#logout-closeBtn').click(function(){
    $('#logout-popup').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  });

  $('#btn-room-add').click(function(){
    $('#room-insert-section').removeClass('blind');
    $('.popup-background').removeClass('blind');
  });

  $('#btn-insert-cancel').click(function(){
    $('.room_type').val('');
    $('#room-insert-section').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  });

  /****** ********* *****/
  /****** 공간 수정 *****/
  /****** ********* *****/

  // 수정 버튼 클릭 -> 수정 팝업 오픈
  $('.btn-room-edit').on('click', function(){
    $.ajax({
      url:"/rence/backoffice_update_room",
        type : "POST",
        dataType : 'json',
        data : {
          backoffice_no : $.cookie("backoffice_no"),
          room_no : $(this).attr("idx")
        },
        success : function(res) {
          $('.popup-background:eq(0)').removeClass('blind');
          $('#room-edit-section').removeClass('blind');
          $("#btn-edit").attr("idx", $(this).attr("idx"));

          $('#m-edit_room_type').val(res.rmvo.room_type);
          $("#m-input-room-name").val(res.rmvo.room_name);
          $("#m-input-price-name").val(res.rmvo.room_price);
          $("#m-edit-room-type-label").val(res.rmvo.room_type);

          for(var i = 0; i < res.room_type.length; i++){
            var sample = $(".edit-type-select-item:eq(0)").clone();
            sample.removeClass("blind");
            
            if(res.room_type[i] == 'desk') sample.text("데스크");
            else if(res.room_type[i] == 'meet_04') sample.text("미팅룸(4인)");
            else if(res.room_type[i] == 'meet_06') sample.text("미팅룸(6인)");
            else if(res.room_type[i] == 'meet_10') sample.text("미팅룸(10인)");
            else if(res.room_type[i] == 'office') sample.text("오피스");

            $(".edit-type-select-list").append(sample);
          }
        },
        error : function(error) {
          $(".popup-background:eq(1)").removeClass("blind");
          $("#common-alert-popup").removeClass("blind");
          $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
        }
    });
  });

  // 수정 팝업 닫기 버튼 -> 수정 팝업 닫음
  $('#btn-edit-cancel').click(function(){
    // input 초기화
    $('#m-edit_room_type').val('');
    $("#m-input-room-name").val('');
    $("#m-input-price-name").val("");
    $("#m-edit-room-type-label").val('타입을 선택해주세요.');

    // 경고 테두리 초기화
    $("#m-input-room-name").removeClass("null-input-border");
    $("#m-input-price-name").removeClass("null-input-border");
    $("#m-room-type-select").removeClass("null-input-border");

    $('#room-edit-section').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  });

  // 인풋 창 클릭 시 경고 테두리 초기화
  $('.room-input').click(function(){
    $(this).removeClass("null-input-border");
  });

  // 공간 가격 정규표현식 사용
  $("#m-input-price-name").on("keyup keydown", function(){
    let check = /^[0-9]+$/;

    if(!check.test($("#m-input-price-name").val().trim())){
      $(this).siblings(".r-input-warning").removeClass("blind");
    }else{
      $(this).siblings(".r-input-warning").addClass("blind");
    }
  });
  
  // 수정 팝업 - 공간 타입 선택 버튼 클릭
  $('#m-edit-room-type-label').on('click', function(){
    $("#m-room-type-select").removeClass("null-input-border");
    $('.edit-type-select-list').toggleClass('blind');
  });

  // 수정 팝업 - 공간 타입 선택 후 처리
  $('.edit-type-select-item').on('click', function(){
    let type = $(this).text();
    $('#m-edit_room_type').val(type);
    $('#m-edit-room-type-label').text(type);
    $('#m-edit-room-type-label').css('color', '#000000');
    $('.edit-type-select-list').addClass('blind');
  });

  // 변경 버튼 클릭 -> 변경 로직
  $('#btn-edit').click(function(){
    // 입력값 not null인지 확인
    if($("#m-input-room-name").val().trim().length > 0 && $("#m-input-price-name").val().trim().length > 0 && $('#m-edit_room_type').val().length > 0){
      $.ajax({
        url:"/rence/backoffice_auth",
          type : "GET",
          dataType : 'json',
          data : {
            backoffice_email : $("#backoffice_email").val().trim()
          },
          success : function(res) {
              // 이메일 중복 성공
              if(res.result == 1){
                  $("#btn-certification").prop("check", true);
                  $("#btn-certification").val("인증완료");
                  $("#backoffice_email").attr("readonly", true);
                  $("#backoffice_email").addClass("readOnly");

                  $(".popup-background:eq(1)").removeClass("blind");
                  $("#common-alert-popup").removeClass("blind");
                  $(".common-alert-txt").text("이메일로 인증번호를 발송하였습니다.");
              }else{
                  $(".popup-background:eq(1)").removeClass("blind");
                  $("#common-alert-popup").removeClass("blind");
                  $(".common-alert-txt").text("이미 존재하는 이메일입니다.");
              }
          },
          error : function(error) {
              console.log(error);
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
          }
      });

      // input 초기화
      $('#m-edit_room_type').val('');
      $("#m-input-room-name").val('');
      $("#m-input-price-name").val("");
      $("#m-edit-room-type-label").val('타입을 선택해주세요.');

      // 경고 테두리 초기화
      $("#m-input-room-name").removeClass("null-input-border");
      $("#m-input-price-name").removeClass("null-input-border");
      $("#m-room-type-select").removeClass("null-input-border");

      $('#room-edit-section').addClass('blind');
      $('.popup-background:eq(0)').addClass('blind');
    }else{
      if($("#m-input-room-name").val().trim().length == 0){
        $("#m-input-room-name").addClass("null-input-border");
      }
      if($("#m-input-price-name").val().trim().length == 0){
        $("#m-input-price-name").addClass("null-input-border");
      }
      if($('#m-edit_room_type').val().length == 0){
        $("#m-room-type-select").addClass("null-input-border");
      }
    }
  });


  /****** ********* *****/
  /****** 공간 삭제 *****/
  /****** ********* *****/
  // 삭제 버튼 클릭 -> 삭제 팝업 오픈
  $('.btn-room-delete').on('click', function(){
    $('.popup-background:eq(0)').removeClass('blind');
    $('#delete-popup').removeClass('blind');
  });

  $('#insert-room-type-label').on('click', function(){
    $('.insert-type-select-list').toggleClass('blind');
  });

  $('.insert-type-select-item').on('click', function(){
    let type = $(this).text();
    $('.room_type').val(type);
    $('#insert-room-type-label').text(type);
    $('#insert-room-type-label').css('color', '#000000');
    $('.insert-type-select-list').addClass('blind');
  });

  // 리뷰 답글 작성
  $('.review-add').on('click', function(){
    $('#comment-section').removeClass('blind');
    $('.popup-background:eq(0)').removeClass('blind');
  });

  $('.btn-comment-cancel').on('click', function(){
    $('#comment-section').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  });

  /** *********************** **/ 
  /** 환경 설정 부분 팝업 관련 **/ 
  /** *********************** **/ 
  $('#btn-update-pw').on('click', function(){
    $('#popup-update-pw').removeClass('blind');
    $('.popup-background:eq(0)').removeClass('blind');
  });

  $('#btn-popup-close').on('click', function(){
    $('#popup-update-pw').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  });

  $('#btn-host-delete').on('click', function(){
    $('#host-delete-popup').removeClass('blind');
    $('.popup-background:eq(0)').removeClass('blind');
  });

  $('#delete-closeBtn').on('click', function(){
    $('#host-delete-popup').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  });

  /** 삭제 요청 버튼 **/
  $("#delete-host-btn").on('click', function(){
    $.ajax({
      url : "/rence/backoffice_setting_delete",
      type : "POST",
      dataType : 'json',
      data : {
        backoffice_no : $.cookie("backoffice_no")
      },
      success : function(res) {
          // 호스트 삭제 성공
          if(res.result == 1){
            $(".popup-background:eq(0)").removeClass("blind");
            $("#common-alert-popup").removeClass("blind");
            $(".common-alert-txt").text("마스터에게 삭제 요청되었습니다.");
          }else{
            $(".popup-background:eq(0)").removeClass("blind");
            $("#common-alert-popup").removeClass("blind");
            $(".common-alert-txt").text("남은 예약이 존재하여 삭제할 수 없습니다.");
          }
      },
      error : function() {
          $(".popup-background:eq(1)").removeClass("blind");
          $("#common-alert-popup").removeClass("blind");
          $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
      }
    });
  });

  /** 호스트 로그아웃 요청 버튼 -> 팝업 띄우기 **/
  $('#btn-host-logout').on("click" ,function(){
    $('.popup-background:eq(0)').removeClass('blind');
    $('#logout-popup').removeClass('blind');
  });


  /** 비밀번호 변경 팝업 닫기 버튼*/
  $("#btn-popup-close").on("click",function(){
    $(".input-check-pw").removeClass("null-input-border");
    $(".input-check-pw").val("");
  });

  /** 현재 비밀번호 일치 여부 확인 버튼*/
  $("#btn-popup-confirm").on("click",function(){
    if($(".input-check-pw").val().trim().length > 0){
      $.ajax({
        url : "/rence/backoffice_update_pw",
        type : "GET",
        dataType : 'json',
        data : {
          backoffice_no : $.cookie("backoffice_no"),
          backoffice_pw : CryptoJS.SHA256($(".input-check-pw").val().trim()).toString()
        },
        success : function(res) {
            // 현재 비밀번호 일치 성공
            if(res.result == 1){
              location.href="/rence/backoffice_setting_pw?backoffice_no=" + window.btoa($.cookie("backoffice_no"));
            }else if(res.result == 0){
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("일치하지않는 비밀번호입니다.");

              $(".input-check-pw").removeClass("null-input-border");
              $(".input-check-pw").val("");
            }
        },
        error : function() {
            $(".popup-background:eq(1)").removeClass("blind");
            $("#common-alert-popup").removeClass("blind");
            $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
        }
      });
    }else{
      $(".input-check-pw").addClass("null-input-border");
    }
  });

});