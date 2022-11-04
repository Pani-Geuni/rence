/**
 * @author 전판근
 */
 
$(function() {
	
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
})