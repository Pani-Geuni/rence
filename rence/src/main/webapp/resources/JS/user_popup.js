$(function(){
    //인풋 창 클릭 시 NULL을 알렸던 CSS제거 처리
    $(".login-popup-input").click(function(){
        if($(this).hasClass("null-input-border")){
            $(this).removeClass("null-input-border");
        }
    });

    /*********************************/ 
    /******* 버튼 클릭 이벤트 *********/ 
    /*********************************/ 
    //로그인 버튼 클릭
    $("#login-btn").click(function(){
        //로그인 시도
        if($("#login-id").val().length > 0 && $("#login-pw").val().length > 0){
        	console.log("in");
            $.ajax({
                url : "/rence/user_loginOK",
                type : "POST",
                dataType : 'json',
                data : {
                    user_id : $("#login-id").val(),
                    user_pw : $("#login-pw").val()
                },
                success : function(res) {
                    console.log(res.result);
                    $("#login-section").addClass("blind");
                    $(".popup-background:eq(0)").addClass("blind");
                },
                error : function(error) {
                    console.log(error);
                }
            });
        }
        // 로그인 실패
        else{
            if($("#login-id").val().length == 0){
                console.log($("#login-id"));
                $("#login-id").addClass("null-input-border");
            }
            if($("#login-pw").val().length == 0){
                $("#login-pw").addClass("null-input-border");
            }
        }
    });
    //아이디 찾기 버튼 클릭 이벤트
    $("#go-find-id").click(function(){
        $("#login-section").addClass("blind");
        $("#find-id-section").removeClass("blind");
    });
    //비밀번호 찾기 버튼 클릭 이벤트
    $("#go-find-pw").click(function(){
        $("#login-section").addClass("blind");
        $("#find-pw-section").removeClass("blind");
    });
    //창닫기 찾기 버튼 클릭 이벤트
    $(".login-close").click(function(){
        $("#login-section").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");
    });


    //아이디 찾기 팝업
    $("#find-id-close").click(function(){
        $("#find-id-section").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");

    });

    //비밀번호 찾기 팝업
    $("#find-pw-close").click(function(){
        $("#find-pw-section").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");

    });

    //회원가입 버튼 클릭
    $("#join-btn").click(function(){
        $("#join-section").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");
    });

    // 팝업 알러트 버튼 클릭 이벤트
    $("#success-alert-btn").click(function(){
        $(".popup-background").addClass("blind");
        $("#success-alert-popup").addClass("blind");
    });
    $("#fail-alert-btn").click(function(){
        $(".popup-background:eq(1)").addClass("blind");
        $("#fail-alert-popup").addClass("blind");
    });

    // 로그아웃 창닫기 버튼 클릭 이벤트
    $("#logout-closeBtn").click(function(){
        $("#logout-popup").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");
    });

});