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
	let payment_total = $("#payment_all").attr("payment_total");
	let earned_mileage = $("#earned_mileage").attr("earned_mileage");
	
	let deposit = $("#payment_all").attr("payment_total") * 0.2;
	let deposit_earned_mileage = deposit * 0.05;
	
	$(".inner-radio:eq(0)").click(function() {
		$(".inner-radio:eq(0)").addClass("choice-radio");
		$(".inner-radio:eq(1)").removeClass("choice-radio");
		
		$("#payment_all").text(payment_total);
		$("#earned_mileage").text(earned_mileage);
	});
	
	$(".inner-radio:eq(1)").click(function() {
		$(".inner-radio:eq(0)").removeClass("choice-radio");
		$(".inner-radio:eq(1)").addClass("choice-radio");
		
		$("#payment_all").text(deposit);
		$("#earned_mileage").text(deposit_earned_mileage);
	});
	
})