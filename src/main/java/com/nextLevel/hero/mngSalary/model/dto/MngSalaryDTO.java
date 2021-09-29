package com.nextLevel.hero.mngSalary.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MngSalaryDTO implements Serializable{

	private String searchDate;					//검색 일자
	private String searchCondition;						//검색 조건
	private String searchValue;							//검색어
	private int companyNo;								//회사번호
	private int memberNo;
	private MemberInfoDTO memberInfo;					//직원정보
	private String departmentName;						//부서명
	private int salaryStepByRank;						//직급별 호봉
	private String rank;								//직급
	private	String salaryStep;							//호봉
	private int salStepAmount;							//호봉금액
	private java.sql.Date salaryStepUpdatedDate;		//호봉승급일	
	private java.sql.Date changeStartDate;				//변경일시
	private MemberMonthlyPayDTO monthlyPay;				//월지급
	private int annualSal;								//연봉
	
	
	
	public MngSalaryDTO() {}



	public MngSalaryDTO(String searchDate, String searchCondition, String searchValue, int companyNo, int memberNo,
			MemberInfoDTO memberInfo, String departmentName, int salaryStepByRank, String rank, String salaryStep,
			int salStepAmount, Date salaryStepUpdatedDate, Date changeStartDate, MemberMonthlyPayDTO monthlyPay,
			int annualSal) {
		super();
		this.searchDate = searchDate;
		this.searchCondition = searchCondition;
		this.searchValue = searchValue;
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.memberInfo = memberInfo;
		this.departmentName = departmentName;
		this.salaryStepByRank = salaryStepByRank;
		this.rank = rank;
		this.salaryStep = salaryStep;
		this.salStepAmount = salStepAmount;
		this.salaryStepUpdatedDate = salaryStepUpdatedDate;
		this.changeStartDate = changeStartDate;
		this.monthlyPay = monthlyPay;
		this.annualSal = annualSal;
	}



	public String getSearchDate() {
		return searchDate;
	}



	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}



	public String getSearchCondition() {
		return searchCondition;
	}



	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}



	public String getSearchValue() {
		return searchValue;
	}



	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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



	public MemberInfoDTO getMemberInfo() {
		return memberInfo;
	}



	public void setMemberInfo(MemberInfoDTO memberInfo) {
		this.memberInfo = memberInfo;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public int getSalaryStepByRank() {
		return salaryStepByRank;
	}



	public void setSalaryStepByRank(int salaryStepByRank) {
		this.salaryStepByRank = salaryStepByRank;
	}



	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}



	public String getSalaryStep() {
		return salaryStep;
	}



	public void setSalaryStep(String salaryStep) {
		this.salaryStep = salaryStep;
	}



	public int getSalStepAmount() {
		return salStepAmount;
	}



	public void setSalStepAmount(int salStepAmount) {
		this.salStepAmount = salStepAmount;
	}



	public java.sql.Date getSalaryStepUpdatedDate() {
		return salaryStepUpdatedDate;
	}



	public void setSalaryStepUpdatedDate(java.sql.Date salaryStepUpdatedDate) {
		this.salaryStepUpdatedDate = salaryStepUpdatedDate;
	}



	public java.sql.Date getChangeStartDate() {
		return changeStartDate;
	}



	public void setChangeStartDate(java.sql.Date changeStartDate) {
		this.changeStartDate = changeStartDate;
	}



	public MemberMonthlyPayDTO getMonthlyPay() {
		return monthlyPay;
	}



	public void setMonthlyPay(MemberMonthlyPayDTO monthlyPay) {
		this.monthlyPay = monthlyPay;
	}



	public int getAnnualSal() {
		return annualSal;
	}



	public void setAnnualSal(int annualSal) {
		this.annualSal = annualSal;
	}



	@Override
	public String toString() {
		return "MngSalaryDTO [searchDate=" + searchDate + ", searchCondition=" + searchCondition + ", searchValue="
				+ searchValue + ", companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberInfo=" + memberInfo
				+ ", departmentName=" + departmentName + ", salaryStepByRank=" + salaryStepByRank + ", rank=" + rank
				+ ", salaryStep=" + salaryStep + ", salStepAmount=" + salStepAmount + ", salaryStepUpdatedDate="
				+ salaryStepUpdatedDate + ", changeStartDate=" + changeStartDate + ", monthlyPay=" + monthlyPay
				+ ", annualSal=" + annualSal + "]";
	}


	

}
