$(function() {
			
	// ****************************************
	// Dash Board Side Menu 현재 페이지 active 설정
	// ****************************************

	
	// backoffice_home 일 때
	if ($(location).attr('pathname') === '/rence/backoffice_home') {	
		$('#menu-home').addClass('active');
	} else if($(location).attr('pathname') === '/rence/backoffice_list' || '/rence/backoffice_qna') {	
		// backoffice_list 일 때
		$('#menu-space').addClass('active');
	}
	
	$('#menu-home').click(function() {
		location.href="/rence/backoffice_home";
	})
	
	$('#menu-space').click(function() {
		location.href="/rence/backoffice_list";
	})
	
	
	// ****************
	// 공간 관리 mini-nav
	// ****************
	if ($(location).attr('pathname') === '/rence/backoffice_list') {
		$('#mini-nav-list').addClass('active');
	} else if ($(location).attr('pathname') === '/rence/backoffice_qna') {
		$('#mini-nav-qna').addClass('active');
	}
	
	$('#mini-nav-list').click(function() {
		location.href="/rence/backoffice_list";
	})
	
	$('#mini-nav-qna').click(function() {
		location.href="/rence/backoffice_qna";
	})
})