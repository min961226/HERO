package com.nextLevel.hero.basicSetting.model.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcelIncomeTax {

	private int companyNo;
	private Integer divNo;
	private Integer salaryMin;
	private Integer salaryMax;
	private Integer salaryTax;
	private java.util.Date startDate;
	
	public ExcelIncomeTax() {}

	public int getCompanyNo() {
		return companyNo;
	}

	public Integer getDivNo() {
		return divNo;
	}

	public void setDivNo(Integer divNo) {
		this.divNo = divNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public Integer getSalaryMin() {
		return salaryMin;
	}

	public void setSalaryMin(Integer salaryMin) {
		this.salaryMin = salaryMin;
	}

	public Integer getSalaryMax() {
		return salaryMax;
	}

	public void setSalaryMax(Integer salaryMax) {
		this.salaryMax = salaryMax;
	}

	public Integer getSalaryTax() {
		return salaryTax;
	}

	public void setSalaryTax(Integer salaryTax) {
		this.salaryTax = salaryTax;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.util.Date date) {
		this.startDate = date;
	}

	
	
	
	
	
}
