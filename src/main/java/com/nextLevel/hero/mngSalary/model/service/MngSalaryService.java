package com.nextLevel.hero.mngSalary.model.service;

import java.util.List;

import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;

public interface MngSalaryService {

	List<MngSalaryDTO> listMngAnnualSalary();

	List<MngDeductFourInsDTO> listMngFourInsuranceList();

	List<MemberInsFeeDTO> listMngNationalHealthInsurancePension();

	List<MngAccountDTO> listmngPayrollAccount();

	List<MemberMonthlyPayDTO> listMonthlySalary(int memberNo, int companyNo);


}
