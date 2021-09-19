package com.nextLevel.hero.mnghumanResource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("/organizationChart")
	public String mngOrganizationChart() {
		return "mngHumanResource/organizationChart";
	}
	@GetMapping("/memberList")
	public String mngMyPage() {
		return "mngHumanResource/memberList";
	}
	
	
}
