/**
* @author : 김예은
*/
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
    // 공용 알러트 창 닫기버튼
    $("#common-alert-btn").click(function(){
        $(".popup-background:eq(1)").addClass("blind");
        $("#common-alert-popup").addClass("blind");
    });

    //로그인 버튼 클릭
    $("#login-btn").click(function(){
        //로그인 시도
        if($("#login-id").val().trim().length > 0 && $("#login-pw").val().trim().length > 0){
            $.ajax({
                url : "/rence/user_loginOK",
                type : "POST",
                dataType : 'json',
                data : {
                    user_id : $("#login-id").val().trim(),
                    user_pw : $("#login-pw").val().trim()
                },
                success : function(res) {
                    console.log(res);
                    // 로그인 성공
                    if(res.result == 1){
                        //INPUT 초기화
                        $("#login-id").val("");
                        $("#login-pw").val("");
    
                        $("#login-id").removeClass("null-input-border");
                        $("#login-pw").removeClass("null-input-border");
    
                        // 팝업 관련창 닫음
                        $("#login-section").addClass("blind");
                        $(".popup-background:eq(0)").addClass("blind");

                        location.href="/rence/";
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
        // 로그인 실패
        else{
            if($("#login-id").val().trim().length == 0){
                console.log($("#login-id"));
                $("#login-id").addClass("null-input-border");
            }
            if($("#login-pw").val().trim().length == 0){
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
        //INPUT 초기화
        $("#login-id").val("");
        $("#login-pw").val("");

        $("#login-id").removeClass("null-input-border");
        $("#login-pw").removeClass("null-input-border");

        // 팝업 관련창 닫음
        $("#login-section").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");
    });

    
    /*********** 아이디 찾기 팝업 ************/
    $("#find-id-close").click(function(){
        //INPUT 초기화
        $("#find-id-email").val("");

        $("#find-id-email").removeClass("null-input-border");

        // 팝업 관련창 닫음
        $("#find-id-section").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");
    });
    $("#find-id-btn").click(function(){
        if($("#find-id-email").val().trim().length > 0){
            $.ajax({
                url : "/rence/find_id",
                type : "POST",
                dataType : 'json',
                data : {
                    user_email : $("#find-id-email").val().trim()
                },
                success : function(res) {
                    console.log(res);
                    // 아이디 찾기 성공
                    if(res.result == 1){
                        //INPUT 초기화
                        $("#find-id-email").val("");

                        $("#find-id-email").removeClass("null-input-border");

                        // 팝업 관련창 닫음
                        $("#find-id-section").addClass("blind");
                        $(".popup-background:eq(0)").addClass("blind");

                        // 성공 알림창
                        $(".popup-background:eq(1)").removeClass("blind");
                        $("#common-alert-popup").removeClass("blind");
                        $(".common-alert-txt").text("이메일로 아이디를 발송해드렸어요!");
                    }
                    // 아이디 찾기 실패
                    else{
                        $(".popup-background:eq(1)").removeClass("blind");
                        $("#common-alert-popup").removeClass("blind");
                        $(".common-alert-txt").text("이메일 발송에 실패하였습니다.");
                    }
                },
                error : function(error) {
                    console.log(error);
                    $(".popup-background:eq(1)").removeClass("blind");
                    $("#common-alert-popup").removeClass("blind");
                    $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
                }
            });
        }else{
            $("#find-id-email").addClass("null-input-border");
        }
    });
    
    $(".find-popup-input").click(function(){
        if($(this).hasClass("null-input-border")){
            $(this).removeClass("null-input-border");
        }
    });
    
    /*********** 비밀번호 찾기 팝업 ************/
    $("#find-pw-close").click(function(){
        //INPUT 초기화
        $("#find-pw-email").val("");
        $("#find-pw-id").val("");

        $("#find-pw-email").removeClass("null-input-border");
        $("#find-pw-id").removeClass("null-input-border");

        // 팝업 관련창 닫음
        $("#find-pw-section").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");
    });
    $("#find-pw-btn").click(function(){
        if($("#find-pw-email").val().trim().length > 0 && $("#find-pw-id").val().trim().length > 0){
            $.ajax({
                url : "/rence/find_pw",
                type : "POST",
                dataType : 'json',
                data : {
                    user_email : $("#find-pw-email").val().trim(),
                    user_id : $("#find-pw-id").val().trim()
                },
                success : function(res) {
                    console.log(res);
                    // 비밀번호 찾기 성공
                    if(res.result == 1){
                        //INPUT 초기화
                        $("#find-pw-email").val("");
                        $("#find-pw-id").val("");

                        $("#find-pw-email").removeClass("null-input-border");
                        $("#find-pw-id").removeClass("null-input-border");

                        // 팝업 관련창 닫음
                        $("#find-pw-section").addClass("blind");
                        $(".popup-background:eq(0)").addClass("blind");

                        // 성공 알림창
                        $(".popup-background:eq(1)").removeClass("blind");
                        $("#common-alert-popup").removeClass("blind");
                        $(".common-alert-txt").text("이메일로 비밀번호를 발송해드렸어요!");
                    }
                    // 아이디 찾기 실패
                    else{
                        $(".popup-background:eq(1)").removeClass("blind");
                        $("#common-alert-popup").removeClass("blind");
                        $(".common-alert-txt").text("이메일 발송에 실패하였습니다.");
                    }
                },
                error : function(error) {
                    console.log(error);
                    $(".popup-background:eq(1)").removeClass("blind");
                    $("#common-alert-popup").removeClass("blind");
                    $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
                }
            });
        }else{
            if($("#find-pw-email").val().trim().length == 0){
                $("#find-pw-email").addClass("null-input-border");
            }
            if($("#find-pw-id").val().trim().length == 0){
                $("#find-pw-id").addClass("null-input-border");
            }
        }
    });
    

    /*********** 회원가입 팝업 ************/
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

    
    /*********** 로그아웃 팝업 ************/
    // 로그아웃 창닫기 버튼 클릭 이벤트
    $("#logout-closeBtn").click(function(){
        $("#logout-popup").addClass("blind");
        $(".popup-background:eq(0)").addClass("blind");
    });
    $("#logout-btn").click(function(){
        location.href="/rence/user_logoutOK";
    });

});