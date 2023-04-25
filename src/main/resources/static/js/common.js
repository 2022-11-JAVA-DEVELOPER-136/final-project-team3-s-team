/**
common.js
*/
$(function() {
	$('#offcanvas-cart-logout').on('click', function(e) {
		$('#signin').click();
		e.preventDefault();
	});
});