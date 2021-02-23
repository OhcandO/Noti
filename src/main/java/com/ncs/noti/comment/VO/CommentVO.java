package com.ncs.noti.comment.VO;

import java.util.Date;

public class CommentVO {

	private int comment_no;				//PK 댓글
	private String user_id; 			//작성자 아이디
	private int board_no;				//댓글 달린 게시물의 PK
	private Date comment_date;			//댓글 작성 시간
	private int comment_like;			//댓글 좋아요 수
	private String comment_seq;			//순서 정렬위한 999999 정렬
	private int comment_groupid;		//대댓글이 어떤 댓글의 자식인지 결정
	private String comment_content;		//댓글 내용
	
	// 댓글의 언급 수준을 표시하는 방법: '시퀀스넘버'라는 문자열 이용함
	public int getLevel()
	{
		if( comment_seq == null			)	{ return -1; }
		if( comment_seq.length() != 16 	) 	{ return -1; }
		if( comment_seq.endsWith("999999")) 	{ return 0; }
		if( comment_seq.endsWith("9999")	) 	{ return 1; }
		if( comment_seq.endsWith("99")	) 	{ return 2; }
		return 3;
	}
	
	public int getComment_no() {
		return comment_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public int getBoard_no() {
		return board_no;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public int getComment_like() {
		return comment_like;
	}
	public String getComment_seq() {
		return comment_seq;
	}
	public int getComment_groupid() {
		return comment_groupid;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public void setComment_like(int comment_like) {
		this.comment_like = comment_like;
	}
	public void setComment_seq(String comment_seq) {
		this.comment_seq = comment_seq;
	}
	public void setComment_groupid(int comment_groupid) {
		this.comment_groupid = comment_groupid;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	
	
	
}
