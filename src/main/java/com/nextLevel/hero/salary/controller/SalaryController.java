package com.nextLevel.hero.salary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.salary.model.service.SalaryService;

@Controller
@RequestMapping("/salary")
public class SalaryController {
	
	private final SalaryService salaryService;
	
	@Autowired
	public SalaryController(SalaryService salaryService) {
		this.salaryService = salaryService;
	}
	
	@GetMapping("/changeaccount")
	public String changeaccount() {
		return "salary/changeaccount";
	}
	
	@GetMapping("/list")
	public String salaryList() {
		return "salary/list";
	}
	
}