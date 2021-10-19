package com.nextLevel.hero.mngWorkAttitude.model.service;

import java.util.List;
import java.util.Map;

import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;

public interface MngWorkAttitudeService {

	List<MngWorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo, Map searchMap);

	List<MngAttitudeUpdateDTO> selectAllWorkAttitudeUpdate(int companyNo, Map searchMap);

	int updateWorkAttitude(MngUpdateDTO updateDTO);

}
