<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<div class="container mt-3">
		<a class="container mt-3"><b>"${searchText}"</b>로 검색 결과 <b>총 ${boardListSize + infoboardListSize}</b>건
			나왔습니다.</a>
	</div>
	<div class="container mt-3">
		<a>정보게시판(<b>${infoboardListSize}</b>)
		</a>
		<table class="table" id="infoboardList">
			<!-- <tr class="text-center">
				<th class="w-50">제목</th>
				<th>그룹번호</th>
				user_id
				<th>날짜</th>
				user_board_start
				<th>추천수</th>
				<th>조회수</th>
				user_board_count
			</tr> -->
			<c:forEach items="${infoboardList}" var="infoboard" begin="0" end="3">
				<!-- 프라퍼티이름 변경 -->
				<tr>
					<td class="100" align=""><a
						href="getinfoBoard.do?info_board_no=${infoboard.info_board_no }">
							${infoboard.info_board_title }</a></td>
					<td align="center">등록일  </td>
					<td><fmt:formatDate value="${infoboard.info_board_start}"
							pattern="yyyy.MM.dd" /></td>
					<%-- <td align="center">추천수 : ${infoboard.info_board_like }</td>
					<td align="center">조회수 : ${infoboard.info_board_count }</td> --%>
				</tr>
				<tr>
					<td Colspan="3" style="border-top: none"><c:choose>
							<c:when test="${fn:length(infoboard.info_board_content) gt 152}">
								<c:out
									value='${fn:substring(infoboard.info_board_content, 0, 150).replaceAll("\\\<.*?\\\>","")}"'>...
					        </c:out>
							</c:when>
							<c:otherwise>
								<c:out value="${infoboard.info_board_content}" escapeXml="false">
								</c:out>
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${infoboardListSize > 4}">
			<a href="getinfoBoardList.do" class=""><i class="fas fa-plus-circle"></i> 더보기</a>
		</c:if>
		</a>
	</div>

	<div class="container mt-3">
		<a>자유게시판(<b>${boardListSize}</b>)
		</a>
		<table class="table" id="boardList">
			<!-- 	<tr class="text-center">
				<th width="w-50">제목</th>
				<th>작성자</th>
				user_id
				<th>등록일</th>
				user_board_start
				<th>추천수</th>
				<th>조회수</th>
				user_board_count

			</tr> -->
			<c:forEach items="${boardList}" var="board" begin="0" end="3">
				<!-- 프라퍼티이름 변경 -->
				<tr>
					<td class="w=50" align=""><a
						href="getBoard.do?user_board_no=${board.user_board_no }">
							${board.user_board_title }</a></td>
				
					<td>등록일 : ${fn:substring(board.user_board_start, 0, 10).replaceAll("-",".")}</td>
					<td align="center">추천수 : ${board.user_board_like }</td>
					<td align="center">조회수 : ${board.user_board_count }</td>

				</tr>
				<td Colspan="3" style="border-top: none"><c:choose>
						<c:when test="${fn:length(board.user_board_content) gt 152}">
							<c:out
								value='${fn:substring(board.user_board_content, 0, 150).replaceAll("\\\<.*?\\\>","")}"'>...
					        </c:out>
						</c:when>
						<c:otherwise>
							<c:out value="${board.user_board_content}" escapeXml="false">
							</c:out>
						</c:otherwise>
					</c:choose>
						<td align="center"  style="border-top: none">>작성자 : ${board.user_id }</td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${boardListSize > 4}">
			<a href="getBoardList.do" class=""><i class="fas fa-plus-circle"></i> 더보기</a>
		</c:if>
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