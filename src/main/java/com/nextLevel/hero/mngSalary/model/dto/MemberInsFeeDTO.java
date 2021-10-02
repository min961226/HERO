package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MemberInsFeeDTO {

	private String searchDate;							//검색 일자
	private String searchCondition;						//검색 조건
	private String searchValue;							//검색어
	private int companyNo;
	private int memberNo;
	private String memberName;
	private java.sql.Date hireDate;
	private String departmentName;
	private java.sql.Date healthCoverDate;
	private int healthSal;
	private int healthInsFee;
	private int longtermFee;
	private java.sql.Date pensionCoverDate;
	private int pensionSal;
	private int pensionFee;
	
	public MemberInsFeeDTO() {}

	public MemberInsFeeDTO(String searchDate, String searchCondition, String searchValue, int companyNo, int memberNo,
			String memberName, Date hireDate, String departmentName, Date healthCoverDate, int healthSal,
			int healthInsFee, int longtermFee, Date pensionCoverDate, int pensionSal, int pensionFee) {
		super();
		this.searchDate = searchDate;
		this.searchCondition = searchCondition;
		this.searchValue = searchValue;
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.hireDate = hireDate;
		this.departmentName = departmentName;
		this.healthCoverDate = healthCoverDate;
		this.healthSal = healthSal;
		this.healthInsFee = healthInsFee;
		this.longtermFee = longtermFee;
		this.pensionCoverDate = pensionCoverDate;
		this.pensionSal = pensionSal;
		this.pensionFee = pensionFee;
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
		return "MemberInsFeeDTO [searchDate=" + searchDate + ", searchCondition=" + searchCondition + ", searchValue="
				+ searchValue + ", companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", hireDate=" + hireDate + ", departmentName=" + departmentName + ", healthCoverDate="
				+ healthCoverDate + ", healthSal=" + healthSal + ", healthInsFee=" + healthInsFee + ", longtermFee="
				+ longtermFee + ", pensionCoverDate=" + pensionCoverDate + ", pensionSal=" + pensionSal
				+ ", pensionFee=" + pensionFee + "]";
	}

	
	
}
