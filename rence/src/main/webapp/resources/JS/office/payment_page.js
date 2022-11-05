/**
 * @author 전판근
 */
 
$(function() {
	
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
		let my_mileage = $("#my-mileage").attr("my-mileage");	// 내가 가진 마일리지
		let use_mileage = $("#use-mileage").val();				// 사용할 마일리지 
		
		// 가진 마일리지보다 많이 사용할 때
		// 마일리지 잠시 홀드
		/* if (use_mileage > my_mileage) {
			
			$("#use-mileage").val("");
			actual_payment = payment_all;
			$("#payment_all").text(actual_payment);
			
		} else if (use_mileage <= my_mileage) {
			// 가진 마일리지보다 적게 사용할 때
			console.log("use_mileage :: ", use_mileage);
			console.log("my_mileage :: ", my_mileage);
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
			
		$("#payment_all").attr("payment_all", actual_payment); */
	});
})