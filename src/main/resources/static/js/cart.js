/**
cart.js
*/
$(function(){
	
	//카트페이지에서 휴지통 버튼 클릭시 delete-cart로 POST방식으로 요청
	$('.ti-trash').on('click', function(e){
		let form = $('#hiddenForm');
		form.children("input[name='cNo']").val($(e.target).attr('cno'));
		
		form.attr('method', 'post');
		form.attr('action', 'delete-cart');
		form.submit();
	});
});