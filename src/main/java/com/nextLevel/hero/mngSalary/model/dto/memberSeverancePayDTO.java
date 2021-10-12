package com.nextLevel.hero.mngSalary.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.NoArgsConstructor;

public class memberSeverancePayDTO implements Serializable{

	
	private int companyNo;
	private int idNo;
	private int memberNo;
	private int sumSalAmount;
	public memberSeverancePayDTO(int companyNo, int idNo, int memberNo, int sumSalAmount) {
		super();
		this.companyNo = companyNo;
		this.idNo = idNo;
		this.memberNo = memberNo;
		this.sumSalAmount = sumSalAmount;
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
	public int getSumSalAmount() {
		return sumSalAmount;
	}
	public void setSumSalAmount(int sumSalAmount) {
		this.sumSalAmount = sumSalAmount;
	}
	@Override
	public String toString() {
		return "memberSeverancePayDTO [companyNo=" + companyNo + ", idNo=" + idNo + ", memberNo=" + memberNo
				+ ", sumSalAmount=" + sumSalAmount + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
