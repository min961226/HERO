package com.nextLevel.hero.workattitude.model.service;

import java.util.List;
import java.util.Map;

import com.nextLevel.hero.workattitude.model.dto.EmployeeAnnualVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;

public interface WorkAttitudeService {

	/* 직원의 연차 조회 */
	EmployeeAnnualVacationDTO listEmployeeAnnualVacation(int companyNo, int idNo);

	/* 직원의 휴가 신청내역 조회 */
	List<EmployeeVacationDTO> listEmployeeVacation(int companyNo, int no);

	/* 직원의 휴가 신청 */
	int insertVacation(EmployeeVacationDTO employeeVacationDTO);

	List<WorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo,int idNo, Map<String, String> searchMap);

}
