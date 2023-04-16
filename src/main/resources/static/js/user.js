/**
user.js
*/
	function userCreate() {
		location.href="user-write";
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
	
