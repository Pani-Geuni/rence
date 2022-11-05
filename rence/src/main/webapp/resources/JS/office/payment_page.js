/**
 * @author 전판근
 */
 
$(function() {
 	var IMP = window.IMP;
 	IMP.init("TC0ONETIME");
	
	// ****************
	// 가격에 ,(콤마) 붙이기
	// ****************
	$('.room_price').each(function (index, value) {
		let price = $(value).text();

    	$(this).text(price.replace(/\B(?=(\d{3})+(?!\d))/g, ','));
	});
	
	$('#payment_all').text(
	    $('#payment_all')
	      .text()
	      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
	);
	
	$('#earned_mileage').text(
	    $('#earned_mileage')
	      .text()
	      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
	);
	
	$('#my-mileage').text(
	    $('#my-mileage')
	      .text()
	      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
	);
	
	// *******************
	// custom-radio action
	// *******************
	let payment_all = $("#payment_all").attr("payment_all");
	let earned_mileage = $("#earned_mileage").attr("earned_mileage");
	
	let deposit = payment_all * 0.2;
	let deposit_earned_mileage = deposit * 0.05;

	// *****
	// 선결제	
	// *****
	$(".inner-radio:eq(0)").click(function() {
		$(".inner-radio:eq(0)").addClass("choice-radio");
		$(".inner-radio:eq(1)").removeClass("choice-radio");
		
		$("#payment_all").text(payment_all);
		$("#earned_mileage").text(earned_mileage);
		
		$('#payment_all').text(
	    $('#payment_all')
	      .text()
	      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
		);
		
		$('#earned_mileage').text(
		    $('#earned_mileage')
		      .text()
		      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
		);
		
		$("#payment_all").attr("payment_all", payment_all);
		$("#earned_mileage").attr("earned_mileage", earned_mileage);
	});
	
	// *******
	// 후불 결제
	// *******
	$(".inner-radio:eq(1)").click(function() {
		$(".inner-radio:eq(0)").removeClass("choice-radio");
		$(".inner-radio:eq(1)").addClass("choice-radio");
		
		$("#payment_all").text(deposit);
		$("#earned_mileage").text(deposit_earned_mileage);
		
		$('#payment_all').text(
	    $('#payment_all')
	      .text()
	      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
		);
		
		$('#earned_mileage').text(
		    $('#earned_mileage')
		      .text()
		      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
		);
		
		$("#payment_all").attr("payment_all", deposit);
		$("#earned_mileage").attr("earned_mileage", deposit_earned_mileage);
	});
	
	// *************
	// 나의 사용 마일리지
	// *************
	$("#use-mileage:text[numberOnly]").on("keyup", function() {
		$(this).val($(this).val().replace(/[^0-9]/g, ""));
	});
	
	$(".use-mileage-btn").click(function() {
		let actual_payment = payment_all;
		let my_mileage = $("#my-mileage").attr("my-mileage");
		let use_mileage = $("#use-mileage").val();
		
		// 가진 마일리지보다 많이 사용할 때
		if (use_mileage > my_mileage) {
			
			$("#use-mileage").val("");
			actual_payment = payment_all;
			$("#payment_all").text(actual_payment);
			
		} else {
			// 가진 마일리지보다 적게 사용할 때
		
			if (use_mileage == 0 || use_mileage == "") {
				actual_payment = payment_all;
			} else {
				actual_payment = payment_all - use_mileage;
			}
			
			$("#payment_all").text(actual_payment);
			
		}
		$('#payment_all').text(
			$('#payment_all')
		      .text()
		      .replace(/\B(?=(\d{3})+(?!\d))/g, ',')
		);
			
		$("#payment_all").attr("payment_all", actual_payment);
	});
	
	
	$(".pay-btn").click(function() {
		IMP.request_pay({ // param
          	pg : 'kakaopay',
		    pay_method : 'card', //생략 가능
		    merchant_uid: "order_no_0001", // 상점에서 관리하는 주문 번호
		    name : '주문명:결제테스트',
		    amount : 14000,
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울특별시 강남구 삼성동',
		    buyer_postcode : '123-456'
      }, function (rsp) { // callback
      if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
        // jQuery로 HTTP 요청
        jQuery.ajax({
            url: "{서버의 결제 정보를 받는 endpoint}", // 예: https://www.myservice.com/payments/complete
            method: "POST",
            headers: { "Content-Type": "application/json" },
            data: {
                imp_uid: rsp.imp_uid,
                merchant_uid: rsp.merchant_uid
            }
        }).done(function (data) {
          // 가맹점 서버 결제 API 성공시 로직
        })
      } else {
        alert("결제에 실패하였습니다. 에러 내용: " +  rsp.error_msg);
      }
    });
	});
})