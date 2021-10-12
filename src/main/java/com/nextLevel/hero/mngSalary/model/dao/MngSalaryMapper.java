package com.nextLevel.hero.mngSalary.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngSalary.model.dto.AppointmentDTO;
import com.nextLevel.hero.mngSalary.model.dto.DetailPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.FourInsRateDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngBonusListDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;

@Mapper
public interface MngSalaryMapper {

	List<MngSalaryDTO> listMngAnnualSalary(MngSalaryDTO search);
	
	List<MemberMonthlyPayDTO> listMonthlyPay(MngSalaryDTO search);

	List<MemberMonthlyPayDTO> listMonthlyPay2(MngSalaryDTO search);

	List<MngDeductFourInsDTO> listMngFourInsuranceList(int companyNo);
	
	int updateFourInsuranceList(MngDeductFourInsDTO personal);

	int insertFourInsHistory(MngDeductFourInsDTO personal);

	List<MemberInsFeeDTO> listMngNationalHealthInsurancePension(MemberInsFeeDTO search);

	List<MngAccountDTO> listmngPayrollAccount();

	List<MemberMonthlyPayDTO> listMonthlySalary(MngSalaryDTO search);

	FourInsRateDTO selectInsRate(FourInsRateDTO search);

	int updateMonthlyInsurance(MemberInsFeeDTO personal);

	List<MemberInsFeeDTO> selectNewMemberInsFee(MemberInsFeeDTO search);

	List<MngBonusListDTO> selectBonusCategory(int companyNo);

	int checkCreate(SalaryAndBonusDTO search);

	AppointmentDTO selectAppointment(AppointmentDTO appointment);

	int insertDetailPay(DetailPayDTO personalPaydetail);

	List<DetailPayDTO> selectPayList(SalaryAndBonusDTO search);

	Integer selectIncomeTax(int companyNo, int calcTaxSalary);

	MngDeductFourInsDTO selectOneFourInsDeduct(MngDeductFourInsDTO fourIns);

	MemberInsFeeDTO selectOneInsFee(MemberInsFeeDTO fee);

	void insertDetailDeduct(DetailPayDTO deductDTO);

	void insertEmployerDeduct(DetailPayDTO deductDTO);

	void insertNewMemInsFee(MemberInsFeeDTO update);

	int insertSalaryList(SalaryAndBonusDTO personalCalc);

	List<SalaryAndBonusDTO> selectSalOrBonusList(SalaryAndBonusDTO search);

	

}
