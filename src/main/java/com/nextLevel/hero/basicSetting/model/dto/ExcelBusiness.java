package com.nextLevel.hero.basicSetting.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcelBusiness {

	private Integer businessCode;
	private Integer industryRate;
	private String typeOfBusiness;
	private String detailTypeOfBusiness;
	
	public ExcelBusiness() {}
	
	public Integer getBusinessCode() {
		return businessCode;
	}
	public void setBusinessCode(Integer businessCode) {
		this.businessCode = businessCode;
	}
	public Integer getIndustryRate() {
		return industryRate;
	}
	public void setIndustryRate(Integer industryRate) {
		this.industryRate = industryRate;
	}
	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}
	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}
	public String getDetailTypeOfBusiness() {
		return detailTypeOfBusiness;
	}
	public void setDetailTypeOfBusiness(String detailTypeOfBusiness) {
		this.detailTypeOfBusiness = detailTypeOfBusiness;
	}
	
	
}
