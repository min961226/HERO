package com.nextLevel.hero.mngVacation.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AnnualVacationControlDTO {

	private int vacationCode;												//조정연차코드
	private int vacationDays;												//연차 지급 일수
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")		
	private java.sql.Date vacationStartDate;								//조정연차 적용일(DB상에서 21/01/01로 했음)
	private int workYears;													//근속년수번호
	
	public AnnualVacationControlDTO() {}

	public AnnualVacationControlDTO(int vacationCode, int vacationDays, Date vacationStartDate, int workYears) {
		super();
		this.vacationCode = vacationCode;
		this.vacationDays = vacationDays;
		this.vacationStartDate = vacationStartDate;
		this.workYears = workYears;
	}

	public int getVacationCode() {
		return vacationCode;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public java.sql.Date getVacationStartDate() {
		return vacationStartDate;
	}

	public int getWorkYears() {
		return workYears;
	}

	public void setVacationCode(int vacationCode) {
		this.vacationCode = vacationCode;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	public void setVacationStartDate(java.sql.Date vacationStartDate) {
		this.vacationStartDate = vacationStartDate;
	}

	public void setWorkYears(int workYears) {
		this.workYears = workYears;
	}

	@Override
	public String toString() {
		return "AnnualVacationControlDTO [vacationCode=" + vacationCode + ", vacationDays=" + vacationDays
				+ ", vacationStartDate=" + vacationStartDate + ", workYears=" + workYears + "]";
	}
	
	
	
}


