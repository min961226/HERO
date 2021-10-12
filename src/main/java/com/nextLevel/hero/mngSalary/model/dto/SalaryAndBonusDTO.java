package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class SalaryAndBonusDTO {

	private int companyNo;	
	private int memberNo;
	private String memberName;
	private int idNo;
	private String departmentName;
	private String rank;
	private String salaryStep;
	private String yearAndMonth;
	private String searchPayDate;
	private String searchingValidateDate;
	private java.sql.Date payDate;
	private int salaryAmount;
	private int deductAmount;
	private int transferAmount;
	private String category;
	private String year;
	private String month;
	
	public SalaryAndBonusDTO() {}

	public SalaryAndBonusDTO(int companyNo, int memberNo, String memberName, int idNo, String departmentName,
			String rank, String salaryStep, String yearAndMonth, String searchPayDate, String searchingValidateDate,
			Date payDate, int salaryAmount, int deductAmount, int transferAmount, String category, String year,
			String month) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.idNo = idNo;
		this.departmentName = departmentName;
		this.rank = rank;
		this.salaryStep = salaryStep;
		this.yearAndMonth = yearAndMonth;
		this.searchPayDate = searchPayDate;
		this.searchingValidateDate = searchingValidateDate;
		this.payDate = payDate;
		this.salaryAmount = salaryAmount;
		this.deductAmount = deductAmount;
		this.transferAmount = transferAmount;
		this.category = category;
		this.year = year;
		this.month = month;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public String getYearAndMonth() {
		return yearAndMonth;
	}

	public void setYearAndMonth(String yearAndMonth) {
		this.yearAndMonth = yearAndMonth;
	}

	public String getSearchPayDate() {
		return searchPayDate;
	}

	public void setSearchPayDate(String searchPayDate) {
		this.searchPayDate = searchPayDate;
	}

	public String getSearchingValidateDate() {
		return searchingValidateDate;
	}

	public void setSearchingValidateDate(String searchingValidateDate) {
		this.searchingValidateDate = searchingValidateDate;
	}

	public java.sql.Date getPayDate() {
		return payDate;
	}

	public void setPayDate(java.sql.Date payDate) {
		this.payDate = payDate;
	}

	public int getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(int salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public int getDeductAmount() {
		return deductAmount;
	}

	public void setDeductAmount(int deductAmount) {
		this.deductAmount = deductAmount;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "SalaryAndBonusDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", idNo=" + idNo + ", departmentName=" + departmentName + ", rank=" + rank + ", salaryStep="
				+ salaryStep + ", yearAndMonth=" + yearAndMonth + ", searchPayDate=" + searchPayDate
				+ ", searchingValidateDate=" + searchingValidateDate + ", payDate=" + payDate + ", salaryAmount="
				+ salaryAmount + ", deductAmount=" + deductAmount + ", transferAmount=" + transferAmount + ", category="
				+ category + ", year=" + year + ", month=" + month + "]";
	}

	
	
}
