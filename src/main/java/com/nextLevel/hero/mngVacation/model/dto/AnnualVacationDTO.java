package com.nextLevel.hero.mngVacation.model.dto;

import java.io.Serializable;

import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;

public class AnnualVacationDTO implements Serializable{

	/* 연차 조정 */
	/* 다시 디비보고 확인 */
	private int companyNo;					// 회사번호
	private int memberNo;					// 사번
	private int createdMonthlyVacation;		// 발생월차
	private int totalVacation;				// 총연차
	private int usedVacation;				// 사용연차
	private int leaveVacation;				// 잔여연차
	private int idNo;						// 계정번호
	private int vacationCode;				// 조정연차코드
	private String departmentName;			// 부서명
	private String koreanName;				// 사원이름
	
	public AnnualVacationDTO() {}

	public AnnualVacationDTO(int companyNo, int memberNo, int createdMonthlyVacation, int totalVacation,
			int usedVacation, int leaveVacation, int idNo, int vacationCode, String departmentName, String koreanName) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.createdMonthlyVacation = createdMonthlyVacation;
		this.totalVacation = totalVacation;
		this.usedVacation = usedVacation;
		this.leaveVacation = leaveVacation;
		this.idNo = idNo;
		this.vacationCode = vacationCode;
		this.departmentName = departmentName;
		this.koreanName = koreanName;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public String getKoreanName() {
		return koreanName;
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

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	@Override
	public String toString() {
		return "AnnualVacationDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", createdMonthlyVacation="
				+ createdMonthlyVacation + ", totalVacation=" + totalVacation + ", usedVacation=" + usedVacation
				+ ", leaveVacation=" + leaveVacation + ", idNo=" + idNo + ", vacationCode=" + vacationCode
				+ ", departmentName=" + departmentName + ", koreanName=" + koreanName + "]";
	}

	
	
	
}
