package com.nextLevel.hero.member.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nextLevel.hero.member.model.dto.FindIdDTO;

/* 특정 인터페이스를 상속받아서 구현 */
public interface MemberService extends UserDetailsService {

	FindIdDTO selectFindId(String username, String phone2);


	 

}
