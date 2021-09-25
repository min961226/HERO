package com.nextLevel.hero.salary.model.dto;

import java.sql.Date;

public class MyAccountDTO {
	
	private int companyNo;
	private int bankCode;
	private String bankName;
	private String accountNo;
	private int memberNo;
	private String memberName;
	private String departmentName;
	private java.sql.Date enrollDate;
	private String accountFileUrl;
	
	public MyAccountDTO() {}

	public MyAccountDTO(int companyNo, int bankCode, String bankName, String accountNo, int memberNo, String memberName,
			String departmentName, Date enrollDate, String accountFileUrl) {
		super();
		this.companyNo = companyNo;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.departmentName = departmentName;
		this.enrollDate = enrollDate;
		this.accountFileUrl = accountFileUrl;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
		return "MyAccountDTO [companyNo=" + companyNo + ", bankCode=" + bankCode + ", bankName=" + bankName
				+ ", accountNo=" + accountNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", departmentName=" + departmentName + ", enrollDate=" + enrollDate + ", accountFileUrl="
				+ accountFileUrl + "]";
	}

	
	

	
}
