package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MngDeductFourInsDTO {

	private int memberNo;
	private String memberName;
	private int companyNo;
	private int idNo;
	private int divNo;
	private String departmentName;
	private java.sql.Date validateDate;
	private String healthYn;
	private String pensionYn;
	private String unemployeeYn;
	private String industryYn;
	
	public MngDeductFourInsDTO() {}

	public MngDeductFourInsDTO(int memberNo, String memberName, int companyNo, int idNo, int divNo,
			String departmentName, Date validateDate, String healthYn, String pensionYn, String unemployeeYn,
			String industryYn) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.companyNo = companyNo;
		this.idNo = idNo;
		this.divNo = divNo;
		this.departmentName = departmentName;
		this.validateDate = validateDate;
		this.healthYn = healthYn;
		this.pensionYn = pensionYn;
		this.unemployeeYn = unemployeeYn;
		this.industryYn = industryYn;
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

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public int getDivNo() {
		return divNo;
	}

	public void setDivNo(int divNo) {
		this.divNo = divNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public java.sql.Date getValidateDate() {
		return validateDate;
	}

	public void setValidateDate(java.sql.Date validateDate) {
		this.validateDate = validateDate;
	}

	public String getHealthYn() {
		return healthYn;
	}

	public void setHealthYn(String healthYn) {
		this.healthYn = healthYn;
	}

	public String getPensionYn() {
		return pensionYn;
	}

	public void setPensionYn(String pensionYn) {
		this.pensionYn = pensionYn;
	}

	public String getUnemployeeYn() {
		return unemployeeYn;
	}

	public void setUnemployeeYn(String unemployeeYn) {
		this.unemployeeYn = unemployeeYn;
	}

	public String getIndustryYn() {
		return industryYn;
	}

	public void setIndustryYn(String industryYn) {
		this.industryYn = industryYn;
	}

	@Override
	public String toString() {
		return "MngDeductFourInsDTO [memberNo=" + memberNo + ", memberName=" + memberName + ", companyNo=" + companyNo
				+ ", idNo=" + idNo + ", divNo=" + divNo + ", departmentName=" + departmentName + ", validateDate="
				+ validateDate + ", healthYn=" + healthYn + ", pensionYn=" + pensionYn + ", unemployeeYn="
				+ unemployeeYn + ", industryYn=" + industryYn + "]";
	}

	
}
