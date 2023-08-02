<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/together/resources/css/common/font.css">
<link rel="stylesheet" href="/together/resources/css/member/loginForm.css">
<link rel="stylesheet" href="/together/resources/css/member/joinForm.css">
<title>join</title>
</head>
<body>
	<div class="headerMain-div">
		<a href="${pageContext.request.contextPath}"><img src="/together/resources/images/logo.png" class="logoImage"></a>
	</div>
	<div class="contentWrap">
		<section id="content">
			<ul class="joinForm">
				<h2> 회원가입 </h2>
				<li>
					<label for="userNm" class="label">성명</label>
					<input id="userNm" type="text" value="${resultVO.userNm}">
				</li>
				<li>
					<label for="userId" class="label">아이디</label>
					<input type="text" name="userId" id="userId" />
					<a class="btn pri btnIDCehck jsOn" href="#checkId_content">중복체크</a>
					<span class="inputNoti">영문 &middot; 숫자 조합 6~12자 이내의 아이디를 생성해주세요.</span>
					<span class="inputAlert" id="userIdAlert"></span>
				</li>
				<li>
					<label for="userPwd" class="label">비밀번호</label>
					<input type="password" name="userPwd" id="userPwd" />
					<span class="inputNoti">영문 &middot; 숫자 &middot; 특수문자(&amp; &lt; &gt; "'제외)를 포함하여 8~20자 이내로 구성</span>
					<span class="inputAlert" id="pwdAlert"></span>
				</li>
				<li>
					<label for="reUserPwd" class="label">비밀번호 확인 </label>
					<input type="password" name="reUserPwd" id="reUserPwd" />
					<span class="inputAlert" id="reUserPwdAlert"></span>
				</li>
				<li>
					<label for="mobile" class="label">휴대폰번호</label>
					<input type="text" name="mobile" id="mobile" oninput="phoneNumber(this)" maxlength="13">
					<span class="inputAlert" id="mobileAlert"></span>
				</li>
				<li class="email_wrap">
					<label for="emailId" class="label">이메일 </label>
					<input type="text" name="emailId" id="emailId" />
					<span class="atSign">@</span>
					<input type="text" name="emailDomain" id="emailDomain" title="이메일도메인" />
				</li>
			</ul>
		
			<div class="btnAreaC">
				<button type="button" class="btn pri" id="saveBtn">확인</button>
			</div>

	</section>
	</div>

</body>
<script type="text/javascript" language="javascript">
</script>
</html>