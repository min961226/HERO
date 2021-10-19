package com.nextLevel.hero.mngPay.model.dto;

import java.sql.Date;

public class MngPayListDTO {

	private int companyNo;	
	private int memberNo;
	private String memberName;
	private int idNo;
	private String departmentName;
	private String rank;
	private String salaryStep;
	private String yearAndMonth;
	private String searchPayDate;
	private java.sql.Date payDate;
	private int salaryAmount;
	private int deductAmount;
	private int transferAmount;
	private String category;
	private int bankCode;
	private String bankName;
	private String accountNo;
	
	
	public MngPayListDTO() {}


	public MngPayListDTO(int companyNo, int memberNo, String memberName, int idNo, String departmentName, String rank,
			String salaryStep, String yearAndMonth, String searchPayDate, Date payDate, int salaryAmount,
			int deductAmount, int transferAmount, String category, int bankCode, String bankName, String accountNo) {
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
		this.payDate = payDate;
		this.salaryAmount = salaryAmount;
		this.deductAmount = deductAmount;
		this.transferAmount = transferAmount;
		this.category = category;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.accountNo = accountNo;
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


	public int getBankCode() {
		return bankCode;
	}


	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getAccountNo() {
		return accountNo;
	}


	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}


	@Override
	public String toString() {
		return "MngPayListDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", idNo=" + idNo + ", departmentName=" + departmentName + ", rank=" + rank + ", salaryStep="
				+ salaryStep + ", yearAndMonth=" + yearAndMonth + ", searchPayDate=" + searchPayDate + ", payDate="
				+ payDate + ", salaryAmount=" + salaryAmount + ", deductAmount=" + deductAmount + ", transferAmount="
				+ transferAmount + ", category=" + category + ", bankCode=" + bankCode + ", bankName=" + bankName
				+ ", accountNo=" + accountNo + "]";
	}
	
	
}
