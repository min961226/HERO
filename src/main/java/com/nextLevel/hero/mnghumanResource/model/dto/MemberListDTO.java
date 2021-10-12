package com.nextLevel.hero.mnghumanResource.model.dto;

public class MemberListDTO {

	
	private int idNo;
	private String memberName;
	private String memberId;
	private String memberNo;
	private String departmentName;
	private String departmentPhone;
	
	
	public MemberListDTO() {}


	public MemberListDTO(int idNo, String memberName, String memberId, String memberNo, String departmentName,
			String departmentPhone) {
		super();
		this.idNo = idNo;
		this.memberName = memberName;
		this.memberId = memberId;
		this.memberNo = memberNo;
		this.departmentName = departmentName;
		this.departmentPhone = departmentPhone;
	}


	public int getIdNo() {
		return idNo;
	}


	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentPhone() {
		return departmentPhone;
	}


	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}


	@Override
	public String toString() {
		return "MemberListDTO [idNo=" + idNo + ", memberName=" + memberName + ", memberId=" + memberId + ", memberNo="
				+ memberNo + ", departmentName=" + departmentName + ", departmentPhone=" + departmentPhone + "]";
	}
	
}
