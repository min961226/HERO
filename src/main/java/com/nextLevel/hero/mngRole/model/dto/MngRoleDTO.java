package com.nextLevel.hero.mngRole.model.dto;

import java.io.Serializable;

public class MngRoleDTO implements Serializable{
	
	private int companyNo;				//회사번호
	private String rank;				//직업이름
	
	public MngRoleDTO() {
		super();
	}

	public MngRoleDTO(int companyNo, String rank) {
		super();
		this.companyNo = companyNo;
		this.rank = rank;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "MngRoleDTO [companyNo=" + companyNo + ", rank=" + rank + "]";
	}

	
	
	
	
}
