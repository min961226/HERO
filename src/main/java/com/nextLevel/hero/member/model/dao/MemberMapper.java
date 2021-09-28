package com.nextLevel.hero.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO findMemberById(String userId);

	int findCompanyNoByUserNo(int no);

	FindIdDTO selectFindId(String username, String phone2);

	FindPwdDTO selectFindPwd(String userId, String username, String email);

	FindPwdDTO updatePwd(String userId, String username, String email);

}
