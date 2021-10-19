package com.nextLevel.hero.salary.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngSalary.model.dto.DetailPayDTO;
import com.nextLevel.hero.salary.model.dao.SalaryMapper;
import com.nextLevel.hero.salary.model.dto.BankListDTO;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;
import com.nextLevel.hero.salary.model.dto.SalaryDTO;

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

	/* 급상여 리스트 조회*/
	@Override
	public List<SalaryDTO> selectMyPaymentList(SalaryDTO search) {
		
		return salaryMapper.selectMyPaymentList(search);
	}

	/* 급상여 세부 리스트 조회 */
	@Override
	public List<DetailPayDTO> selectDetailList(SalaryDTO search) {
		
		List<DetailPayDTO> payList = salaryMapper.listPayDetail(search);
		List<DetailPayDTO> deductList = salaryMapper.listDeductDetail(search);
		
		System.out.println("서비스 : " + payList);
		System.out.println("서비스 : " + deductList);
		
		List<DetailPayDTO> detailList = new ArrayList<>();
		
		for(DetailPayDTO pay : payList) {
						
			detailList.add(pay);
		}
		
		for(DetailPayDTO deduct : deductList) {
			
			deduct.setDivNo(1);
			detailList.add(deduct);
		}
		
		System.out.println("서비스 결과 : " + detailList);
		
		return detailList;
	}
	
	
}
