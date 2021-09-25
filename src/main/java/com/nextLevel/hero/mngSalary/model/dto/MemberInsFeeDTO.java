package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MemberInsFeeDTO {

	private MemberInfoDTO memberInfo;
	private String departmentName;
	private java.sql.Date healthCoverDate;
	private int healthSal;
	private int healthInsFee;
	private int longtermFee;
	private java.sql.Date pensionCoverDate;
	private int pensionSal;
	private int pensionFee;
	
	public MemberInsFeeDTO() {}

	public MemberInsFeeDTO(MemberInfoDTO memberInfo, String departmentName, Date healthCoverDate, int healthSal,
			int healthInsFee, int longtermFee, Date pensionCoverDate, int pensionSal, int pensionFee) {
		super();
		this.memberInfo = memberInfo;
		this.departmentName = departmentName;
		this.healthCoverDate = healthCoverDate;
		this.healthSal = healthSal;
		this.healthInsFee = healthInsFee;
		this.longtermFee = longtermFee;
		this.pensionCoverDate = pensionCoverDate;
		this.pensionSal = pensionSal;
		this.pensionFee = pensionFee;
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

	public java.sql.Date getHealthCoverDate() {
		return healthCoverDate;
	}

	public void setHealthCoverDate(java.sql.Date healthCoverDate) {
		this.healthCoverDate = healthCoverDate;
	}

	public int getHealthSal() {
		return healthSal;
	}

	public void setHealthSal(int healthSal) {
		this.healthSal = healthSal;
	}

	public int getHealthInsFee() {
		return healthInsFee;
	}

	public void setHealthInsFee(int healthInsFee) {
		this.healthInsFee = healthInsFee;
	}

	public int getLongtermFee() {
		return longtermFee;
	}

	public void setLongtermFee(int longtermFee) {
		this.longtermFee = longtermFee;
	}

	public java.sql.Date getPensionCoverDate() {
		return pensionCoverDate;
	}

	public void setPensionCoverDate(java.sql.Date pensionCoverDate) {
		this.pensionCoverDate = pensionCoverDate;
	}

	public int getPensionSal() {
		return pensionSal;
	}

	public void setPensionSal(int pensionSal) {
		this.pensionSal = pensionSal;
	}

	public int getPensionFee() {
		return pensionFee;
	}

	public void setPensionFee(int pensionFee) {
		this.pensionFee = pensionFee;
	}

	@Override
	public String toString() {
		return "MemberInsFeeDTO [memberInfo=" + memberInfo + ", departmentName=" + departmentName + ", healthCoverDate="
				+ healthCoverDate + ", healthSal=" + healthSal + ", healthInsFee=" + healthInsFee + ", longtermFee="
				+ longtermFee + ", pensionCoverDate=" + pensionCoverDate + ", pensionSal=" + pensionSal
				+ ", pensionFee=" + pensionFee + "]";
	}
	
	
}
