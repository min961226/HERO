package com.nextLevel.hero.member.model.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserImpl extends User {
	
	private int no;										//회원번호
	private String id;									//회원아이디
	private String pwd;									//회원비밀번호
	private String tempPwdYn;							//임시비밀번호여부
	private String name;								//회원이름
	private java.sql.Date registDatetime;				//회원가입일시
	private java.sql.Date accSecessionDatetime;			//계정탈퇴일시
	private String accSecessionYn;						//계정탈퇴여부
	
	private List<MemberRoleDTO> memberRoleList;			//회원별권한리스트

	public UserImpl(String username, String password, 
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public void setDetails(MemberDTO member) {
		this.no = member.getNo();
		this.id = member.getId();
		this.pwd = member.getPwd();
		this.tempPwdYn = member.getTempPwdYn();
		this.name = member.getName();
		this.registDatetime = member.getRegistDatetime();
		this.accSecessionDatetime = member.getAccSecessionDatetime();
		this.accSecessionYn = member.getAccSecessionYn();
		this.memberRoleList = member.getMemberRoleList();
		
		
	}

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getTempPwdYn() {
		return tempPwdYn;
	}


	public String getName() {
		return name;
	}

	public java.sql.Date getRegistDatetime() {
		return registDatetime;
	}

	public java.sql.Date getAccSecessionDatetime() {
		return accSecessionDatetime;
	}

	public String getAccSecessionYn() {
		return accSecessionYn;
	}

	public List<MemberRoleDTO> getMemberRoleList() {
		return memberRoleList;
	}

}
