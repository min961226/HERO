package com.nextLevel.hero.workattitude.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class EmployeeVacationDTO implements Serializable {
	
	private int resquestNo;					//신청번호
	private int companyNo;					//회사번호
	private int memberNo;					//사번
	private String vacationCategory;		//휴가종류
	private java.sql.Date startDate;		//휴가시작일
	private java.sql.Date endDate;			//휴가종료일
	private String vacationContents;		//휴가내용
	private String confirmedYn;				//승인여부
	private int idNo;						//계정번호
	private int vacationDate;				//휴가일수
	private String koreanName;				//사원이름
	private String departmentName;			//부서명
	
	public EmployeeVacationDTO() {}

	

	public EmployeeVacationDTO(int resquestNo, int companyNo, int memberNo, String vacationCategory, Date startDate,
			Date endDate, String vacationContents, String confirmedYn, int idNo, int vacationDate, String koreanName,
			String departmentName) {
		super();
		this.resquestNo = resquestNo;
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.vacationCategory = vacationCategory;
		this.startDate = startDate;
		this.endDate = endDate;
		this.vacationContents = vacationContents;
		this.confirmedYn = confirmedYn;
		this.idNo = idNo;
		this.vacationDate = vacationDate;
		this.koreanName = koreanName;
		this.departmentName = departmentName;
	}



	public String getKoreanName() {
		return koreanName;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public int getResquestNo() {
		return resquestNo;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public String getVacationCategory() {
		return vacationCategory;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public String getVacationContents() {
		return vacationContents;
	}

	public String getConfirmedYn() {
		return confirmedYn;
	}

	public int getIdNo() {
		return idNo;
	}

	public int getVacationDate() {
		return vacationDate;
	}

	public void setResquestNo(int resquestNo) {
		this.resquestNo = resquestNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setVacationCategory(String vacationCategory) {
		this.vacationCategory = vacationCategory;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}

	public void setVacationContents(String vacationContents) {
		this.vacationContents = vacationContents;
	}

	public void setConfirmedYn(String confirmedYn) {
		this.confirmedYn = confirmedYn;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public void setVacationDate(int vacationDate) {
		this.vacationDate = vacationDate;
	}

	@Override
	public String toString() {
		return "EmployeeVacationDTO [resquestNo=" + resquestNo + ", companyNo=" + companyNo + ", memberNo=" + memberNo
				+ ", vacationCategory=" + vacationCategory + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", vacationContents=" + vacationContents + ", confirmedYn=" + confirmedYn + ", idNo=" + idNo
				+ ", vacationDate=" + vacationDate + ", koreanName=" + koreanName + ", departmentName=" + departmentName
				+ "]";
	}


		
	

}









