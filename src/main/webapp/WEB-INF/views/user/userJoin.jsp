<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>사용자 등록</title>

<!-- 
          정적자원들은 resources 폴더에 저장
	 현재 프로젝트명에서 user 경로를 더한 상태이기에 상위경로를 올라갔다가 resources를 찾음.
 -->
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
	<link rel="stylesheet" href="../resources/css/style.css">
	<link rel="stylesheet" href="../resources/css/base.css">
	<link rel="stylesheet" href="../resources/css/loginsty.css">
	
	<link rel="stylesheet" href="../resources/style/stylecss.css" type="text/css"/>
	<script type="text/javascript" src="../resources/js/jquery-1.7.1.js"></script>
	<script src="../resources/js/js_userinput.js"></script>
</head>


<body bgcolor="#FFFFFF">
	<%@ include file="../base/top.jsp"%>
	<div class="log-bgc1">
		<div class="container login-x1">
			<div class="row">
				<div class="col-lg-1"></div>
				<div class="col-lg-4 log_bg1 shadow">
					
				</div>
				<div class="col-lg-6 login-r col-12 log-bgc-w shadow px-5">
					<form method="post" action="userInsert.do" name="userinput" id="userinput">
						<div class="login-w1">
							<div class="font-size-12 font-weight-600 font-sty-1 main-font-color">
								Welcome to Noti
							</div>
							
							<div class="font-size-08 main-font-color2 font-weight-600 mt-2 font-sty-2">
								안녕하세요. 우리 홈페이지를 자유롭게 이용하려면 회원가입을 하셔야 합니다.<br> 아래의 사항들을
								빠짐없이 기록해 주세요
							</div>
							<div class="mt-4">		
								<label for="exampleFormControlInput1" class="form-label font-size-08 font-sty-1 main-font-color">ID</label>
								<div class="input-group">									
									<input type="text" name="user_id" id="user_id" class="form-control border-radius-0 w-50 font-sty-2 plh-f" placeholder="ID를 입력해 주세요"> 
									<span id="idCheckResult" class="w-50 font-sty-2 plh-f pt-2 pl-2" style="color: red; display:inline-block;"></span>
								</div>
		
								<label for="exampleFormControlInput1" class="form-label font-size-08 mt-3 font-sty-1 main-font-color">Password</label>
								<div class="input-group">
									<input type="password" name="user_pass" id="user_pass" class="form-control border-radius-0 font-sty-2 plh-f w-50" placeholder="PW를 입력해 주세요">
									<input type="password" name="user_pass2" id="user_pass2" class="form-control border-radius-0 font-sty-2 plh-f w-50" placeholder="PW를 한번 더 입력해 주세요">
								</div>
								
								<label for="exampleFormControlInput1" class="form-label font-size-08 mt-3 font-sty-1 main-font-color">Name</label>
								<div class="input-group">									
									<input type="text" name="user_name" id="user_name" class="form-control border-radius-0 w-50 font-sty-2 plh-f" placeholder="이름을 입력해 주세요">
								</div>
								
								<label for="exampleFormControlInput1" class="form-label font-size-08 mt-3 font-sty-1 main-font-color">Email</label>
								<div class="input-group">									
									<input type="text" name="user_email" id="user_email" class="form-control border-radius-0 w-100 font-sty-2 plh-f" placeholder="이메일을 입력해 주세요"> 
								</div>
								
								<label for="exampleFormControlInput1" class="form-label font-size-08 mt-3 font-sty-1 main-font-color">Gender</label>
								<div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox" name="user_gender" id="user_gender" value="남자">
										<label class="form-check-label" for="inlineCheckbox1">남자</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox" name="user_gender" id="user_gender" value="여자">
										<label class="form-check-label" for="inlineCheckbox2">여자</label>
									</div>
								</div>
								
								<label for="exampleFormControlInput1" class="form-label font-size-08 mt-3 font-sty-1 main-font-color">Birth</label>
								<div class="input-group">									
									<input type="date" name="user_birth" id="user_birth" class="form-control border-radius-0 w-100 font-sty-2 plh-f"> 
								</div>
								
								<label for="exampleFormControlInput1" class="form-label font-size-08 mt-3 font-sty-1 main-font-color">Location</label>
								
								<div class="input-group">	
									<select id="loc_dong_no" name="loc_dong_no" class="form-control border-radius-0 w-100 font-sty-2 plh-f">
										<optgroup label="시.도">
											<c:forEach var="LocVO" items="${result}" varStatus="status">
												<option selected value="${LocVO.loc_dong_no}"><c:out
														value="${LocVO.loc_dong_name}" />
												</option>
											</c:forEach>
										</optgroup>
									</select>								
								</div>
								<div class="text-center mt-4">
									<button type="submit" name="confirm" id="confirm" class="btn btn-secondary border-radius-0 w-50 mt-3 btn-bg font-weight-600 font-sty-1 border-0 shadow-sm">Join</button>
								</div>
							</div>							
						</div>
					</form>
				</div>		
				<div class="col-lg-2"></div>
			</div>
		</div>
	</div>
	<!-- 원본
	<form method="post" action="userInsert.do" name="userinput" id="userinput">
		<table class='table2'>
			<tr>
				<td class="normalbold tb_ttl">
					<div align="center">사용자 ID</div>
				</td>
				<td colspan="3" class="normal"><input type="text" name="user_id"
					id="user_id" size="20"> <span id="idCheckResult"
					style="width: 150px; color: red"></span></td>
			</tr>
			<tr>
				<td class="normalbold tb_ttl">
					<div align="center">비밀번호</div>
				</td>
				<td width="154" class="normal"><input type="password"
					name="user_pass" id="user_pass"></td>
				<td class="normalbold tb_ttl">
					<div align="center">비밀번호 확인</div>
				</td>
				<td width="160"><input type="password" name="user_pass2"
					id="user_pass2"></td>
			</tr>
			<tr>
				<td class="normalbold tb_ttl">
					<div align="center">사용자 이름</div>
				</td>
				<td colspan="3" height="23" class="normal"><input type="text"
					name="user_name" id="user_name"></td>
			</tr>
			<tr>
				<td class="normalbold tb_ttl">
					<div align="center">이메일</div>
				</td>
				<td colspan="3" height="26" class="normal"><input type="text"
					name="user_email" id="user_email"></td>
			</tr>
			<tr>
				<td class="normalbold tb_ttl">
					<div align="center">성별</div>
				</td>
				<td colspan="3" height="30" class="normal"><label></label>
					<input type="checkbox" name="user_gender" id="user_gender" value="남자">남자
						<label></label>
					<input type="checkbox" name="user_gender" id="user_gender" value="여자">여자
				</td>
			</tr>
			<tr>
				<td class="normalbold tb_ttl">
					<div align="center">생년월일</div>
				</td>
				<td colspan="3" height="35" class="normal"><input type="date" name="user_birth" id="user_birth"></td>
			</tr>
			<tr>
			<tr>
				<td class="normalbold tb_ttl">
					<div align="center">거주지</div>
				</td>
				<td colspan="3" height="40" class="normal">
					<select id="loc_dong_no" name="loc_dong_no">
						<optgroup label="시.도">
							<c:forEach var="LocVO" items="${result}" varStatus="status">
								<option selected value="${LocVO.loc_dong_no}"><c:out
										value="${LocVO.loc_dong_name}" />
								</option>
							</c:forEach>
						</optgroup>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="normal">
					<div align="center">
						<input type="submit" name="confirm" id="confirm" value="등   록">
						<input type="reset" name="reset" value="취   소">
					</div>
				</td>
			</tr>
		</table>
	</form>
	 -->

</body>
</html>
