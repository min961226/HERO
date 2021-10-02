package com.nextLevel.hero.member.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.member.model.dto.AuthorityDTO;
import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.member.model.dto.RankAuthDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO findMemberById(String userId);

	int findCompanyNoByUserNo(int no);

	FindIdDTO selectFindId(String username, String phone2);

	FindPwdDTO selectFindPwd(String userId, String username, String email);

	int updatePwd(FindPwdDTO findPwdDTO);

	List<AuthorityDTO> findRankAuth(MemberDTO member, int companyNo);


}
