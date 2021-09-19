package com.nextLevel.hero.workattitude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.workattitude.model.service.WorkAttitudeService;

@Controller
@RequestMapping("/workattitude")
public class WorkAttitudeController {
	
	private final WorkAttitudeService workAttitudeService; 
	
	@Autowired
	public WorkAttitudeController(WorkAttitudeService workAttitudeService) {
		this.workAttitudeService = workAttitudeService;
	}
	
	@GetMapping("/list")
	public String workAttitudeList() {
		
		return "workattitude/list";
	}

	@GetMapping("/vacation")
	public String vacation() {
		return "workattitude/vacation";
	}
	
}
