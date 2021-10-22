package com.nextLevel.hero.mngSalary.model.service;

import java.util.List;

import com.nextLevel.hero.mngSalary.model.dto.DetailPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.FourInsRateDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngBonusListDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDepositDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;
import com.nextLevel.hero.mngSalary.model.dto.MonthlyListDTO;
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;
import com.nextLevel.hero.mngSalary.model.dto.SeverancePayDTO;
import com.nextLevel.hero.mngSalary.model.dto.fourInsuranceList;
import com.nextLevel.hero.mngSalary.model.dto.memInsFeeList;
import com.nextLevel.hero.mngSalary.model.dto.memberSeverancePayDTO;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;

public interface MngSalaryService {

	List<MngSalaryDTO> listMngAnnualSalary(MngSalaryDTO search);

	List<MngDeductFourInsDTO> listMngFourInsuranceList(MngDeductFourInsDTO search);

	List<MemberInsFeeDTO> listMngNationalHealthInsurancePension(MemberInsFeeDTO search);

	FourInsRateDTO selectInsRate(FourInsRateDTO search);

	List<MngAccountDTO> listmngPayrollAccount(MngAccountDTO search);
	
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
  
	List<DetailPayDTO> listPersonalDetail(SalaryAndBonusDTO search);

	List<MngDepositDTO> selectDepositList(MngDepositDTO search);

	String updatePersonalDeduct(int companyNo, List<DetailPayDTO> detail);

	List<MyAccountDTO> selectPersonalAccount(MngAccountDTO search);

	List<MonthlyListDTO> selectMonthlyList(int companyNo);

	String updatePersonalMonPay(int companyNo, List<MemberMonthlyPayDTO> detail);



}
