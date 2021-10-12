package com.nextLevel.hero.mngSalary.model.dto;

public class MngBonusListDTO {

	private int companyNo;							
	private String category;
	private int bonusNo;
	private String bonusName;
	private int bonusAmount;
	
	public MngBonusListDTO() {}

	public MngBonusListDTO(int companyNo, String category, int bonusNo, String bonusName, int bonusAmount) {
		super();
		this.companyNo = companyNo;
		this.category = category;
		this.bonusNo = bonusNo;
		this.bonusName = bonusName;
		this.bonusAmount = bonusAmount;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBonusNo() {
		return bonusNo;
	}

	public void setBonusNo(int bonusNo) {
		this.bonusNo = bonusNo;
	}

	public String getBonusName() {
		return bonusName;
	}

	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}

	public int getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	@Override
	public String toString() {
		return "MngBonusDTO [companyNo=" + companyNo + ", category=" + category + ", bonusNo=" + bonusNo
				+ ", bonusName=" + bonusName + ", bonusAmount=" + bonusAmount + "]";
	}
	
	
}
