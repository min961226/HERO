package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MngAccountDTO {

	private MemberInfoDTO memberInfo;
	private String departmentName;
	private String rank;
	private int bankCode;
	private String bankName;
	private String accountNo;
	private java.sql.Date enrollDate;
	private String accountFileUrl;
	
	public MngAccountDTO() {}

	public MngAccountDTO(MemberInfoDTO memberInfo, String departmentName, String rank, int bankCode, String bankName,
			String accountNo, Date enrollDate, String accountFileUrl) {
		super();
		this.memberInfo = memberInfo;
		this.departmentName = departmentName;
		this.rank = rank;
		this.bankCode = bankCode;
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.enrollDate = enrollDate;
		this.accountFileUrl = accountFileUrl;
	}

	public MemberInfoDTO getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfoDTO memberInfo) {
		this.memberInfo = memberInfo;
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
		return "MngAccountDTO [memberInfo=" + memberInfo + ", departmentName=" + departmentName + ", rank=" + rank
				+ ", bankCode=" + bankCode + ", bankName=" + bankName + ", accountNo=" + accountNo + ", enrollDate="
				+ enrollDate + ", accountFileUrl=" + accountFileUrl + "]";
	}
	
	
}
