package com.nextLevel.hero.salary.model.dto;

import java.io.Serializable;
import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;

public class SalaryDTO implements Serializable{

	private int companyNo;
	private int memberNo;
	private int idNo;
	private String searchDate;
	private String category;
	private String yearAndMonth;
	private String rank;
	private String salaryStep;
	private java.sql.Date payDate;
	private int transferAmount;
	private String memberName;
	
	public SalaryDTO() {}

	public SalaryDTO(int companyNo, int memberNo, int idNo, String searchDate, String category, String yearAndMonth,
			String rank, String salaryStep, Date payDate, int transferAmount, String memberName) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.idNo = idNo;
		this.searchDate = searchDate;
		this.category = category;
		this.yearAndMonth = yearAndMonth;
		this.rank = rank;
		this.salaryStep = salaryStep;
		this.payDate = payDate;
		this.transferAmount = transferAmount;
		this.memberName = memberName;
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

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
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

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSalaryStep() {
		return salaryStep;
	}

	public void setSalaryStep(String salaryStep) {
		this.salaryStep = salaryStep;
	}

	public java.sql.Date getPayDate() {
		return payDate;
	}

	public void setPayDate(java.sql.Date payDate) {
		this.payDate = payDate;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "SalaryDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", idNo=" + idNo + ", searchDate="
				+ searchDate + ", category=" + category + ", yearAndMonth=" + yearAndMonth + ", rank=" + rank
				+ ", salaryStep=" + salaryStep + ", payDate=" + payDate + ", transferAmount=" + transferAmount
				+ ", memberName=" + memberName + "]";
	}

	
	
}
