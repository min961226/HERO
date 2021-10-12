package com.nextLevel.hero.mngWorkAttitude.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;

@Mapper
public interface MngWorkAttitudeMapper {

	List<MngWorkAttitudeDTO> selectWorkAttitudeList(int companyNo, String formatedNow);

}
