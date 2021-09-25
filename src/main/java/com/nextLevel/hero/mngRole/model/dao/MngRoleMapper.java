package com.nextLevel.hero.mngRole.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;

@Mapper
public interface MngRoleMapper {

	List<MngRoleDTO> selectRank(int companyNo);

	List<MngRankAuthDTO> selectRankAuth(int companyNo, String rank);


}
