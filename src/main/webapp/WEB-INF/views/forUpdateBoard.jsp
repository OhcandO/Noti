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
	
	<!-- 카운트 업(숫자)ajax -->
	<script type="text/javascript" src="resources/js/indexCountUp.js"></script>

	<!-- 이모티콘 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.9.0/css/all.css"
		integrity="sha384-i1LQnF23gykqWXg6jxC2ZbCbUMxyw5gLZY6UiUS98LYV5unm8GWmfkIS6jqJfb4E" crossorigin="anonymous">

	<!-- css -->
	<link rel="stylesheet" href="resources/css/style.css?after">
	<link rel="stylesheet" href="resources/css/base.css?after">

	<title>Noti 일반게시판 상세페이지 수정</title>
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
		<form action="updateBoard.do" method="post">
			<input name="user_board_no" type="hidden" value="${board.user_board_no}" />
			<table class="w-100">
				<tr class="main_td_sty b-t-5">
					<td class="w-10 bgc-123 text-center h-50px">제목</td>
					<td colspan="8" class="font-weight-600 pl-3">
						<input name="user_board_title" type="text"
						value="${board.user_board_title }" class="w-100 border-radius-0 form-control" />
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
					<td colspan="8" class="pt-3">
						<textarea name="user_board_content" cols="40" rows="10" class="w-100">${board.user_board_content }</textarea>
					</td>
				</tr>
				<tr>
				<td colspan="8" align="center">
					<button type="submit" class="btn btn-secondary border-radius-0 font-size-08" value="글 수정" ><i class="fas fa-list pr-1"></i>수정완료</button>
					
				</tr>
			</table>
			
		</form>
		<div class="text-right">
			<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/getBoardList.do'"><i class="fas fa-list pr-1"></i>글목록</button>
			<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/insertBoard.do'"><i class="fas fa-plus"></i>글등록</button>
			<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/deleteBoard.do?user_board_no=${board.user_board_no }'"><i class="fas fa-times pr-1"></i>글삭제</button>
		</div>
	</div>
	
	<!-- 
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td width="70">제목</td>
			<td align="left">
				<input name="user_board_title" type="text"
				value="${board.user_board_title }" />
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td align="left">${board.user_id }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td align="left"><textarea name="user_board_content" cols="40" rows="10">${board.user_board_content }</textarea></td>
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
			<input type="submit" value="글 수정" /></td>
		</tr>
	</table>
	 -->
</body>
</html>
