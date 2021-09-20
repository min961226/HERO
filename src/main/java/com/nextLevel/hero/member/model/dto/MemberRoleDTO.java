package com.nextLevel.hero.member.model.dto;

public class MemberRoleDTO {
	
	private int idNo;
	private int authorityCode;
	private String authorityCategory;
	private char createdAutorityStatus;
	
	private AuthorityDTO authority;
	
	public MemberRoleDTO() {}

	public MemberRoleDTO(int idNo, int authorityCode, String authorityCategory, char createdAutorityStatus,
			AuthorityDTO authority) {
		super();
		this.idNo = idNo;
		this.authorityCode = authorityCode;
		this.authorityCategory = authorityCategory;
		this.createdAutorityStatus = createdAutorityStatus;
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

	public String getAuthorityCategory() {
		return authorityCategory;
	}

	public void setAuthorityCategory(String authorityCategory) {
		this.authorityCategory = authorityCategory;
	}

	public char getCreatedAutorityStatus() {
		return createdAutorityStatus;
	}

	public void setCreatedAutorityStatus(char createdAutorityStatus) {
		this.createdAutorityStatus = createdAutorityStatus;
	}

	public AuthorityDTO getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityDTO authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "MemberRoleDTO [idNo=" + idNo + ", authorityCode=" + authorityCode + ", authorityCategory="
				+ authorityCategory + ", createdAutorityStatus=" + createdAutorityStatus + ", authority=" + authority
				+ "]";
	}

	
	
	
	
}
