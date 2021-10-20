package com.nextLevel.hero.mngWorkAttitude.model.service;

import java.util.List;
import java.util.Map;

import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateViewDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;

public interface MngWorkAttitudeService {

	List<MngWorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo, Map searchMap, SelectCriteria selectCriteria);

	List<MngAttitudeUpdateDTO> selectAllWorkAttitudeUpdate(int companyNo, Map searchMap);

	int updateWorkAttitude(MngUpdateDTO updateDTO);

	List<MngAttitudeUpdateDTO> selectUpdateAttitudeList(int companyNo, Map searchMap);

	List<MngAttitudeUpdateViewDTO> selectAllUpdateAttitudeList(int companyNo, int memberNo);

	int selectMemberCount(int companyNo, Map searchMap);

}
