package com.ncs.noti.board.VO;

public class likeUserVO {
	private int like_user_list_no;
	private int user_board_no;
	
	private String user_board_title;
	private String user_id;
	private String user_board_start;
	private int user_board_count;
	private int user_board_like;
	
	public int getUser_board_no() {
		return user_board_no;
	}
	public void setUser_board_no(int user_board_no) {
		this.user_board_no = user_board_no;
	}
	
	
	public int getLike_user_list_no() {
		return like_user_list_no;
	}
	public void setLike_user_list_no(int like_user_list_no) {
		this.like_user_list_no = like_user_list_no;
	}
	public String getUser_board_title() {
		return user_board_title;
	}
	public void setUser_board_title(String user_board_title) {
		this.user_board_title = user_board_title;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_board_start() {
		return user_board_start;
	}
	public void setUser_board_start(String user_board_start) {
		this.user_board_start = user_board_start;
	}
	public int getUser_board_count() {
		return user_board_count;
	}
	public void setUser_board_count(int user_board_count) {
		this.user_board_count = user_board_count;
	}
	public int getUser_board_like() {
		return user_board_like;
	}
	public void setUser_board_like(int user_board_like) {
		this.user_board_like = user_board_like;
	}

}
