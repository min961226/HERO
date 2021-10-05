package com.nextLevel.hero.mngBasicInformation.model.dto;

import java.io.Serializable;

public class MngSalaryCriteriaDTO implements Serializable {
	
	private int companyNo;
	private int salaryNo;
	private String salaryName;
	private String regularlyYn;
	private String payPeriod;
	private String deductionYn;
	private String annualSalaryYn;
	private String payHiredMonthYn;
	private String paymentMonthYn;
	private String target;
	private int salaryAmount;
	private char useStatus;
	
	public MngSalaryCriteriaDTO() {}

	public MngSalaryCriteriaDTO(int companyNo, int salaryNo, String salaryName, String regularlyYn, String payPeriod,
			String deductionYn, String annualSalaryYn, String payHiredMonthYn, String paymentMonthYn, String target,
			int salaryAmount, char useStatus) {
		super();
		this.companyNo = companyNo;
		this.salaryNo = salaryNo;
		this.salaryName = salaryName;
		this.regularlyYn = regularlyYn;
		this.payPeriod = payPeriod;
		this.deductionYn = deductionYn;
		this.annualSalaryYn = annualSalaryYn;
		this.payHiredMonthYn = payHiredMonthYn;
		this.paymentMonthYn = paymentMonthYn;
		this.target = target;
		this.salaryAmount = salaryAmount;
		this.useStatus = useStatus;
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

	public String getDeductionYn() {
		return deductionYn;
	}

	public void setDeductionYn(String deductionYn) {
		this.deductionYn = deductionYn;
	}

	public String getAnnualSalaryYn() {
		return annualSalaryYn;
	}

	public void setAnnualSalaryYn(String annualSalaryYn) {
		this.annualSalaryYn = annualSalaryYn;
	}

	public String getPayHiredMonthYn() {
		return payHiredMonthYn;
	}

	public void setPayHiredMonthYn(String payHiredMonthYn) {
		this.payHiredMonthYn = payHiredMonthYn;
	}

	public String getPaymentMonthYn() {
		return paymentMonthYn;
	}

	public void setPaymentMonthYn(String paymentMonthYn) {
		this.paymentMonthYn = paymentMonthYn;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(int salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public char getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(char useStatus) {
		this.useStatus = useStatus;
	}

	@Override
	public String toString() {
		return "MngSalaryCriteriaDTO [companyNo=" + companyNo + ", salaryNo=" + salaryNo + ", salaryName=" + salaryName
				+ ", regularlyYn=" + regularlyYn + ", payPeriod=" + payPeriod + ", deductionYn=" + deductionYn
				+ ", annualSalaryYn=" + annualSalaryYn + ", payHiredMonthYn=" + payHiredMonthYn + ", paymentMonthYn="
				+ paymentMonthYn + ", target=" + target + ", salaryAmount=" + salaryAmount + ", useStatus=" + useStatus
				+ "]";
	}


}
