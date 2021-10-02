package com.nextLevel.hero.salary.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.salary.model.dao.SalaryMapper;
import com.nextLevel.hero.salary.model.dto.BankListDTO;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

	private final SalaryMapper salaryMapper; 
	
	@Autowired
	public SalaryServiceImpl(SalaryMapper salaryMapper) {
		this.salaryMapper = salaryMapper;
	}

	/* 본인 등록 계좌 리스트 조회 */
	@Override
	public List<MyAccountDTO> selectAccountList(int companyNo, int idNo) {
		
		return salaryMapper.selectAccountList(companyNo, idNo);
	}

	/* 추가 등록 시, 등록 가능한 은행 리스트 조회 */
	@Override
	public List<BankListDTO> selectBankList() {
		
		
		return salaryMapper.selectBankList();
	}
	
	
}
