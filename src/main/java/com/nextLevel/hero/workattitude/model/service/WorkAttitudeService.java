package com.nextLevel.hero.workattitude.model.service;

import java.util.List;
import java.util.Map;

import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;

public interface WorkAttitudeService {

	List<WorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo,int idNo, Map searchMap);

}
