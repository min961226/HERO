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
	private java.sql.Date pwdChangedDatetime;			//회원비밀번호변경일시
	private String pwdExpDate;							//회원비밀번호만료일자
	private String name;								//회원이름
	private java.sql.Date registDatetime;				//회원가입일시
	private int accumLoginCount;						//누적로그인횟수
	private int loginFailedCount;						//로그인연속실패횟수
	private String accLockYn;							//계정잠금여부
	private String accInactiveYn;						//계정비활성화여부
	private String accExpDate;							//계정만료일자
	private String accExpYn;							//계정만료여부
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
		this.pwdChangedDatetime = member.getPwdChangedDatetime();
		this.pwdExpDate = member.getPwdExpDate();
		this.name = member.getName();
		this.registDatetime = member.getRegistDatetime();
		this.accumLoginCount = member.getAccumLoginCount();
		this.loginFailedCount = member.getLoginFailedCount();
		this.accLockYn = member.getAccExpYn();
		this.accExpDate = member.getAccExpDate();
		this.accExpYn = member.getAccExpYn();
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

	public java.sql.Date getPwdChangedDatetime() {
		return pwdChangedDatetime;
	}

	public String getPwdExpDate() {
		return pwdExpDate;
	}

	public String getName() {
		return name;
	}

	public java.sql.Date getRegistDatetime() {
		return registDatetime;
	}

	public int getAccumLoginCount() {
		return accumLoginCount;
	}

	public int getLoginFailedCount() {
		return loginFailedCount;
	}

	public String getAccLockYn() {
		return accLockYn;
	}

	public String getAccInactiveYn() {
		return accInactiveYn;
	}

	public String getAccExpDate() {
		return accExpDate;
	}

	public String getAccExpYn() {
		return accExpYn;
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
