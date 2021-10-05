package com.nextLevel.hero.mnghumanResource.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;

@Mapper
public interface MngHumanResourceMapper {

	int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo);

}
