package com.nextLevel.hero.SYSTEM.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.SYSTEM.model.dto.NewMemberDTO;

@Mapper
public interface SystemManagerMapper {

	List<String> selectMemberIdList();

	int insertControlClient(NewMemberDTO newMemberDTO);

	int selectLastCompanyNo();

	int insertNewMember(NewMemberDTO newMemberDTO);

	int selectLastIdNo();

	int insertMemberCompany(int companyNo, int idNo);

	int insertMemberAuth(int idNo);

	List<NewMemberDTO> selectControlClientList();

}
