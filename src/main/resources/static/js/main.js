/**
main.js
*/
$(function() {
	
	//카트담기
	$('span.item_atc_text').on('click', function(e) {
		let form = $('#hiddenForm');
		
		//form.children("input[name='uNo']").val()===undefined인 경우 (로그아웃한 경우)
		if(!form.children("input[name='uNo']").val()) $('#signin').click();
		
		//form.children("input[name='uNo']").val()가 해당 유저의 uNo를 갖는 경우 (로그인한 경우)
		if(form.children("input[name='uNo']").val()) {
			console.log(e.target);
			console.log($(e.target).attr('gno'));
			
			form.children("input[name='gNo']").val($(e.target).attr('gno'));
			form.attr('method', 'post');
			form.attr('action', 'insert-cart');
			form.submit();
		}
		e.preventDefault();
	});
});