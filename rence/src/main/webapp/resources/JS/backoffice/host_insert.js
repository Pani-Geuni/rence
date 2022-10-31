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

  // backoffice_type 필수 입력 체크
  $('#submit-application').click(function () {
  
    var result = true;
  	
  	var desk_checked = $('#type_checkbox_desk').is(':checked');
  	var meeting_room_checked = $('#type_checkbox_meeting_room').is(':checked');
  	var office_checked = $('#type_checkbox_office').is(':checked');
  	
  	if (desk_checked || meeting_room_checked || office_checked) {
  		$('submit-application').submit();
  		result = true;
  	} else {
  		$(".popup-background").removeClass("blind");
  		$("#fail-alert-popup").removeClass("blind");
  		result = false;
  	}
  	
  	return result;
  });
  
  // 빈 항목 팝업 닫기
  $('#empty-fail-alert-btn').click(function () {
  	$("#fail-alert-popup").addClass("blind");
  	$(".popup-background").addClass("blind");
  })
  
});
