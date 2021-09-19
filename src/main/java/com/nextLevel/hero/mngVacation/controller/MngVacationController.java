package com.nextLevel.hero.mngVacation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.mngVacation.model.service.MngVacationService;

@Controller
@RequestMapping("/mngVacation")
public class MngVacationController {
	
	private final MngVacationService mngVacationService;
	
	@Autowired
	public MngVacationController(MngVacationService mngVacationService) {
		this.mngVacationService = mngVacationService;
	}
	
	@GetMapping("/annualVacation")
	public String mngAnnualVacation() {
		return "mngVacation/annualVacation";				//연차
	}
	
	@GetMapping("/publicHoliday")
	public String mngPublicHoliday() {
		return "mngVacation/publicHoliday";				//휴일
	}
	
	@GetMapping("/vacationList")
	public String mngVacationList() {
		return "mngVacation/vacationList";				//직원 휴가
	}
	
}
