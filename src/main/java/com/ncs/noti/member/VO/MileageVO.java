package com.ncs.noti.member.VO;

import java.sql.Date;

public class MileageVO {
	private Date mileage_date;
	private int mileage_amount;
	public Date getMileage_date() {
		return mileage_date;
	}
	public void setMileage_date(Date mileage_date) {
		this.mileage_date = mileage_date;
	}
	public int getMileage_amount() {
		return mileage_amount;
	}
	public void setMileage_amount(int mileage_amount) {
		this.mileage_amount = mileage_amount;
	}
	public String getMileage_content() {
		return mileage_content;
	}
	public void setMileage_content(String mileage_content) {
		this.mileage_content = mileage_content;
	}
	private String mileage_content;
	
}
