package com.nextLevel.hero.mngWorkAttitude.model.dto;

import java.util.List;

public class MngAttitudeUpdateDTO {
	
	private int idNo;									//계정번호
	private int memberNo;								//사번
	private String koreanName;							//이름
	private String departmenetName;						//부서이름
	private String rank;								//직급
	private String hireDate;							//입사일
	
	public MngAttitudeUpdateDTO() {
		super();
	}

	public MngAttitudeUpdateDTO(int idNo, int memberNo, String koreanName, String departmenetName, String rank,
			String hireDate) {
		super();
		this.idNo = idNo;
		this.memberNo = memberNo;
		this.koreanName = koreanName;
		this.departmenetName = departmenetName;
		this.rank = rank;
		this.hireDate = hireDate;
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

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public String getDepartmenetName() {
		return departmenetName;
	}

	public void setDepartmenetName(String departmenetName) {
		this.departmenetName = departmenetName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "MngAttitudeUpdateDTO [idNo=" + idNo + ", memberNo=" + memberNo + ", koreanName=" + koreanName
				+ ", departmenetName=" + departmenetName + ", rank=" + rank + ", hireDate=" + hireDate + "]";
	}
	
	
	
	
	
}
