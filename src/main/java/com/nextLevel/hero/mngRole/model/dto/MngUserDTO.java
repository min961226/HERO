package com.nextLevel.hero.mngRole.model.dto;

import java.util.List;

public class MngUserDTO {
	
	private int companyNo;
	private String name;
	private int memberNo;
	private String departmentName;
	
	public MngUserDTO() {
		super();
	}

	public MngUserDTO(int companyNo, String name, int memberNo, String departmentName) {
		super();
		this.companyNo = companyNo;
		this.name = name;
		this.memberNo = memberNo;
		this.departmentName = departmentName;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "MngUserDTO [companyNo=" + companyNo + ", name=" + name + ", memberNo=" + memberNo + ", departmentName="
				+ departmentName + "]";
	}

	
	

}
