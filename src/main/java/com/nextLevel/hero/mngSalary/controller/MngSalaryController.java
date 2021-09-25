package com.nextLevel.hero.mngSalary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;
import com.nextLevel.hero.mngSalary.model.service.MngSalaryService;

@Controller
@RequestMapping("/mngSalary")
public class MngSalaryController {
	
	private MngSalaryService mngSalaryService;
	
	@Autowired
	public MngSalaryController(MngSalaryService mngSalaryService) {
		this.mngSalaryService = mngSalaryService;
	}
	
	/* 연봉 조회 */
	@GetMapping("/annualSalary")		// postMapping으로 변경해야 할 것 같은데...일단 보류
	public ModelAndView mngAnnualSalary(ModelAndView mv) {
		
		List<MngSalaryDTO> salaryList = mngSalaryService.listMngAnnualSalary();
		
		mv.addObject("salaryList",salaryList);
		mv.setViewName("/mngSalary/annualSalary");
		
		return mv;
	}
	
	/* 4대보험 개인별 공제항목 리스트*/
	@GetMapping("/deductFourMajorInsurances")
	public ModelAndView mngDeductFourMajorInsurances(ModelAndView mv) {
		
		List<MngDeductFourInsDTO> fourInsuranceList = mngSalaryService.listMngFourInsuranceList();
		
		mv.addObject("fourInsuranceList", fourInsuranceList);
		mv.setViewName("mngSalary/deductFourMajorInsurances");
		
		return mv;
	}
	
	
	/* 건강보험 국민연금 */
	@GetMapping("/nationalHealthInsurancePension")
	public ModelAndView mngNationalHealthInsurancePension(ModelAndView mv) {
		
		List<MemberInsFeeDTO> memInsFeeList = mngSalaryService.listMngNationalHealthInsurancePension();
		
		mv.addObject("memInsFeeList", memInsFeeList);
		mv.setViewName("mngSalary/nationalHealthInsurancePension");
		
		return mv;
	}
	
	
	/* 급여 계좌 조회 */
	@GetMapping("/payrollAccount")
	public ModelAndView mngPayrollAccount(ModelAndView mv) {
		
		List<MngAccountDTO> memAccountList = mngSalaryService.listmngPayrollAccount();
		
		mv.addObject("memAccount", memAccountList);
		mv.setViewName("mngSalary/payrollAccount");
		
		return mv;
	}

	/* 급상여 생성 조회 */
	@GetMapping("/salaryAndBonus")
	public String mngSalaryAndBonus() {
		return "mngSalary/salaryAndBonus";
	}
	
	/* 급상여 지급 이체 리스트 */
	@GetMapping("/paySalaryAndBonus")
	public String mngPaySalaryAndBonus() {
		return "mngSalary/paySalaryAndBonus";
	}
	
	/* 예수금 */
	@GetMapping("/deposit")
	public String mngDeposit() {
		return "mngSalary/deposit";
	}
	
	/* 퇴직 정산 */
	@GetMapping("/severancePay")
	public String mngSeverancePay() {
		return "/mngSalary/severancePay";
	}
	
}
