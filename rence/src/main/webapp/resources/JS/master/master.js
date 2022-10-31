/**
* @author : 전판근
*/

$(function(){

	// master login
	$("#btn-master-login").click(function () {
	
		console.log("111");
		// 로그인 시도
		// 로그인 성공
		if ($('#master-id').val().trim().length > 0 && $('#master-pw').val().trim().length > 0) {
			console.log("222");
			$.ajax({
				url : "/rence/master_loginOK",
				type : "POST",
				dataType : "json",
				data : {
					master_id : $('#master-id').val().trim(),
					master_pw : CryptoJS.SHA256($('#master-pw').val().trim()).toString()
				},
				
				success : function(res) {
					console.log("success 333");
					console.log(res);
					// 로그인 성공 시
					if (res.result == 1) {
						// INPUT 초기화
						$('#master-id').val("");
						$('#master-pw').val("");
						
						location.href="/rence/master_main";
					} else {
						console.log("success fail 444");
						$('.popup-background').removeClass('blind');
						$('#common-alert-popup').removeClass('blind');
						$(".common-alert-txt").text("로그인에 실패하였습니다.");
					}
				},
				error : function(error) {
					console.log("error fail 555555");
					console.log(error);
					$(".popup-background:eq(1)").removeClass("blind");
                    $("#common-alert-popup").removeClass("blind");
                    $(".common-alert-txt").text("오류 발생으로 인해 처리에 실패하였습니다.");
                }
			});
		}
		
		// 로그인 실패
		else {
			if ($('#master-id').val().trim().length == 0) {
				$("#master-id").addClass("null-input-border");
			}
			
			if ($('#master-pw').val().trim().length == 0) {
				$("#master-pw").addClass("null-input-border");
			}
		}
	});
	
	// Master 로그아웃
	$('#btn-logout').click(function() {
		location.href='/rence/master_logoutOK';
	})


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