package com.nextLevel.hero.mnghumanResource.model.dto;

public class SalaryStepDTO {

	private String rank;
	private String salaryStep;
	
	public SalaryStepDTO () {}

	public SalaryStepDTO(String rank, String salaryStep) {
		super();
		this.rank = rank;
		this.salaryStep = salaryStep;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSalaryStep() {
		return salaryStep;
	}

	public void setSalaryStep(String salaryStep) {
		this.salaryStep = salaryStep;
	}

	@Override
	public String toString() {
		return "SalaryStepDTO [rank=" + rank + ", salaryStep=" + salaryStep + "]";
	}
	
}
