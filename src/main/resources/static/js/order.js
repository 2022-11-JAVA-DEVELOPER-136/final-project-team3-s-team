/**
order.js
*/
$(function(){
	//checkout-address페이지의 Billing Details 뜨게 하는 이벤트 등록
	$('#billing_address_1').on('keyup', function(){
		$('#billing_details_street').html($('#billing_address_1').val());
	});
	$('#billing_city').on('keyup', function(){
		$('#billing_details_city').html($('#billing_city').val());
	});
	$('#state').on('click', function(){
		val = $('#billing_details_stateFull option:selected').text($('#state').text());
	});
	$('#billing_postcode').on('keyup', function(){
		$('#billing_details_Zip').html($('#billing_postcode').val());
	});
	$('#billing_phone').on('keyup', function(){
		$('#billing_details_phoneNumber').html($('#billing_phone').val());
	});
	
	//주문완료시 alert 띄우기
	$('#orderBt').on('click', function(){
		alert('주문완료~');
	});
	
	console.log($('#state option'));
});