package com.nextLevel.hero.mngSalary.model.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class FourInsRateDTO {

	private String searchDate;
	private int companyNo;
	private int divNo;
	private java.sql.Date insRateStartDate;
	private BigDecimal workersPensionRate;
	private BigDecimal workersHealthRate;
	private BigDecimal workersLongTermCareRate;
	private BigDecimal workersUnempRate;
	private BigDecimal under150EmpRate;
	private BigDecimal industryRate;
	
	public FourInsRateDTO() {}

	public FourInsRateDTO(String searchDate, int companyNo, int divNo, Date insRateStartDate,
			BigDecimal workersPensionRate, BigDecimal workersHealthRate, BigDecimal workersLongTermCareRate,
			BigDecimal workersUnempRate, BigDecimal under150EmpRate, BigDecimal industryRate) {
		super();
		this.searchDate = searchDate;
		this.companyNo = companyNo;
		this.divNo = divNo;
		this.insRateStartDate = insRateStartDate;
		this.workersPensionRate = workersPensionRate;
		this.workersHealthRate = workersHealthRate;
		this.workersLongTermCareRate = workersLongTermCareRate;
		this.workersUnempRate = workersUnempRate;
		this.under150EmpRate = under150EmpRate;
		this.industryRate = industryRate;
	}

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getDivNo() {
		return divNo;
	}

	public void setDivNo(int divNo) {
		this.divNo = divNo;
	}

	public java.sql.Date getInsRateStartDate() {
		return insRateStartDate;
	}

	public void setInsRateStartDate(java.sql.Date insRateStartDate) {
		this.insRateStartDate = insRateStartDate;
	}

	public BigDecimal getWorkersPensionRate() {
		return workersPensionRate;
	}

	public void setWorkersPensionRate(BigDecimal workersPensionRate) {
		this.workersPensionRate = workersPensionRate;
	}

	public BigDecimal getWorkersHealthRate() {
		return workersHealthRate;
	}

	public void setWorkersHealthRate(BigDecimal workersHealthRate) {
		this.workersHealthRate = workersHealthRate;
	}

	public BigDecimal getWorkersLongTermCareRate() {
		return workersLongTermCareRate;
	}

	public void setWorkersLongTermCareRate(BigDecimal workersLongTermCareRate) {
		this.workersLongTermCareRate = workersLongTermCareRate;
	}

	public BigDecimal getWorkersUnempRate() {
		return workersUnempRate;
	}

	public void setWorkersUnempRate(BigDecimal workersUnempRate) {
		this.workersUnempRate = workersUnempRate;
	}

	public BigDecimal getUnder150EmpRate() {
		return under150EmpRate;
	}

	public void setUnder150EmpRate(BigDecimal under150EmpRate) {
		this.under150EmpRate = under150EmpRate;
	}

	public BigDecimal getIndustryRate() {
		return industryRate;
	}

	public void setIndustryRate(BigDecimal industryRate) {
		this.industryRate = industryRate;
	}

	@Override
	public String toString() {
		return "FourInsRateDTO [searchDate=" + searchDate + ", companyNo=" + companyNo + ", divNo=" + divNo
				+ ", insRateStartDate=" + insRateStartDate + ", workersPensionRate=" + workersPensionRate
				+ ", workersHealthRate=" + workersHealthRate + ", workersLongTermCareRate=" + workersLongTermCareRate
				+ ", workersUnempRate=" + workersUnempRate + ", under150EmpRate=" + under150EmpRate + ", industryRate="
				+ industryRate + "]";
	}

	
}
