package com.nextLevel.hero.mngRole.model.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserDTO;

@Mapper
public interface MngRoleMapper {

	List<MngRoleDTO> selectRank(int companyNo);

	List<MngRankAuthDTO> selectRankAuth(int companyNo, String rank);

	int updateRoleAuth(MngRankSalaryDTO mngRankSalaryDTO);

	List<MngRankAuthDTO> selectStepByRank(MngRankAuthDTO mngRankAuthDTO);

	int deleteRankAuth(MngRankAuthDTO mngRankAuthDTO);

	int insertRankAuth(MngRankAuthDTO mngRankAuthDTO);

	Collection<? extends MngRankAuthDTO> selectAuthority(int salaryStepByRank, int companyNo);

	List<MngUserDTO> selectUser(int companyNo);









}
