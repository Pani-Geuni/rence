$(function(){
    $(".logo-mku").click(function(){
        location.href="/rence/backoffice_landing";
    });

    $("#before_hostMenu").click(function(){
        $("#before_login>.custom-select-host").toggleClass("blind");
    });
    $("#after_hostMenu").click(function(){
        $("#after_login>.custom-select-host").toggleClass("blind");
    });

    $("#go-login").click(function(){
        $("#before_login>.custom-select-host").addClass("blind");
        $(".popup-background:eq(0)").removeClass("blind");
        $("#login-section").removeClass("blind");
    });
    
    $("#go-user-home").click(function(){
    	location.href="/rence/";
    });

    $("#go-myPage").click(function(){
        $("#after_login>.custom-select-host").addClass("blind");
        location.href="/rence/go_my_page";
    });
    
    $("#go-logOut").click(function(){
        $("#after_login>.custom-select-host").addClass("blind");
        $("#logout-popup").removeClass("blind");
        $(".popup-background:eq(0)").removeClass("blind");
    });
});