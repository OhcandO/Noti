<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- 기본 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>


	<!-- 이모티콘 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css"
		integrity="sha384-i1LQnF23gykqWXg6jxC2ZbCbUMxyw5gLZY6UiUS98LYV5unm8GWmfkIS6jqJfb4E" crossorigin="anonymous">

	<!-- css -->
	<link rel="stylesheet" href="../resources/css/style.css">
	<link rel="stylesheet" href="../resources/css/base.css">
	<link rel="stylesheet" href="../resources/css/loginsty.css">

	<title>Noti 로그인페이지</title>
	<style>
		/* Make the image fully responsive */
	</style>

</head>
<script>
	window.onload = function(){
		document.getElementById('Submit').onclick = check;	
	}
	
	function check(){
		if(document.form.login_id.value==""){
			alert("ID를 입력하세요.")
			document.form.login_id.focus();
			return false;
		}
		
		if(document.form.login_pass.value==""){
			alert("패스워드를 입력하세요.")
			document.form.login_pass.focus();
			return false;
		}
		
		document.form.submit();//전송
		
	}
	
	
</script>
<body>
<%@ include file="../base/top.jsp"%>
<div class="log-bgc">
	<div class="container login-x">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-4 log_bg shadow">
				
			</div>
			<div class="col-lg-6 login-r col-12 log-bgc-w shadow px-5">
				<form name="form" action="login.do" method="post">
					<div class="login-w">
						<div class="font-size-12 font-weight-600 font-sty-1 main-font-color">
							Welcome to Noti
						</div>
						<div class="font-size-08 main-font-color2 font-weight-600 mt-2 font-sty-2">
							사이트에 접속하기 위해서 사용자 인증 절차가 필요합니다.
						</div>
						<div class="pt-4 mt-4">
							<label for="exampleFormControlInput1" class="form-label font-size-08 font-sty-1 main-font-color">ID</label>
							<input type="text" name="login_id" class="form-control border-radius-0 w-100 font-sty-2 plh-f" autofocus="autofocus" id="" placeholder="ID를 입력해 주세요">
	
							<label for="exampleFormControlInput1" class="form-label font-size-08 mt-3 font-sty-1 main-font-color">Password</label>
							<input type="password" name="login_pass" class="form-control border-radius-0 font-sty-2 plh-f" id="" placeholder="PW를 입력해 주세요">
							<div class="text-center mt-4">
								<button type="button" name="Submit" id="Submit" class="btn btn-secondary border-radius-0 w-50 mt-3 btn-bg font-weight-600 font-sty-1 border-0 shadow-sm">LOGIN</button>
							</div>
						</div>
	
						<div class="font-size-08 mt-4 w-100 font-sty-2">
							<table class="w-100">
								<tr>
									<td class="main-font-color2 font-weight-600">
										회원이 아니시라면 ?
									</td>
									<td>
										<button type="button" onclick="location.href='userJoin.do'" class="btn font-size-08 font-weight-600 main-font-color">회원가입</button>									
									</td>
									<td class="main-font-color2 font-weight-600">
										아이디/비밀번호를 잊었다면?
									</td>
									<td>
										<button type="button" class="btn font-size-08 font-weight-600 main-font-color">아이디찾기</button>										
									</td>
								</tr>
								<tr>
									
								</tr>
							</table>
						</div>
					</div>
				</form>
			</div>		
			<div class="col-lg-2"></div>
		</div>
	</div>
</div>


</body>
</html>

















