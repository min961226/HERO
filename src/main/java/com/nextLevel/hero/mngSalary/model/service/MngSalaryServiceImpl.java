package com.nextLevel.hero.mngSalary.model.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.mngSalary.model.dao.MngSalaryMapper;
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
import com.nextLevel.hero.mngSalary.model.dto.fourInsuranceList;
import com.nextLevel.hero.mngSalary.model.dto.memInsFeeList;

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
		
				
		// 호봉 정보와 월 지급항목 합산 후 연 환산 
		for(int i = 0; i < salStepList.size(); i++) {
			
			int memberNum = salStepList.get(i).getMemberInfo().getMemberNo();
			int salStepAmount = salStepList.get(i).getSalStepAmount();
			int annualSal = salStepList.get(i).getAnnualSal();
			java.sql.Date latestDate = salStepList.get(i).getChangeStartDate();
			
			for(int j = 0; j < monthlyList.size(); j++) {
				int memNo = monthlyList.get(j).getMemberInfo().getMemberNo();
				
				java.sql.Date monStart = monthlyList.get(j).getMonthlyStartDate();

					
					/* 연봉 연산 */
					if(memberNum == memNo) {
						int monthlyPay = monthlyList.get(j).getAmount();
						java.sql.Date salStart = salStepList.get(i).getSalaryStepUpdatedDate();
														
						if(annualSal != 0) {
							annualSal = (annualSal / 12 +  monthlyPay) * 12;
							
							if(monStart.compareTo(latestDate) > 0) {
								latestDate = monStart;
							} 
							
							
						} else {
							annualSal = (monthlyPay +  salStepAmount) * 12;
							
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
	} // 4대보험 개인별 공제항목 수정 종료

	

	/* 건강, 국민연금 보수월액 및 공제금액 조회 */
	@Override
	public List<MemberInsFeeDTO> listMngNationalHealthInsurancePension(MemberInsFeeDTO search) {
	
		List<MemberInsFeeDTO> originMemberList = mngSalaryMapper.listMngNationalHealthInsurancePension(search);
		List<MemberInsFeeDTO> newMemberList = mngSalaryMapper.selectNewMemberInsFee(search);
			
		if(newMemberList.size() > 0) {
			for(MemberInsFeeDTO newMember : newMemberList) {
				originMemberList.add(newMember);
			}
		}		
	
		
		
		
		return originMemberList;
	}
	

	/* 건강, 국민연금 적용 요율 조회 */
	@Override
	public FourInsRateDTO selectInsRate(FourInsRateDTO search) {
		
		return mngSalaryMapper.selectInsRate(search);
	}
	
	
	/* 개인별 건강, 국민연금 보수월액 및 보험료 수정 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
			rollbackFor = {Exception.class})
	public int updateMonthlyInsurance(int companyNo, memInsFeeList insFeeList) {
		
		MemberInsFeeDTO search = new MemberInsFeeDTO();
		search.setCompanyNo(companyNo);
		
		List<MemberInsFeeDTO> beforeList = listMngNationalHealthInsurancePension(search);
		List<MemberInsFeeDTO> afterList = insFeeList.getMemInsFeeList();
		List<MemberInsFeeDTO> updateList = new ArrayList<>();
		
		System.out.println("서비스 폼 개수 : " + insFeeList.getMemInsFeeList().size());
		
		/* 이번 리스트와 비교 */
		for(int j = 0; j < insFeeList.getMemInsFeeList().size(); j++) {
			
			System.out.println("서비스 비교대상 리스트 : " + insFeeList.getMemInsFeeList().get(j));
			
			int afterMemNo = afterList.get(j).getMemberNo();
			int afterDivNo = Integer.parseInt(afterList.get(j).getDivNo());
			java.sql.Date afterHealthStartDate = afterList.get(j).getHealthCoverDate();
			Integer afterHealthSal = afterList.get(j).getHealthSal();
			int afterlongtermFee = afterList.get(j).getLongtermFee();
			
			java.sql.Date afterPensionStartDate = afterList.get(j).getPensionCoverDate();			
			Integer afterPensionSal = afterList.get(j).getPensionSal();
			int afterPensionFee = afterList.get(j).getPensionFee();
			
			MemberInsFeeDTO update = new MemberInsFeeDTO();
		
		
			for(int i = 0; i < beforeList.size(); i++) {
				
				int beforeMemNo = beforeList.get(i).getMemberNo();
				
				Integer originHealthSal = beforeList.get(i).getHealthSal();
				int originlongtermFee = beforeList.get(i).getLongtermFee();
					
				Integer originPensionSal = beforeList.get(i).getPensionSal();
				
				
				if((beforeMemNo == afterMemNo) && 
						(((!originHealthSal.equals(afterHealthSal)) || (originlongtermFee != afterlongtermFee))
						|| (!originPensionSal.equals(afterPensionSal)))) {
					
					update.setCompanyNo(companyNo);
					update.setMemberNo(afterMemNo);
					update.setDivNum(afterDivNo);
					update.setHealthCoverDate(afterHealthStartDate);
					update.setHealthSal(afterHealthSal);
					update.setHealthInsFee(afterList.get(j).getHealthInsFee());
					update.setLongtermFee(afterlongtermFee);
					update.setPensionCoverDate(afterPensionStartDate);
					update.setPensionSal(afterPensionSal);
					update.setPensionFee(afterPensionFee);
					
					updateList.add(update);
					
				} 					
			}
		}
		
		int insertResult = 0;
		int finalResult = 0;
		
		
		if (updateList.size() > 0) {
			for(MemberInsFeeDTO personal : updateList) {
				insertResult += mngSalaryMapper.updateMonthlyInsurance(personal);
			}		
			
		} else {
			finalResult = 0;
		}
				
		if(insertResult > 0  && (insertResult == updateList.size())) {			
			finalResult = 1;
		}
		
		
		return finalResult;
	}

	/* 상여 항목 조회 */
	@Override
	public List<MngBonusListDTO> selectBonusCategory(int companyNo) {
		
		return mngSalaryMapper.selectBonusCategory(companyNo);
	}
	
	/* 급상여 생성여부 체크 */
	@Override
	public String checkCreate(SalaryAndBonusDTO search) {
		
		int count = mngSalaryMapper.checkCreate(search);
		String result = "";
		
		if(count > 0) {
			result = "1";
		} else {
			result = "0";
		}
		
		return result;
	}

	/* 정기 급여 생성 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
			rollbackFor = {Exception.class})
	public List<SalaryAndBonusDTO> insertSalary(SalaryAndBonusDTO search) {

		List<SalaryAndBonusDTO> salList = new ArrayList<>();
		
		String year = "";
		String month = "";
		if(search.getMonth().equals("12")) {
			year = String.valueOf(Integer.parseInt(search.getYear()) + 1);
			month = "1";
		} else {
			year = search.getYear();
			month = String.valueOf(Integer.parseInt(search.getMonth()) + 1);
		}
		
		String searchingDate = year + month + "01";
		
		MngSalaryDTO salaryDTO = new MngSalaryDTO();
		salaryDTO.setCompanyNo(search.getCompanyNo());
		salaryDTO.setSearchDate(searchingDate);
		
		
		List<MngSalaryDTO> salStepList = mngSalaryMapper.listMngAnnualSalary(salaryDTO);
		List<MemberMonthlyPayDTO> monthlyList = mngSalaryMapper.listMonthlyPay(salaryDTO);
		
		
		int basicMonthlyAmount = 0;
		String imputedDate = search.getYear() + "-" + search.getMonth();
		
		List<DetailPayDTO> personalPay = new ArrayList<>();
		
		/* 호봉 정보와 월 지급항목 합산 */
		for(int i = 0; i < salStepList.size(); i++) {
						
			int memberNum = salStepList.get(i).getMemberInfo().getMemberNo();
			int salStepAmount = salStepList.get(i).getSalStepAmount();			
			
				
				DetailPayDTO pay = new DetailPayDTO();
				pay.setCompanyNo(search.getCompanyNo());
				pay.setMemberNo(memberNum);
				pay.setIdNo(salStepList.get(i).getMemberInfo().getIdNo());
				pay.setImputedDate(imputedDate);
				pay.setSalOrBonus(search.getCategory());
				pay.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
				pay.setMemberName(salStepList.get(i).getMemberInfo().getMemberName());
				pay.setDepartmentName(salStepList.get(i).getDepartmentName());
				pay.setSalaryName("기본급");
				pay.setSalaryAmount(salStepAmount);

				personalPay.add(pay);
				
				/* 월 지급항목 추가 */
				for(int j = 0; j < monthlyList.size(); j++) {
					
					int memNo = monthlyList.get(j).getMemberInfo().getMemberNo();
													
					if(memberNum == memNo) {
						int monthlyPay = monthlyList.get(j).getAmount();
						
						DetailPayDTO monPay = new DetailPayDTO();
						monPay.setCompanyNo(search.getCompanyNo());
						monPay.setMemberNo(memberNum);
						monPay.setIdNo(salStepList.get(i).getMemberInfo().getIdNo());
						monPay.setImputedDate(imputedDate);
						monPay.setSalOrBonus(search.getCategory());
						monPay.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
						monPay.setMemberName(salStepList.get(i).getMemberInfo().getMemberName());
						monPay.setDepartmentName(salStepList.get(i).getDepartmentName());
						monPay.setSalaryName(monthlyList.get(j).getPayCategory());
						monPay.setSalaryAmount(monthlyPay);
						
						personalPay.add(monPay);
					}
									
				}
						
				/* 발령에 따른 월 지급액 재계산 */
				AppointmentDTO appointment = new AppointmentDTO();
				appointment.setCompanyNo(search.getCompanyNo());
				appointment.setSearchDate(searchingDate);
				appointment.setMemberNo(memberNum);
				
				appointment = mngSalaryMapper.selectAppointment(appointment);
				String appointmentCategory = appointment.getAppointment();
				
				
				SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM");
				String appYearAndMonth = dateForm.format(appointment.getDate());
													
				LocalDate typeChangeSearchingDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
				
					/* 월 중 입사자 */
					if((appointmentCategory.equals("입사")) && (appYearAndMonth.equals(search.getYear() +"-"+ search.getMonth()))
							&& (appointment.getDate().toLocalDate().getDayOfMonth() != 1)) {
						
						/* 근무일수 산출 */
						long workDate = ChronoUnit.DAYS.between(appointment.getDate().toLocalDate(), typeChangeSearchingDate); 
						
						/* 입사월 말일 산출 */
						int hireMonLastDay = appointment.getDate().toLocalDate().lengthOfMonth();
						
						/* 입사일부터 말일까지 급여 일할 계산 */
						for(int k = 0; k < personalPay.size(); k++) {
							if(memberNum == personalPay.get(k).getMemberNo()) {						
								basicMonthlyAmount = personalPay.get(k).getSalaryAmount();							
								int calcBasicAmount = (int) Math.ceil((basicMonthlyAmount /  hireMonLastDay * workDate) / 10) * 10;
								
								personalPay.get(k).setSalaryAmount(calcBasicAmount);
							}
						}
						
					} else if((appointmentCategory.equals("퇴사")) && (appYearAndMonth.equals(search.getYear() +"-"+ search.getMonth()))) {
						
						/* 퇴사일 근무일수 */
						int entDay = appointment.getDate().toLocalDate().getDayOfMonth();
						
						/* 퇴사월 말일 산출 */
						int entMonLastDay = appointment.getDate().toLocalDate().lengthOfMonth();
						
						/* 퇴사월 급여 산출 */
						for(int k = 0; k < personalPay.size(); k++) {
							if(memberNum == personalPay.get(k).getMemberNo()) {		
								basicMonthlyAmount = personalPay.get(k).getSalaryAmount();	
								int calcBasicAmount = (int) Math.ceil((basicMonthlyAmount /  entMonLastDay * entDay) / 10) * 10;
							
								personalPay.get(k).setSalaryAmount(calcBasicAmount);
							}
						}
						
					} else if((appointmentCategory.equals("무급휴직")) || (appointmentCategory.equals("육아휴직"))) {
						
						/* 휴직 시작일이 당월인 경우 */
						if(appYearAndMonth.equals(search.getYear() +"-"+ search.getMonth())) {
							
							/* 휴직월 근무일수 */
							int leaveDay = appointment.getDate().toLocalDate().getDayOfMonth();
							
							/* 휴직월 말일 산출 */						
							int leaveMonLastDay = appointment.getDate().toLocalDate().lengthOfMonth();
							
							/* 휴직월 급여 산출 */
							for(int k = 0; k < personalPay.size(); k++) {
								if(memberNum == personalPay.get(k).getMemberNo()) {		
									basicMonthlyAmount = personalPay.get(k).getSalaryAmount();
									int calcBasicAmount = (int)Math.ceil((basicMonthlyAmount / leaveMonLastDay * leaveDay) / 10) * 10;
									
									personalPay.get(k).setSalaryAmount(calcBasicAmount);
								}
							}							
						} 
					}
				
					
				} //월 지급액 계산 종료
					
				
		System.out.println("정기급여 지급리스트 : " + personalPay);
		System.out.println("salStep 체크 : " + salStepList);
				
		/* 개인별 지급금액 리스트 insert */
		int insertPayResult = 0;
		for(DetailPayDTO personalPaydetail : personalPay) {
			insertPayResult += mngSalaryMapper.insertDetailPay(personalPaydetail);
		}
							
				
		/* 정기 급여 공제 금액 산출 */
		List<DetailPayDTO> deductDetail = new ArrayList<>();
				
		/* 개인별 지급 총액 */
		for(int i = 0; i < salStepList.size(); i++) {
					
			SalaryAndBonusDTO calc = new SalaryAndBonusDTO();
			calc.setCompanyNo(search.getCompanyNo());
			calc.setMemberNo(salStepList.get(i).getMemberInfo().getMemberNo());
			calc.setMemberName(salStepList.get(i).getMemberInfo().getMemberName());
			calc.setDepartmentName(salStepList.get(i).getDepartmentName());
			calc.setRank(salStepList.get(i).getRank());
			calc.setSalaryStep(salStepList.get(i).getSalaryStep());
			calc.setSearchPayDate(search.getSearchPayDate());
					
			searchingDate = year + "-" + month + "-" + "01";
			calc.setSearchingValidateDate(searchingDate);
			calc.setCategory(search.getCategory());
			calc.setYear(search.getYear());
			calc.setMonth(search.getMonth());
					
			System.out.println("넘기기전 체크 : " + calc);
				
			calcDeductAndTotalSal(calc);						
					
			salList.add(calc);
		}
			
		System.out.println("인서트 전 체크 : " + salList);
		
		int lastResult = 0;
				
		for(SalaryAndBonusDTO personalCalc : salList) {
			lastResult += mngSalaryMapper.insertSalaryList(personalCalc);
		}
		
		if(lastResult != salList.size()) {
			salList = null;
		}
		
		return salList;
	}

	/* 개인별 급여 공제항목 연산 및 급여 리스트 산출 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
			rollbackFor = {Exception.class})
	public SalaryAndBonusDTO calcDeductAndTotalSal(SalaryAndBonusDTO search) {
		
		System.out.println("calc로 넘어옴 : " + search);
		
		int companyNo = search.getCompanyNo();
		int memberNo = search.getMemberNo();
		String imputedDate = search.getYear() + "-" + search.getMonth();
		search.setYearAndMonth(imputedDate);
		
		List<DetailPayDTO> payList = mngSalaryMapper.selectPayList(search);
		int totalPay = 0;
		int calcTaxSalary = 0;																
		int totalDeduct = 0;
		System.out.println("calc 지급총액 체크 : " + payList);
		/* 개인별 총 지급금액과 과세금액 산출 */
		for(int i = 0; i < payList.size(); i++) {
			if(((payList.get(i).getSalaryName()).equals("기본급")) || ((payList.get(i).getDeductYn()).equals("Y"))) {
				
				totalPay += payList.get(i).getSalaryAmount();
				calcTaxSalary += payList.get(i).getSalaryAmount();
			
			} else {
				
				totalPay += payList.get(i).getSalaryAmount();
			}
		}
		
		/* 지급 총액 및 지급 일자 return 값에 추가 */
		search.setSalaryAmount(totalPay);
		search.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
		
		
		/* 소득세 산출 */
		Integer incometax = mngSalaryMapper.selectIncomeTax(companyNo, calcTaxSalary);
		int residentTax = 0;
		
		if(incometax != null) {
			residentTax = (int)(Math.floor((incometax * 0.1) / 10) * 10); 			
		} else {
			incometax = 0;
		}
		
		
		/* 개인별 4대보험 공제항목 확인 및 월 공제액, 보험요율 확인 */
		
		/* 개인별 공제항목 확인 및 월 공제액 */
		int healthFee = 0;
		int longtermFee = 0;
		
		int pensionFee = 0;
		int unemployeeFee = 0;
		int employerEmpInsFee = 0;
		int industryFee = 0;
		
		/* 4대보험 공제 여부 조회 */
		MngDeductFourInsDTO fourIns = new MngDeductFourInsDTO();
		fourIns.setCompanyNo(companyNo);
		fourIns.setMemberNo(memberNo);
		fourIns.setSearchStartDate(search.getSearchingValidateDate());
		
		MngDeductFourInsDTO personalFour = mngSalaryMapper.selectOneFourInsDeduct(fourIns);
		search.setIdNo(personalFour.getIdNo());
		
		/* 소득세, 주민세 공제 DB 저장 */
		DetailPayDTO deductDTO = new DetailPayDTO();
		deductDTO.setCompanyNo(companyNo);
		deductDTO.setIdNo(personalFour.getIdNo());
		deductDTO.setMemberNo(memberNo);
		deductDTO.setImputedDate(imputedDate);
		deductDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
		deductDTO.setDepartmentName(personalFour.getDepartmentName());
		deductDTO.setMemberName(personalFour.getMemberName());
		deductDTO.setSalOrBonus(search.getCategory());
		deductDTO.setSalaryName("소득세");
		deductDTO.setSalaryAmount(incometax);
		mngSalaryMapper.insertDetailDeduct(deductDTO);
		mngSalaryMapper.insertEmployerDeduct(deductDTO);
		
		
		DetailPayDTO nextDTO = new DetailPayDTO();
		nextDTO.setCompanyNo(companyNo);
		nextDTO.setIdNo(personalFour.getIdNo());
		nextDTO.setMemberNo(memberNo);
		nextDTO.setImputedDate(imputedDate);
		nextDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
		nextDTO.setDepartmentName(personalFour.getDepartmentName());
		nextDTO.setMemberName(personalFour.getMemberName());
		nextDTO.setSalOrBonus(search.getCategory());
		nextDTO.setSalaryName("주민세");
		nextDTO.setSalaryAmount(residentTax);
		mngSalaryMapper.insertDetailDeduct(nextDTO);
		mngSalaryMapper.insertEmployerDeduct(nextDTO);
		
		
		/* 건강, 국민연금 보험료 */
		if(((personalFour.getHealthYn()).equals("Y")) || ((personalFour.getPensionYn()).equals("Y"))) {
			
			MemberInsFeeDTO fee = new MemberInsFeeDTO();
			fee.setCompanyNo(companyNo);
			fee.setMemberNo(memberNo);
			fee.setSearchDate(search.getSearchingValidateDate());
			
			MemberInsFeeDTO personalFee = mngSalaryMapper.selectOneInsFee(fee);
			
			if((personalFour.getHealthYn()).equals("Y")) {
				healthFee = personalFee.getHealthInsFee();
				longtermFee = personalFee.getLongtermFee();
				
				DetailPayDTO healthdeductDTO = new DetailPayDTO();
				healthdeductDTO.setCompanyNo(companyNo);
				healthdeductDTO.setIdNo(personalFour.getIdNo());
				healthdeductDTO.setMemberNo(memberNo);
				healthdeductDTO.setImputedDate(imputedDate);
				healthdeductDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
				healthdeductDTO.setDepartmentName(personalFour.getDepartmentName());
				healthdeductDTO.setMemberName(personalFour.getMemberName());
				healthdeductDTO.setSalOrBonus(search.getCategory());
				healthdeductDTO.setSalaryName("건강보험");
				healthdeductDTO.setSalaryAmount(healthFee);
				
				mngSalaryMapper.insertDetailDeduct(healthdeductDTO);
				mngSalaryMapper.insertEmployerDeduct(healthdeductDTO);
				
				
				DetailPayDTO longdeductDTO = new DetailPayDTO();
				longdeductDTO.setCompanyNo(companyNo);
				longdeductDTO.setIdNo(personalFour.getIdNo());
				longdeductDTO.setMemberNo(memberNo);
				longdeductDTO.setImputedDate(imputedDate);
				longdeductDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
				longdeductDTO.setDepartmentName(personalFour.getDepartmentName());
				longdeductDTO.setMemberName(personalFour.getMemberName());
				longdeductDTO.setSalOrBonus(search.getCategory());
				longdeductDTO.setSalaryName("장기요양");
				longdeductDTO.setSalaryAmount(longtermFee);
				
				mngSalaryMapper.insertDetailDeduct(longdeductDTO);
				mngSalaryMapper.insertEmployerDeduct(longdeductDTO);
			}
			
			if((personalFour.getPensionYn()).equals("Y")) {
				pensionFee = personalFee.getPensionFee();
				
				DetailPayDTO pensiondeductDTO = new DetailPayDTO();
				pensiondeductDTO.setCompanyNo(companyNo);
				pensiondeductDTO.setIdNo(personalFour.getIdNo());
				pensiondeductDTO.setMemberNo(memberNo);
				pensiondeductDTO.setImputedDate(imputedDate);
				pensiondeductDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
				pensiondeductDTO.setDepartmentName(personalFour.getDepartmentName());
				pensiondeductDTO.setMemberName(personalFour.getMemberName());
				pensiondeductDTO.setSalOrBonus(search.getCategory());
				pensiondeductDTO.setSalaryName("국민연금");
				pensiondeductDTO.setSalaryAmount(pensionFee);
				
				mngSalaryMapper.insertDetailDeduct(pensiondeductDTO);
				mngSalaryMapper.insertEmployerDeduct(pensiondeductDTO);
			}
		}
		
		/* 고용, 산재 보험료 */
		if(((personalFour.getUnemployeeYn()).equals("Y")) || ((personalFour.getIndustryYn()).equals("Y"))) {
			
			FourInsRateDTO insRate = new FourInsRateDTO();
			insRate.setCompanyNo(companyNo);
			insRate.setSearchDate(search.getSearchingValidateDate());		
			
			FourInsRateDTO rate = mngSalaryMapper.selectInsRate(insRate);
	
			if((personalFour.getUnemployeeYn()).equals("Y")) {
				
				unemployeeFee = (int)(Math.floor(calcTaxSalary * (rate.getWorkersUnempRate().doubleValue()) / 10) * 10.0);
				employerEmpInsFee = (int)(Math.floor(calcTaxSalary * (rate.getUnder150EmpRate().doubleValue()) / 10) * 10.0);
			
				DetailPayDTO unEmpdeductDTO = new DetailPayDTO();
				unEmpdeductDTO.setCompanyNo(companyNo);
				unEmpdeductDTO.setIdNo(personalFour.getIdNo());
				unEmpdeductDTO.setMemberNo(memberNo);
				unEmpdeductDTO.setImputedDate(imputedDate);
				unEmpdeductDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
				unEmpdeductDTO.setDepartmentName(personalFour.getDepartmentName());
				unEmpdeductDTO.setMemberName(personalFour.getMemberName());
				unEmpdeductDTO.setSalOrBonus(search.getCategory());
				unEmpdeductDTO.setSalaryName("실업급여");
				unEmpdeductDTO.setSalaryAmount(unemployeeFee);
				
				mngSalaryMapper.insertDetailDeduct(unEmpdeductDTO);
				mngSalaryMapper.insertEmployerDeduct(unEmpdeductDTO);
			
				DetailPayDTO employerdeductDTO = new DetailPayDTO();
				employerdeductDTO.setCompanyNo(companyNo);
				employerdeductDTO.setIdNo(personalFour.getIdNo());
				employerdeductDTO.setMemberNo(memberNo);
				employerdeductDTO.setImputedDate(imputedDate);
				employerdeductDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
				employerdeductDTO.setDepartmentName(personalFour.getDepartmentName());
				employerdeductDTO.setMemberName(personalFour.getMemberName());
				employerdeductDTO.setSalOrBonus(search.getCategory());
				employerdeductDTO.setSalaryName("고안직능");
				employerdeductDTO.setSalaryAmount(employerEmpInsFee);
				
				mngSalaryMapper.insertEmployerDeduct(employerdeductDTO);
					
			
			}
		
			if((personalFour.getIndustryYn()).equals("Y")) {
				industryFee = (int)(Math.floor(calcTaxSalary * (rate.getIndustryRate().doubleValue()) / 10) * 10.0);
			
				DetailPayDTO industrydeductDTO = new DetailPayDTO();
				industrydeductDTO.setCompanyNo(companyNo);
				industrydeductDTO.setIdNo(personalFour.getIdNo());
				industrydeductDTO.setMemberNo(memberNo);
				industrydeductDTO.setImputedDate(imputedDate);
				industrydeductDTO.setPayDate(java.sql.Date.valueOf(search.getSearchPayDate()));
				industrydeductDTO.setDepartmentName(personalFour.getDepartmentName());
				industrydeductDTO.setMemberName(personalFour.getMemberName());
				industrydeductDTO.setSalOrBonus(search.getCategory());
				industrydeductDTO.setSalaryName("산재보험");
				industrydeductDTO.setSalaryAmount(industryFee);
				
				mngSalaryMapper.insertEmployerDeduct(industrydeductDTO);
						
			}
		
		}
		
		/* 총 공제금액 추가 및 return값 넣기 */
		totalDeduct = incometax + residentTax + healthFee + longtermFee + pensionFee + unemployeeFee;
		int transferAmount = totalPay - totalDeduct;
		
		search.setDeductAmount(totalDeduct);
		search.setTransferAmount(transferAmount);	
		
		return search;
	}
	
	
	/* 상여 생성 */
	@Override
	public List<SalaryAndBonusDTO> insertBonus(SalaryAndBonusDTO search) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 과거 지급 이력 조회 */
	@Override
	public List<SalaryAndBonusDTO> selectSalOrBonusList(SalaryAndBonusDTO search) {
		
		System.out.println(search);
		
		
		
		return mngSalaryMapper.selectSalOrBonusList(search);
	}

	
	/* 급여 계좌 조회 */
	@Override
	public List<MngAccountDTO> listmngPayrollAccount() {
		
		return mngSalaryMapper.listmngPayrollAccount();
	}

	
	

	
	

	
}
