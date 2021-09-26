package com.nextLevel.hero.mngBasicInformation.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.main.model.service.MainService;
import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
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
	public ModelAndView mngCompany(@AuthenticationPrincipal UserImpl user,ModelAndView mv) {
		
		MngBasicInformationDTO companyInfo = mngBasicInformationService.selectCompanyInformationByCompanyNo(user.getCompanyNo());
		mv.addObject("companyInfo", companyInfo);
		mv.setViewName("mngBasicInformation/company");
		return mv;
	}
	
	@PostMapping("/company")
	public ModelAndView updateCompany(ModelAndView mv,RedirectAttributes rttr, MngBasicInformationDTO basicInformation,@AuthenticationPrincipal UserImpl user) {
		
		basicInformation.setCompanyRegistrationNo(basicInformation.getCompanyRegistrationNo1()+"-"+basicInformation.getCompanyRegistrationNo2()+"-"+basicInformation.getCompanyRegistrationNo3());
		basicInformation.setIdentificationNo(basicInformation.getIdentificationNo1()+"-"+basicInformation.getIdentificationNo2());
		basicInformation.setCompanyNo(user.getCompanyNo());
		
		System.out.println(basicInformation);
		
		mngBasicInformationService.updateCompanyInformation(basicInformation);
		
		rttr.addFlashAttribute("successMessage", "회사 정보 수정에 성공하였습니다!");
		mv.setViewName("redirect:/mngBasicInformation/company");
		
		return mv;
	}
	
	@GetMapping("/department")
	public String mngDepartment() {
		return "mngBasicInformation/department";
	}
	@GetMapping("/departmentHistory")
	public ModelAndView mngDepartmentHistory(ModelAndView mv,@AuthenticationPrincipal UserImpl user) {
		
		MngDepartmentHistoryDTO departmentHistory = mngBasicInformationService.selectDepartmentHistory(user.getCompanyNo());
		
		mv.addObject("departmentHistory",departmentHistory);
		mv.setViewName("mngBasicInformation/departmentHistory");
		
		return mv;
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
