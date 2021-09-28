package com.nextLevel.hero.member.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.MailDTO;

/* 특정 인터페이스를 상속받아서 구현 */
public interface MemberService extends UserDetailsService {

	FindIdDTO selectFindId(String username, String phone2);

	FindPwdDTO selectFindPwd(String userId, String username, String email);

	FindPwdDTO updatePwd(String userId, String username, String email);

	MailDTO emailCheck(MailDTO mailDTO);
		



	 

}
