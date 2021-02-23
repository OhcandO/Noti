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

	<title>Noti 일반게시판 등록</title>
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
		<!-- 1. 폼태그에 속성 추가  -->
		<form action="saveBoard.do"  method='post' enctype="multipart/form-data">  <!-- -->
			<table class="w-100">
				<tr class="main_td_sty b-t-5">
					<td class="w-10 bgc-123 text-center h-50px">제목</td>
					<td colspan="2" class="font-weight-600 pl-3">
						<input name='user_board_title' type="text" class="w-100 border-radius-0 form-control" required="required"/>
					</td>
				</tr>
				<tr class="main_td_sty">
					<td class="w-10 bgc-123 text-center h-50px">작성자</td>
					<td class=" pl-3">
						<input type="text" size="10" name='user_id' value="${login.user_id}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<td colspan="8" class="pt-3">
						<textarea name="user_board_content" cols="40" rows="10" class="w-100">${board.user_board_content }</textarea>
					</td>
				</tr>
				<tr>
				<td colspan="8" align="center">
					<button type="submit" class="btn btn-secondary border-radius-0 font-size-08" value="새글 등록" ><i class="fas fa-list pr-1"></i>새글등록</button>					
				</tr>
			</table>
			
			<!-- 
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td width="70">제목</td>
					<td align="left"><input type="text" name='user_board_title'/></td>
				</tr>
				<tr>
					<td >작성자</td>
					<td align="left"><input type="text" size="10" name='user_id'/></td>
				</tr>
				<tr>
					<td >내용</td>
					<td align="left"><textarea cols="40" rows="10" name='user_board_content'></textarea></td>
				</tr>
				
				
				<%-- <tr>
					<td>비밀번호</td>
					<td align="left"><input type="text" name='user_board_pass' />
					<input type="hidden" value="<%=request.getRemoteAddr()%>" name='b_ip'> 
					<!-- 클라이언트 아이피 주소를 찾으려면? -->
					</td>
				</tr> --%>
				<!--
				<tr>
					<td width="70">파일추가</td><td align="left">
					 name='file'은  BoardVo 에서 File file 이름과 동일해야 한다 
					<input type="file" maxlength="60" size="40" name='file'></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="submit"	value=" 새글 등록 " /></td>
				</tr>-->
			</table>
		</form>
		<hr>
		<div class="text-right">
			<button type="button" class="btn btn-secondary border-radius-0 font-size-08" onclick="location.href='http://localhost:8888/noti/getBoardList.do'"><i class="fas fa-list pr-1"></i>글목록</button>
		</div>
	</div>
</body>
</html>