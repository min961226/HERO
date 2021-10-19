package com.nextLevel.hero.humanResource.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.humanResource.model.dto.MyPageDTO;

@Mapper
public interface HumanResourceMapper {

	int selectMemberNo(int companyNo, int idNo);

	int selectjobNo(int companyNo, int idNo);

	MyPageDTO selectMypage(int companyNo, int idNo, int memberNo, int jobNo);

	int updateEmp(int companyNo, int idNo, MyPageDTO myPageDTO);

	int updateMypage(int companyNo, int idNo, MyPageDTO myPageDTO);


}
