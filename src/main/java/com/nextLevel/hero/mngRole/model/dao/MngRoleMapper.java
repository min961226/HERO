package com.nextLevel.hero.mngRole.model.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserAuthDTO;
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

	List<MngUserDTO> selectUser(int companyNo, Map searchMap, SelectCriteria selectCriteria);

	List<MngUserAuthDTO> selectUserAuth(String userName, String memberNo, int companyNo);
 
	Collection<? extends MngUserAuthDTO> selectUserAuthority(int idNo);

	int updateUserRoleAuth(MngUserAuthDTO mngUserAuthDTO);

	int deleteUserAuth(MngUserAuthDTO mngUserAuthDTO);

	int insertUserAuth(MngUserAuthDTO mngUserAuthDTO);

	int selectMemberCount(Map searchMap, int companyNo);











}
