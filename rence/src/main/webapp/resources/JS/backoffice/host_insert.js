/**
* @author : 전판근
*/

// ******************
// 호스트 신청에 필요한 JS
// ******************

$(function () {
  // TIME PICKER
  $('.time-picker').timepicker({
    timeFormat: 'HH:mm',
    interval: 60,
    defaultTime: '09',
    dynamic: false,
    dropdown: true,
    scrollbar: true,
  });

  // multi checkbox
  var chk_option_arr = new Array();
  var nearby_option_arr = new Array();
  
  $('#submit-application').click(function () {
  
  	// space option check
    $('input[name=option]:checked').each(function (event) {
      chk_option_arr.push($(this).val());
    });

    $('#options').val(chk_option_arr);

	// space nearby place check
    $('input[name=nearby-option]:checked').each(function (event) {
      nearby_option_arr.push($(this).val());
    });

    $('#nearby-options').val(nearby_option_arr);
  });
});
