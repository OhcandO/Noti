<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

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

<title>글 목록</title>
<link rel="stylesheet" href="resources/css/user_boardList.css">
</head>
<body>
<%@ include file="base/top.jsp"%>
   <div id="body">
      <div class="container-fluid">
      <div class="row">
				<img alt="bg" src="resources/images/info_board.png" class="w-100">
		</div>
         <div class="row text-center font-weight-600 font-color-white pointer">
			<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getinfoBoardList.do'">
				공지사항
			</div> 
			<div class="col-lg-3 col-12 sub_menu_click main-font-color  py-2" onclick="location.href='http://localhost:8888/noti/getBoardList.do'">
				자유게시판
			</div>
			<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getTopSearch.do'">
				인기검색어
			</div>
			<div class="col-lg-3 col-12 sub_menu_none py-2" onclick="location.href='http://localhost:8888/noti/getNotiInfo.do'">
				노티소개
			</div>
		</div>
      </div>
		<div class="container mt-3">
			<table id="likeUserList" class="table">
				<tr class="text-center">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<!-- user_id -->
					<th>등록일</th>
					<!-- user_board_start -->
					<th>조회수</th>
					<!-- user_board_count -->
					<th>추천수</th>
				</tr>
				<c:forEach items="${likeInfoList }" var="likeBoardInfo">
					<!-- 프라퍼티이름 변경 -->
					<%
						
					%>
					<tr>
						<td align="center">${likeBoardInfo.like_info_list_no}</td>
						<td align="center">${likeBoardInfo.info_board_title}</td>
						<td align="center">${likeBoardInfo.cat_small_group_name}</td>
						<td align="center">${likeBoardInfo.info_board_start}</td>
						<td align="center">${likeBoardInfo.info_board_count}</td>
						<td align="center">${likeBoardInfo.info_board_like}</td>
					</tr>
				</c:forEach>

			</table>

			<a id="insert" href="insertBoard.do">새글 등록</a>
			<div>
				<ul>
					<c:if test="${pageMaker.prev}">
						<li><a
							href="likeUserList${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage}"
						end="${pageMaker.endPage}" var="idx">
						<li><a href="likeUserList${pageMaker.makeQuery(idx)}">${idx}</a></li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="likeUserList${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>


	<br>

</body>
</html>