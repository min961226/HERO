package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MemberInfoDTO {

	private int companyNo;
	private int memberNo;
	private String memberName;
	private java.sql.Date hireDate;
	
	public MemberInfoDTO() {}

	public MemberInfoDTO(int companyNo, int memberNo, String memberName, Date hireDate) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.hireDate = hireDate;
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

	public java.sql.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.sql.Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "MemberInfoDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", hireDate=" + hireDate + "]";
	}

	
	
	
	
}
