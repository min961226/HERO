package com.nextLevel.hero.salary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngSalary.model.dto.DetailPayDTO;
import com.nextLevel.hero.salary.model.dto.BankListDTO;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;
import com.nextLevel.hero.salary.model.dto.SalaryDTO;
import com.nextLevel.hero.salary.model.service.SalaryService;

@Controller
@RequestMapping("/salary")
public class SalaryController {
	
	private final SalaryService salaryService;
	
	@Autowired
	public SalaryController(SalaryService salaryService) {
		this.salaryService = salaryService;
	}
	
	/* 직원 본인 급여계좌 리스트 */
	@GetMapping("/changeaccount")
	public ModelAndView changeaccount(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {
		
		int idNo = user.getNo();
		int companyNo = user.getCompanyNo();
		
		List<MyAccountDTO> accountList = salaryService.selectAccountList(companyNo, idNo);
		
		mv.addObject("accountList",accountList);
		mv.setViewName("salary/changeaccount");
		
		return mv;
	}
	
	/* 직원 계좌 인증 */
	@GetMapping("/authAccount")
	protected void authAccount() {
		
	}
	
	
	/* 직원 본인 계좌 등록 */
	@PostMapping("/applyAccount")
	public ModelAndView applyAccount(@AuthenticationPrincipal UserImpl user, MyAccountDTO add) {
		
		
		
		return null;
	}
	
	/* 은행 목록 조회 */
	@PostMapping(value="bankList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String getBankList() {
		
		List<BankListDTO> list = salaryService.selectBankList();
		System.out.println(list);	
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
	
		return gson.toJson(list);
		
	}
	
	/* 직원 본인 급여명세서 조회 */
	@GetMapping("/list")
	public ModelAndView salaryList(@AuthenticationPrincipal UserImpl user, ModelAndView mv, SalaryDTO search) {
		
		search.setIdNo(user.getNo());
		search.setCompanyNo(user.getCompanyNo());
		
		List<SalaryDTO> salList = salaryService.selectMyPaymentList(search);
		
		mv.addObject("salList", salList);
		mv.setViewName("salary/list");
		
		return mv;
	}
	
	
	/* 직원 본인 급여명세서 세부 조회 */
	@PostMapping(value="detailList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectDetailList(@AuthenticationPrincipal UserImpl user, SalaryDTO search) {
		
		search.setIdNo(user.getNo());
		search.setCompanyNo(user.getCompanyNo());
		
		List<DetailPayDTO> detailList = salaryService.selectDetailList(search);
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
	
		return gson.toJson(detailList);		
	}
	
	
}