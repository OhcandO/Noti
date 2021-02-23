<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
	<link rel="stylesheet" href="resources/css/style.css?after">
	<link rel="stylesheet" href="resources/css/base.css?after">

	<title>Noti 정보게시판 상세페이지</title>
	<script>
$(document).ready(function(){
		
		var heartval = ${heartInfo};
		
		if(heartval >= 1){
			console.log(heartval);
			$('#heart').prop("src","resources/images/likeafter.png");
			$("#heart").prop('name',heartval)
			
		}else {
			console.log(heartval);
			$('#heart').prop('src','resources/images/likebefore.png');
			$("#heart").prop('name',heartval)
		}
		
		$(".heart").on("click", function(){
			var that = $('#heart');
			
			var sendData = {'info_board_no':'${infoBoardVO.info_board_no}','user_id':'${login.user_id }','heart' : that.prop('name')};
			
			$.ajax({
				url:'heartInfo',
				type: 'post',
				data: sendData,
				success:function(data){
					if(data == -1){
						alert('통신에러',"error","확인",function(){});
					}
					else if(data == 1){
						$('#heart').prop('src','resources/images/likeafter.png');
						/* $("#likecnt").empty();
						$("#likecnt").addend(data.) */
						alert("좋아요를 눌렀습니다.");
					}else if(data == 0){
						$('#heart').prop('src','resources/images/likebefore.png');
						alert("좋아요를 취소합니다.");
					}
					
				}
			});
		});
	});
</script>
<style>
#heart {
	background: none;
	border: 0;
	outline: 0;
	cursor: pointer;
	width: 20px;
}
</style>
	<style>
		/* Make the image fully responsive */
	</style>
</head>
<body>
	<%@ include file="base/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<img alt="bg" src="resources/images/info_board.png" class="w-100">
		</div>		
	</div>
	<div class="container mt-4">
	<form action="likeBoardInfo.do" method="post">
		<input name="info_board_no" type="hidden" value="${infoboard.info_board_no}" />
		<table class="w-100">
			<tr class="main_td_sty b-t-5">
				<td class="w-10 bgc-123 text-center h-50px">제목</td>
				<td colspan="6" class="font-weight-600 pl-3">
					${infoboard.info_board_title}
				</td>
			</tr>
			<tr class="main_td_sty">
				<td class="w-10 bgc-123 text-center h-50px">등록기관</td>
				<td class="w-23 pl-3">
					${infoboard.cat_small_group_no }
				</td>
				<td class="w-10 bgc-123 text-center h-50px">등록일</td>
				<td class="w-23 pl-3">
					<fmt:formatDate value="${infoboard.info_board_start}" pattern="yyyy.MM.dd" />
				</td>
				<td class="w-10 bgc-123 text-center h-50px">조회수</td>
				<td class="w-23 pl-3">
					${infoboard.info_board_count }
				</td>
			</tr>
			<tr class="main_td_sty">
				<td class="w-10 bgc-123 text-center h-50px">원본링크</td>
				<td colspan="6" class="pl-3">
				<a href="${infoboard.info_board_url}">${infoboard.info_board_url}</a>	
				</td>
			</tr>
			<tr>
				<td colspan="6" class="pt-3">${infoboard.info_board_content}</td>
			</tr>
		</table>
</form>
		<hr>
		<div class="text-right">
		<c:choose>
			
				<c:when test="${!empty login }">
						<a class="heart"><img id='heart' src=''></a>
				</c:when>

				<c:otherwise>
					<a href="user/userLogin.do" style="cursor: pointer"> <img src='resources/images/likebefore.png' style="width: 20px"> </a>
				</c:otherwise>
			</c:choose>
			<button type="button" class="btn btn-secondary border-radius-0 px-3" onclick="location.href='http://localhost:8888/noti/getinfoBoardList.do'"><i class="fas fa-list pr-1"></i>글목록</button>
		</div>
		<a href="getinfoBoardList.do"></a>
		
		<div id="commentArea">
			<%@include file="comment/commentList.jsp" %>
		</div>
	</div>
</body>
</html>
