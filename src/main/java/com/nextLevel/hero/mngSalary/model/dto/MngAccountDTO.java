package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MngAccountDTO {

	private int companyNo;
	private int memberNo;
	private String memberName;
	private String searchDate;
	private String searchCondition;
	private String searchValue;
	private String departmentName;
	private String rank;
	private int bankCode;
	private String bankName;
	private String accountNo;
	private java.sql.Date enrollDate;
	private String accountFileUrl;
		
	
	public MngAccountDTO() {}


	public MngAccountDTO(int companyNo, int memberNo, String memberName, String searchDate, String searchCondition,
			String searchValue, String departmentName, String rank, int bankCode, String bankName, String accountNo,
			Date enrollDate, String accountFileUrl) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.searchDate = searchDate;
		this.searchCondition = searchCondition;
		this.searchValue = searchValue;
		this.departmentName = departmentName;
		this.rank = rank;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.enrollDate = enrollDate;
		this.accountFileUrl = accountFileUrl;
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


	public String getSearchDate() {
		return searchDate;
	}


	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}


	public String getSearchCondition() {
		return searchCondition;
	}


	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}


	public String getSearchValue() {
		return searchValue;
	}


	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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


	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}


	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}


	public String getAccountFileUrl() {
		return accountFileUrl;
	}


	public void setAccountFileUrl(String accountFileUrl) {
		this.accountFileUrl = accountFileUrl;
	}


	@Override
	public String toString() {
		return "MngAccountDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", searchDate=" + searchDate + ", searchCondition=" + searchCondition + ", searchValue=" + searchValue
				+ ", departmentName=" + departmentName + ", rank=" + rank + ", bankCode=" + bankCode + ", bankName="
				+ bankName + ", accountNo=" + accountNo + ", enrollDate=" + enrollDate + ", accountFileUrl="
				+ accountFileUrl + "]";
	}

	
	
}
