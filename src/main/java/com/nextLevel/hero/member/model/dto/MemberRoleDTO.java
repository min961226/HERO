package com.nextLevel.hero.member.model.dto;

public class MemberRoleDTO {
	
	private int idNo;
	private int authorityCode;
	
	private AuthorityDTO authority;
	
	public MemberRoleDTO() {}

	public MemberRoleDTO(int idNo, int authorityCode, AuthorityDTO authority) {
		super();
		this.idNo = idNo;
		this.authorityCode = authorityCode;
		this.authority = authority;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public int getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(int authorityCode) {
		this.authorityCode = authorityCode;
	}

	public AuthorityDTO getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityDTO authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberRoleDTO [idNo=" + idNo + ", authorityCode=" + authorityCode + ", authority=" + authority + "]";
	}

	

	
	
	
	
}
