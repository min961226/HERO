package com.nextLevel.hero.mngBasicInformation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.main.model.service.MainService;
import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
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
	public String mngCompany(@AuthenticationPrincipal UserImpl user) {
		MngBasicInformationDTO mngBasicInformationDTO = mngBasicInformationService.selectCompanyInformationByCompanyNo(user.getCompanyNo());
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
