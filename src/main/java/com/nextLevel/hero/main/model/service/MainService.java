package com.nextLevel.hero.main.model.service;

import java.util.List;
import java.util.Map;

import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;

public interface MainService {

	List<WorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo, int idNo, Map searchMap);

}
