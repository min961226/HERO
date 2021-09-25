package com.nextLevel.hero.mngRole.model.dto;

public class MngRankAuthDTO {
	
	private int companyNo;
	private int authorityNo;
	private String rank;
	private String createdAuthorityStatus;
	
	public MngRankAuthDTO() {
		super();
	}

	public MngRankAuthDTO(int companyNo, int authorityNo, String rank, String createdAuthorityStatus) {
		super();
		this.companyNo = companyNo;
		this.authorityNo = authorityNo;
		this.rank = rank;
		this.createdAuthorityStatus = createdAuthorityStatus;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getAuthorityNo() {
		return authorityNo;
	}

	public void setAuthorityNo(int authorityNo) {
		this.authorityNo = authorityNo;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getCreatedAuthorityStatus() {
		return createdAuthorityStatus;
	}

	public void setCreatedAuthorityStatus(String createdAuthorityStatus) {
		this.createdAuthorityStatus = createdAuthorityStatus;
	}

	@Override
	public String toString() {
		return "MngRankAuthDTO [companyNo=" + companyNo + ", authorityNo=" + authorityNo + ", rank=" + rank
				+ ", createdAuthorityStatus=" + createdAuthorityStatus + "]";
	}
	
	
	

}
