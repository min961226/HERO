package com.nextLevel.hero.mngSalary.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.nextLevel.hero.member.model.dto.UserImpl;
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
import com.nextLevel.hero.mngSalary.model.service.MngSalaryService;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;

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

	/* 월 지급금액 추가용 리스트 */
	@PostMapping(value="addMonthPay", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String listAddMonthlyPay(@AuthenticationPrincipal UserImpl user) {
		
		int companyNo = user.getCompanyNo();
		
		List<MonthlyListDTO> month = mngSalaryService.selectMonthlyList(companyNo);
		
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		
		return gson.toJson(month);
	}
	
	
	/* 개인별 월 지급금액 변경 */
	@PostMapping(value="updatePerMonthly", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String updatePersonalMonPay(@AuthenticationPrincipal UserImpl user, @RequestParam String updateList) {
		
		Type ListType = new TypeToken<List<MemberMonthlyPayDTO>>(){}.getType();
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		List<MemberMonthlyPayDTO> detail = gson.fromJson(updateList, ListType);
		
		int companyNo = user.getCompanyNo();
		
		String result = mngSalaryService.updatePersonalMonPay(companyNo, detail);
		
		return result;
	}
	
	
	
	/* 4대보험 개인별 공제항목 리스트*/
	@GetMapping("/deductFourMajorInsurances")
	public ModelAndView mngDeductFourMajorInsurances(@AuthenticationPrincipal UserImpl user, ModelAndView mv, MngDeductFourInsDTO search) {

		search.setCompanyNo(user.getCompanyNo());

		List<MngDeductFourInsDTO> fourInsuranceList = mngSalaryService.listMngFourInsuranceList(search);

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
	public ModelAndView mngPayrollAccount(ModelAndView mv, @AuthenticationPrincipal UserImpl user, MngAccountDTO search) {

		search.setCompanyNo(user.getCompanyNo());
		
		List<MngAccountDTO> memAccountList = mngSalaryService.listmngPayrollAccount(search);

		mv.addObject("memAccount", memAccountList);
		mv.setViewName("mngSalary/payrollAccount");

		return mv;
	}

	/* 개인별 급여 계좌 리스트 */
	@PostMapping(value="personalAccountList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectPersonalAccountList(@AuthenticationPrincipal UserImpl user, MngAccountDTO search) {
		
		search.setCompanyNo(user.getCompanyNo());
		
		List<MyAccountDTO> personalList = mngSalaryService.selectPersonalAccount(search);
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		return gson.toJson(personalList);
	}
	
	
	
	
	/* 급상여 페이지 이동 */
	@GetMapping("/salaryAndBonus")
	public String mngSalaryAndBonus() {
		return "mngSalary/salaryAndBonus";	
	
	}


	/* 상여 카테고리 */
	@GetMapping(value="selectBonusCategory", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectBonusCategory(@AuthenticationPrincipal UserImpl user) {
		
		int companyNo = user.getCompanyNo();	
		List<MngBonusListDTO> bonusCategory = mngSalaryService.selectBonusCategory(companyNo);
		
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		return gson.toJson(bonusCategory);
	}
		
	
	
	/* 급상여 생성여부 체크 */
	@GetMapping(value="/searchSalaryAndBonus", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String searchSalaryAndBonus(@AuthenticationPrincipal UserImpl user, SalaryAndBonusDTO search) {
		
		search.setCompanyNo(user.getCompanyNo());
		String result = mngSalaryService.checkCreate(search);		
		
		return result;
	}
	
	/* 급상여 생성 */
	@GetMapping("/listSalaryAndBonus")
	public ModelAndView listSalaryAndBonus(ModelAndView mv, @AuthenticationPrincipal UserImpl user, SalaryAndBonusDTO search) {
		
		search.setCompanyNo(user.getCompanyNo());
		List<SalaryAndBonusDTO> basicSalList = new ArrayList<>();
		
		if(search.getCategory().equals("급여")) {
			
			search.setCategory("급여");
			basicSalList =  mngSalaryService.insertSalary(search);
			
		} else {
			search.setCategory("상여");
			basicSalList = mngSalaryService.insertBonus(search);
		}
		
		mv.addObject("basicSalList",basicSalList);
		mv.setViewName("mngSalary/salaryAndBonus");

		return mv;
	}
	
	/* 급상여 이력 조회 */
	@GetMapping("/historySalAndBonus")
	public ModelAndView selectHistory(ModelAndView mv, @AuthenticationPrincipal UserImpl user, SalaryAndBonusDTO search) {
				
		search.setCompanyNo(user.getCompanyNo());
		List<SalaryAndBonusDTO> basicSalList = new ArrayList<>();
		
		basicSalList = mngSalaryService.selectSalOrBonusList(search);
		
		mv.addObject("basicSalList",basicSalList);
		mv.setViewName("mngSalary/salaryAndBonus");
		
		
		return mv;
	}
	
	/* 개인별 세부 내역 */
	@PostMapping(value="personalDetail", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String listPersonalDetail(@AuthenticationPrincipal UserImpl user, SalaryAndBonusDTO search) {
		
		search.setCompanyNo(user.getCompanyNo());
		
		List<DetailPayDTO> detailList = mngSalaryService.listPersonalDetail(search);
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();

		
		return gson.toJson(detailList);
	}
	
	/* 개인별 공제 내역 수정 */
	@PostMapping(value="personalUpdate", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String updatePersonalDetail(@AuthenticationPrincipal UserImpl user, @RequestParam String updateList) {
		
		int companyNo = user.getCompanyNo();
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		Type ListType = new TypeToken<List<DetailPayDTO>>(){}.getType();
		List<DetailPayDTO> detail = gson.fromJson(updateList, ListType);
		
		String result = mngSalaryService.updatePersonalDeduct(companyNo, detail);
		
		return result;
	}
	
	
	
	
	/* 예수금 */
	@GetMapping("/deposit")
	public String mngDeposit() {
		return "mngSalary/deposit";
	}

	/* 예수금 검색 조회 */
	@GetMapping("/depositHistory")
	public ModelAndView selectDepositList(ModelAndView mv, @AuthenticationPrincipal UserImpl user, MngDepositDTO search) {
		
		search.setCompanyNo(user.getCompanyNo());

		List<MngDepositDTO> depositList = mngSalaryService.selectDepositList(search);
		
		mv.addObject("depositList",depositList);
		mv.setViewName("mngSalary/deposit");
		
		return mv;
	}
	
	/* 퇴직 정산 */
	@GetMapping("/severancePay")
	public ModelAndView mngSeverancePay(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<SeverancePayDTO> severancePayDTO = mngSalaryService.severancePayList(user.getCompanyNo()); 

		mv.addObject("severancePayList",severancePayDTO);
		mv.setViewName("/mngSalary/severancePay");
		return mv;
	}
	
	@PostMapping(value ="severanceDetail", produces = "application/json; chartset=UTF-8")
	@ResponseBody
	public String severanceDetail(@AuthenticationPrincipal UserImpl user, @RequestParam String memberNo,@RequestParam String idNo) {

		int membNo = Integer.parseInt(memberNo);
		int idNum = Integer.parseInt(idNo);
		
		memberSeverancePayDTO severancePay = mngSalaryService.selectOneSeverancePay(user.getCompanyNo(),idNum);

		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();


		return gson.toJson(severancePay);
	}
	

}
