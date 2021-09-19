package com.nextLevel.hero.salary.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.salary.model.dao.SalaryMapper;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

	private final SalaryMapper salaryMapper; 
	
	@Autowired
	public SalaryServiceImpl(SalaryMapper salaryMapper) {
		this.salaryMapper = salaryMapper;
	}
	
	
}
