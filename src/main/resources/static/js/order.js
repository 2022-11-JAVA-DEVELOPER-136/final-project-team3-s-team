/**
order.js
*/
$(function(){
	
	//checkout-address페이지의 Billing Details 뜨게 하는 이벤트 등록
	$('#billing_address_1').on('keyup', function(e){
		$('#billing_details_street').html($(e.target).val());
	});
	$('#billing_city').on('keyup', function(e){
		$('#billing_details_city').html($(e.target).val());
	});
	$('#billing_state').on('keyup', function(e){
		$('#billing_details_stateFull').html($(e.target).val());
	});
	$('#billing_postcode').on('keyup', function(e){
		$('#billing_details_Zip').html($(e.target).val());
	});
	$('#billing_phone').on('keyup', function(e){
		$('#billing_details_phoneNumber').html($(e.target).val());
	});
	
	//주문완료시 alert 띄우기
	$('#orderBtn').on('click', function(){
		alert('주문완료!');
		
		let form = $('#hiddenForm');
		form.attr('method', 'post');
		form.attr('action', 'order-insert-action');
		form.submit();
	});
});