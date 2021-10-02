package com.nextLevel.hero.mngPay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.mngPay.model.service.MngPayService;

@Controller
@RequestMapping("/mngPay")
public class MngPayController {

	private final MngPayService mngPayService;
	
	@Autowired
	public MngPayController(MngPayService mngPayService) {
		this.mngPayService = mngPayService;
	}
	
	
	/* 급상여 지급 리스트 조회 */
	@GetMapping("/paySalaryAndBonus")
	public ModelAndView mngPaySalaryAndBonus () {
		
		return null;
	}
}
