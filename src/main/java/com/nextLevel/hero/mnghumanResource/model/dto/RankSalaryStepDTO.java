package com.nextLevel.hero.mnghumanResource.model.dto;

import java.sql.Date;

public class RankSalaryStepDTO {

	private int companyNo;				//회사번호
	private int salaryStepByRank;		//직급별호봉
	private String rank;				//직급
	private String salaryStep;			//호봉
	private java.sql.Date startDate;	//적용일시
	private int amount;					//금액
	private char tblUserAuth;			//권한생성여부
	
	public RankSalaryStepDTO() {}

	public RankSalaryStepDTO(int companyNo, int salaryStepByRank, String rank, String salaryStep, Date startDate,
			int amount, char tblUserAuth) {
		super();
		this.companyNo = companyNo;
		this.salaryStepByRank = salaryStepByRank;
		this.rank = rank;
		this.salaryStep = salaryStep;
		this.startDate = startDate;
		this.amount = amount;
		this.tblUserAuth = tblUserAuth;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
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

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public char getTblUserAuth() {
		return tblUserAuth;
	}

	public void setTblUserAuth(char tblUserAuth) {
		this.tblUserAuth = tblUserAuth;
	}

	@Override
	public String toString() {
		return "RankSalaryStepDTO [companyNo=" + companyNo + ", salaryStepByRank=" + salaryStepByRank + ", rank=" + rank
				+ ", salaryStep=" + salaryStep + ", startDate=" + startDate + ", amount=" + amount + ", tblUserAuth="
				+ tblUserAuth + "]";
	}
	
}
