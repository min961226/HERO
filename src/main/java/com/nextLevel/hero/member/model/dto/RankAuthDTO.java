package com.nextLevel.hero.member.model.dto;

public class RankAuthDTO {
	
	private int companyNo;
	private int salaryStepByRank;
	private int authorityNo;
	private String rankName;
	
	public RankAuthDTO() {
		super();
	}
	public RankAuthDTO(int companyNo, int salaryStepByRank, int authorityNo, String rankName) {
		super();
		this.companyNo = companyNo;
		this.salaryStepByRank = salaryStepByRank;
		this.authorityNo = authorityNo;
		this.rankName = rankName;
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
	public int getAuthorityNo() {
		return authorityNo;
	}
	public void setAuthorityNo(int authorityNo) {
		this.authorityNo = authorityNo;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	@Override
	public String toString() {
		return "RankAuthDTO [companyNo=" + companyNo + ", salaryStepByRank=" + salaryStepByRank + ", authorityNo="
				+ authorityNo + ", rankName=" + rankName + "]";
	}
	
	

}
