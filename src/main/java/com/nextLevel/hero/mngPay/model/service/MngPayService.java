package com.nextLevel.hero.mngPay.model.service;

import java.util.List;

import com.nextLevel.hero.mngPay.model.dto.MngPayDTO;
import com.nextLevel.hero.mngPay.model.dto.MngPayListDTO;
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;

public interface MngPayService {

	List<MngPayDTO> selectPayList(MngPayDTO search);

	String updateSalAndBonusConfirm(SalaryAndBonusDTO update);

	List<MngPayListDTO> selectPayListDetail(MngPayListDTO search);

}
