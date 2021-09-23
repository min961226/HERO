package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MngDeductFourInsDTO {

	private MemberInfoDTO memberInfo;
	private String departmentName;
	private java.sql.Date validateDate;
	private String healthYn;
	private String pensionYn;
	private String unemployeeYn;
	private String industryYn;
	
	public MngDeductFourInsDTO() {}

	public MngDeductFourInsDTO(MemberInfoDTO memberInfo, String departmentName, Date validateDate, String healthYn,
			String pensionYn, String unemployeeYn, String industryYn) {
		super();
		this.memberInfo = memberInfo;
		this.departmentName = departmentName;
		this.validateDate = validateDate;
		this.healthYn = healthYn;
		this.pensionYn = pensionYn;
		this.unemployeeYn = unemployeeYn;
		this.industryYn = industryYn;
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
		return "MngDeductFourInsDTO [memberInfo=" + memberInfo + ", departmentName=" + departmentName
				+ ", validateDate=" + validateDate + ", healthYn=" + healthYn + ", pensionYn=" + pensionYn
				+ ", unemployeeYn=" + unemployeeYn + ", industryYn=" + industryYn + "]";
	}
	
	
}
