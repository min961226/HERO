package com.nextLevel.hero.mngRole.model.service;

import java.util.List;
import java.util.Map;

import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserDTO;

public interface MngRoleService {

	List<MngRoleDTO> selectRank(int companyNo);

	List<MngRankAuthDTO> selectRankAuth(int companyNo, String rank);

	int updateRoleAuth(MngRankSalaryDTO mngRankSalaryDTO);

	int selectStepByRank(MngRankAuthDTO mngRankAuthDTO);

	List<MngUserDTO> selectUser(int companyNo, Map searchMap, SelectCriteria selectCriteria);

	List<MngUserAuthDTO> selectUserAuth(String userName, String memberNo, int companyNo);

	int updateUserRoleAuth(MngUserAuthDTO mngUserAuthDTO);

	int insertUserAuth(MngUserAuthDTO mngUserAuthDTO);

	int selectMemberCount(int companyNo, Map searchMap);





}
