package com.nextLevel.hero.mngVacation.model.dto;

import java.sql.Date;

public class MngHolidayDTO {

	
	// 휴일여부 스트링으로 받아오는거 YN아님
	private int companyNo;
	private int holidayNo;
	private String calendar;
	private java.sql.Date holidayDate;
	private String title;
	private String holidayStatus;
	
	
		
	public MngHolidayDTO() {}

	public MngHolidayDTO(int companyNo, int holidayNo, String calendar, Date holidayDate, String title,
			String holidayStatus) {
		super();
		this.companyNo = companyNo;
		this.holidayNo = holidayNo;
		this.calendar = calendar;
		this.holidayDate = holidayDate;
		this.title = title;
		this.holidayStatus = holidayStatus;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public int getHolidayNo() {
		return holidayNo;
	}

	public String getCalendar() {
		return calendar;
	}

	public java.sql.Date getHolidayDate() {
		return holidayDate;
	}

	public String getTitle() {
		return title;
	}

	public String getHolidayStatus() {
		return holidayStatus;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public void setHolidayNo(int holidayNo) {
		this.holidayNo = holidayNo;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public void setHolidayDate(java.sql.Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setHolidayStatus(String holidayStatus) {
		this.holidayStatus = holidayStatus;
	}

	@Override
	public String toString() {
		return "MngHolidayDTO [companyNo=" + companyNo + ", holidayNo=" + holidayNo + ", calendar=" + calendar
				+ ", holidayDate=" + holidayDate + ", title=" + title + ", holidayStatus=" + holidayStatus + "]";
	}

	
}
