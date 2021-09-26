package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class MngInsuranceRateDTO implements Serializable {

	private int companyNo;
	private int divNo;
	private Date insuranceRateStartDate;
	private double nationalPensionRate;
	private double workersPensionRate;
	private double employerPensionRate;
	private double healthRate;
	private double workersHealthRate;
	private double employerHealthRate;
	private double longTermCareRate;
	private double workersLongTermCareRate;
	private double employerLongTermCareRate;
	private double unempBenefitRate;
	private double workersUnempRate;
	private double employerUnempRate;
	private double under150EmpRate;
	private double over150PriorityEmpRate;
	private double under1000EmpRate;
	private double over1000EmpRate;
	private double commuteAccidentRate;
	private char wageBondChargesYn;
	private double wageBondChargesRate;
	private char asbestosDamagechargeYn;
	private double asbestosDamagechargeRate;
	private double industrialInsuranceRate;
	private int businessCode;
	private double industryRate;
	
	public MngInsuranceRateDTO() {}

	public MngInsuranceRateDTO(int companyNo, int divNo, Date insuranceRateStartDate, double nationalPensionRate,
			double workersPensionRate, double employerPensionRate, double healthRate, double workersHealthRate,
			double employerHealthRate, double longTermCareRate, double workersLongTermCareRate,
			double employerLongTermCareRate, double unempBenefitRate, double workersUnempRate, double employerUnempRate,
			double under150EmpRate, double over150PriorityEmpRate, double under1000EmpRate, double over1000EmpRate,
			double commuteAccidentRate, char wageBondChargesYn, double wageBondChargesRate, char asbestosDamagechargeYn,
			double asbestosDamagechargeRate, double industrialInsuranceRate, int businessCode, double industryRate) {
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

	public double getNationalPensionRate() {
		return nationalPensionRate;
	}

	public void setNationalPensionRate(double nationalPensionRate) {
		this.nationalPensionRate = nationalPensionRate;
	}

	public double getWorkersPensionRate() {
		return workersPensionRate;
	}

	public void setWorkersPensionRate(double workersPensionRate) {
		this.workersPensionRate = workersPensionRate;
	}

	public double getEmployerPensionRate() {
		return employerPensionRate;
	}

	public void setEmployerPensionRate(double employerPensionRate) {
		this.employerPensionRate = employerPensionRate;
	}

	public double getHealthRate() {
		return healthRate;
	}

	public void setHealthRate(double healthRate) {
		this.healthRate = healthRate;
	}

	public double getWorkersHealthRate() {
		return workersHealthRate;
	}

	public void setWorkersHealthRate(double workersHealthRate) {
		this.workersHealthRate = workersHealthRate;
	}

	public double getEmployerHealthRate() {
		return employerHealthRate;
	}

	public void setEmployerHealthRate(double employerHealthRate) {
		this.employerHealthRate = employerHealthRate;
	}

	public double getLongTermCareRate() {
		return longTermCareRate;
	}

	public void setLongTermCareRate(double longTermCareRate) {
		this.longTermCareRate = longTermCareRate;
	}

	public double getWorkersLongTermCareRate() {
		return workersLongTermCareRate;
	}

	public void setWorkersLongTermCareRate(double workersLongTermCareRate) {
		this.workersLongTermCareRate = workersLongTermCareRate;
	}

	public double getEmployerLongTermCareRate() {
		return employerLongTermCareRate;
	}

	public void setEmployerLongTermCareRate(double employerLongTermCareRate) {
		this.employerLongTermCareRate = employerLongTermCareRate;
	}

	public double getUnempBenefitRate() {
		return unempBenefitRate;
	}

	public void setUnempBenefitRate(double unempBenefitRate) {
		this.unempBenefitRate = unempBenefitRate;
	}

	public double getWorkersUnempRate() {
		return workersUnempRate;
	}

	public void setWorkersUnempRate(double workersUnempRate) {
		this.workersUnempRate = workersUnempRate;
	}

	public double getEmployerUnempRate() {
		return employerUnempRate;
	}

	public void setEmployerUnempRate(double employerUnempRate) {
		this.employerUnempRate = employerUnempRate;
	}

	public double getUnder150EmpRate() {
		return under150EmpRate;
	}

	public void setUnder150EmpRate(double under150EmpRate) {
		this.under150EmpRate = under150EmpRate;
	}

	public double getOver150PriorityEmpRate() {
		return over150PriorityEmpRate;
	}

	public void setOver150PriorityEmpRate(double over150PriorityEmpRate) {
		this.over150PriorityEmpRate = over150PriorityEmpRate;
	}

	public double getUnder1000EmpRate() {
		return under1000EmpRate;
	}

	public void setUnder1000EmpRate(double under1000EmpRate) {
		this.under1000EmpRate = under1000EmpRate;
	}

	public double getOver1000EmpRate() {
		return over1000EmpRate;
	}

	public void setOver1000EmpRate(double over1000EmpRate) {
		this.over1000EmpRate = over1000EmpRate;
	}

	public double getCommuteAccidentRate() {
		return commuteAccidentRate;
	}

	public void setCommuteAccidentRate(double commuteAccidentRate) {
		this.commuteAccidentRate = commuteAccidentRate;
	}

	public char getWageBondChargesYn() {
		return wageBondChargesYn;
	}

	public void setWageBondChargesYn(char wageBondChargesYn) {
		this.wageBondChargesYn = wageBondChargesYn;
	}

	public double getWageBondChargesRate() {
		return wageBondChargesRate;
	}

	public void setWageBondChargesRate(double wageBondChargesRate) {
		this.wageBondChargesRate = wageBondChargesRate;
	}

	public char getAsbestosDamagechargeYn() {
		return asbestosDamagechargeYn;
	}

	public void setAsbestosDamagechargeYn(char asbestosDamagechargeYn) {
		this.asbestosDamagechargeYn = asbestosDamagechargeYn;
	}

	public double getAsbestosDamagechargeRate() {
		return asbestosDamagechargeRate;
	}

	public void setAsbestosDamagechargeRate(double asbestosDamagechargeRate) {
		this.asbestosDamagechargeRate = asbestosDamagechargeRate;
	}

	public double getIndustrialInsuranceRate() {
		return industrialInsuranceRate;
	}

	public void setIndustrialInsuranceRate(double industrialInsuranceRate) {
		this.industrialInsuranceRate = industrialInsuranceRate;
	}

	public int getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(int businessCode) {
		this.businessCode = businessCode;
	}

	public double getIndustryRate() {
		return industryRate;
	}

	public void setIndustryRate(double industryRate) {
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
				+ industrialInsuranceRate + ", businessCode=" + businessCode + ", industryRate=" + industryRate + "]";
	}

	
}
