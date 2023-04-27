/**
user.js
*/

$(function(){
	/*
	profile.html에서 사용
	
	tab 파라미터가 있는 경우, 해당 탭에 클릭이벤트 발생
	tab=2 --> 게임 탭
	tab=5 --> 위시리스트 탭
	*/
	if(location.href.endsWith('tab=2')) $('#mp-2-02-tab').click();//게임 탭
	if(location.href.endsWith('tab=5')) $('#mp-2-05-tab').click();//위시리스트 탭
});

var pathNm = location.pathname;

$(document).ready(function(){
	// 카드데이터가 존재한다면 "카드등록" 버튼 hide
	if($("#cardSeq").val() != "") {
		$("#cardAddBtn").hide();
	}
	
	// Settings 클릭시에
	$("#mp-2-04-tab").click(function(){
		$("#settingChkDiv").modal("show");
	});
	
	// Setting 비번체크 알림창에서 닫기버튼 클릭시
	$("#closeBtn").click(function(){
		location.reload();
	});
	
	
});

// 삭제버튼 클릭이벤트
function removeAction(param){
	
	var deleteForm = makeForm("deleteform");
	addFormData(deleteForm,"wishNo",param);
	doAction("delete_action", deleteForm, function(resDs){
		
		if($(resDs).find("#rChk").val() == "Y") {
			$('#removeReloadDiv').load(location.href+' #removeReloadDiv');
		} else  {
			alert("오류");
		}
		
	});
	
}

function pwChk() {
	
	if ($("#settingPassword").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#settingPassword").focus();
			return false;
		}
		
	doAction("user_pwChk_action", $("#pwForm"), function(resDs){
		console.log(resDs);
			
			if($(resDs).find("#pwSuccYn").val() == "Y") {
				$("#settingChkDiv").modal('hide');	// 모달닫기
				$("#settingPassword").val("");		// 초기화
				$("#psMsgChk").val("");				// 초기화
				location.href="/final-project-team3-s-team/profile#mp-2-04-c";
			// 로그인 실패
			} else {
				
				if($(resDs).find("#psMsgChk").text() != null || $(resDs).find("#psMsgChk").text() != "") {
					// 실패 메시지 존재시 뿌려줌
					$("#psMsgChk").text($(resDs).find("#psMsgChk").text());
				}
			}
		});
		
}

	function userCreate() {
    		
		/*	 
    		최소 8 자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자
			/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
			
			최소 8 자, 하나 이상의 대문자, 하나의 소문자 및 하나의 숫자
			/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;
			
			최소 8자, 하나의 이상의 대소문자 및 하나의 숫자, 하나의 특수문자
			/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
		*/
		
		// TODO 정규식 패턴
		var regId = /^[a-zA-Z0-9]{4,12}$/;													// ID
		var regPw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;	// PW
		var regName = /^[가-힣a-zA-Z]{2,15}$/;												// 이름
		var regPhone = /^\d{2,3}\d{3,4}\d{4}$/;											// 휴대전화
		var regEmail = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{1,5}$/;	// 이메일
		
		
		if (document.upForm.uId.value == "") {
			alert("사용자 아이디를 입력하세요.");
			upForm.uId.focus();
			return false;
		}
		
		/*if(!regId.test(document.upForm.uId.value)) {
			alert("ID는 4~12자 영문 대소문자, 숫자만 입력하세요.");
			return false;
		}*/
		if (document.upForm.uPassword.value == "") {
			alert("비밀번호를 입력하세요.");
			upForm.uPassword.focus();
			return false;
		}
		if (document.upForm.uPassword2.value == "") {
			alert("비밀번호확인을 입력하세요.");
			upForm.uPassword2.focus();
			return false;
		}
		
		/*if(!regPw.test(document.upForm.uId.value)) {
			alert("최소 8 자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자를 입력하세요.");
			return false;
		}*/
		    		
		if (document.upForm.uPassword.value != document.upForm.uPassword2.value) {
			alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
			upForm.uPassword.focus();
			upForm.uPassword.select();
			return false;
		}
		
		if (document.upForm.uName.value == "") {
			alert("이름을 입력하세요.");
			upForm.uName.focus();
			return false;
		}
		
		/*if (!regName.test(document.upForm.uName.value)) {
			alert("최소 2글자 이상, 한글과 영어만 입력하세요.");
			return false;
		}*/
		
		if (document.upForm.uPhone.value == "") {
			alert("휴대폰 번호를 입력하세요.");
			upForm.uPhone.focus();
			return false;
		}
		
		/*if (!regPhone.test(document.upForm.uPhone.value)) {
			alert("휴대전화번호 형식에 맞춰주세요.");
			return false;
		}*/
		
		if (document.upForm.uEmail.value == "") {
			alert("이메일 주소를 입력하세요.");
			upForm.uEmail.focus();
			return false;
		}

		if (!regEmail.test(document.upForm.uEmail.value)) {
			alert("이메일형식을 맞춰주세요.");
			return false;
		} 		
		
		
		/*document.upForm.action = "user_write_action";
		document.upForm.method='POST';
		document.upForm.submit();*/
		
		
		// 서비스 호출
		doAction("user_write_action", $("#upForm"), function(resDs){
			// 가입성공
			if($(resDs).find("#succYn").val() == "Y") {
				alert("회원가입이 완료되었습니다.");
				$("#userWrite").modal('hide');						// 모달 닫기
				location.href = "/final-project-team3-s-team/main";	// main으로 이동
			// 가입실패
			} else {
				if($(resDs).find("#checked").text() != null || $(resDs).find("#checked").text() != "") {
					// 실패 메시지 존재시 뿌려줌
					$("#checked").text($(resDs).find("#checked").text());
				}
			}
		});
		
	}

	function login() {
		if (document.f.uId.value == "") {
			alert("아이디를 입력하십시오.");
			document.f.uId.focus();
			return false;
		}
		if (document.f.uPassword.value == "") {
			alert("비밀번호를 입력하십시오.");
			document.f.uPassword.focus();
			return false;
		}

		// 서비스 호출
		doAction("user_login_action", $("#f"), function(resDs){
			if($(resDs).find("#loginSuccYn").val() == "Y") {
				// 0.5초 후 리로드
				$("#userLogin").modal('hide');	
				location.reload();
				/*setTimeout(function(){
							$("#userLogin").modal('hide');						// 모달 닫기
							$("#relogin").load(pathNm+" #relogin2 > *");
						}, 500);*/
				
			// 로그인 실패
			} else {
				if($(resDs).find("#uChk").text() != null || $(resDs).find("#uChk").text() != "") {
					// 실패 메시지 존재시 뿌려줌
					$("#uChk").text($(resDs).find("#uChk").text());
				} 
				
				if($(resDs).find("#fChk").text() != null || $(resDs).find("#fChk").text() != "") {
					// 실패 메시지 존재시 뿌려줌
					$("#fChk").text($(resDs).find("#fChk").text());
				}
			}
		});
		
	}

	// 내정보 변경 버튼 클릭
	$("#infoChangeBtn").click(function(){
	
		doAction("user_modify_action", $("#updtForm"), function(resDs){
			if($(resDs).find("#succYn").val() == "Y") {
				alert("수정되었습니다");
				$("#uName").val($(resDs).find("#uName").val());
				$("#uEmail").val($(resDs).find("#uEmail").val());
				$("#uPhone").val($(resDs).find("#uPhone").val());
				$("#uNickname").val($(resDs).find("#uNickname").val());
			} else {
				
			}
		});
		
	});
	
	// 주소 변경 클릭
	$("#addrChangeBtn").click(function(){
	
		doAction("user_modify_action", $("#addrForm"), function(resDs){
			if($(resDs).find("#succYn").val() == "Y") {
				alert("수정되었습니다");
				$("#uName").val($(resDs).find("#uName").val());
				$("#uEmail").val($(resDs).find("#uEmail").val());
				$("#uPhone").val($(resDs).find("#uPhone").val());
				$("#uNickname").val($(resDs).find("#uNickname").val());
			} else {
				
			}
		});		
		
	});
	
		
	// 카드 변경 클릭
	$("#cardChangeBtn").click(function(){
	
		var cardForm = $("#cardForm");
		addFormData(cardForm,"param","U");
		doAction("card_modify_action", cardForm, function(resDs){
			if($(resDs).find("#succYn").val() == "Y") {
				alert("수정처리완료");
				$("#cardName").val($(resDs).find("#cardName").val());
				$("#cardNumber").val($(resDs).find("#cardNumber").val());
				$("#cardExDate").val($(resDs).find("#cardExDate").val());
			} else {
				
			}
		});
		
	});
	
	// 카드 등록 클릭
	$("#cardAddBtn").click(function(){
		
		if ($("#cardName").val() == "") {
			alert("카드이름을 입력하세요.");
			$("#cardName").focus();
			return false;
		}

		if ($("#cardNumber").val() == "") {
			alert("카드번호를 입력하세요.");
			$("#cardNumber").focus();
			return false;
		}
		
		if ($("#cardExDate").val() == "") {
			alert("카드 만료일자를 입력하세요.");
			$("#cardExDate").focus();
			return false;
		}

		
		var cardForm = makeForm("cardForm");
		addFormData(cardForm,"param","I");
		addFormData(cardForm,"cardName",$("#cardName").val());
		addFormData(cardForm,"cardNumber",$("#cardNumber").val());
		addFormData(cardForm,"cardExDate",$("#cardExDate").val());
		
		doAction("card_modify_action", cardForm, function(resDs){
			if($(resDs).find("#succYn").val() == "Y") {
				alert("등록처리완료");
				$("#cardName").val($(resDs).find("#cardName").val());
				$("#cardNumber").val($(resDs).find("#cardNumber").val());
				$("#cardExDate").val($(resDs).find("#cardExDate").val());
				$("#cardSeq").val($(resDs).find("#cardSeq").val());
				$("#cardAddBtn").hide();
			} else {
				alert($(resDs).find("#msg2").val());
			}
		});
	});	
	
	// 카드 삭제 클릭
	$("#cardDelBtn").click(function(){
		
		var cardForm = $("#cardForm");
		addFormData(cardForm,"param","D");	// 구분코드(I:등록 U:수정 D:삭제)
		doAction("card_modify_action", cardForm, function(resDs){
			if($(resDs).find("#succYn").val() == "Y") {
				alert("삭제되었습니다.");
				$("#cardName").val("");
				$("#cardNumber").val("");
				$("#cardExDate").val("");
				$("#cardAddBtn").show();
			} else {
				alert($(resDs).find("#msg1").val());
			}
		});
	});	
	                    
                        

function doAction(serviceCd, srcForm, callbackFunc) {
	var url = '/final-project-team3-s-team/'+serviceCd;
	var data = srcForm.serialize();
	
	$.ajax({
			url : url
			,type : "post"
			,data : srcForm.serialize()
			,success : function(resData){
				callbackFunc(resData);
			}
			,error: function(errorThrown) {
				console.log(errorThrown);
			}
	});
}


function makeForm(formId) {
	var newForm =  $('<form>', {
		 'id' : formId
		,'name' : formId
		,'method' : 'POST'
	});
	return newForm;
}

function addFormData(form, name, value) {
	if (typeof($("input[name="+name+"]", form).val()) == 'undefined') {
		var inputField = $("<input>").attr("type", "hidden").attr("name", name).val(value);	
		$(form).append($(inputField));
	} else {
		$("input[name="+name+"]", form).val(value);
	}
}