package com.nextLevel.hero.mngPay.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.mngPay.model.dao.MngPayMapper;
import com.nextLevel.hero.mngPay.model.dto.MngPayDTO;
import com.nextLevel.hero.mngPay.model.dto.MngPayListDTO;
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;

@Service("mngPayService")
public class MngPayServiceImpl implements MngPayService{

	private final MngPayMapper mngPayMapper;
	
	@Autowired
	public MngPayServiceImpl(MngPayMapper mngPayMapper) {
		this.mngPayMapper = mngPayMapper;
	}

	/* 급상여 지급 리스트 조회 */
	@Override
	public List<MngPayDTO> selectPayList(MngPayDTO search) {
		
		return mngPayMapper.selectPayList(search);
	}

	/* 급상여 지급 승인 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
			rollbackFor = {Exception.class})
	public String updateSalAndBonusConfirm(SalaryAndBonusDTO update) {
		
		int result = mngPayMapper.updateSalAndBonusConfirm(update);
		String updateResult = "";
		
		if(result > 0) {
			updateResult = "1";
		} else {
			updateResult = "0";
		}
		return updateResult;
	}

	
	/* 세부 이체 리스트 */
	@Override
	public List<MngPayListDTO> selectPayListDetail(MngPayListDTO search) {
			
		
		return mngPayMapper.selectPayListDetail(search);
	}
	
	
	
	
	
	
	
}
