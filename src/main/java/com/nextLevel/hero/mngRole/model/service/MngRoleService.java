package com.nextLevel.hero.mngRole.model.service;

import java.util.List; 

import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserDTO;

public interface MngRoleService {

	List<MngRoleDTO> selectRank(int companyNo);

	List<MngRankAuthDTO> selectRankAuth(int companyNo, String rank);

	int updateRoleAuth(MngRankSalaryDTO mngRankSalaryDTO);

	List<MngRankAuthDTO> selectStepByRank(MngRankAuthDTO mngRankAuthDTO);

	int deleteRankAuth(MngRankAuthDTO mngRankAuthDTO);

	int insertRankAuth(MngRankAuthDTO mngRankAuthDTO);

	List<MngUserDTO> selectUser(int companyNo);



}
