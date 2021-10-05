package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;

public class MngVacationTypeDTO implements Serializable{

	private int companyNo;
	private int vacationNo;
	private String vacationCategory;
	private String vacationName;
	private String vacationSettingWay;
	private int vacationDate;
	private char paidVacationYn;
	private String settingGender;
	
	public MngVacationTypeDTO() {}

	public MngVacationTypeDTO(int companyNo, int vacationNo, String vacationCategory, String vacationName,
			String vacationSettingWay, int vacationDate, char paidVacationYn, String settingGender) {
		super();
		this.companyNo = companyNo;
		this.vacationNo = vacationNo;
		this.vacationCategory = vacationCategory;
		this.vacationName = vacationName;
		this.vacationSettingWay = vacationSettingWay;
		this.vacationDate = vacationDate;
		this.paidVacationYn = paidVacationYn;
		this.settingGender = settingGender;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getVacationNo() {
		return vacationNo;
	}

	public void setVacationNo(int vacationNo) {
		this.vacationNo = vacationNo;
	}

	public String getVacationCategory() {
		return vacationCategory;
	}

	public void setVacationCategory(String vacationCategory) {
		this.vacationCategory = vacationCategory;
	}

	public String getVacationName() {
		return vacationName;
	}

	public void setVacationName(String vacationName) {
		this.vacationName = vacationName;
	}

	public String getVacationSettingWay() {
		return vacationSettingWay;
	}

	public void setVacationSettingWay(String vacationSettingWay) {
		this.vacationSettingWay = vacationSettingWay;
	}

	public int getVacationDate() {
		return vacationDate;
	}

	public void setVacationDate(int vacationDate) {
		this.vacationDate = vacationDate;
	}

	public char getPaidVacationYn() {
		return paidVacationYn;
	}

	public void setPaidVacationYn(char paidVacationYn) {
		this.paidVacationYn = paidVacationYn;
	}

	public String getSettingGender() {
		return settingGender;
	}

	public void setSettingGender(String settingGender) {
		this.settingGender = settingGender;
	}

	@Override
	public String toString() {
		return "MngVacationTypeDTO [companyNo=" + companyNo + ", vacationNo=" + vacationNo + ", vacationCategory="
				+ vacationCategory + ", vacationName=" + vacationName + ", vacationSettingWay=" + vacationSettingWay
				+ ", vacationDate=" + vacationDate + ", paidVacationYn=" + paidVacationYn + ", settingGender="
				+ settingGender + "]";
	}

	

	
	
	
}
