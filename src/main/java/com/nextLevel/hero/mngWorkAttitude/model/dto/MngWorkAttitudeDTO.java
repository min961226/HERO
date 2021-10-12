package com.nextLevel.hero.mngWorkAttitude.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MngWorkAttitudeDTO implements Serializable{
	
	private int companyNo;					//회사번호
	private int IdNo; 						//계정번호
	private String koreanName;				//이름
	private int memberNo;					//사번

	private List<MngWorkCommuteDTO> workCoList;
	
	public MngWorkAttitudeDTO() {}

	public MngWorkAttitudeDTO(int companyNo, int idNo, String koreanName, int memberNo,
			List<MngWorkCommuteDTO> workCoList) {
		super();
		this.companyNo = companyNo;
		IdNo = idNo;
		this.koreanName = koreanName;
		this.memberNo = memberNo;
		this.workCoList = workCoList;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getIdNo() {
		return IdNo;
	}

	public void setIdNo(int idNo) {
		IdNo = idNo;
	}

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public List<MngWorkCommuteDTO> getWorkCoList() {
		return workCoList;
	}

	public void setWorkCoList(List<MngWorkCommuteDTO> workCoList) {
		this.workCoList = workCoList;
	}

	@Override
	public String toString() {
		return "MngWorkAttitudeDTO [companyNo=" + companyNo + ", IdNo=" + IdNo + ", koreanName=" + koreanName
				+ ", memberNo=" + memberNo + ", workCoList=" + workCoList + "]";
	}

	

}
