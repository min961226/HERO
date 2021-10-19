package com.nextLevel.hero.workattitude.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.workattitude.model.dto.EmployeeAnnualVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;

@Mapper
public interface WorkAttitudeMapper {


	List<EmployeeVacationDTO> listEmployeeVacation(int companyNo, int no);

	EmployeeAnnualVacationDTO listEmployeeAnnualVacation(int companyNo, int idNo);

	int insertVacation(EmployeeVacationDTO employeeVacationDTO);

	

}
