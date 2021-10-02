package com.nextLevel.hero.mngSalary.model.service;

import java.util.List;

import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;
import com.nextLevel.hero.mngSalary.model.dto.fourInsuranceList;

public interface MngSalaryService {

	List<MngSalaryDTO> listMngAnnualSalary(MngSalaryDTO search);

	List<MngDeductFourInsDTO> listMngFourInsuranceList(int companyNo);

	List<MemberInsFeeDTO> listMngNationalHealthInsurancePension(MemberInsFeeDTO search);

	List<MngAccountDTO> listmngPayrollAccount();
	
	List<MemberMonthlyPayDTO> listMonthlySalary(MngSalaryDTO search);

	int updateFourInsuranceList(int companyNo, fourInsuranceList deductList);


}
