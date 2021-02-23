package com.ncs.noti.member.VO;

import org.springframework.stereotype.Component;

@Component
public class LoginVO {
	private String login_id;
	private String login_pass;
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getLogin_pass() {
		return login_pass;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}
	
	
}
