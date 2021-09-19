package com.nextLevel.hero.mngSalary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.mngSalary.model.service.MngSalaryService;

@Controller
@RequestMapping("/mngSalary")
public class MngSalaryController {
	
	private MngSalaryService mngSalaryService;
	
	@Autowired
	public MngSalaryController(MngSalaryService mngSalaryService) {
		this.mngSalaryService = mngSalaryService;
	}
	
	@GetMapping("/annualSalary")
	public String mngAnnualSalary() {
		return "/mngSalary/annualSalary";
	}
	
	@GetMapping("/deductFourMajorInsurances")
	public String mngDeductFourMajorInsurances() {
		return "/mngSalary/deductFourMajorInsurances";
	}
	
	@GetMapping("/nationalHealthInsurancePension")
	public String mngNationalHealthInsurancePension() {
		return "mngSalary/nationalHealthInsurancePension";
	}
	
	@GetMapping("/payrollAccount")
	public String mngPayrollAccount() {
		return "mngSalary/payrollAccount";
	}

	@GetMapping("/salaryAndBonus")
	public String mngSalaryAndBonus() {
		return "mngSalary/salaryAndBonus";
	}
	
	@GetMapping("/paySalaryAndBonus")
	public String mngPaySalaryAndBonus() {
		return "mngSalary/paySalaryAndBonus";
	}
	
	@GetMapping("/deposit")
	public String mngDeposit() {
		return "mngSalary/deposit";
	}
	
	@GetMapping("/severancePay")
	public String mngSeverancePay() {
		return "/mngSalary/severancePay";
	}
	
}
