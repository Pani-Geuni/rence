$(function() {
			
	// ****************************************
	// Dash Board Side Menu 현재 페이지 active 설정
	// ****************************************
	
	console.log($(location).attr('pathname'))
	// backoffice_home 일 때
	if ($(location).attr('pathname') === '/rence/backoffice_home') {	
		$('#menu-home').addClass('active');
		
	} else if ($(location).attr('pathname') === ('/rence/backoffice_list' || '/rence/backoffice_qna' || '/rence/backoffice_review')) {	
		// backoffice_list, backoffice_qna, backoffice_review 일 때
		$('#menu-space').addClass('active');
		
	} else if ($(location).attr('pathname') === '/rence/backoffice_reserve') {	
		// backoffice_reserve 일 때
		$('#menu-reserve').addClass('active');

	} else if ($(location).attr('pathname') === '/rence/backoffice_day_sales' || '/rence/backoffice_week_sales' || '/rence/backoffice_month_sales') {
		// backoffice_day_sales, backoffice_week_sales, backoffice_month_sales 일 때
		console.log('fuck')
		console.log($(location).attr('pathname'))
		$('#menu-sales').addClass('active');
		
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
	
	$('#menu-sales').click(function() {
		location.href="/rence/backoffice_day_sales";
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
	
	// ****************
	// 정산 관리 mini-nav
	// ****************
	if ($(location).attr('pathname') === '/rence/backoffice_day_sales') {
		$('#sales-mini-nav-day').addClass('active');
	} else if ($(location).attr('pathname') === '/rence/backoffice_week_sales') {
		$('#sales-mini-nav-week').addClass('active');
	} else if ($(location).attr('pathname') === '/rence/backoffice_month_sales') {
		$('#sales-mini-nav-month').addClass('active');
	}
	
	$('#sales-mini-nav-day').click(function() {
		location.href="/rence/backoffice_day_sales";
	})
	
	$('#sales-mini-nav-week').click(function() {
		location.href="/rence/backoffice_week_sales";
	})
	
	$('#sales-mini-nav-month').click(function() {
		location.href="/rence/backoffice_month_sales";
	})
	
})