<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="/together/resources/css/common/font.css">
<link rel="stylesheet" href="/together/resources/css/member/loginForm.css">
<title>login</title>
</head>
<body>
	<div class="headerMain-div">
		<a href="${pageContext.request.contextPath}"><img src="/together/resources/images/logo.png" class="logoImage"></a>
		<div class="loginForm">
			<form id="loginForm" method="post">
				<input type="text" id="userId" name="userId" placeholder="아이디" > <br>
				<p id="userIdAlert" ></p>
				<input type="password" id="userPwd" name="userPwd" placeholder="비밀번호" >
				<button type="submit" id="goUserLogin" onclick="loginProc()">로그인</button>
				<p id="userPwdAlert"></p>
			</form>
			<div></div>
			<div>카카오로 로그인</div>
		</div>
	</div>
</body>
<script>

	$("#goUserLogin").keypress(function(e){
		var code = e.keyCode || e.which;
		if(code == 13){
			loginProc();
		}
	});
	function loginProc(){
		if(!$("#userId").val().trim()){
			$("#userId").focus();
			$("#userIdAlert").addClass("on wrn").text("아이디를 입력하세요.");
			return false;
		}
		$("#userIdAlert").removeClass("on wrn").text("");
	
		if(!$("#userPwd").val().trim()){
			$("#userPwd").focus();
			$("#userPwdAlert").addClass("on wrn").text("비밀번호를 입력하세요");
			return false;
		}
		$("#userPwdAlert").removeClass("on wrn").text("");
	
		$("#userId").val($("#userId").val().trim());	
		$("#userPwd").val($("#userPwd").val().trim());
		location.href='${pageContext.request.contextPath}/member/loginProcess.do';
	}
	
	/*
	$("#goUserLogin").on("click", function () {
		loginProc();
	})
*/
</script>
</html>