/**
 * @author 김예은
 */
$(function() {
  // CUSTOM TYPE SELECT
  $('#type').click(function(){
    $('#custom-type-select').toggleClass('blind');
  });

  $('.type-select-list').click(function(e){
    $('#type>span').text($(this).text());
    $('#custom-type-select').addClass('blind');
  });
});
