package com.nextLevel.hero.mnghumanResource.model.dto;

public class VacationControlDTO {
	private int vacationCode;
	private int vacationDays;
	
	public VacationControlDTO() {}

	public VacationControlDTO(int vacationCode, int vacationDays) {
		super();
		this.vacationCode = vacationCode;
		this.vacationDays = vacationDays;
	}

	public int getVacationCode() {
		return vacationCode;
	}

	public void setVacationCode(int vacationCode) {
		this.vacationCode = vacationCode;
	}

	public int getVacationDays() {
		return vacationDays;
	}

	public void setVacationDays(int vacationDays) {
		this.vacationDays = vacationDays;
	}

	@Override
	public String toString() {
		return "VacationControlDTO [vacationCode=" + vacationCode + ", vacationDays=" + vacationDays + "]";
	}
	
}
