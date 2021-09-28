package com.nextLevel.hero.mngVacation.model.dto;

import java.io.Serializable;

public class AnnualVacationDTO implements Serializable{

	/* 연차 조정 */
	/* 다시 디비보고 확인 */
	private int companyNo;						// 회사번호
	private int memberNo;						// 사번
	private int createdMonthlyVacation;			// 발생월차
	private int totalVacation;					// 총연차
	private int controlledVacation;				// 조정연차
	private int usedVacation;					// 사용연차
	private int leaveVacation;					// 잔여연차
	private int departmentNo;					// 부서번호
	
	public AnnualVacationDTO() {}

	public AnnualVacationDTO(int companyNo, int memberNo, int createdMonthlyVacation, int totalVacation,
			int controlledVacation, int usedVacation, int leaveVacation, int departmentNo) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.createdMonthlyVacation = createdMonthlyVacation;
		this.totalVacation = totalVacation;
		this.controlledVacation = controlledVacation;
		this.usedVacation = usedVacation;
		this.leaveVacation = leaveVacation;
		this.departmentNo = departmentNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public int getCreatedMonthlyVacation() {
		return createdMonthlyVacation;
	}

	public int getTotalVacation() {
		return totalVacation;
	}

	public int getControlledVacation() {
		return controlledVacation;
	}

	public int getUsedVacation() {
		return usedVacation;
	}

	public int getLeaveVacation() {
		return leaveVacation;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setCreatedMonthlyVacation(int createdMonthlyVacation) {
		this.createdMonthlyVacation = createdMonthlyVacation;
	}

	public void setTotalVacation(int totalVacation) {
		this.totalVacation = totalVacation;
	}

	public void setControlledVacation(int controlledVacation) {
		this.controlledVacation = controlledVacation;
	}

	public void setUsedVacation(int usedVacation) {
		this.usedVacation = usedVacation;
	}

	public void setLeaveVacation(int leaveVacation) {
		this.leaveVacation = leaveVacation;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	@Override
	public String toString() {
		return "AnnualVacationDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", createdMonthlyVacation="
				+ createdMonthlyVacation + ", totalVacation=" + totalVacation + ", controlledVacation="
				+ controlledVacation + ", usedVacation=" + usedVacation + ", leaveVacation=" + leaveVacation
				+ ", departmentNo=" + departmentNo + "]";
	}
	
	
	
}
