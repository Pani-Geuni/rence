$(function() {
			
	// ****************************************
	// Dash Board Side Menu 현재 페이지 active 설정
	// ****************************************
	
	
	// backoffice_home 일 때
	if ($(location).attr('pathname') === '/rence/backoffice_home') {	
		$('#menu-home').addClass('active');
		
	} else if ($(location).attr('pathname') === ('/rence/backoffice_list' || '/rence/backoffice_qna' || '/rence/backoffice_review')) {	
		// backoffice_list, backoffice_qna, backoffice_review 일 때
		$('#menu-space').addClass('active');
	} else if ($(location).attr('pathname') === '/rence/backoffice_reserve') {	
		// backoffice_reserve 일 때
		$('#menu-reserve').addClass('active');
		
	} 
	
	$('#menu-home').click(function() {
		location.href="/rence/backoffice_home";
	})
	
	$('#menu-space').click(function() {
		location.href="/rence/backoffice_list";
	})
	
	$('#menu-reserve').click(function() {
		location.href="/rence/backoffice_reserve";
	})
	
	
	// ****************
	// 공간 관리 mini-nav
	// ****************
	if ($(location).attr('pathname') === '/rence/backoffice_list') {
		$('#mini-nav-list').addClass('active');
	} else if ($(location).attr('pathname') === '/rence/backoffice_qna') {
		$('#mini-nav-qna').addClass('active');
	} else if ($(location).attr('pathname') === '/rence/backoffice_review') {
		$('#mini-nav-review').addClass('active');
	}
	
	$('#mini-nav-list').click(function() {
		location.href="/rence/backoffice_list";
	})
	
	$('#mini-nav-qna').click(function() {
		location.href="/rence/backoffice_qna";
	})
	
	$('#mini-nav-review').click(function() {
		location.href="/rence/backoffice_review";
	})
})