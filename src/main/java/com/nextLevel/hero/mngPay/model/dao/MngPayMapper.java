package com.nextLevel.hero.mngPay.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngPay.model.dto.MngPayDTO;
import com.nextLevel.hero.mngPay.model.dto.MngPayListDTO;
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;

@Mapper
public interface MngPayMapper {

	List<MngPayDTO> selectPayList(MngPayDTO search);

	int updateSalAndBonusConfirm(SalaryAndBonusDTO update);

	List<MngPayListDTO> selectPayListDetail(MngPayListDTO search);

}
