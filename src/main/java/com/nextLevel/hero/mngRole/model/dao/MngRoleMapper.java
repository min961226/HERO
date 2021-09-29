package com.nextLevel.hero.mngRole.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;

@Mapper
public interface MngRoleMapper {

	List<MngRoleDTO> selectRank(int companyNo);

	List<MngRankSalaryDTO> selectRankAuth(int companyNo, String rank);

	int updateRoleAuth(MngRankSalaryDTO mngRankSalaryDTO);

	List<MngRankAuthDTO> selectStepByRank(MngRankAuthDTO mngRankAuthDTO);

	int deleteRankAuth(MngRankAuthDTO mngRankAuthDTO);


}
