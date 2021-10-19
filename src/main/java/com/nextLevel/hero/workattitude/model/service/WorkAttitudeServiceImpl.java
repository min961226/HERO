package com.nextLevel.hero.workattitude.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.workattitude.model.dao.WorkAttitudeMapper;
import com.nextLevel.hero.workattitude.model.dto.EmployeeAnnualVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;


@Service("workAttitudeService")
public class WorkAttitudeServiceImpl implements WorkAttitudeService{
	
	 private WorkAttitudeMapper workAttitudeMapper;
	   
	   @Autowired
	   public WorkAttitudeServiceImpl(WorkAttitudeMapper workAttitudeMapper) {
	      this.workAttitudeMapper = workAttitudeMapper;
	   }


	@Override
	public List<EmployeeVacationDTO> listEmployeeVacation(int companyNo, int no) {
		return workAttitudeMapper.listEmployeeVacation(companyNo,no);
	}


	@Override
	public EmployeeAnnualVacationDTO listEmployeeAnnualVacation(int companyNo, int idNo) {
		return workAttitudeMapper.listEmployeeAnnualVacation(companyNo,idNo);
	}


	@Override
	@Transactional
	public int insertVacation(EmployeeVacationDTO employeeVacationDTO) {
		
		return workAttitudeMapper.insertVacation(employeeVacationDTO);
	}




}
