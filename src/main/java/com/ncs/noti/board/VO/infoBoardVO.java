package com.ncs.noti.board.VO;

import java.util.Date;

public class infoBoardVO {
	private int info_board_no;
	private String info_board_title;
	private Date info_board_start;
	private int cat_small_group_no;
	private int info_board_count;
	private int info_board_like;
	private String info_board_content;
	private String info_board_url;
	private String CAT_SMALL_GROUP_NAME;
	
	public String getCat_small_group_name() {
		return CAT_SMALL_GROUP_NAME;
	}
	public void setCat_small_group_name(String CAT_SMALL_GROUP_NAME) {
		this.CAT_SMALL_GROUP_NAME = CAT_SMALL_GROUP_NAME;
	}
	public int getInfo_board_no() {
		return info_board_no;
	}
	public void setInfo_board_no(int info_board_no) {
		this.info_board_no = info_board_no;
	}
	public String getInfo_board_title() {
		return info_board_title;
	}
	public void setInfo_board_title(String info_board_title) {
		this.info_board_title = info_board_title;
	}
	public Date getInfo_board_start() {
		return info_board_start;
	}
	public void setInfo_board_start(Date info_board_start) {
		this.info_board_start = info_board_start;
	}
	public int getCat_small_group_no() {
		return cat_small_group_no;
	}
	public void setCat_small_group_no(int cat_small_group_no) {
		this.cat_small_group_no = cat_small_group_no;
	}
	public int getInfo_board_count() {
		return info_board_count;
	}
	public void setInfo_board_count(int info_board_count) {
		this.info_board_count = info_board_count;
	}
	public int getInfo_board_like() {
		return info_board_like;
	}
	public void setInfo_board_like(int info_board_like) {
		this.info_board_like = info_board_like;
	}
	public String getInfo_board_content() {
		return info_board_content;
	}
	public void setInfo_board_content(String info_board_content) {
		this.info_board_content = info_board_content;
	}
	public String getInfo_board_url() {
		return info_board_url;
	}
	public void setInfo_board_url(String info_board_url) {
		this.info_board_url = info_board_url;
	}
	
	
	
}
