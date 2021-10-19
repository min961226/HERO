package com.nextLevel.hero.mngSalary.model.dto;

public class MngDepositDTO {
	
	private int companyNo;
	private int memberNo;
	private String memberName;
	private String departmentName;
	private String yearAndMonth;
	private Integer incomeTax;
	private Integer residentTax;
	private Integer health;
	private Integer longterm;
	private Integer pension;
	private Integer workerEmp;
	private Integer employerEmp;
	private Integer industry;
	private Integer etcDeduct;
	private String searchDate;
	private String year;
	private String month;
	
	
	public MngDepositDTO() {}


	public MngDepositDTO(int companyNo, int memberNo, String memberName, String departmentName, String yearAndMonth,
			Integer incomeTax, Integer residentTax, Integer health, Integer longterm, Integer pension,
			Integer workerEmp, Integer employerEmp, Integer industry, Integer etcDeduct, String searchDate, String year,
			String month) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.departmentName = departmentName;
		this.yearAndMonth = yearAndMonth;
		this.incomeTax = incomeTax;
		this.residentTax = residentTax;
		this.health = health;
		this.longterm = longterm;
		this.pension = pension;
		this.workerEmp = workerEmp;
		this.employerEmp = employerEmp;
		this.industry = industry;
		this.etcDeduct = etcDeduct;
		this.searchDate = searchDate;
		this.year = year;
		this.month = month;
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getYearAndMonth() {
		return yearAndMonth;
	}


	public void setYearAndMonth(String yearAndMonth) {
		this.yearAndMonth = yearAndMonth;
	}


	public Integer getIncomeTax() {
		return incomeTax;
	}


	public void setIncomeTax(Integer incomeTax) {
		this.incomeTax = incomeTax;
	}


	public Integer getResidentTax() {
		return residentTax;
	}


	public void setResidentTax(Integer residentTax) {
		this.residentTax = residentTax;
	}


	public Integer getHealth() {
		return health;
	}


	public void setHealth(Integer health) {
		this.health = health;
	}


	public Integer getLongterm() {
		return longterm;
	}


	public void setLongterm(Integer longterm) {
		this.longterm = longterm;
	}


	public Integer getPension() {
		return pension;
	}


	public void setPension(Integer pension) {
		this.pension = pension;
	}


	public Integer getWorkerEmp() {
		return workerEmp;
	}


	public void setWorkerEmp(Integer workerEmp) {
		this.workerEmp = workerEmp;
	}


	public Integer getEmployerEmp() {
		return employerEmp;
	}


	public void setEmployerEmp(Integer employerEmp) {
		this.employerEmp = employerEmp;
	}


	public Integer getIndustry() {
		return industry;
	}


	public void setIndustry(Integer industry) {
		this.industry = industry;
	}


	public Integer getEtcDeduct() {
		return etcDeduct;
	}


	public void setEtcDeduct(Integer etcDeduct) {
		this.etcDeduct = etcDeduct;
	}


	public String getSearchDate() {
		return searchDate;
	}


	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	@Override
	public String toString() {
		return "MngDepositDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", memberName=" + memberName
				+ ", departmentName=" + departmentName + ", yearAndMonth=" + yearAndMonth + ", incomeTax=" + incomeTax
				+ ", residentTax=" + residentTax + ", health=" + health + ", longterm=" + longterm + ", pension="
				+ pension + ", workerEmp=" + workerEmp + ", employerEmp=" + employerEmp + ", industry=" + industry
				+ ", etcDeduct=" + etcDeduct + ", searchDate=" + searchDate + ", year=" + year + ", month=" + month
				+ "]";
	}


	
	
}
