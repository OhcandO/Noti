<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>${sessionScope.login.user_id}님 회원정보수정되었습니다.</p>
	<input type="button" onclick="location.href='http://localhost:8888/noti'"/> 홈으로 가기 
	</div>
</body>
</html>