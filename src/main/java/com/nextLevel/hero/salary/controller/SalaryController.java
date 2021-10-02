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
import com.nextLevel.hero.salary.model.dto.BankListDTO;
import com.nextLevel.hero.salary.model.dto.MyAccountDTO;
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
	
	/* 직원 본인 급여명세서 조회 */
	@GetMapping("/list")
	public String salaryList() {
		return "salary/list";
	}
	
	
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
	
	
	
}