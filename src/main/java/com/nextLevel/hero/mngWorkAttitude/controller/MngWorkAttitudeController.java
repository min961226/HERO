package com.nextLevel.hero.mngWorkAttitude.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;
import com.nextLevel.hero.mngWorkAttitude.model.service.MngWorkAttitudeService;

@Controller
@RequestMapping("/mngWorkAttitude")
public class MngWorkAttitudeController {
	
	private final MngWorkAttitudeService mngWorkAttitudeService;
	
	@Autowired
	public MngWorkAttitudeController(MngWorkAttitudeService mngWorkAttitudeService) {
		this.mngWorkAttitudeService = mngWorkAttitudeService;
	}
	
	@GetMapping("/workAttitudeList")
	public ModelAndView mngWorkAttitudeList(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		int companyNo = user.getCompanyNo();
		
		List<MngWorkAttitudeDTO> workList = mngWorkAttitudeService.selectWorkAttitudeList(companyNo);
		
		mv.addObject("workList", workList);
		mv.setViewName("/mngWorkAttitude/workAttitudeList");
		
		return mv;
	}
	
	@GetMapping("/workAttitudeUpdate")
	public String mngWorkAttitudeUpdate() {
		return "mngWorkAttitude/workAttitudeUpdate";
	}
	
	@GetMapping("/workAttitudeHistory")
	public String mngWorkAttitudeHistory() {
		return "mngWorkAttitude/workAttitudeHistory";
	}
	
}
