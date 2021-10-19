package com.nextLevel.hero.mngPay.model.dto;

import java.sql.Date;

public class MngPayDTO {

	private int companyNo;
	private String category;
	private String yearAndMonth;
	private String searchDate;
	private java.sql.Date payDate;
	private int totalPay;
	private int totalCount;
	private String confirmYn;
	
	
	public MngPayDTO() {}


	public MngPayDTO(int companyNo, String category, String yearAndMonth, String searchDate, Date payDate, int totalPay,
			int totalCount, String confirmYn) {
		super();
		this.companyNo = companyNo;
		this.category = category;
		this.yearAndMonth = yearAndMonth;
		this.searchDate = searchDate;
		this.payDate = payDate;
		this.totalPay = totalPay;
		this.totalCount = totalCount;
		this.confirmYn = confirmYn;
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getYearAndMonth() {
		return yearAndMonth;
	}


	public void setYearAndMonth(String yearAndMonth) {
		this.yearAndMonth = yearAndMonth;
	}


	public String getSearchDate() {
		return searchDate;
	}


	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}


	public java.sql.Date getPayDate() {
		return payDate;
	}


	public void setPayDate(java.sql.Date payDate) {
		this.payDate = payDate;
	}


	public int getTotalPay() {
		return totalPay;
	}


	public void setTotalPay(int totalPay) {
		this.totalPay = totalPay;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public String getConfirmYn() {
		return confirmYn;
	}


	public void setConfirmYn(String confirmYn) {
		this.confirmYn = confirmYn;
	}


	@Override
	public String toString() {
		return "MngPayDTO [companyNo=" + companyNo + ", category=" + category + ", yearAndMonth=" + yearAndMonth
				+ ", searchDate=" + searchDate + ", payDate=" + payDate + ", totalPay=" + totalPay + ", totalCount="
				+ totalCount + ", confirmYn=" + confirmYn + "]";
	}
	
	
	
}
