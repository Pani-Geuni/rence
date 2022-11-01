/**
* @author : 전판근
*/

$(function () {

  // HOST LOGIN 관련 팝업 JS
  $('#login-btn').click(function () {
    $('#login-section').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  })
  $('#join-btn').click(function () {
    $('#join-section').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  })

  $('#success-alert-btn').click(function () {
    $('.popup-background').addClass('blind');
    $('#success-alert-popup').addClass('blind');
  })
  $('#fail-alert-btn').click(function () {
    $('.popup-background').addClass('blind');
    $('#fail-alert-popup').addClass('blind');
  })

  $('#logout-closeBtn').click(function () {
    $('#logout-popup').addClass('blind');
    $('.popup-background:eq(0)').addClass('blind');
  })
  
  // 비밀번호 찾기 버튼 클릭
  $('#go-find-pw').click(function () {
    //INPUT 초기화
    $("#login-id").val("");
    $("#login-pw").val("");

    $("#login-id").removeClass("null-input-border");
    $("#login-pw").removeClass("null-input-border");

    // 팝업 관련창 닫음
    $("#login-section").addClass("blind");
    
    $("#find-pw-section").removeClass("blind");
    
    // $(".popup-background:eq(0)").addClass("blind");
  })
  
  //창닫기 찾기 버튼 클릭 이벤트
  $(".login-close").click(function(){
      //INPUT 초기화
      $("#login-id").val("");
      $("#login-pw").val("");

      $("#login-id").removeClass("null-input-border");
      $("#login-pw").removeClass("null-input-border");

      // 팝업 관련창 닫음
      $("#login-section").addClass("blind");
      $(".popup-background:eq(0)").addClass("blind");
  });
  
  $(".find-pw-close").click(function () {
  	  //INPUT 초기화
      $("#find-pw-email").val("");
      $("#find-guide-text").val("");

      $("#find-pw-email").removeClass("null-input-border");
      $("#find-guide-text").removeClass("null-input-border");

      // 팝업 관련창 닫음
      $("#find-pw-section").addClass("blind");
      $(".popup-background:eq(0)").addClass("blind");
  })
  
  // Dash Board 팝업 JS
  $('#btn-room-add').click(function () {
    $('#room-insert-section').removeClass('blind');
    $('.popup-background').removeClass('blind');
  })

  $('#btn-insert-cancel').click(function () {
    $('#room-insert-section').addClass('blind');
    $('.popup-background').addClass('blind');
  })

  $('#btn-edit-cancel').click(function () {
    $('#room-edit-section').addClass('blind');
    $('.popup-background').addClass('blind');
  })

  $('.btn-room-edit').on('click', function () {
    $('#room-edit-section').removeClass('blind');
    $('.popup-background').removeClass('blind');
  })

  $('.btn-room-delete').on('click', function () {
    $('#host-delete-popup').removeClass('blind');
    $('.popup-background').removeClass('blind');
  })

  $('#insert-room-type-label').on('click', function () {
    $('.insert-type-select-list').toggleClass('blind');
  })

  $('#edit-room-type-label').on('click', function () {
    $('.edit-type-select-list').toggleClass('blind');
  })

  $('.insert-type-select-item').on('click', function () {
    let type = $(this).text();
    
    $('#insert-room-type-label').text(type);
    $('#insert-room-type-label').css('color', '#000000');
    $('.insert-type-select-list').addClass('blind');
  })

  $('.edit-type-select-item').on('click', function () {
    let type = $(this).text();
    $('#edit-room-type-label').text(type);
    $('#edit-room-type-label').css('color', '#000000');
    $('.edit-type-select-list').addClass('blind');
  })

  // 리뷰 답글 작성
  $('.review-add').on('click', function () {
    $('#comment-section').removeClass('blind');
    $('.popup-background').removeClass('blind');
  })

  $('.btn-comment-cancel').on('click', function () {
    $('#comment-section').addClass('blind');
    $('.popup-background').addClass('blind');
  })

  // 환경 설정 부분 팝업 관련
  $('#btn-update-pw').on('click', function () {
    $('#popup-update-pw').removeClass('blind');
    $('.popup-background').removeClass('blind');
  })

  $('#btn-popup-close').on('click', function () {
    $('#popup-update-pw').addClass('blind');
    $('.popup-background').addClass('blind');
  })

  $('#btn-host-delete').on('click', function () {
    $('#host-delete-popup').removeClass('blind');
    $('.popup-background').removeClass('blind');
  })

  $('#delete-closeBtn').on('click', function () {
    $('#host-delete-popup').addClass('blind');
    $('.popup-background').addClass('blind');
  })
  
})
