<%@page contentType="text/html; charset=UTF-8"%>
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

	<title>Noti 일반게시판 상세페이지</title>
	<script>
$(document).ready(function(){
		
		var heartval = ${heart};
		
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
			
			var sendData = {'user_board_no':'${boardVO.user_board_no}','user_id':'${login.user_id }','heart' : that.prop('name')};
			
			$.ajax({
				url:'heart',
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
	<%@ include file="base/header.jsp"%>
	<%@ include file="base/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<img alt="bg" src="resources/images/info_board.png" class="w-100">
		</div>		
	</div>
	<div class="container mt-4">
		<form action="likeBoard.do" method="post">
			<table class="w-100">
				<tr class="main_td_sty b-t-5">
					<td class="w-10 bgc-123 text-center h-50px">제목</td>
					<td colspan="8" class="font-weight-600 pl-3">
						${board.user_board_title}
					</td>
				</tr>
				<tr class="main_td_sty">
					<td class="w-10 bgc-123 text-center h-50px">작성자</td>
					<td class=" pl-3">
						<input name="user_id" type="hidden" value="${board.user_id }" />${board.user_id }
					</td>
					<td class="w-10 bgc-123 text-center h-50px">등록일</td>
					<td class=" pl-3">
						${board.user_board_start }
					</td>
					<td class="w-10 bgc-123 text-center h-50px">조회수</td>
					<td class=" pl-3">
						${board.user_board_count }
					</td>
					<td class="w-10 bgc-123 text-center h-50px">추천수</td>
					<td class="pl-3">
						${board.user_board_like }
					</td>
				</tr>
				<tr>
					<td colspan="8" class="pt-3">${board.user_board_content}</td>
				</tr>
			</table>
		</form>
		<hr>
		<div class="text-right">
			<c:choose>
			
				<c:when test="${!empty login }">
						<a class="heart"><img id='heart' src=''>${board.user_board_like}</a>
				</c:when>

				<c:otherwise>
					<a href="user/userLogin.do" style="cursor: pointer"> <img src='resources/images/likebefore.png' style="width: 20px"> </a>
				</c:otherwise>
			</c:choose>
			<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/getBoardList.do'"><i class="fas fa-list pr-1"></i>글목록</button>
			<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/insertBoard.do'"><i class="fas fa-plus"></i>글등록</button>
			<!-- 로그인 세션과 작성자 이름 같아야 삭제 가능 -->
			<c:if test="${login.user_id eq board.user_id}">
				<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/forUpdateBoard.do?user_board_no=${board.user_board_no }'"><i class="fas fa-pen pr-1"></i> 글수정</button>
				<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/deleteBoard.do?user_board_no=${board.user_board_no }'"><i class="fas fa-times pr-1"></i>글삭제</button>
			</c:if>
		</div>
		<hr>
		<div id="commentArea">
			<%@include file="comment/commentList.jsp" %>
		</div>
		
		<!-- 원본
		<input name="user_board_no" type="hidden" value="${board.user_board_no}" />
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td width="70">제목</td>
				<td align="left" >
				${board.user_board_title}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td align="left"><input name="user_id" type="hidden" value="${board.user_id }" />${board.user_id }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${board.user_board_content}</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td align="left">${board.user_board_start }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td align="left">${board.user_board_count }</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<a href="forUpdateBoard.do?user_board_no=${board.user_board_no }"> 글 수정하기 </a>
				&nbsp; <input type="submit" id="like" value="관심 게시물 등록"/></td>
			</tr>
		</table> 
		-->
	</div>
</body>
</html>
