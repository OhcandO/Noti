<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</head>
<body>
	<strong>총 댓글 수 : ${NumberOfComments}</strong>
	<br>
	<!-- 
	<strong>세션 아이디 : ${login.user_id} </strong> 
	 -->
	 
	<c:forEach items="${comments}" var="comment" varStatus="status">
		<div class="py-3 main_td_sty" style="background-color:#f9f9f9">
		
			<!-- 댓글으 ㅣ순서.. count는 1부터, index는 0부터 
			<span>${status.count}</span>-->
			
			<span>
				<!-- 댓글의 수준 (원댓글0,대댓글1,대대댓글2)에 따라 indent 효과 -->
				<!-- 댓글의 수준(comment.getLevel()) = ${comment.getLevel()} -->
				<c:if test="${comment.getLevel() ge 0 }">
					<c:forEach var="level" begin="0" end="${comment.getLevel()}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</c:forEach> <img alt="tt" src="resources/images/board_re.gif">
				</c:if>
			</span>
			
			<!-- 대댓글 달기			
			<span> 
				<c:choose>
					<c:when test="${!empty login}">
						<button type="button" class="font-size-06 btn-com-1 shadow-sm" onclick="replyingComment('${comment.comment_no}', '${login.user_id}')"> <i class="fas fa-pen-square pr-1"></i>답글 </button>
					</c:when>
					<c:otherwise>
						<i>대댓기능은 로그인 필요!</i>
					</c:otherwise>
				</c:choose>
			</span>
			 -->
			<!-- 댓글 본문 : 작성자 + 댓글 내용 -->
			<span class="main-font-color font-weight-600 pr-2"><b><i class="fas fa-user pr-1"></i> ${comment.user_id}</b></span>
			<!-- 수정될 때. 본문과 버튼 두 개 모두 밀어버림 -->
			<span class="commentMainOF${comment.comment_no}"> 
			
				<span class="font-size-08 main-font-color3 pr-2"> <fmt:formatDate value="${comment.comment_date}" pattern="yyyy.MM.dd HH:mm:ss" /></span> <span class="font-size-08 main-font-color3 pr-2"> 추천 수 : ${comment.comment_like}  </span>
				<!-- 세션에 저장된 아이디와 해당 댓글 작성자가 같을 때 버튼 보여줌 -->
				<span> 
					<c:choose>
						<c:when test="${!empty login}">
							<button type="button" class="font-size-06 btn-com-1 shadow-sm" onclick="replyingComment('${comment.comment_no}', '${login.user_id}')"> <i class="fas fa-pen-square pr-1"></i>답글 </button>
						</c:when>
						<c:otherwise>
							<!-- 
							<i>대댓기능은 로그인 필요!</i>
							 -->
						</c:otherwise>
					</c:choose>
				</span>
				<c:if test="${login.user_id eq comment.user_id }">						
					<!-- <button onclick="updatingComment(${comment.comment_no}, ${comment.comment_content})">수정</button>
					 -->
					
					<button type="button" class="font-size-06 btn-com-1 shadow-sm" onclick="updatingComment(${comment.comment_no})"><i class="fas fa-pen pr-1"></i>수정</button>
					<button type="button" class="font-size-06 btn-com-1 shadow-sm" onclick="deleteComment(${comment.comment_no})"><i class="fas fa-times pr-1"></i>삭제</button>
					
				</c:if>
					
				</br>
				<div class="pt-1"></div>
				<span class="contentOF${comment.comment_no} px-4"> ${comment.comment_content} </span>			
			</span>
		</div>
		
		<!-- 대댓 들어갈 영역 선점 -->
			<div class="replyOF${comment.comment_no}"> </div>
	</c:forEach>
	
</body>
</html>