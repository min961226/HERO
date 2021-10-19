package com.nextLevel.hero.mngWorkAttitude.model.dto;

public class MngUpdateDTO {
	
	private int memberNo;
	private int companyNo;
	private String updateDate;
	private String goTime;
	private String offTime;
	private String name;
	
	public MngUpdateDTO() {
		super();
	}

	public MngUpdateDTO(int memberNo, int companyNo, String updateDate, String goTime, String offTime, String name) {
		super();
		this.memberNo = memberNo;
		this.companyNo = companyNo;
		this.updateDate = updateDate;
		this.goTime = goTime;
		this.offTime = offTime;
		this.name = name;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getGoTime() {
		return goTime;
	}

	public void setGoTime(String goTime) {
		this.goTime = goTime;
	}

	public String getOffTime() {
		return offTime;
	}

	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MngUpdateDTO [memberNo=" + memberNo + ", companyNo=" + companyNo + ", updateDate=" + updateDate
				+ ", goTime=" + goTime + ", offTime=" + offTime + ", name=" + name + "]";
	}

	
	
}
