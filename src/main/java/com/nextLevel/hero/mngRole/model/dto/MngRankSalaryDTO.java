package com.nextLevel.hero.mngRole.model.dto;

public class MngRankSalaryDTO {
	
	private int companyNo;					//회사번호
	private int salaryStepByRank;			//직급별호봉
	private String rank;					//직급명
	private char tblUserAuth;				//권한생성여부
	
	public MngRankSalaryDTO() {
		super();
	}

	public MngRankSalaryDTO(int companyNo, int salaryStepByRank, String rank, char tblUserAuth) {
		super();
		this.companyNo = companyNo;
		this.salaryStepByRank = salaryStepByRank;
		this.rank = rank;
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

	public char getTblUserAuth() {
		return tblUserAuth;
	}

	public void setTblUserAuth(char tblUserAuth) {
		this.tblUserAuth = tblUserAuth;
	}

	@Override
	public String toString() {
		return "MngRankSalaryDTO [companyNo=" + companyNo + ", salaryStepByRank=" + salaryStepByRank + ", rank=" + rank
				+ ", tblUserAuth=" + tblUserAuth + "]";
	}

	
	

}
