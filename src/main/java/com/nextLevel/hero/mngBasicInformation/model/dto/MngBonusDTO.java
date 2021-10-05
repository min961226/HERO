package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;

public class MngBonusDTO implements Serializable{

	private int companyNo;
	private int bonusNo;
	private String bonusName;
	private String regularlyYn;
	private String payPeriod;
	private int bonusAmount;
	private char useYn;
	
	public MngBonusDTO() {}
	
	public MngBonusDTO(int companyNo, int bonusNo, String bonusName, String regularlyYn, String payPeriod,
			int bonusAmount, char useYn) {
		super();
		this.companyNo = companyNo;
		this.bonusNo = bonusNo;
		this.bonusName = bonusName;
		this.regularlyYn = regularlyYn;
		this.payPeriod = payPeriod;
		this.bonusAmount = bonusAmount;
		this.useYn = useYn;
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
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


	public String getRegularlyYn() {
		return regularlyYn;
	}


	public void setRegularlyYn(String regularlyYn) {
		this.regularlyYn = regularlyYn;
	}


	public String getPayPeriod() {
		return payPeriod;
	}


	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}


	public int getBonusAmount() {
		return bonusAmount;
	}


	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}


	public char getUseYn() {
		return useYn;
	}


	public void setUseYn(char useYn) {
		this.useYn = useYn;
	}


	@Override
	public String toString() {
		return "MngBonusDTO [companyNo=" + companyNo + ", bonusNo=" + bonusNo + ", bonusName=" + bonusName
				+ ", regularlyYn=" + regularlyYn + ", payPeriod=" + payPeriod + ", bonusAmount=" + bonusAmount
				+ ", useYn=" + useYn + "]";
	}
	
	
	
}
