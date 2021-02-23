<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page import="com.ncs.noti.member.VO.MemberVO"%>
<%@ page import="com.ncs.noti.board.VO.BoardVO"%>
<%@ page import="com.ncs.noti.board.VO.infoBoardVO"%>

<%
	//세션에 저장된 memberVO 객체 가져오기. 없다면 '로긘이 피료함'띄우기
	String user_id = "LOGIN 해주세요";
	MemberVO member;
	Object login = session.getAttribute("login");
	if (login != null) {
		user_id = ((MemberVO) login).getUser_id();
	}
	
	int board_no=0;
	
	Object userB = request.getAttribute("board");
	Object infoB = request.getAttribute("infoboard");
	
	if (userB != null){
		board_no = ((BoardVO)userB).getUser_board_no();
	}else if(infoB !=null){
		board_no = ((infoBoardVO)infoB).getInfo_board_no();
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-1.7.1.js"></script>
<script type="text/javascript">
	var board_no=${infoboard.info_board_no + board.user_board_no};
		/* 0;
	var ii=${infoboard};
	if(ii!=null){
		board_no = ${infoboard.info_board_no}; //게시글 목록에서 상세 페이지로 넘어올 때 게시글 번호
	}else {
		board_no = ${board.user_board_no};
	} */
</script>
<script type="text/javascript" src="resources/js/js_comment.js"></script>
</head>
<body>

	<!-- 1수준 댓글 등록부. 현 페이지의 상단에 고정되어 움직이지 않음 -->

	<div>
		<label for="content">게시물 댓글</label>
		<form name="insertCommentForm">
			<input type="hidden" name="board_no" value="<%=board_no%>" /> 
			 
			 
			<input type="hidden" name="user_id" value="<%=user_id%>" readonly="readonly"/> 
		
			<div class="input-group mb-3">
			  <textarea type="text" class="form-control border-radius-0 text" rows="5" required="required"
			  	id="content" name="comment_content"	placeholder="권리침해, 욕설 및 특정 대상을 비하하는 내용을 게시할 경우 이용약관 및 관련 법률에 의해 제해될 수 있습니다." aria-describedby="Btn_insertComment"/></textarea>
			  	<c:choose>
			         <c:when test="${!empty login }">
			            <button class="btn btn-outline-secondary border-radius-0" type="button" id="Btn_insertComment">댓글 등록</button>
			         </c:when>
			         <c:otherwise>
			         	<button class="btn btn-outline-secondary border-radius-0" type="button" onclick="location.href='user/userLogin.do'">로그인</button>
			         </c:otherwise>
			      </c:choose>
			  
			</div>
			<!-- 
			<input type="text" class="form-control border-radius-0" required="required"
						id="content" name="comment_content"	placeholder="권리침해, 욕설 및 특정 대상을 비하하는 내용을 게시할 경우 이용약관 및 관련 법률에 의해 제해될 수 있습니다.">
			<button type="button" id="Btn_insertComment">등록</button>
			 -->
			
		</form>
	</div>

	<!-- 댓글 리스트 보여주는 부분. 첫 댓글이 맨 위로. 막 댓이 맨 아래로. 실제 내용은 js 파일 내 ajax 방식 -->

	<div>
		<div class="commentLists"></div>
	</div>

</body>
</html>
