/**
main.js
*/
$(function() {
	//카트담기
	$('.item_atc_text').on('click', function(e) {
		let form = $('#hiddenForm');
		if(!form.children('input').val()) $('#signin').click();
		if(form.children('input').val()) {
			form.attr('method', 'post');
			form.attr('action', 'insert-cart');
			form.submit();
		}
		e.preventDefault();
	});
});