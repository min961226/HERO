package com.nextLevel.hero.mngWorkAttitude.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateViewDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkCommuteDTO;

@Mapper
public interface MngWorkAttitudeMapper {

	int selectMemberCount(Map<String, String> searchMap, int companyNo);
	
	List<MngWorkAttitudeDTO> selectMemberList(Map<String, String> searchMap, int companyNo,SelectCriteria selectCriteria );
	
	List<MngWorkCommuteDTO> selectWorkAttitudeList(MngWorkAttitudeDTO memberInfo, String formatedNow);

	List<MngAttitudeUpdateDTO> selectUpdateList(Map searchMap, int companyNo, SelectCriteria selectCriteria);
	
	MngWorkCommuteDTO selectWorkAttitude(MngUpdateDTO updateDTO, String updateDate);
	
	int insertWorkAttitude(MngUpdateDTO updateDTO, MngWorkCommuteDTO commuteDTO);

	int updateWorkAttitude(MngUpdateDTO updateDTO, String updateDate);

	List<MngAttitudeUpdateViewDTO> selectUpdateAttitudeList(int companyNo, int memberNo);





}
