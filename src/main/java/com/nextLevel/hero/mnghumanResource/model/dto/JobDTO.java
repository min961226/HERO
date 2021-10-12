package com.nextLevel.hero.mnghumanResource.model.dto;

public class JobDTO {
	private int jobNo;
	private String jobName;
	
	public JobDTO() {}

	public JobDTO(int jobNo, String jobName) {
		super();
		this.jobNo = jobNo;
		this.jobName = jobName;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "JobDTO [jobNo=" + jobNo + ", jobName=" + jobName + "]";
	}
	
	
}
