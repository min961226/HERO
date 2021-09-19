package com.nextLevel.hero.member.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.member.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	
	MemberDTO findMemberById(String userId);

}
