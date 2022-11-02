/**
* @author : 전판근, 김예은
*/
$(function () {
  // 공용 알러트 창 닫기버튼
  $("#common-alert-btn").click(function(){
    $(".popup-background:eq(1)").addClass("blind");
    $("#common-alert-popup").addClass("blind");
  });

  /******************************* */
  /***********로그인 팝업 ********* */
  /******************************* */
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
                $('.popup-background:eq(0)').removeClass('blind');
                $('#login-section').removeClass('blind');

                location.reload();
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
  $('#join-btn').click(function () {
    $('#join-section').addClass('blind')
    $('.popup-background:eq(0)').addClass('blind')
  })

  $('#success-alert-btn').click(function () {
    $('.popup-background').addClass('blind')
    $('#success-alert-popup').addClass('blind')
  })
  $('#fail-alert-btn').click(function () {
    $('.popup-background:eq(1)').addClass('blind')
    $('#fail-alert-popup').addClass('blind')
  })

  $('#logout-closeBtn').click(function () {
    $('#logout-popup').addClass('blind')
    $('.popup-background:eq(0)').addClass('blind')
  })

  $('#btn-room-add').click(function () {
    $('#room-insert-section').removeClass('blind')
    $('.popup-background').removeClass('blind')
  })

  $('#btn-insert-cancel').click(function () {
    $('.room_type').val('')
    $('#room-insert-section').addClass('blind')
    $('.popup-background').addClass('blind')
  })

  $('#btn-edit-cancel').click(function () {
    $('.room_type').val('')
    $('#room-edit-section').addClass('blind')
    $('.popup-background').addClass('blind')
  })

  $('.btn-room-edit').on('click', function () {
    $('#room-edit-section').removeClass('blind')
    $('.popup-background').removeClass('blind')
  })

  $('.btn-room-delete').on('click', function () {
    $('#delete-popup').removeClass('blind')
    $('.popup-background').removeClass('blind')
  })

  $('#insert-room-type-label').on('click', function () {
    $('.insert-type-select-list').toggleClass('blind')
  })

  $('#edit-room-type-label').on('click', function () {
    $('.edit-type-select-list').toggleClass('blind')
  })

  $('.insert-type-select-item').on('click', function () {
    let type = $(this).text()
    $('.room_type').val(type)
    $('#insert-room-type-label').text(type)
    $('#insert-room-type-label').css('color', '#000000')
    $('.insert-type-select-list').addClass('blind')
  })

  $('.edit-type-select-item').on('click', function () {
    let type = $(this).text()
    $('.room_type').val(type)
    $('#edit-room-type-label').text(type)
    $('#edit-room-type-label').css('color', '#000000')
    $('.edit-type-select-list').addClass('blind')
  })

  // 리뷰 답글 작성
  $('.review-add').on('click', function () {
    $('#comment-section').removeClass('blind')
    $('.popup-background').removeClass('blind')
  })

  $('.btn-comment-cancel').on('click', function () {
    $('#comment-section').addClass('blind')
    $('.popup-background').addClass('blind')
  })

  // 환경 설정 부분 팝업 관련
  $('#btn-update-pw').on('click', function () {
    $('#popup-update-pw').removeClass('blind')
    $('.popup-background').removeClass('blind')
  })

  $('#btn-popup-close').on('click', function () {
    $('#popup-update-pw').addClass('blind')
    $('.popup-background').addClass('blind')
  })

  $('#btn-host-delete').on('click', function () {
    $('#host-delete-popup').removeClass('blind')
    $('.popup-background').removeClass('blind')
  })

  $('#delete-closeBtn').on('click', function () {
    $('#host-delete-popup').addClass('blind')
    $('.popup-background').addClass('blind')
  })
});