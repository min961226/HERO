package com.nextLevel.hero.humanResource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.humanResource.model.service.HumanResourceService;

@Controller
@RequestMapping("/humanResource")
public class HumanResourceController {
	
	private final HumanResourceService humanResourceService;
	
	@Autowired
	public HumanResourceController(HumanResourceService humanResourceService) {
		this.humanResourceService = humanResourceService; 
	}
	
	@GetMapping("/organizationChart")
	public String hrOrganizationChart() {
		return "humanResource/organizationChart";
	}
	@GetMapping("/myPage")
	public String hrMyPage() {
		return "humanResource/myPage";
	}
	
	
}
