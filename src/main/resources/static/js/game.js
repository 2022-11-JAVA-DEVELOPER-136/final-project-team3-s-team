/**
game.js
*/
function filterButton(formId){
	let form = $(formId);
	form.method = 'POST';
	form.action = 'store';
	form.submit();
}

$(function(){
	//alert('game.js');
})