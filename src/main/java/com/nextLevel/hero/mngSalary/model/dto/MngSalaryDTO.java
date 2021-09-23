package com.nextLevel.hero.mngSalary.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MngSalaryDTO implements Serializable{

	private MemberInfoDTO memberInfo;
	private String departmentName;
	private int salaryStepByRank;
	private String rank;
	private	String salaryStep;
	private java.sql.Date salaryStepUpdatedDate;
	private java.sql.Date changeStartDate;
	
	public MngSalaryDTO() {}

	public MngSalaryDTO(MemberInfoDTO memberInfo, String departmentName, int salaryStepByRank, String rank,
			String salaryStep, Date salaryStepUpdatedDate, Date changeStartDate) {
		super();
		this.memberInfo = memberInfo;
		this.departmentName = departmentName;
		this.salaryStepByRank = salaryStepByRank;
		this.rank = rank;
		this.salaryStep = salaryStep;
		this.salaryStepUpdatedDate = salaryStepUpdatedDate;
		this.changeStartDate = changeStartDate;
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

	public int getSalaryStepByRank() {
		return salaryStepByRank;
	}

	public void setSalaryStepByRank(int salaryStepByRank) {
		this.salaryStepByRank = salaryStepByRank;
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

	public java.sql.Date getSalaryStepUpdatedDate() {
		return salaryStepUpdatedDate;
	}

	public void setSalaryStepUpdatedDate(java.sql.Date salaryStepUpdatedDate) {
		this.salaryStepUpdatedDate = salaryStepUpdatedDate;
	}

	public java.sql.Date getChangeStartDate() {
		return changeStartDate;
	}

	public void setChangeStartDate(java.sql.Date changeStartDate) {
		this.changeStartDate = changeStartDate;
	}

	@Override
	public String toString() {
		return "MngSalaryDTO [memberInfo=" + memberInfo + ", departmentName=" + departmentName + ", salaryStepByRank="
				+ salaryStepByRank + ", rank=" + rank + ", salaryStep=" + salaryStep + ", salaryStepUpdatedDate="
				+ salaryStepUpdatedDate + ", changeStartDate=" + changeStartDate + "]";
	}

	

	
}
