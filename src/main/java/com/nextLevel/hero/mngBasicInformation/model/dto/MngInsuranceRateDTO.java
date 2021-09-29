package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class MngInsuranceRateDTO implements Serializable {

	private int companyNo;
	private int divNo;
	private Date insuranceRateStartDate;
	private BigDecimal nationalPensionRate;
	private BigDecimal workersPensionRate;
	private BigDecimal employerPensionRate;
	private BigDecimal healthRate;
	private BigDecimal workersHealthRate;
	private BigDecimal employerHealthRate;
	private BigDecimal longTermCareRate;
	private BigDecimal workersLongTermCareRate;
	private BigDecimal employerLongTermCareRate;
	private BigDecimal unempBenefitRate;
	private BigDecimal workersUnempRate;
	private BigDecimal employerUnempRate;
	private BigDecimal under150EmpRate;
	private BigDecimal over150PriorityEmpRate;
	private BigDecimal under1000EmpRate;
	private BigDecimal over1000EmpRate;
	private BigDecimal commuteAccidentRate;
	private char wageBondChargesYn;
	private BigDecimal wageBondChargesRate;
	private char asbestosDamagechargeYn;
	private BigDecimal asbestosDamagechargeRate;
	private BigDecimal industrialInsuranceRate;
	private int businessCode;
	private String detailTypeOfBusiness;
	private BigDecimal industryRate;
	
	public MngInsuranceRateDTO() {}

	public MngInsuranceRateDTO(int companyNo, int divNo, Date insuranceRateStartDate, BigDecimal nationalPensionRate,
			BigDecimal workersPensionRate, BigDecimal employerPensionRate, BigDecimal healthRate,
			BigDecimal workersHealthRate, BigDecimal employerHealthRate, BigDecimal longTermCareRate,
			BigDecimal workersLongTermCareRate, BigDecimal employerLongTermCareRate, BigDecimal unempBenefitRate,
			BigDecimal workersUnempRate, BigDecimal employerUnempRate, BigDecimal under150EmpRate,
			BigDecimal over150PriorityEmpRate, BigDecimal under1000EmpRate, BigDecimal over1000EmpRate,
			BigDecimal commuteAccidentRate, char wageBondChargesYn, BigDecimal wageBondChargesRate,
			char asbestosDamagechargeYn, BigDecimal asbestosDamagechargeRate, BigDecimal industrialInsuranceRate,
			int businessCode, String detailTypeOfBusiness, BigDecimal industryRate) {
		super();
		this.companyNo = companyNo;
		this.divNo = divNo;
		this.insuranceRateStartDate = insuranceRateStartDate;
		this.nationalPensionRate = nationalPensionRate;
		this.workersPensionRate = workersPensionRate;
		this.employerPensionRate = employerPensionRate;
		this.healthRate = healthRate;
		this.workersHealthRate = workersHealthRate;
		this.employerHealthRate = employerHealthRate;
		this.longTermCareRate = longTermCareRate;
		this.workersLongTermCareRate = workersLongTermCareRate;
		this.employerLongTermCareRate = employerLongTermCareRate;
		this.unempBenefitRate = unempBenefitRate;
		this.workersUnempRate = workersUnempRate;
		this.employerUnempRate = employerUnempRate;
		this.under150EmpRate = under150EmpRate;
		this.over150PriorityEmpRate = over150PriorityEmpRate;
		this.under1000EmpRate = under1000EmpRate;
		this.over1000EmpRate = over1000EmpRate;
		this.commuteAccidentRate = commuteAccidentRate;
		this.wageBondChargesYn = wageBondChargesYn;
		this.wageBondChargesRate = wageBondChargesRate;
		this.asbestosDamagechargeYn = asbestosDamagechargeYn;
		this.asbestosDamagechargeRate = asbestosDamagechargeRate;
		this.industrialInsuranceRate = industrialInsuranceRate;
		this.businessCode = businessCode;
		this.detailTypeOfBusiness = detailTypeOfBusiness;
		this.industryRate = industryRate;
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

	public Date getInsuranceRateStartDate() {
		return insuranceRateStartDate;
	}

	public void setInsuranceRateStartDate(Date insuranceRateStartDate) {
		this.insuranceRateStartDate = insuranceRateStartDate;
	}

	public BigDecimal getNationalPensionRate() {
		return nationalPensionRate;
	}

	public void setNationalPensionRate(BigDecimal nationalPensionRate) {
		this.nationalPensionRate = nationalPensionRate;
	}

	public BigDecimal getWorkersPensionRate() {
		return workersPensionRate;
	}

	public void setWorkersPensionRate(BigDecimal workersPensionRate) {
		this.workersPensionRate = workersPensionRate;
	}

	public BigDecimal getEmployerPensionRate() {
		return employerPensionRate;
	}

	public void setEmployerPensionRate(BigDecimal employerPensionRate) {
		this.employerPensionRate = employerPensionRate;
	}

	public BigDecimal getHealthRate() {
		return healthRate;
	}

	public void setHealthRate(BigDecimal healthRate) {
		this.healthRate = healthRate;
	}

	public BigDecimal getWorkersHealthRate() {
		return workersHealthRate;
	}

	public void setWorkersHealthRate(BigDecimal workersHealthRate) {
		this.workersHealthRate = workersHealthRate;
	}

	public BigDecimal getEmployerHealthRate() {
		return employerHealthRate;
	}

	public void setEmployerHealthRate(BigDecimal employerHealthRate) {
		this.employerHealthRate = employerHealthRate;
	}

	public BigDecimal getLongTermCareRate() {
		return longTermCareRate;
	}

	public void setLongTermCareRate(BigDecimal longTermCareRate) {
		this.longTermCareRate = longTermCareRate;
	}

	public BigDecimal getWorkersLongTermCareRate() {
		return workersLongTermCareRate;
	}

	public void setWorkersLongTermCareRate(BigDecimal workersLongTermCareRate) {
		this.workersLongTermCareRate = workersLongTermCareRate;
	}

	public BigDecimal getEmployerLongTermCareRate() {
		return employerLongTermCareRate;
	}

	public void setEmployerLongTermCareRate(BigDecimal employerLongTermCareRate) {
		this.employerLongTermCareRate = employerLongTermCareRate;
	}

	public BigDecimal getUnempBenefitRate() {
		return unempBenefitRate;
	}

	public void setUnempBenefitRate(BigDecimal unempBenefitRate) {
		this.unempBenefitRate = unempBenefitRate;
	}

	public BigDecimal getWorkersUnempRate() {
		return workersUnempRate;
	}

	public void setWorkersUnempRate(BigDecimal workersUnempRate) {
		this.workersUnempRate = workersUnempRate;
	}

	public BigDecimal getEmployerUnempRate() {
		return employerUnempRate;
	}

	public void setEmployerUnempRate(BigDecimal employerUnempRate) {
		this.employerUnempRate = employerUnempRate;
	}

	public BigDecimal getUnder150EmpRate() {
		return under150EmpRate;
	}

	public void setUnder150EmpRate(BigDecimal under150EmpRate) {
		this.under150EmpRate = under150EmpRate;
	}

	public BigDecimal getOver150PriorityEmpRate() {
		return over150PriorityEmpRate;
	}

	public void setOver150PriorityEmpRate(BigDecimal over150PriorityEmpRate) {
		this.over150PriorityEmpRate = over150PriorityEmpRate;
	}

	public BigDecimal getUnder1000EmpRate() {
		return under1000EmpRate;
	}

	public void setUnder1000EmpRate(BigDecimal under1000EmpRate) {
		this.under1000EmpRate = under1000EmpRate;
	}

	public BigDecimal getOver1000EmpRate() {
		return over1000EmpRate;
	}

	public void setOver1000EmpRate(BigDecimal over1000EmpRate) {
		this.over1000EmpRate = over1000EmpRate;
	}

	public BigDecimal getCommuteAccidentRate() {
		return commuteAccidentRate;
	}

	public void setCommuteAccidentRate(BigDecimal commuteAccidentRate) {
		this.commuteAccidentRate = commuteAccidentRate;
	}

	public char getWageBondChargesYn() {
		return wageBondChargesYn;
	}

	public void setWageBondChargesYn(char wageBondChargesYn) {
		this.wageBondChargesYn = wageBondChargesYn;
	}

	public BigDecimal getWageBondChargesRate() {
		return wageBondChargesRate;
	}

	public void setWageBondChargesRate(BigDecimal wageBondChargesRate) {
		this.wageBondChargesRate = wageBondChargesRate;
	}

	public char getAsbestosDamagechargeYn() {
		return asbestosDamagechargeYn;
	}

	public void setAsbestosDamagechargeYn(char asbestosDamagechargeYn) {
		this.asbestosDamagechargeYn = asbestosDamagechargeYn;
	}

	public BigDecimal getAsbestosDamagechargeRate() {
		return asbestosDamagechargeRate;
	}

	public void setAsbestosDamagechargeRate(BigDecimal asbestosDamagechargeRate) {
		this.asbestosDamagechargeRate = asbestosDamagechargeRate;
	}

	public BigDecimal getIndustrialInsuranceRate() {
		return industrialInsuranceRate;
	}

	public void setIndustrialInsuranceRate(BigDecimal industrialInsuranceRate) {
		this.industrialInsuranceRate = industrialInsuranceRate;
	}

	public int getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(int businessCode) {
		this.businessCode = businessCode;
	}

	public String getDetailTypeOfBusiness() {
		return detailTypeOfBusiness;
	}

	public void setDetailTypeOfBusiness(String detailTypeOfBusiness) {
		this.detailTypeOfBusiness = detailTypeOfBusiness;
	}

	public BigDecimal getIndustryRate() {
		return industryRate;
	}

	public void setIndustryRate(BigDecimal industryRate) {
		this.industryRate = industryRate;
	}

	@Override
	public String toString() {
		return "MngInsuranceRateDTO [companyNo=" + companyNo + ", divNo=" + divNo + ", insuranceRateStartDate="
				+ insuranceRateStartDate + ", nationalPensionRate=" + nationalPensionRate + ", workersPensionRate="
				+ workersPensionRate + ", employerPensionRate=" + employerPensionRate + ", healthRate=" + healthRate
				+ ", workersHealthRate=" + workersHealthRate + ", employerHealthRate=" + employerHealthRate
				+ ", longTermCareRate=" + longTermCareRate + ", workersLongTermCareRate=" + workersLongTermCareRate
				+ ", employerLongTermCareRate=" + employerLongTermCareRate + ", unempBenefitRate=" + unempBenefitRate
				+ ", workersUnempRate=" + workersUnempRate + ", employerUnempRate=" + employerUnempRate
				+ ", under150EmpRate=" + under150EmpRate + ", over150PriorityEmpRate=" + over150PriorityEmpRate
				+ ", under1000EmpRate=" + under1000EmpRate + ", over1000EmpRate=" + over1000EmpRate
				+ ", commuteAccidentRate=" + commuteAccidentRate + ", wageBondChargesYn=" + wageBondChargesYn
				+ ", wageBondChargesRate=" + wageBondChargesRate + ", asbestosDamagechargeYn=" + asbestosDamagechargeYn
				+ ", asbestosDamagechargeRate=" + asbestosDamagechargeRate + ", industrialInsuranceRate="
				+ industrialInsuranceRate + ", businessCode=" + businessCode + ", detailTypeOfBusiness="
				+ detailTypeOfBusiness + ", industryRate=" + industryRate + "]";
	}

	
	
}
