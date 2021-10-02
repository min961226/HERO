package com.nextLevel.hero.mngSalary.model.dto;

import java.sql.Date;

public class MemberMonthlyPayDTO {

	private MemberInfoDTO memberInfo;		//직원 정보
	private int salaryStepByRank;			//직급별 호봉번호
	private String rank;					//직급
	private	String salaryStep;				//호봉
	private int salaryNo;					//급여번호
	private java.sql.Date monthlyStartDate; //월 지급금액 적용일자
	private String payCategory;				//지급항목명
	private int amount;						//지급금액
	private String note;					//비고
	private String deductionYn;				//과세여부
	private java.sql.Date monthlyStopDate;  //지급 중단 시작일
	
	public MemberMonthlyPayDTO() {}

	public MemberMonthlyPayDTO(MemberInfoDTO memberInfo, int salaryStepByRank, String rank, String salaryStep,
			int salaryNo, Date monthlyStartDate, String payCategory, int amount, String note, String deductionYn,
			Date monthlyStopDate) {
		super();
		this.memberInfo = memberInfo;
		this.salaryStepByRank = salaryStepByRank;
		this.rank = rank;
		this.salaryStep = salaryStep;
		this.salaryNo = salaryNo;
		this.monthlyStartDate = monthlyStartDate;
		this.payCategory = payCategory;
		this.amount = amount;
		this.note = note;
		this.deductionYn = deductionYn;
		this.monthlyStopDate = monthlyStopDate;
	}

	public MemberInfoDTO getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfoDTO memberInfo) {
		this.memberInfo = memberInfo;
	}

	public int getSalaryStepByRank() {
		return salaryStepByRank;
	}

	public void setSalaryStepByRank(int salaryStepByRank) {
		this.salaryStepByRank = salaryStepByRank;
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

	public int getSalaryNo() {
		return salaryNo;
	}

	public void setSalaryNo(int salaryNo) {
		this.salaryNo = salaryNo;
	}

	public java.sql.Date getMonthlyStartDate() {
		return monthlyStartDate;
	}

	public void setMonthlyStartDate(java.sql.Date monthlyStartDate) {
		this.monthlyStartDate = monthlyStartDate;
	}

	public String getPayCategory() {
		return payCategory;
	}

	public void setPayCategory(String payCategory) {
		this.payCategory = payCategory;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDeductionYn() {
		return deductionYn;
	}

	public void setDeductionYn(String deductionYn) {
		this.deductionYn = deductionYn;
	}

	public java.sql.Date getMonthlyStopDate() {
		return monthlyStopDate;
	}

	public void setMonthlyStopDate(java.sql.Date monthlyStopDate) {
		this.monthlyStopDate = monthlyStopDate;
	}

	@Override
	public String toString() {
		return "MemberMonthlyPayDTO [memberInfo=" + memberInfo + ", salaryStepByRank=" + salaryStepByRank + ", rank="
				+ rank + ", salaryStep=" + salaryStep + ", salaryNo=" + salaryNo + ", monthlyStartDate="
				+ monthlyStartDate + ", payCategory=" + payCategory + ", amount=" + amount + ", note=" + note
				+ ", deductionYn=" + deductionYn + ", monthlyStopDate=" + monthlyStopDate + "]";
	}

	
	
	
}
