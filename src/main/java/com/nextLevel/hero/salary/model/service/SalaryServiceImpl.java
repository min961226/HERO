package com.nextLevel.hero.salary.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.salary.model.dao.SalaryMapper;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

	private final SalaryMapper salaryMapper; 
	
	@Autowired
	public SalaryServiceImpl(SalaryMapper salaryMapper) {
		this.salaryMapper = salaryMapper;
	}

	@Override
	public List<MyAccountDTO> selectAccountList(int companyNo, int idNo) {
		
		return salaryMapper.selectAccountList(companyNo, idNo);
	}
	
	
}
