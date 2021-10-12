package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class AppointmentDTO {

	private String searchDate;
	private int companyNo;
	private int memberNo;
	private java.sql.Date date;
	private String appointment;
	
	public AppointmentDTO() {}

	public AppointmentDTO(String searchDate, int companyNo, int memberNo, Date date, String appointment) {
		super();
		this.searchDate = searchDate;
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.date = date;
		this.appointment = appointment;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "AppointmentDTO [searchDate=" + searchDate + ", companyNo=" + companyNo + ", memberNo=" + memberNo
				+ ", date=" + date + ", appointment=" + appointment + "]";
	}

	
	
	
}
