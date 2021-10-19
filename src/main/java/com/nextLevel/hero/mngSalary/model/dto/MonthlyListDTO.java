package com.nextLevel.hero.mngSalary.model.dto;

public class MonthlyListDTO {

	private int companyNo;
	private int salaryNo;
	private String salaryName;
	private String regularyYn;
	private String payPeriod;
	private int salaryAmount;
	private String deductYn;
	private String annualYn;
	private String useYn;
	private String targetYn;
	
	
	public MonthlyListDTO() {}


	public MonthlyListDTO(int companyNo, int salaryNo, String salaryName, String regularyYn, String payPeriod,
			int salaryAmount, String deductYn, String annualYn, String useYn, String targetYn) {
		super();
		this.companyNo = companyNo;
		this.salaryNo = salaryNo;
		this.salaryName = salaryName;
		this.regularyYn = regularyYn;
		this.payPeriod = payPeriod;
		this.salaryAmount = salaryAmount;
		this.deductYn = deductYn;
		this.annualYn = annualYn;
		this.useYn = useYn;
		this.targetYn = targetYn;
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}


	public int getSalaryNo() {
		return salaryNo;
	}


	public void setSalaryNo(int salaryNo) {
		this.salaryNo = salaryNo;
	}


	public String getSalaryName() {
		return salaryName;
	}


	public void setSalaryName(String salaryName) {
		this.salaryName = salaryName;
	}


	public String getRegularyYn() {
		return regularyYn;
	}


	public void setRegularyYn(String regularyYn) {
		this.regularyYn = regularyYn;
	}


	public String getPayPeriod() {
		return payPeriod;
	}


	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}


	public int getSalaryAmount() {
		return salaryAmount;
	}


	public void setSalaryAmount(int salaryAmount) {
		this.salaryAmount = salaryAmount;
	}


	public String getDeductYn() {
		return deductYn;
	}


	public void setDeductYn(String deductYn) {
		this.deductYn = deductYn;
	}


	public String getAnnualYn() {
		return annualYn;
	}


	public void setAnnualYn(String annualYn) {
		this.annualYn = annualYn;
	}


	public String getUseYn() {
		return useYn;
	}


	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}


	public String getTargetYn() {
		return targetYn;
	}


	public void setTargetYn(String targetYn) {
		this.targetYn = targetYn;
	}


	@Override
	public String toString() {
		return "MonthlyListDTO [companyNo=" + companyNo + ", salaryNo=" + salaryNo + ", salaryName=" + salaryName
				+ ", regularyYn=" + regularyYn + ", payPeriod=" + payPeriod + ", salaryAmount=" + salaryAmount
				+ ", deductYn=" + deductYn + ", annualYn=" + annualYn + ", useYn=" + useYn + ", targetYn=" + targetYn
				+ "]";
	}
	
	
}
