/**
* @author 김예은
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

    $("#go-myPage").click(function(){
        $("#after_login>.custom-select-user").addClass("blind");
        location.href="/rence/go_my_page";
    });
    $("#go-logOut").click(function(){
        $("#after_login>.custom-select-user").addClass("blind");
        $("#logout-popup").removeClass("blind");
        $(".popup-background:eq(0)").removeClass("blind");
    });

    $("#go-backOffice").click(function(){
        location.href="/rence/backoffice_landing";
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
                    load_city(city);
                },
                error : function(err) {
                    console.log(err);
                }
            });
        }
        
        if($("#custom-location-select").hasClass("blind")){
            $("#custom-location-select").removeClass("blind");
        }else{
            $("#custom-location-select").addClass("blind");
            $("#location-town").addClass("blind");
        }
    });
    $("#location-city").on('click', '.location-select-list', function(){
        $("#location-town").removeClass("blind");

        let idx = $(this).prop("idx");
        town = cityObject.filter(function(v){
            if(v.city == idx) return true;
        })[0].arr.slice();

        console.log(town);
        load_town(town);
    });
    $("#location-town").on('click', '.location-select-list', function(){
        let idx = $(this).prop("idx");

        $("#location_val").text(idx);
        $("#location_val").prop("idx", idx);

        $("#location-town").addClass("blind");
        $("#custom-location-select").addClass("blind");
    });


    /**********************************/
    /*********FUNCTION SECTION*********/
    /**********************************/
    function load_city(city){
        for(var i = 0; i < city.length; i++){
            let sample = $("#location-city>.location-select-list.sample").clone();
            sample.removeClass("sample blind");
            sample.text(city[i]);
            sample.prop("idx", city[i]);

            $("#location-city").append(sample);
        }
    }
    function load_town(town){
        let setting = $("#location-town>.location-select-list.sample").clone();
        $("#location-town").empty().append(setting);

        for(var i = 0; i < town.length; i++){
            let sample = $("#location-town>.location-select-list.sample").clone();
            sample.removeClass("sample blind");
            sample.text(town[i]);
            sample.prop("idx", town[i]);

            $("#location-town").append(sample);
        }
    }
});