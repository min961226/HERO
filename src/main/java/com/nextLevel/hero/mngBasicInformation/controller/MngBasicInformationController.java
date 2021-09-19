package com.nextLevel.hero.mngBasicInformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.main.model.service.MainService;
import com.nextLevel.hero.mngBasicInformation.model.service.MngBasicInformationService;

@Controller
@RequestMapping("/mngBasicInformation")
public class MngBasicInformationController {
	
	private final MngBasicInformationService mngBasicInformationService;
	
	@Autowired
	public MngBasicInformationController(MngBasicInformationService mngBasicInformationService) {
		this.mngBasicInformationService = mngBasicInformationService;
	}

	
	@GetMapping("/company")
	public String mngCompany() {
		return "mngBasicInformation/company";
	}
	@GetMapping("/department")
	public String mngDepartment() {
		return "mngBasicInformation/department";
	}
	@GetMapping("/departmentHistory")
	public String mngDepartmentHistory() {
		return "mngBasicInformation/departmentHistory";
	}
	@GetMapping("/premiumRate")
	public String mngPremiumRate() {
		return "mngBasicInformation/premiumRate";
	}
	@GetMapping("/premiumRateHistory")
	public String mngPremiumRateHistory() {
		return "mngBasicInformation/premiumRateHistory";
	}
	@GetMapping("/vacationType")
	public String mngVacationType() {
		return "mngBasicInformation/vacationType";
	}
	@GetMapping("/salaryType")
	public String mngSalaryType() {
		return "mngBasicInformation/salaryType";
	}
	
	
	
}
