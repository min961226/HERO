package com.nextLevel.hero.mngSalary.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.NoArgsConstructor;

public class SeverancePayDTO implements Serializable{

	
	private int companyNo;
	private int idNo;
	private int memberNo;
	private String memberName;
	private String memberDept;
	private char severanceStatus;
	
	public SeverancePayDTO(int companyNo, int idNo, int memberNo, String memberName, String memberDept,
			char severanceStatus) {
		super();
		this.companyNo = companyNo;
		this.idNo = idNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberDept = memberDept;
		this.severanceStatus = severanceStatus;
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
	public String getMemberDept() {
		return memberDept;
	}
	public void setMemberDept(String memberDept) {
		this.memberDept = memberDept;
	}
	public char getSeveranceStatus() {
		return severanceStatus;
	}
	public void setSeveranceStatus(char severanceStatus) {
		this.severanceStatus = severanceStatus;
	}
	@Override
	public String toString() {
		return "SeverancePayDTO [companyNo=" + companyNo + ", idNo=" + idNo + ", memberNo=" + memberNo + ", memberName="
				+ memberName + ", memberDept=" + memberDept + ", severanceStatus=" + severanceStatus + "]";
	}
	
	
	
	
	
	
	
	
	
}
