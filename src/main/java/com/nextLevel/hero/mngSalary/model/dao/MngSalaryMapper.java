package com.nextLevel.hero.mngSalary.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;

@Mapper
public interface MngSalaryMapper {

	List<MngSalaryDTO> listMngAnnualSalary(MngSalaryDTO search);
	
	List<MemberMonthlyPayDTO> listMonthlyPay(MngSalaryDTO search);

	List<MngDeductFourInsDTO> listMngFourInsuranceList();

	List<MemberInsFeeDTO> listMngNationalHealthInsurancePension();

	List<MngAccountDTO> listmngPayrollAccount();

	List<MemberMonthlyPayDTO> listMonthlySalary(MngSalaryDTO search);

	

}
