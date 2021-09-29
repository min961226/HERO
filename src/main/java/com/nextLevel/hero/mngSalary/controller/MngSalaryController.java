package com.nextLevel.hero.mngSalary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngSalary.model.dto.MemberInfoDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
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
	public ModelAndView mngAnnualSalary(ModelAndView mv, MngSalaryDTO search, @AuthenticationPrincipal UserImpl user) {
		
		search.setCompanyNo(user.getCompanyNo());

		
		List<MngSalaryDTO> salaryList = mngSalaryService.listMngAnnualSalary(search);
		
		mv.addObject("salaryList",salaryList);
		mv.setViewName("/mngSalary/annualSalary");
		
		return mv;
	}
	
	/* 월 지급금액 조회 */
	@PostMapping(value ="annualSalary", produces = "application/json; chartset=UTF-8")
	@ResponseBody
	public String listMonthlySalary(@AuthenticationPrincipal UserImpl user, MngSalaryDTO search) {

		search.setCompanyNo(user.getCompanyNo());
		
		List<MemberMonthlyPayDTO> memberMonthly = mngSalaryService.listMonthlySalary(search);
		
		System.out.println(memberMonthly);
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		
		return gson.toJson(memberMonthly);
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
