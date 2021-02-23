package com.ncs.noti.member.VO;

import java.sql.Date;

import org.springframework.stereotype.Component;
@Component
public class MemberVO {
	private String user_id;
	private String user_pass;
	private Date user_birth;
	private String user_gender;
	private String user_email;
	private int loc_dong_no;
	private String user_name;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}
	public int getLoc_dong_no() {
		return loc_dong_no;
	}
	public void setLoc_dong_no(int loc_dong_no) {
		this.loc_dong_no = loc_dong_no;
	}
	
	
	
}
