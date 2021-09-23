package com.nextLevel.hero.mngSalary.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;

@Mapper
public interface MngSalaryMapper {

	List<MngSalaryDTO> listMngAnnualSalary();

	List<MngDeductFourInsDTO> listMngFourInsuranceList();

}
