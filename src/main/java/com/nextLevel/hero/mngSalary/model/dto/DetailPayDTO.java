package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;
import java.time.LocalDate;

public class DetailPayDTO {

	private int companyNo;
	private int idNo;
	private int memberNo;
	private String salaryName;
	private String imputedDate;
	private java.sql.Date payDate;
	private int salaryAmount;
	private String departmentName;
	private String memberName;
	private String salOrBonus;
	private int divNo;
	private String deductYn;
	
	public DetailPayDTO() {}

	public DetailPayDTO(int companyNo, int idNo, int memberNo, String salaryName, String imputedDate, Date payDate,
			int salaryAmount, String departmentName, String memberName, String salOrBonus, int divNo, String deductYn) {
		super();
		this.companyNo = companyNo;
		this.idNo = idNo;
		this.memberNo = memberNo;
		this.salaryName = salaryName;
		this.imputedDate = imputedDate;
		this.payDate = payDate;
		this.salaryAmount = salaryAmount;
		this.departmentName = departmentName;
		this.memberName = memberName;
		this.salOrBonus = salOrBonus;
		this.divNo = divNo;
		this.deductYn = deductYn;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(String salaryName) {
		this.salaryName = salaryName;
	}

	public String getImputedDate() {
		return imputedDate;
	}

	public void setImputedDate(String imputedDate) {
		this.imputedDate = imputedDate;
	}

	public java.sql.Date getPayDate() {
		return payDate;
	}

	public void setPayDate(java.sql.Date payDate) {
		this.payDate = payDate;
	}

	public int getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(int salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSalOrBonus() {
		return salOrBonus;
	}

	public void setSalOrBonus(String salOrBonus) {
		this.salOrBonus = salOrBonus;
	}

	public int getDivNo() {
		return divNo;
	}

	public void setDivNo(int divNo) {
		this.divNo = divNo;
	}

	public String getDeductYn() {
		return deductYn;
	}

	public void setDeductYn(String deductYn) {
		this.deductYn = deductYn;
	}

	@Override
	public String toString() {
		return "DetailPayDTO [companyNo=" + companyNo + ", idNo=" + idNo + ", memberNo=" + memberNo + ", salaryName="
				+ salaryName + ", imputedDate=" + imputedDate + ", payDate=" + payDate + ", salaryAmount="
				+ salaryAmount + ", departmentName=" + departmentName + ", memberName=" + memberName + ", salOrBonus="
				+ salOrBonus + ", divNo=" + divNo + ", deductYn=" + deductYn + "]";
	}

	
	
}
