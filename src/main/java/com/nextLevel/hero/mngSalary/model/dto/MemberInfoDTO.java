package com.nextLevel.hero.mngSalary.model.dto;

public class MemberInfoDTO {

	private int companyNo;
	private int memberNo;
	private String memberName;
	
	public MemberInfoDTO() {}

	public MemberInfoDTO(int companyNo, int memberNo, String memberName) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
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

	@Override
	public String toString() {
		return "MemberInfoDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberName=" + memberName + "]";
	}
	
	
	
}
