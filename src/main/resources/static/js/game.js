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
	/************************************store.html************************************/
	//페이지 버튼 클릭시 실행할 function 등록
	$('.page-link').on('click', function(e) {
		//2, 3번 tab이 선택되어 있는 경우, 앵커의 href 마지막에 tab 파라미터 추가.
		if($('#mp-2-02-tab.show').length===1) e.target.href += '&tab=2';
		if($('#mp-2-03-tab.show').length===1) e.target.href += '&tab=3';
	});
	
	//tab 파라미터가 있는 경우, 해당 탭에 클릭이벤트 발생
	if(location.href.endsWith('&tab=2')) $('#mp-2-02-tab').click();
	if(location.href.endsWith('&tab=3')) $('#mp-2-03-tab').click();
	
	//$();
	/**********************************************************************************/
	
	/********************************store-product.html********************************/
	//ADD TO CART버튼 클릭시 해당 게임 카트에 등록
	$('#addCart').on('click', function(e) {
		
	});
	/**********************************************************************************/
});