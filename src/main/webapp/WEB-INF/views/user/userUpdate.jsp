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
		<p>${sessionScope.login.user_id}�� ȸ�����������Ǿ����ϴ�.</p>
	<input type="button" onclick="location.href='http://localhost:8888/noti'"/> Ȩ���� ���� 
	</div>
</body>
</html>