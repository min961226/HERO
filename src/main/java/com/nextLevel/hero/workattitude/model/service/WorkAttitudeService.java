package com.nextLevel.hero.workattitude.model.service;

import java.util.List;

import com.nextLevel.hero.workattitude.model.dto.EmployeeAnnualVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;

public interface WorkAttitudeService {

	EmployeeAnnualVacationDTO listEmployeeAnnualVacation(int companyNo, int idNo);

	List<EmployeeVacationDTO> listEmployeeVacation(int companyNo, int no);

	int insertVacation(EmployeeVacationDTO employeeVacationDTO);


	

	
import java.util.Map;

import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;

public interface WorkAttitudeService {

	List<WorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo,int idNo, Map searchMap);

}
