package com.nextLevel.hero.mngRole.model.dto;

import java.util.Arrays;
import java.util.List;

public class MngRankAuthDTO {
	
	private int companyNo;					//회사번호
	private int[] salaryStepByRank;			//직급별호봉
	private int[] authoryityNo;				//권한번호
	private String rankName;				//직급이름
	
	public MngRankAuthDTO() {}

	public MngRankAuthDTO(int companyNo, int[] salaryStepByRank, int[] authoryityNo, String rankName) {
		super();
		this.companyNo = companyNo;
		this.salaryStepByRank = salaryStepByRank;
		this.authoryityNo = authoryityNo;
		this.rankName = rankName;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int[] getSalaryStepByRank() {
		return salaryStepByRank;
	}

	public void setSalaryStepByRank(int[] salaryStepByRank) {
		this.salaryStepByRank = salaryStepByRank;
	}

	public int[] getAuthoryityNo() {
		return authoryityNo;
	}

	public void setAuthoryityNo(int[] authoryityNo) {
		this.authoryityNo = authoryityNo;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	@Override
	public String toString() {
		return "MngRankAuthDTO [companyNo=" + companyNo + ", salaryStepByRank=" + Arrays.toString(salaryStepByRank)
				+ ", authoryityNo=" + Arrays.toString(authoryityNo) + ", rankName=" + rankName + "]";
	}

	
	

}
