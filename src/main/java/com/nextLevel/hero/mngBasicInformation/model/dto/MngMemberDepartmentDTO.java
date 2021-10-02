package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;

public class MngMemberDepartmentDTO implements Serializable{

	private int companyNo;
	private int departmentNo;
	private String departmentName;
	private String koreanName;
	private int memberNo;
	private String jobName;
	
	public MngMemberDepartmentDTO() {}
	
	public MngMemberDepartmentDTO(int companyNo, int departmentNo, String departmentName, String koreanName,
			int memberNo, String jobName) {
		super();
		this.companyNo = companyNo;
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
		this.koreanName = koreanName;
		this.memberNo = memberNo;
		this.jobName = jobName;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "MngMemberDepartmentDTO [companyNo=" + companyNo + ", departmentNo=" + departmentNo + ", departmentName="
				+ departmentName + ", koreanName=" + koreanName + ", memberNo=" + memberNo + ", jobName=" + jobName
				+ "]";
	}
	
	
	
}
