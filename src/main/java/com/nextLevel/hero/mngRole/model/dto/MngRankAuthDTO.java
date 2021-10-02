package com.nextLevel.hero.mngRole.model.dto;

import java.util.List;

public class MngRankAuthDTO {
	
	private int companyNo;					//회사번호
	private int salaryStepByRank;			//직급별호봉
	private int authoryityNo;				//권한번호
	private String rankName;				//직급이름
	private char tblUserAuth;				//권한생성여부
	
	private List<MngRankAuthDTO> salaryStepByRankArg;			//직급별호봉
	private List<MngRankAuthDTO> authoryityNoArg;				//권한번호

	public MngRankAuthDTO() {}

	public MngRankAuthDTO(int companyNo, int salaryStepByRank, int authoryityNo, String rankName, char tblUserAuth,
			List<MngRankAuthDTO> salaryStepByRankArg, List<MngRankAuthDTO> authoryityNoArg) {
		super();
		this.companyNo = companyNo;
		this.salaryStepByRank = salaryStepByRank;
		this.authoryityNo = authoryityNo;
		this.rankName = rankName;
		this.tblUserAuth = tblUserAuth;
		this.salaryStepByRankArg = salaryStepByRankArg;
		this.authoryityNoArg = authoryityNoArg;
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

	public int getAuthoryityNo() {
		return authoryityNo;
	}

	public void setAuthoryityNo(int authoryityNo) {
		this.authoryityNo = authoryityNo;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public char getTblUserAuth() {
		return tblUserAuth;
	}

	public void setTblUserAuth(char tblUserAuth) {
		this.tblUserAuth = tblUserAuth;
	}

	public List<MngRankAuthDTO> getSalaryStepByRankArg() {
		return salaryStepByRankArg;
	}

	public void setSalaryStepByRankArg(List<MngRankAuthDTO> salaryStepByRankArg) {
		this.salaryStepByRankArg = salaryStepByRankArg;
	}

	public List<MngRankAuthDTO> getAuthoryityNoArg() {
		return authoryityNoArg;
	}

	public void setAuthoryityNoArg(List<MngRankAuthDTO> authoryityNoArg) {
		this.authoryityNoArg = authoryityNoArg;
	}

	@Override
	public String toString() {
		return "MngRankAuthDTO [companyNo=" + companyNo + ", salaryStepByRank=" + salaryStepByRank + ", authoryityNo="
				+ authoryityNo + ", rankName=" + rankName + ", tblUserAuth=" + tblUserAuth + ", salaryStepByRankArg="
				+ salaryStepByRankArg + ", authoryityNoArg=" + authoryityNoArg + "]";
	}

	

}
