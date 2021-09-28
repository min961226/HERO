package com.nextLevel.hero.member.model.dto;

public class FindPwdDTO {

	private String userId;
	private String username;
	private String email;
	private String idNo;
	private String userPwd;
	
	public FindPwdDTO() {}

	public FindPwdDTO(String userId, String username, String email, String idNo, String userPwd) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.idNo = idNo;
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "FindPwdDTO [userId=" + userId + ", username=" + username + ", email=" + email + ", idNo=" + idNo
				+ ", userPwd=" + userPwd + "]";
	}

	
}
