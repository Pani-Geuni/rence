/**
* @author : 전판근, 김예은
*/
$(function () {
  /** 공용 알러트 창닫기 버튼 */ 
  $("#common-alert-btn").click(function(){
    $(".popup-background:eq(1)").addClass("blind");
    $("#common-alert-popup").addClass("blind");

    if($(".common-alert-txt").text() == "수정이 완료되었습니다." || $(".common-alert-txt").text() == "공간이 추가되었습니다."){
      location.reload();
    }
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

  /****** ********* *****/
  /****** 공간 추가 *****/
  /****** ********* *****/
  // 추가 버튼 클릭 -> 추가 팝업창 SHOW
  $('#btn-room-add').click(function(){
    $.ajax({
      url:"/rence/backoffice_insert_room",
        type : "GET",
        dataType : 'json',
        data : {
          backoffice_no : $.cookie("backoffice_no")
        },
        success : function(res) {
          $('.popup-background:eq(0)').removeClass('blind');
          $('#room-insert-section').removeClass('blind');
          
          for(var i = 0; i < res.room_type.length; i++){
            var sample = $(".insert-type-select-item:eq(0)").clone();
            sample.removeClass("blind");
            sample.attr("type", res.room_type[i]);

            if(res.room_type[i] == 'desk') sample.text("데스크");
            else if(res.room_type[i] == 'meeting_04') sample.text("미팅룸(4인)");
            else if(res.room_type[i] == 'meeting_06') sample.text("미팅룸(6인)");
            else if(res.room_type[i] == 'meeting_10') sample.text("미팅룸(10인)");
            else if(res.room_type[i] == 'office') sample.text("오피스");

            if(res.room_type[i] == "office"){
              $(".room-input-wrap:eq(2)").removeClass("blind");
            }
            else{
              if(!$(".room-input-wrap:eq(2)").hasClass("blind")) 
                $(".room-input-wrap:eq(2)").addClass("blind");
            }

            $(".insert-type-select-list").append(sample);
          }
        },
        error : function() {
          $(".popup-background:eq(1)").removeClass("blind");
          $("#common-alert-popup").removeClass("blind");
          $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
        }
    });
  });

  $('#insert-room-type-label').on('click', function(){
    $('.insert-type-select-list').toggleClass('blind');
  });

  $('.insert-type-select-item').on('click', function(){
    let type = $(this).text();

    if(type == '데스크') $('.room_type').val("desk");
    else if(type == '미팅룸(4인)') $('.room_type').val("meeting_04");
    else if(type == '미팅룸(6인)') $('.room_type').val("meeting_06");
    else if(type == '미팅룸(10인)') $('.room_type').val("meeting_10");
    else if(type == '오피스') $('.room_type').val("office");

    if(type == "오피스"){
      $(".room-input-wrap:eq(2)").removeClass("blind");
    }else{
      $(".room-input-wrap:eq(2)").addClass("blind");
    }

    $('#insert-room-type-label').text(type);
    $('#insert-room-type-label').css('color', '#000000');
    $('.insert-type-select-list').addClass('blind');
  });

   // 공간 가격 정규표현식 사용
   $("#input-price-name").on("keyup keydown", function(){
    let check = /^[0-9]+$/;

    if(!check.test($("#input-price-name").val().trim())){
      $(this).siblings(".r-input-warning:eq(0)").removeClass("blind");
    }else{
      $(this).siblings(".r-input-warning:eq(0)").addClass("blind");
    }
  });

  // 닫기 버튼 클릭 -> 추가 팝업창 HIDE
  $('#btn-insert-cancel').click(function(){
    $('#edit_room_type').val('');
    $("#input-room-name").val('');
    $("#input-price-name").val('');
    $("#insert-room-type-label").val('타입을 선택해주세요.');

    $(".r-input-warning:eq(0)").addClass("blind");

    // 경고 테두리 초기화
    $("#input-room-name").removeClass("null-input-border");
    $("#input-price-name").removeClass("null-input-border");
    $("#room-type-select").removeClass("null-input-border");

    var sample = $(".insert-type-select-item:eq(0)").clone();
    $(".insert-type-select-list").empty().append(sample);

    $('.insert-type-select-list').addClass('blind');
    $('#room-insert-section').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  });

  // 추가 버튼 클릭 -> 추가 로직
  $('#btn-insert').click(function(){
    // 입력값 not null인지 확인
    if($("#input-room-name").val().trim().length > 0 && $("#input-price-name").val().trim().length > 0 && $('#edit_room_type').val().length > 0){
      $.ajax({
        url:"/rence/backoffice_insertOK_room",
          type : "POST",
          dataType : 'json',
          data : {
            backoffice_no : $.cookie("backoffice_no"),
            room_name : $("#input-room-name").val().trim(),
            room_type : $('#edit_room_type').val(),
            room_price : $("#input-price-name").val().trim()
          },
          success : function(res) {
              // 변경 성공
              if(res.result == 1){
                  // input 초기화
                  $('#edit_room_type').val('');
                  $("#input-room-name").val('');
                  $("#input-price-name").val("");
                  $("#edit-room-type-label").val('타입을 선택해주세요.');

                  // 경고 테두리 초기화
                  $("#input-room-name").removeClass("null-input-border");
                  $("#input-price-name").removeClass("null-input-border");
                  $("#room-type-select").removeClass("null-input-border");

                  $('.popup-background:eq(0)').addClass('blind');
                  $('#room-insert-section').addClass('blind');

                  var sample = $(".insert-type-select-item:eq(0)").clone();
                  $(".insert-type-select-list").empty().append(sample);

                  $(".popup-background:eq(1)").removeClass("blind");
                  $("#common-alert-popup").removeClass("blind");
                  $(".common-alert-txt").text("공간이 추가되었습니다.");
              }else{
                  $(".popup-background:eq(1)").removeClass("blind");
                  $("#common-alert-popup").removeClass("blind");
                  $(".common-alert-txt").text("수정에 실패하였습니다.");
              }
          },
          error : function() {
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
          }
      });
    }else{
      if($("#input-room-name").val().trim().length == 0){
        $("#input-room-name").addClass("null-input-border");
      }
      if($("#input-price-name").val().trim().length == 0){
        $("#input-price-name").addClass("null-input-border");
      }
      if($('#edit_room_type').val().length == 0){
        $("#room-type-select").addClass("null-input-border");
      }
    }
  });



  /****** ********* *****/
  /****** 공간 수정 *****/
  /****** ********* *****/

  // 수정 버튼 클릭 -> 수정 팝업 오픈
  $('.btn-room-edit').on('click', function(){
    $.ajax({
      url:"/rence/backoffice_update_room",
        type : "GET",
        dataType : 'json',
        data : {
          backoffice_no : $.cookie("backoffice_no"),
          room_no : $(this).attr("idx")
        },
        success : function(res) {
          console.log(res);
          $('.popup-background:eq(0)').removeClass('blind');
          $('#room-edit-section').removeClass('blind');
          $("#btn-edit").attr("idx", res.rmvo.room_no);

          $('#m-edit_room_type').val(res.rmvo.room_type);
          $("#m-input-room-name").val(res.rmvo.room_name);
          $("#m-input-price-name").val(res.rmvo.room_price);

          var typeName = "";
          if(res.rmvo.room_type == 'desk') typeName = "데스크";
          else if(res.rmvo.room_type == 'meeting_04') typeName = "미팅룸(4인)";
          else if(res.rmvo.room_type == 'meeting_06') typeName = "미팅룸(6인)";
          else if(res.rmvo.room_type == 'meeting_10') typeName = "미팅룸(10인)";
          else if(res.rmvo.room_type == 'office') typeName = "오피스";

          if(typeName == "오피스"){
            $(".room-input-wrap:eq(5)").removeClass("blind");
          }else{
            $(".room-input-wrap:eq(5)").addClass("blind");
          }

          $("#m-edit-room-type-label").val(res.rmvo.room_type);
          $("#m-edit-room-type-label").text(typeName);

          for(var i = 0; i < res.room_type.length; i++){
            var sample = $(".edit-type-select-item:eq(0)").clone();
            sample.removeClass("blind");
            sample.attr("type", res.room_type[i]);
            console.log(res.room_type[i])

            if(res.room_type[i] == 'desk') sample.text("데스크");
            else if(res.room_type[i] == 'meeting_04') sample.text("미팅룸(4인)");
            else if(res.room_type[i] == 'meeting_06') sample.text("미팅룸(6인)");
            else if(res.room_type[i] == 'meeting_10') sample.text("미팅룸(10인)");
            else if(res.room_type[i] == 'office') sample.text("오피스");

            $(".edit-type-select-list").append(sample);
          }
        },
        error : function() {
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

    var sample = $(".edit-type-select-item:eq(0)").clone();
    $(".edit-type-select-list").empty().append(sample);

    $(".r-input-warning:eq(1)").addClass("blind");

    $('.edit-type-select-list').addClass('blind');
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
      $(this).siblings(".r-input-warning:eq(1)").removeClass("blind");
    }else{
      $(this).siblings(".r-input-warning:eq(1)").addClass("blind");
    }
  });
  
  // 수정 팝업 - 공간 타입 선택 버튼 클릭
  $('#m-edit-room-type-label').on('click', function(){
    $("#m-room-type-select").removeClass("null-input-border");
    $('.edit-type-select-list').toggleClass('blind');
  });

  // 수정 팝업 - 공간 타입 선택 후 처리
  $('.edit-type-select-list').on('click', '.edit-type-select-item', function(){
    let type = $(this).text();

    if(type == '데스크') $('#m-edit_room_type').val("desk");
    else if(type == '미팅룸(4인)') $('#m-edit_room_type').val("meeting_04");
    else if(type == '미팅룸(6인)') $('#m-edit_room_type').val("meeting_06");
    else if(type == '미팅룸(10인)') $('#m-edit_room_type').val("meeting_10");
    else if(type == '오피스') $('#m-edit_room_type').val("office");

    if(type == "오피스"){
      $(".room-input-wrap:eq(5)").removeClass("blind");
    }else{
      $(".room-input-wrap:eq(5)").addClass("blind");
    }

    $('#m-edit-room-type-label').text(type);
    $('#m-edit-room-type-label').css('color', '#000000');
    $('.edit-type-select-list').addClass('blind');
  });

  // 변경 버튼 클릭 -> 변경 로직
  $('#btn-edit').click(function(){
    // 입력값 not null인지 확인
    if($("#m-input-room-name").val().trim().length > 0 && $("#m-input-price-name").val().trim().length > 0 && $('#m-edit_room_type').val().length > 0){
      $.ajax({
        url:"/rence/backoffice_updateOK_room",
          type : "POST",
          dataType : 'json',
          data : {
            backoffice_no : $.cookie("backoffice_no"),
            room_no : $(this).attr("idx"),
            room_name : $("#m-input-room-name").val().trim(),
            room_type : $('#m-edit_room_type').val(),
            room_price : $("#m-input-price-name").val().trim()
          },
          success : function(res) {
              // 변경 성공
              if(res.result == 1){
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

                  var sample = $(".edit-type-select-item:eq(0)").clone();
                  $(".edit-type-select-list").empty().append(sample);

                  $(".popup-background:eq(1)").removeClass("blind");
                  $("#common-alert-popup").removeClass("blind");
                  $(".common-alert-txt").text("수정이 완료되었습니다.");
              }else{
                  $(".popup-background:eq(1)").removeClass("blind");
                  $("#common-alert-popup").removeClass("blind");
                  $(".common-alert-txt").text("수정에 실패하였습니다.");
              }
          },
          error : function() {
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
          }
      });
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
    $('#host-delete-popup').removeClass('blind');
    $("#delete-host-btn").attr("idx", $(this).attr("idx"));
  });

  // 공간 삭제 버튼 클릭 -> 삭제 로직 처리
  $("#delete-host-btn").click(function(){
    $.ajax({
      url:"/rence/backoffice_deleteOK_room",
        type : "POST",
        dataType : 'json',
        data : {
          backoffice_no : $.cookie("backoffice_no"),
          room_no : $(this).attr("idx")
        },
        success : function(res) {
          $('.popup-background:eq(0)').addClass('blind');
          $('#host-delete-popup').addClass('blind');
          $("#delete-host-btn").attr("idx", "");

          // 삭제 성공
          if(res.result == 1){
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("삭제가 완료되었습니다.");
          }else{
              $(".popup-background:eq(1)").removeClass("blind");
              $("#common-alert-popup").removeClass("blind");
              $(".common-alert-txt").text("삭제에 실패하였습니다.");
          }
        },
        error : function() {
            $(".popup-background:eq(1)").removeClass("blind");
            $("#common-alert-popup").removeClass("blind");
            $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
        }
    });
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
  $("#host-delete").on('click', function(){
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