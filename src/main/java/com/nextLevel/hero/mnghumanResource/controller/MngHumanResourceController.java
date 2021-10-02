package com.nextLevel.hero.mnghumanResource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@PostMapping("/memberInsert")
	public ModelAndView mngMember(ModelAndView mv,RedirectAttributes rttr, MngHumanResourceDTO humanResourceDTO) {
														
		System.out.println(humanResourceDTO);
		
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
