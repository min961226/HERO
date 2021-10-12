package com.nextLevel.hero.basicSetting.model.dto;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcelRankSalary {

	private int companyNo;
	private Integer annualSalary;
	private Date startDate;
	private Integer num;
	private String jobName;
	private Integer jobRank;
	
	
	public ExcelRankSalary() {}


	public Integer getAnnualSalary() {
		return annualSalary;
	}


	public void setAnnualSalary(Integer annualSalary) {
		this.annualSalary = annualSalary;
	}


	public int getCompanyNo() {
		return companyNo;
	}


	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public Integer getJobRank() {
		return jobRank;
	}


	public void setJobRank(Integer jobRank) {
		this.jobRank = jobRank;
	}

	
	
	
	
	
}
