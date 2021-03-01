$(document).ready(function(){
	
    getCommentList(board_no);   
    
    $("#Btn_insertComment").click(function(){ //댓글 등록 버튼 클릭시 
    	var insertReally = confirm('댓글을 입력하시겠습니까');
    	if(insertReally){
    		alert('댓글답니다');
    		var insertData = $('[name=insertCommentForm]').serialize(); //commentInsertForm의 내용을 가져옴
    		insertComment(insertData); //Insert 함수호출(아래)
    	}
    });
    
    
});

function getCommentList(board_no){
    $.ajax({
        url:'comments/getCommentList.do',
        type: 'get',
        data: {'board_no' : board_no},
        success : function(data){
        	$(".commentLists").html(data);
        },
        error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}
    });
}

//댓글 등록
function insertComment(insertData){
//	alert(insertData);
	
    $.ajax({
        url : 'comments/insertComment.do',
        type : 'post',
        data : insertData,
        success : function(data){
            if(data == 1) {
                getCommentList(board_no); //댓글 작성 후 댓글 목록 reload
                $('#content').val('');
            }
        },
        error:function(){alert("댓글 입력 오류");}
    });
	
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function updatingComment(comment_no){
	var a ='';
	var comment_content ='';
	comment_content = $('.contentOF'+comment_no).text();	
	// 댓글 content 있을 자리가 textarea로 대치
	a += '<div class="input-group mt-2">';
	a += '<textarea type="text" class="form-control border-radius-0" required="required" name="updatingCommentOF'+comment_no+'">';
	a += comment_content;
	a += '</textarea>';
	// 수정 확인 버튼 생성
	a += '<button class="btn btn-outline-secondary border-radius-0" type="button" type="button" onclick="updateCommentProc('+comment_no+')">수정확인</button>';
	a += '</div>';
	
	$('.commentMainOF'+comment_no).html(a);
}

//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 원본
//function updatingComment(comment_no){
//	alert('수정버튼 눌림');
//	var a ='';
//	var comment_content ='';
//	comment_content = $('.contentOF'+comment_no).text();
//	// 댓글 content 있을 자리가 textarea로 대치
//	a += '<textarea rows="2" cols="" ';
//	a += 'name="updatingCommentOF'+comment_no+'">';
//	a += comment_content;
//	a += '</textarea> &nbsp';
//	// 수정 확인 버튼 생성
//	a += '<button onclick="updateCommentProc('+comment_no+')">수정확인</button>';
//	
//	$('.commentMainOF'+comment_no).html(a);
//}


//댓글 수정
function updateCommentProc(comment_no){
//	alert('수정확인버튼 눌림');
    var updateContent = $('[name=updatingCommentOF'+comment_no+']').val();
    
    $.ajax({
        url : 'comments/updateComment.do',
        type : 'post',
        data : {'comment_content' : updateContent, 'comment_no' : comment_no},
        success : function(data){
            if(data == 1) getCommentList(board_no); //댓글 수정후 목록 출력 
        }
    });
}
 
//댓글 삭제 
function deleteComment(comment_no){
	var deleteReally = confirm('댓글을 삭제하시겠습니까');
	if(deleteReally){
		alert('삭제합니다');
		$.ajax({
			url : 'comments/deleteComment.do',
			data : {'comment_no':comment_no},
			type : 'post',
			success : function(data){
				if(data == 1) getCommentList(board_no); //댓글 삭제후 목록 출력 
			}
		});
	}
}

//대댓글, 대대댓글 달기
function replyingComment(Parent_comment_no, user_id){
	var r ='';
	r+= '<form name="replyCommentForm"> <input type="hidden" name="board_no" value='+board_no+'>';
	r+= '<input class="border-0" type="hidden" readonly="readonly" name="user_id" value="'+user_id+'"></input>'; 
	r+= '<div class="input-group mt-2">';
	r+= '<textarea type="text" class="form-control border-radius-0" required="required" name="comment_content"	placeholder="권리침해, 욕설 및 특정 대상을 비하하는 내용을 게시할 경우 이용약관 및 관련 법률에 의해 제해될 수 있습니다." aria-describedby="Btn_insertComment"></textarea></form>';
	r+= '<button class="btn btn-outline-secondary border-radius-0" type="button" type="button" onclick="replyComment('+Parent_comment_no+')">등록</button>';
	r+= '</div>';
	$('.replyOF'+Parent_comment_no).html(r);
}

//<span class="main-font-color font-weight-600 pr-2"><b> ${comment.user_id}</b></span>

//대댓글, 대대댓글 달기 원본
//function replyingComment(Parent_comment_no, user_id){
//	var r ='';
//	r+= '<form name="replyCommentForm"> <input type="hidden" name="board_no" value='+board_no+'>';
//	r+= '<input class="border-0" type="text" readonly="readonly" name="user_id" value="'+user_id+'"></input> </br>'; 
//	r+=	' <textarea rows="" cols="" required="required" name="comment_content"></textarea></form>';
//	r+= '<button type="button" onclick="replyComment('+Parent_comment_no+')">댓글달기</button>';
//	$('.replyOF'+Parent_comment_no).html(r);
//}
 

	
	


function replyComment(Parent_comment_no){
	//버튼 name 속성이 Btn_replyComment-???? 로 시작하는 것들
	var replyReally = confirm('정말 댓글 작성할래요?');
	if(replyReally){
		$.ajax({
			url : 'comments/replyComment.do',
	       	type : 'get',
	        data : $('[name=replyCommentForm]').serialize() + "&parent_comment_no="+Parent_comment_no,
	        success : function(data){
	            if(data == 1) {
	                getCommentList(board_no); 
	            }
	        },
	        error:function(){alert("대ㅐㄷㅅ댓글 입력 오류");}
	    });
	}
}