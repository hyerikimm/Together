<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/together/resources/css/common/font.css">
<link rel="stylesheet" href="/together/resources/css/common/header.css">
<!-- fontawesome icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" 
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" 
crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Alert 창  -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<title>Insert title here</title>

</head>
<body>
	<div class="headerMain-div">
		
		<a href="${pageContext.request.contextPath}"><img src="/together/resources/images/logo.png" class="logoImage"></a>
		<div class="navBar">
			<div class="navText">
				<i class="fa-brands fa-pagelines fa-2xl" style="font-weight:100; color:white;"></i>
				<a href="#" class="">메리크리스마스</a>
				<a href="#" class="">포트폴리오</a>
				<a href="${pageContext.request.contextPath}/board/boardList" class="">방명록</a>
			</div>
			<div class="login">
				<a href="${pageContext.request.contextPath}/member/loginForm" class="">로그인</a>
				<a href="#" class="">회원가입</a>
			</div>
		</div>
	
	</div>

</body>
</html>