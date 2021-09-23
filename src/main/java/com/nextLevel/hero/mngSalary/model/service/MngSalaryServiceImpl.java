package com.nextLevel.hero.mngSalary.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngSalary.model.dao.MngSalaryMapper;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;

@Service("mngSalaryService")
public class MngSalaryServiceImpl implements MngSalaryService {

	private final MngSalaryMapper mngSalaryMapper;
	
	@Autowired
	public MngSalaryServiceImpl(MngSalaryMapper mngSalaryMapper) {
		this.mngSalaryMapper = mngSalaryMapper;
	}

	/* 연봉 조회 */
	@Override
	public List<MngSalaryDTO> listMngAnnualSalary() {
		
		return mngSalaryMapper.listMngAnnualSalary();
	}

	
	/* 4대보험 개인별 공제항목 조회*/
	@Override
	public List<MngDeductFourInsDTO> listMngFourInsuranceList() {
		
		return mngSalaryMapper.listMngFourInsuranceList();
	}

	
	
}
