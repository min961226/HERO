package com.nextLevel.hero.workattitude.model.service;

import java.util.List;
import java.util.Map;

import com.nextLevel.hero.workattitude.model.dto.EmployeeAnnualVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;

public interface WorkAttitudeService {

	EmployeeAnnualVacationDTO listEmployeeAnnualVacation(int companyNo, int idNo);

	List<EmployeeVacationDTO> listEmployeeVacation(int companyNo, int no);

	int insertVacation(EmployeeVacationDTO employeeVacationDTO);

	List<WorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo,int idNo, Map searchMap);

}
