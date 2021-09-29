package com.nextLevel.hero.mngSalary.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngSalary.model.dao.MngSalaryMapper;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
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
	public List<MngSalaryDTO> listMngAnnualSalary(MngSalaryDTO search) {

		/*
		List<MngSalaryDTO> salStepList = mngSalaryMapper.listMngAnnualSalary(search);
		List<MemberMonthlyPayDTO> monthlyList = mngSalaryMapper.listMonthlyPay(search);
		
		List<MngSalaryDTO> annualList = new ArrayList<>();
		
		 호봉 정보와 월 지급항목 합산 후 연 환산 
		for(int i = 0; i < salStepList.size(); i++) {
			
			if()
			for(int j = 0; j < monthlyList.size(); j++) {
				
			}
		}*/
		
		
		return mngSalaryMapper.listMngAnnualSalary(search);
	}

	
	
	/* 개인별 월 지급항목 조회 */
	@Override
	public List<MemberMonthlyPayDTO> listMonthlySalary(MngSalaryDTO search) {
		
		return mngSalaryMapper.listMonthlySalary(search);
	}
	
	/* 4대보험 개인별 공제항목 조회*/
	@Override
	public List<MngDeductFourInsDTO> listMngFourInsuranceList() {
		
		return mngSalaryMapper.listMngFourInsuranceList();
	}

	/* 건강, 국민연금 보수월액 및 공제금액 조회 */
	@Override
	public List<MemberInsFeeDTO> listMngNationalHealthInsurancePension() {
		
		return mngSalaryMapper.listMngNationalHealthInsurancePension();
	}

	
	/* 급여 계좌 조회 */
	@Override
	public List<MngAccountDTO> listmngPayrollAccount() {
		
		return mngSalaryMapper.listmngPayrollAccount();
	}


	
	
}
