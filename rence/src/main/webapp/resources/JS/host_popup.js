$(function () {
  $('#login-btn').click(function () {
    $('#login-section').addClass('blind')
    $('.popup-background:eq(0)').addClass('blind')
  })
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
  
})
