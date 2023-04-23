/**
game.js
*/
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
	
	//필터링검색 버튼 클릭시 실행할 function 등록
	$('#filterButton').on('click', function(){
		let form = $('#filterForm');
		form.attr('method', 'get');
		form.attr('action', 'store');
		form.submit();
	});
	/**********************************************************************************/
	
	/********************************store-product.html********************************/
	//카트 담기 - 로그인한 경우
	$('#addCartLogin').on('click', function() {
		//alert('login cart');
		let form = $('#hiddenForm');
		form.attr('method', 'post');
		form.attr('action', 'insert-cart');
		form.submit();
		
	});
	
	//카트 담기 - 로그아웃한 경우
	$('#addCartLogout').on('click', function() {
		$('#signin').click();
	});
	
	//위시리스트 담기 - 로그인한 경우
	$('#addWishlistLogin').on('click', function() {
		//alert('login wishlist');
		let form = $('#hiddenForm');
		form.attr('method', 'post');
		form.attr('action', 'insert-wishlist');
		form.submit();
		
	});
	
	//위시리스트 담기 - 로그아웃한 경우
	$('#addWishlistLogout').on('click', function() {
		$('#signin').click();
	});
	
	//라이브러리에 있는 경우
	$('#isExistedLibraryC').on('click', function() {
		//프로필 - 게임탭으로 이동
	});
	$('#isExistedLibraryW').on('click', function() {
		//프로필 - 게임탭으로 이동
	});
	
	//카트에 이미 담겨있는 경우
	$('#isExistedCart').on('click', function() {
		//카트로 이동
	});
	
	//위시리스트에 이미 담겨있는 경우
	$('#isExistedWishlist').on('click', function() {
		//프로필 - 위시리스트탭으로 이동
	});
	/**********************************************************************************/
});