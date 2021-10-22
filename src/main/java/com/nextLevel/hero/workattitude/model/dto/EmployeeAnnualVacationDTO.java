package com.nextLevel.hero.workattitude.model.dto;

import java.io.Serializable;

import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;

public class EmployeeAnnualVacationDTO implements Serializable{

	private int companyNo;								// 회사번호
	private int memberNo;								// 사번
	private int createdMonthlyVacation;					// 발생월차
	private int totalVacation;							// 총연차
	private int usedVacation;							// 사용연차
	private int leaveVacation;							// 잔여연차
	private int idNo;									// 계정번호
	private int vacationCode;							// 조정연차코드
	private MngMemberDepartmentDTO mngMemberDepartment; //mngBasicInformation에 있음	// 직원의 이름&부서를 받아오려고 -> mapper.xml에서 Association 해야함
	
	public EmployeeAnnualVacationDTO() {}

	public EmployeeAnnualVacationDTO(int companyNo, int memberNo, int createdMonthlyVacation, int totalVacation,
			int usedVacation, int leaveVacation, int idNo, int vacationCode,
			MngMemberDepartmentDTO mngMemberDepartment) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.createdMonthlyVacation = createdMonthlyVacation;
		this.totalVacation = totalVacation;
		this.usedVacation = usedVacation;
		this.leaveVacation = leaveVacation;
		this.idNo = idNo;
		this.vacationCode = vacationCode;
		this.mngMemberDepartment = mngMemberDepartment;
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

	public int getUsedVacation() {
		return usedVacation;
	}

	public int getLeaveVacation() {
		return leaveVacation;
	}

	public int getIdNo() {
		return idNo;
	}

	public int getVacationCode() {
		return vacationCode;
	}

	public MngMemberDepartmentDTO getMngMemberDepartment() {
		return mngMemberDepartment;
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

	public void setUsedVacation(int usedVacation) {
		this.usedVacation = usedVacation;
	}

	public void setLeaveVacation(int leaveVacation) {
		this.leaveVacation = leaveVacation;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public void setVacationCode(int vacationCode) {
		this.vacationCode = vacationCode;
	}

	public void setMngMemberDepartment(MngMemberDepartmentDTO mngMemberDepartment) {
		this.mngMemberDepartment = mngMemberDepartment;
	}

	@Override
	public String toString() {
		return "EmployeeAnnualVacationDTO [companyNo=" + companyNo + ", memberNo=" + memberNo
				+ ", createdMonthlyVacation=" + createdMonthlyVacation + ", totalVacation=" + totalVacation
				+ ", usedVacation=" + usedVacation + ", leaveVacation=" + leaveVacation + ", idNo=" + idNo
				+ ", vacationCode=" + vacationCode + ", mngMemberDepartment=" + mngMemberDepartment + "]";
	}
	
	
	
	
	
}








