<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 로그인 성공하였습니다.</h3> 
	<hr>
		<p>${login.user_name}님환영합니다.</p>
	<div>
		<button onclick="location.href='${prevPage}'">이전 페이지로 가기</button>
	</div>
	<div>
		<button onclick="location.href='MyPage.do'" >회원 정보 보기</button> 
	</div>
	<div>
		<button onclick="location.href='http://localhost:8888/noti'">홈으로가기</button> 
	</div>

</body>
</html>