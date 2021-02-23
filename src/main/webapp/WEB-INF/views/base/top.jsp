<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	if (session != null){
		Date loginT = null;
		loginT=(Date)session.getAttribute("loginTime");
		
		String user_name ="";
		user_name=(String)session.getAttribute("user_name");
	}
	String referer = (String)request.getHeader("REFERER");
	
%>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script src="resources/js/js_totalSearch.js"></script>

<script type="text/javascript">
	
/* 로그아웃용 */
$(document).ready(function(){
$('#beforePage').text();
	
$('#logout').click(function(){
	
	var reallyLogOut = confirm("로그아웃 하시겠습니까?");
	if(reallyLogOut){
		var loginTime = ${loginTime.getTime()};
		var now = new Date();
		var sessionPeriod = now.getTime() -loginTime;
	
		
		var hour = Math.floor((sessionPeriod % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
		var min = Math.floor((sessionPeriod % (1000 * 60 * 60)) / (1000 * 60));
		var sec = Math.floor((sessionPeriod % (1000 * 60)) / 1000);

		var period = "접속 기간 : "+hour+"시간 "+min+" 분 "+sec+" 초"; 
		
		alert('${login.user_name}' + "님의 " + period);

		location.href="user/logOut.do";		
		
		}
	});
});

</script>	

<div class="container py-3">
		<div class="row">
			<div class="col-lg-4 font-weight-600 font-size-29 main-font-color pointer" onclick="location.href='http://localhost:8888/noti/'">
				Noti<span class="" style="font-size:1px">rannosaurus</span>
			</div>
			<div class="col-lg-4 pt-4">
				<input type="text" id="search" class="form-control w-100 serch_bar_sty" placeholder="검색어를 입력해 주세요.">
			</div>
			<div class="col-lg-4 pt-4">
				<div class="text-right">
				
				<!-- 세션에 아무 정보 없을 때 [로그인] [회원가입], 세션에 정보 있으면 [로그아웃], [마이페이지] 와 접속자: 누구누구 -->
				<c:choose>
					<c:when test="${empty login}">
						<a href="user/userLogin.do" class="main-font-color font-weight-600 pr-3">로그인</a>
						<a href="user/userJoin.do" class="main-font-color font-weight-600">회원가입</a>
					</c:when>
					
					<c:otherwise>
                  접속자 : <span><b>${login.user_name}</b></span> &nbsp;|&nbsp; 접속시간 : <span><fmt:formatDate value="${loginTime}" type="time" /></span>&nbsp; <br>
                  <a href="user/MyPage.do" class="main-font-color font-weight-600">마이페이지</a>&nbsp;
                  <label id="logout" class="main-font-color font-weight-600" style="cursor: pointer">로그아웃</label>
               </c:otherwise>
				
				</c:choose>
				</div>
			</div>
		</div>
	</div>
