<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/together/resources/css/common/font.css">
<!-- fontawesome icon -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" 
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" 
crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Alert 창  -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<title>Insert title here</title>
<style>
	body{
	    font-family: 'S-CoreDream-3Light';
	    padding: 0px;
	    margin: 0px;
	}
	.headerMain-div{
		width: 100%;
	    height: 300px;
	    background-color: #f4f5f9;
	    position: sticky; /*fixed랑 비슷하게 자리 고정*/
	    top:0;
	   	z-index:1;
	   
	}
	.logoImage{
		width:800px;
		margin:auto;
		position:absolute;
		left:25%;
		top:10%;
	}
	.navBar{
		margin:auto;
		position:absolute;
		background-color: #5A9367;
		width: 100%;
		height: 100px;
		top:100%;
	}
	.navText{
		margin:35px 50px;
		padding-left: 33%;
		
	}
	.navText > a{
		color:white;
		font-weight:600;
		font-size:20px;
		text-decoration-line :none;
		padding:20px;
		
	}
	.navText > a:hover{
		text-decoration: underline #a6172d dotted 5px ;
	}
	

</style>
</head>
<body>
	<div class="headerMain-div">
		<img src="/together/resources/images/logo.png" class="logoImage">
		<div class="navBar">
			<div class="navText">
				<i class="fa-brands fa-pagelines fa-2xl" style="font-weight:100; color:white;"></i>
				<a href="#" class="">메리크리스마스</a>
				<a href="#" class="">포트폴리오</a>
				<a href="#" class="">방명록</a>
			</div>
		</div>
	
	</div>

</body>
</html>