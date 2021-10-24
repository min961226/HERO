package com.nextLevel.hero.humanResource.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.humanResource.model.dto.MyPageDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;

@Mapper
public interface HumanResourceMapper {

	int updatePassword(int companyNo, FindPwdDTO findPwdDTO);							//비밀번호 변경
	
	int selectMemberNo(int companyNo, int idNo);										//memberNo 조회
	
	int selectjobNo(int companyNo, int idNo);											//jobNo 조회

	MyPageDTO selectMypage(int companyNo, int idNo, int memberNo, int jobNo);			//mypage 유저 정보 조회

	int updateEmp(int companyNo, int idNo, MyPageDTO myPageDTO);						//mypage 유저 정보 수정

	int updateMypage(int companyNo, int idNo, MyPageDTO myPageDTO);						//mypage 유저 정보 수정



}
