/**
 * @author 김예은
 */
$(function() {
  // // CUSTOM TYPE SELECT
  // $('#type').click(function(){
  //   $('#custom-type-select').toggleClass('blind');
  // });

  // $('.type-select-list').click(function(e){
  //   $('#type>span').text($(this).text());
  //   $('#custom-type-select').addClass('blind');
  // });

  $("#input_searchBar").on('keydown', function(e){
    if(e.keyCode == 13){
        if($("#input_searchBar").val().trim().length > 0){
        location.href="/rence/backoffice_search_reserve?backoffice_no=" + $.cookie("backoffice_no") + "&searchword=" + $("#input_searchBar").val().trim();
        }else{
          $(".popup-background:eq(1)").removeClass("blind");
          $("#common-alert-popup").removeClass("blind");
          $(".common-alert-txt").text("검색어를 입력하세요.");
        }
      }
  });
});
