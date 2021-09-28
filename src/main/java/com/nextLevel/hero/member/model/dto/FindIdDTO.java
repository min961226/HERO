package com.nextLevel.hero.member.model.dto;

public class FindIdDTO {

	private String username; 
	private String phone;
	private String id;
	
	public FindIdDTO(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FindIdDTO(String username, String phone, String id) {
		super();
		this.username = username;
		this.phone = phone;
		this.id = id;
	}

	@Override
	public String toString() {
		return "FindIdDTO [username=" + username + ", phone=" + phone + ", id=" + id + "]";
	}
	
	
}
