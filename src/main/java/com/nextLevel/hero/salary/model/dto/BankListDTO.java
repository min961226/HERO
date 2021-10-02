package com.nextLevel.hero.salary.model.dto;

public class BankListDTO {

	private String code;
	private String bankName;
	
	
	public BankListDTO() {}

	public BankListDTO(String code, String bankName) {
		super();
		this.code = code;
		this.bankName = bankName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "BankListDTO [code=" + code + ", bankName=" + bankName + "]";
	}
	
	
}
