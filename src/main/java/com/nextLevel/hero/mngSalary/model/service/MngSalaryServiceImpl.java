package com.nextLevel.hero.mngSalary.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.mngSalary.model.dao.MngSalaryMapper;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;
import com.nextLevel.hero.mngSalary.model.dto.fourInsuranceList;

@Service("mngSalaryService")
public class MngSalaryServiceImpl implements MngSalaryService {

	private final MngSalaryMapper mngSalaryMapper;
	
	@Autowired
	public MngSalaryServiceImpl(MngSalaryMapper mngSalaryMapper) {
		this.mngSalaryMapper = mngSalaryMapper;
	}

	/* 연봉 조회 - 검색 시 오류 제외 */
	@Override
	public List<MngSalaryDTO> listMngAnnualSalary(MngSalaryDTO search) {
	
		List<MngSalaryDTO> salStepList = mngSalaryMapper.listMngAnnualSalary(search);
		List<MemberMonthlyPayDTO> monthlyList = mngSalaryMapper.listMonthlyPay(search);
		
		System.out.println("월 지급금액 체크"+monthlyList);
		
		// 호봉 정보와 월 지급항목 합산 후 연 환산 
		for(int i = 0; i < salStepList.size(); i++) {
			
			int memberNum = salStepList.get(i).getMemberInfo().getMemberNo();
			int salStepAmount = salStepList.get(i).getSalStepAmount();
			int annualSal = salStepList.get(i).getAnnualSal();
			java.sql.Date latestDate = salStepList.get(i).getChangeStartDate();
			
			for(int j = 0; j < monthlyList.size(); j++) {
				int memNo = monthlyList.get(j).getMemberInfo().getMemberNo();
				
				java.sql.Date monStart = monthlyList.get(j).getMonthlyStartDate();
//				java.sql.Date monEnd = monthlyList.get(j).getMonthlyStartDate();
//				java.sql.Date removeEnd = monthEndDateList.get(j).getMonthlyStopDate(); 

					
					/* 연봉 연산 */
					if(memberNum == memNo) {
						int monthlyPay = monthlyList.get(j).getAmount();
						java.sql.Date salStart = salStepList.get(i).getSalaryStepUpdatedDate();
														
						if(annualSal != 0) {
							annualSal = (annualSal / 12 +  monthlyPay) * 12;
							System.out.println("이미 연산 값이 있으면 연 지급 : " + annualSal);
							if(monStart.compareTo(latestDate) > 0) {
								latestDate = monStart;
							} 
							
							
						} else {
							annualSal = (monthlyPay +  salStepAmount) * 12;
							System.out.println("연산 값이 없으면 연 지급 : " + annualSal);
							if(monStart.compareTo(salStart) > 0) {
								latestDate = monStart;
							} else {
								latestDate = salStart;
							}
						}
					} 

			}
			/* 연봉 금액 및 최종 설정 시작일 List에 담기 */
			if (annualSal == 0) {
				annualSal = salStepAmount * 12;
				latestDate = salStepList.get(i).getSalaryStepUpdatedDate();
				
			}
			salStepList.get(i).setAnnualSal(annualSal);
			salStepList.get(i).setChangeStartDate(latestDate);
			
		}
		System.out.println("서비스 : " + salStepList);
		return salStepList;
	}

	
	
	/* 개인별 월 지급항목 조회 */
	@Override
	public List<MemberMonthlyPayDTO> listMonthlySalary(MngSalaryDTO search) {
		
		return mngSalaryMapper.listMonthlySalary(search);
	}
	
	/* 4대보험 개인별 공제항목 조회*/
	@Override
	public List<MngDeductFourInsDTO> listMngFourInsuranceList(int companyNo) {
		
		return mngSalaryMapper.listMngFourInsuranceList(companyNo);
	}
	
	
	/* 4대보험 개인별 공제항목 수정 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
			rollbackFor = {Exception.class})
	public int updateFourInsuranceList(int companyNo, fourInsuranceList deductList) {
		
		
		List<MngDeductFourInsDTO> beforeList = listMngFourInsuranceList(companyNo);
		List<MngDeductFourInsDTO> afterList = deductList.getFourInsuranceList();
		
		List<MngDeductFourInsDTO> updateList = new ArrayList<>();
		
		/* 변경된 사원 분류 */
		for(int i = 0; i < afterList.size(); i++) {
			
			int afterListMemNo = afterList.get(i).getMemberNo();		
			
			if(afterList.get(i).getHealthYn() != null) {
				afterList.get(i).setHealthYn("Y");
			} else {
				afterList.get(i).setHealthYn("N");
			}
			
			if(afterList.get(i).getPensionYn() != null) {
				afterList.get(i).setPensionYn("Y");
			} else {
				afterList.get(i).setPensionYn("N");
			}
			
			if(afterList.get(i).getUnemployeeYn() != null) {
				afterList.get(i).setUnemployeeYn("Y");
			} else {
				afterList.get(i).setUnemployeeYn("N");
			}
			
			if(afterList.get(i).getIndustryYn() != null) {
				afterList.get(i).setIndustryYn("Y");
			} else {
				afterList.get(i).setIndustryYn("N");
			}
			
			
			String afterHealthYn = afterList.get(i).getHealthYn();
			String afterPensionYn = afterList.get(i).getPensionYn();
			String afterUnEmployeeYn = afterList.get(i).getUnemployeeYn();
			String afterIndustryYn = afterList.get(i).getIndustryYn();
			
			
			
			for(int j = 0; j < beforeList.size(); j++) {
				
				int beforeListMemNo = beforeList.get(j).getMemberNo();
				
				java.sql.Date changeDate = afterList.get(i).getValidateDate();
				java.sql.Date originDate = beforeList.get(j).getValidateDate();
				
				if((beforeListMemNo == afterListMemNo) && (!changeDate.equals(originDate))) {
					
					MngDeductFourInsDTO update = new MngDeductFourInsDTO();
					
					update.setCompanyNo(beforeList.get(j).getCompanyNo());
					update.setDivNo(beforeList.get(j).getDivNo());
					update.setIdNo(beforeList.get(j).getIdNo());
					update.setMemberNo(afterListMemNo);
					update.setValidateDate(changeDate);
					update.setHealthYn(afterHealthYn);
					update.setPensionYn(afterPensionYn);
					update.setUnemployeeYn(afterUnEmployeeYn);
					update.setIndustryYn(afterIndustryYn);
					
					updateList.add(update);
				}
			}
		}

		System.out.println(updateList);
				
		int updateFourInsResult = 0;
		int insertHistoryResult = 0;
		
		int finalResult = 0;  
		
		if (updateList.size() > 0) {
			for(MngDeductFourInsDTO personal : updateList) {
				updateFourInsResult += mngSalaryMapper.updateFourInsuranceList(personal);
				insertHistoryResult += mngSalaryMapper.insertFourInsHistory(personal);
			}		
			
		} else {
			finalResult = 0;
		}
		
		
		if(updateFourInsResult > 0 && insertHistoryResult > 0 && (updateFourInsResult == updateList.size() ) 
				&& (insertHistoryResult == updateList.size())) {
			
			finalResult = 1;
		}
				
		return finalResult;
	}

	

	/* 건강, 국민연금 보수월액 및 공제금액 조회 */
	@Override
	public List<MemberInsFeeDTO> listMngNationalHealthInsurancePension(MemberInsFeeDTO search) {
		
		return mngSalaryMapper.listMngNationalHealthInsurancePension(search);
	}

	
	/* 급여 계좌 조회 */
	@Override
	public List<MngAccountDTO> listmngPayrollAccount() {
		
		return mngSalaryMapper.listmngPayrollAccount();
	}

	

	
	
}
