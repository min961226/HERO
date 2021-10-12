package com.nextLevel.hero.mngSalary.model.service;

import java.util.List;

import com.nextLevel.hero.mngSalary.model.dto.FourInsRateDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngBonusListDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;
import com.nextLevel.hero.mngSalary.model.dto.SeverancePayDTO;
import com.nextLevel.hero.mngSalary.model.dto.fourInsuranceList;
import com.nextLevel.hero.mngSalary.model.dto.memInsFeeList;
import com.nextLevel.hero.mngSalary.model.dto.memberSeverancePayDTO;

public interface MngSalaryService {

	List<MngSalaryDTO> listMngAnnualSalary(MngSalaryDTO search);

	List<MngDeductFourInsDTO> listMngFourInsuranceList(int companyNo);

	List<MemberInsFeeDTO> listMngNationalHealthInsurancePension(MemberInsFeeDTO search);

	FourInsRateDTO selectInsRate(FourInsRateDTO search);

	List<MngAccountDTO> listmngPayrollAccount();
	
	List<MemberMonthlyPayDTO> listMonthlySalary(MngSalaryDTO search);

	int updateFourInsuranceList(int companyNo, fourInsuranceList deductList);

	int updateMonthlyInsurance(int companyNo, memInsFeeList insFeeList);

	List<MngBonusListDTO> selectBonusCategory(int companyNo);

	String checkCreate(SalaryAndBonusDTO search);

	List<SalaryAndBonusDTO> insertSalary(SalaryAndBonusDTO search);

	List<SalaryAndBonusDTO> insertBonus(SalaryAndBonusDTO search);

	List<SalaryAndBonusDTO> selectSalOrBonusList(SalaryAndBonusDTO search);

	List<SeverancePayDTO> severancePayList(int companyNo);

	memberSeverancePayDTO selectOneSeverancePay(int companyNo, int idNum);



}
