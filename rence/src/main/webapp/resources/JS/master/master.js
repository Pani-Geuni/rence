/**
* @author : 전판근
*/

$(function(){

	// master header nav 변경
	switch($(location).attr('pathname')) {
	
		case '/rence/master_main':
			$('#nav-item-agree').addClass('active');
			break;
			
		case '/rence/master_backoffice_end':
			$('#nav-item-delete').addClass('active');
			break;
			
		default:
			break;
	}

	// location.href 작업
	$('.logo-mku').click(function() {
		location.href="/rence/master_main";
	})
	
	$('#nav-item-agree').click(function() {
		location.href="/rence/master_main";
	})
	
	$('#nav-item-delete').click(function() {
		location.href="/rence/master_backoffice_end";
	})
})