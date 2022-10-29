$(function() {
			
	// ****************************************
	// Dash Board Side Menu 현재 페이지 active 설정
	// ****************************************
	
	$('#menu-home').removeClass('active');
	$('#menu-space').removeClass('active');
	$('#menu-reserve').removeClass('active');
	$('#menu-sales').removeClass('active');
	$('#menu-settings').removeClass('active');
	
	
	// backoffice_home 일 때
	if ($(location).attr('pathname') === '/rence/backoffice_home') {	
		$('#menu-home').addClass('active');
	} else if($(location).attr('pathname') === '/rence/backoffice_list') {	
		// backoffice_list 일 때
		$('#menu-space').addClass('active');
	} 
})