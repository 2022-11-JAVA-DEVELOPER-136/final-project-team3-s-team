/**
user.js
*/
	function userCreate() {
    		if (document.upForm.uId.value == "") {
    			alert("사용자 아이디를 입력하세요.");
    			upForm.uId.focus();
    			return false;
    		}
    	    /*
    	    if (!isIdChecked) {
    	        alert("아이디 중복 확인 버튼을 클릭해주세요.");
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
    		if (document.upForm.uName.value == "") {
    			alert("이름을 입력하세요.");
    			upForm.uName.focus();
    			return false;
    		}
    		
    		if (document.upForm.uPhone.value == "") {
    			alert("휴대폰 번호를 입력하세요.");
    			upForm.uPhone.focus();
    			return false;
    		}
    		if (document.upForm.uEmail.value == "") {
    			alert("이메일 주소를 입력하세요.");
    			upForm.uEmail.focus();
    			return false;
    		}
    		if (document.upForm.uPassword.value != document.upForm.uPassword2.value) {
    			alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
    			upForm.uPassword.focus();
    			upForm.uPassword.select();
    			return false;
    		}
    		document.upForm.action = "user_write_action";
    		document.upForm.method='POST';
    		document.upForm.submit();
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

		document.f.action ="user_login_action";
		document.f.method='POST';
		document.f.submit();
		
		
	}
	
	
	if($("#uChk").text() != "") {
		$("#userLogin").modal('show');
	} else if($("#fChk").text() != "") {
		$("#userLogin").modal('show');
	}
	
	if($("#checked").text() != "") {
		$("#userWrite").modal('show');
	}
	
