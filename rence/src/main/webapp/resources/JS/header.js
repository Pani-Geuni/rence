/**
* @author : 김예은
*/
$(function(){
    let cityObject = [];
    let city = [];
    let town = [];

    $(".logo-mku").click(function(){
        location.href="/rence/";
    });

    $("#before_userMenu").click(function(){
        $("#before_login>.custom-select-user").toggleClass("blind");
    });
    $("#after_userMenu").click(function(){
        $("#after_login>.custom-select-user").toggleClass("blind");
    });

    $("#go-login").click(function(){
        $("#before_login>.custom-select-user").addClass("blind");
        $(".popup-background:eq(0)").removeClass("blind");
        $("#login-section").removeClass("blind");
    });
    $("#go-join").click(function(){
        $("#before_login>.custom-select-user").addClass("blind");
        $(".popup-background:eq(0)").removeClass("blind");
        $("#join-section").removeClass("blind");
    });
    
    $("#go-backOffice").click(function(){
        location.href="/rence/backoffice_landing";
    });

    $("#go-myPage").click(function(){
        $("#after_login>.custom-select-user").addClass("blind");
        location.href="/rence/go_my_page";
    });
    $("#go-logOut").click(function(){
        $("#after_login>.custom-select-user").addClass("blind");
        $("#logout-popup").removeClass("blind");
        $(".popup-background:eq(0)").removeClass("blind");
    });

    // CUSTOM TYPE SELECT
    $("#type").click(function(){
        $("#custom-type-select").toggleClass("blind");
    });
    $(".type-select-list").click(function(e){
        $("#type>span").text($(this).text());
        $("#custom-type-select").addClass("blind");
    });
    
    // CUSTOM LOCATION SELECT
    $("#location").click(function(){
        if(city.length == 0){
            $.ajax({
                url : "../json/city.json",
                dataType : "json",
                success : function(res) {
                    cityObject = res.slice();
                    console.log(cityObject);

                    city = cityObject.map(function(v){
                        if(v.city != null) return v.city;
                    }).slice();
                    
                },
                error : function(err) {
                    console.log(err);
                }
            });
        }
        $("#custom-location-select").toggleClass("blind");
    });

    function load_city(){
        $(".location-select-city-list.sample")
    }
});