/**
user.js
*/
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

    		/*if (!regEmail.test(document.upForm.uEmail.value)) {
				alert("이메일형식을 맞춰주세요.");
				return false;
			}*/ 		
    		
    		
    		/*document.upForm.action = "user_write_action";
    		document.upForm.method='POST';
    		document.upForm.submit();*/
    		
			$.ajax({
				url : "/final-project-team3-s-team/user_write_action",
				type : "post",
				data : $("#upForm").serialize(),
				success : function(resData){
					// resDs에 응답 html 담겨있음
					// 가입성공
					if($(resData).find("#succYn").val() == "Y") {
						$("#userWrite").modal('hide');						// 모달 닫기
						location.href = "/final-project-team3-s-team/main";	// main으로 이동
					// 가입실패
					} else {
						if($(resData).find("#checked").text() != null || $(resData).find("#checked").text() != "") {
							// 실패 메시지 존재시 뿌려줌
							$("#checked").text($(resData).find("#checked").text());
						}
					}
				},
				error: function(errorThrown) {
					console.log(errorThrown);
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


		$.ajax({
			url : "/final-project-team3-s-team/user_login_action",
			type : "post",
			data : $("#f").serialize(),
			success : function(resData){
				// resDs에 응답 html 담겨있음
				// 로그인 성공
				console.log($(resData).find("#loginSuccYn").val());
				if($(resData).find("#loginSuccYn").val() == "Y") {
					$("#userLogin").modal('hide');						// 모달 닫기
					//location.href = "/final-project-team3-s-team/main";	// main으로 이동
				//location.reload();
					//$("#relogin").load("/final-project-team3-s-team/store #relogin2 > *");
					//$("#relogin").load("/final-project-team3-s-team/store-product #relogin2 > *");
					//$("#relogin").load("/final-project-team3-s-team/main #relogin2 > *");
				if (window.location.pathname === "/final-project-team3-s-team/store") {
  $("#relogin").load("/final-project-team3-s-team/store #relogin2 > *");
} else if (window.location.pathname === "/final-project-team3-s-team/store-product") {
  $("#relogin").load("/final-project-team3-s-team/store-product #relogin2 > *");
} else if (window.location.pathname === "/final-project-team3-s-team/main") {
  $("#relogin").load("/final-project-team3-s-team/main #relogin2 > *");
} else if (window.location.pathname === "/final-project-team3-s-team/news-article") {
  $("#relogin").load("/final-project-team3-s-team/news-article #relogin2 > *");
} else if (window.location.pathname === "/final-project-team3-s-team/private-messaging") {
  $("#relogin").load("/final-project-team3-s-team/private-messaging #relogin2 > *");
} 

				// 로그인 실패
				} else {
					if($(resData).find("#uChk").text() != null || $(resData).find("#uChk").text() != "") {
						// 실패 메시지 존재시 뿌려줌
						$("#uChk").text($(resData).find("#uChk").text());
					} 
					
					if($(resData).find("#fChk").text() != null || $(resData).find("#fChk").text() != "") {
						// 실패 메시지 존재시 뿌려줌
						$("#fChk").text($(resData).find("#fChk").text());
					}
				}
			},
			error: function(errorThrown) {
				console.log(errorThrown);
			}
		});
		
		
	}

	
	var clickYn = false;
	
	$("#infoChangeBtn").click(function(){
	
		$.ajax({
			url : "/final-project-team3-s-team/user_modify_action",
			type : "post",
			data : $("#updtForm").serialize(),
			success : function(resData){
				// resDs에 응답 html 담겨있음
				// 성공
				if($(resData).find("#succYn").val() == "Y") {
					alert("수정되었습니다.");
					$("#uName").val($(resData).find("#uName").val());
					$("#uEmail").val($(resData).find("#uEmail").val());
					$("#uPhone").val($(resData).find("#uPhone").val());
					$("#uNickname").val($(resData).find("#uNickname").val());
					//location.href = "/final-project-team3-s-team/profile";	// profile으로 이동
					
				// 실패
				} else {
					
				}
			},
			error: function(errorThrown) {
				console.log(errorThrown);
			}
		});
		
	});