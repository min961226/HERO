package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BusinessDTO implements Serializable{
	
	private int idx;
	private String businessName;
	private String businessDetail;
	private BigDecimal industryRate;
	
	private String keyword;
	
	public BusinessDTO() {}

	public BusinessDTO(int idx, String businessName, String businessDetail, BigDecimal industryRate, String keyword) {
		super();
		this.idx = idx;
		this.businessName = businessName;
		this.businessDetail = businessDetail;
		this.industryRate = industryRate;
		this.keyword = keyword;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessDetail() {
		return businessDetail;
	}

	public void setBusinessDetail(String businessDetail) {
		this.businessDetail = businessDetail;
	}

	public BigDecimal getIndustryRate() {
		return industryRate;
	}

	public void setIndustryRate(BigDecimal industryRate) {
		this.industryRate = industryRate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "BusinessDTO [idx=" + idx + ", businessName=" + businessName + ", businessDetail=" + businessDetail
				+ ", industryRate=" + industryRate + ", keyword=" + keyword + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
