package com.nextLevel.hero.mnghumanResource.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.service.MngHumanResourceService;

@Controller
@RequestMapping("/mngHumanResource")
public class MngHumanResourceController {
	
	private final MngHumanResourceService mngHumanResourceService;
	
	@Autowired
	public MngHumanResourceController(MngHumanResourceService mngHumanResourceService) {
		this.mngHumanResourceService = mngHumanResourceService;
	}
	
	@GetMapping("/memberHistory")
	public String mngMemberHistory() {
		return "mngHumanResource/memberHistory";
	}
	@GetMapping("/memberInsert")
	public String mngMemberInsert() {
		return "mngHumanResource/memberInsert";
	}

//	@PostMapping(value = "/memberInsert" , produces = "application/json; chartset=UTF-8")
	@PostMapping("/memberInsert")
	public ModelAndView mngMember(ModelAndView mv, RedirectAttributes rttr, MngHumanResourceDTO humanResourceDTO ,@AuthenticationPrincipal UserImpl user) {
		
//		String sss= humanResourceDTO.getAddress();					
//		String ss = request.getParameter("name");
//		System.out.println("ss : " + ss);
//		System.out.println("sss : " + sss);
		
		System.out.println(humanResourceDTO);
		
		int insertMember = mngHumanResourceService.insertMember(humanResourceDTO ,user.getCompanyNo());
		
		return mv;
	}
	
	
	@GetMapping("/organizationChart")
	public String mngOrganizationChart() {
		return "mngHumanResource/organizationChart";
	}
	@GetMapping("/memberList")
	public String mngMyPage() {
		return "mngHumanResource/memberList";
	}
	
	
}
