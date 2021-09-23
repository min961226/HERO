package com.nextLevel.hero.member.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/* 특정 인터페이스를 상속받아서 구현 */
public interface MemberService extends UserDetailsService {

	static String memberFindId() {

		return null;
	}
	
	

}
