package com.nextLevel.hero.mngRole.model.dto;

import java.util.List;

public class MngUserAuthDTO {
	
	private int companyNo;										//회사번호
	private int idNo;											//계정번호
	private int authoryityNo;									//권한번호
	private String userName;									//사원이름
	private char tblUserAuth;									//권한생성여부
	private String memberNo;									//사원번호
	
	private List<MngUserAuthDTO> authoryityNoArg;				//권한번호

	public MngUserAuthDTO() {}

	public MngUserAuthDTO(int companyNo, int idNo, int authoryityNo, String userName, char tblUserAuth, String memberNo,
			List<MngUserAuthDTO> authoryityNoArg) {
		super();
		this.companyNo = companyNo;
		this.idNo = idNo;
		this.authoryityNo = authoryityNo;
		this.userName = userName;
		this.tblUserAuth = tblUserAuth;
		this.memberNo = memberNo;
		this.authoryityNoArg = authoryityNoArg;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public int getAuthoryityNo() {
		return authoryityNo;
	}

	public void setAuthoryityNo(int authoryityNo) {
		this.authoryityNo = authoryityNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getTblUserAuth() {
		return tblUserAuth;
	}

	public void setTblUserAuth(char tblUserAuth) {
		this.tblUserAuth = tblUserAuth;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public List<MngUserAuthDTO> getAuthoryityNoArg() {
		return authoryityNoArg;
	}

	public void setAuthoryityNoArg(List<MngUserAuthDTO> authoryityNoArg) {
		this.authoryityNoArg = authoryityNoArg;
	}

	@Override
	public String toString() {
		return "MngUserAuthDTO [companyNo=" + companyNo + ", idNo=" + idNo + ", authoryityNo=" + authoryityNo
				+ ", userName=" + userName + ", tblUserAuth=" + tblUserAuth + ", memberNo=" + memberNo
				+ ", authoryityNoArg=" + authoryityNoArg + "]";
	}

	
	

}
