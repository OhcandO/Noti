<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 기본 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>


<!-- 이모티콘 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.9.0/css/all.css"
	integrity="sha384-i1LQnF23gykqWXg6jxC2ZbCbUMxyw5gLZY6UiUS98LYV5unm8GWmfkIS6jqJfb4E"
	crossorigin="anonymous">

<!-- css -->
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/base.css">

<title>Noti</title>
<style>
/* Make the image fully responsive */
</style>
</head>
<title>글 목록</title>
<link rel="stylesheet" href="resources/css/user_boardList.css">
</head>
<body>

	<div id="London" class="tabcontent">
		<h1>공지사항</h1>
		<p>중/소 공공기관의 공지사항을 확인할 수 있습니다.</p>
	</div>

	<div id="Paris" class="tabcontent">
		<h1>Paris</h1>
		<p>Paris is the capital of France.</p>
	</div>

	<div id="Tokyo" class="tabcontent">
		<h1>Tokyo</h1>
		<p>Tokyo is the capital of Japan.</p>
	</div>

	<div id="Oslo" class="tabcontent">
		<h1>Oslo</h1>
		<p>Oslo is the capital of Norway.</p>
	</div>
	<button class="tablink" onclick="openCity('London', this, 'blue')"
		id="defaultOpen">공지사항</button>
	<button class="tablink" onclick="openCity('Paris', this, 'green')">자유게시판</button>
	<button class="tablink" onclick="openCity('Tokyo', this, '#FF1212')">공지사항</button>
	<button class="tablink" onclick="openCity('Oslo', this, 'orange')">공지사항</button>
	<hr>

	<div class="container mt-3">
		<table class="table" id="infoboardList">
			<tr class="text-center">
				<th>번호</th>
				<th class="w-50">제목</th>
				<th>그룹번호</th>
				<!-- user_id -->
				<th>날짜</th>
				<!-- user_board_start -->
				<th>추천수</th>
				<th>조회수</th>
				<!-- user_board_count -->

			</tr>
			<c:forEach items="${infoboardList}" var="infoboard">
				<!-- 프라퍼티이름 변경 -->
				<tr>
					<td align="center">${infoboard.info_board_no}</td>
					<td align=""><a
						href="getinfoBoard.do?info_board_no=${infoboard.info_board_no }">${infoboard.info_board_title }</a></td>
					<td align="center">${infoboard.cat_small_group_no }</td>
					<td><fmt:formatDate value="${infoboard.info_board_start}" pattern="yyyy.MM.dd" /></td>
					<td align="center">${infoboard.info_board_like }</td>
					<td align="center">${infoboard.info_board_count }</td>

				</tr>
			</c:forEach>

		</table>
	</div>
	<br>

	<script>
		function openCity(cityName, elmnt, color) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].style.backgroundColor = "";
			}
			document.getElementById(cityName).style.display = "block";
			elmnt.style.backgroundColor = color;

		}
		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>
</body>
</html>