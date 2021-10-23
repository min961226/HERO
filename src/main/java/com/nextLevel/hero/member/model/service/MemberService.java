package com.nextLevel.hero.member.model.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.MailDTO;

/* 특정 인터페이스를 상속받아서 구현 */
public interface MemberService extends UserDetailsService {

	FindIdDTO selectFindId(String username, String phone2);						//아이디 찾기			
	
	FindPwdDTO selectFindPwd(String userId, String username, String email);		//비밀번호 찾기

	MailDTO emailCheck(MailDTO mailDTO);										//이메일 체크

	int updatePwd(FindPwdDTO findPwdDTO);										//비밀번호 찾기후 비밀번호 변경

}
