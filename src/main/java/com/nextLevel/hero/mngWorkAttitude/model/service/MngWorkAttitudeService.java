package com.nextLevel.hero.mngWorkAttitude.model.service;

import java.util.List;

import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;

public interface MngWorkAttitudeService {

	List<MngWorkAttitudeDTO> selectWorkAttitudeList(int companyNo);

}
