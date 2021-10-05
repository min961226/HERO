package com.nextLevel.hero.mngSalary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngSalary.model.dto.FourInsRateDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MemberMonthlyPayDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngAccountDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngSalaryDTO;
import com.nextLevel.hero.mngSalary.model.dto.fourInsuranceList;
import com.nextLevel.hero.mngSalary.model.dto.memInsFeeList;
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
	public ModelAndView mngDeductFourMajorInsurances(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {

		int companyNo = user.getCompanyNo();		

		List<MngDeductFourInsDTO> fourInsuranceList = mngSalaryService.listMngFourInsuranceList(companyNo);

		mv.addObject("fourInsuranceList", fourInsuranceList);
		mv.setViewName("mngSalary/deductFourMajorInsurances");

		return mv;
	}

	/* 4대보험 개인별 공제항목 수정 */
	@PostMapping("/updateInsurances")
	public ModelAndView updateInsurances(@AuthenticationPrincipal UserImpl user, ModelAndView mv, 
			@ModelAttribute fourInsuranceList deductList, RedirectAttributes rttr)  {

		int companyNo = user.getCompanyNo();

		int result = mngSalaryService.updateFourInsuranceList(companyNo, deductList);

		if(result >0) {
			rttr.addFlashAttribute("successMessage", "4대보험 공제항목 수정에 성공하였습니다");
		} else {
			rttr.addFlashAttribute("failedMessage", "4대보험 공제항목 수정에 실패하였습니다");
		}

		mv.setViewName("redirect:/mngSalary/deductFourMajorInsurances");

		return mv;
	}



	/* 건강보험 국민연금 조회 */
	@GetMapping("/nationalHealthInsurancePension")
	public ModelAndView mngNationalHealthInsurancePension(ModelAndView mv, MemberInsFeeDTO search, @AuthenticationPrincipal UserImpl user) {

		search.setCompanyNo(user.getCompanyNo());
		List<MemberInsFeeDTO> memInsFeeList = mngSalaryService.listMngNationalHealthInsurancePension(search);

		mv.addObject("memInsFeeList", memInsFeeList);
		mv.setViewName("mngSalary/nationalHealthInsurancePension");

		return mv;
	}

	/* 건강보험, 국민연금 보험요율 조회 */
	@GetMapping(value = "selectInsRate", produces = "application/json; chartset=UTF-8")
	@ResponseBody
	public String selectInsRateList(@AuthenticationPrincipal UserImpl user, FourInsRateDTO search) {

		search.setCompanyNo(user.getCompanyNo());

		FourInsRateDTO rateList = mngSalaryService.selectInsRate(search);
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();

		System.out.println("controller : " + rateList);
		return gson.toJson(rateList);


	}

	/* 건강보험 국민연금 수정 */
	@PostMapping("/updateMonthlyIns")
	public ModelAndView updateMonthlyInsurance(@AuthenticationPrincipal UserImpl user, ModelAndView mv, 
			@ModelAttribute memInsFeeList insFeeList, RedirectAttributes rttr) {

		int companyNo = user.getCompanyNo();

		int result = mngSalaryService.updateMonthlyInsurance(companyNo, insFeeList);

		if(result >0) {
			rttr.addFlashAttribute("successMessage", "4대보험 공제항목 수정에 성공하였습니다");
		} else {
			rttr.addFlashAttribute("failedMessage", "4대보험 공제항목 수정에 실패하였습니다");
		}

		mv.setViewName("redirect:/mngSalary/nationalHealthInsurancePension");

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
