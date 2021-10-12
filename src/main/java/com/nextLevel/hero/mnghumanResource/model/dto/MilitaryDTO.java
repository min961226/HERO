package com.nextLevel.hero.mnghumanResource.model.dto;

import java.util.Date;

public class MilitaryDTO {

	private String militaryServiceStatus;
	private String militaryKind;
	private String ranking;
	private java.util.Date militaryStartDate;
	private java.util.Date militaryEndDate;
	
	public MilitaryDTO() {}

	public MilitaryDTO(String militaryServiceStatus, String militaryKind, String ranking, Date militaryStartDate,
			Date militaryEndDate) {
		super();
		this.militaryServiceStatus = militaryServiceStatus;
		this.militaryKind = militaryKind;
		this.ranking = ranking;
		this.militaryStartDate = militaryStartDate;
		this.militaryEndDate = militaryEndDate;
	}

	public String getMilitaryServiceStatus() {
		return militaryServiceStatus;
	}

	public void setMilitaryServiceStatus(String militaryServiceStatus) {
		this.militaryServiceStatus = militaryServiceStatus;
	}

	public String getMilitaryKind() {
		return militaryKind;
	}

	public void setMilitaryKind(String militaryKind) {
		this.militaryKind = militaryKind;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public java.util.Date getMilitaryStartDate() {
		return militaryStartDate;
	}

	public void setMilitaryStartDate(java.util.Date militaryStartDate) {
		this.militaryStartDate = militaryStartDate;
	}

	public java.util.Date getMilitaryEndDate() {
		return militaryEndDate;
	}

	public void setMilitaryEndDate(java.util.Date militaryEndDate) {
		this.militaryEndDate = militaryEndDate;
	}

	@Override
	public String toString() {
		return "MilitaryDTO [militaryServiceStatus=" + militaryServiceStatus + ", militaryKind=" + militaryKind
				+ ", ranking=" + ranking + ", militaryStartDate=" + militaryStartDate + ", militaryEndDate="
				+ militaryEndDate + "]";
	}
	
}
