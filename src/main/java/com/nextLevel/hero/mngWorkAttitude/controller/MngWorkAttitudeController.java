package com.nextLevel.hero.mngWorkAttitude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String mngWorkAttitudeList() {
		return "mngWorkAttitude/workAttitudeList";
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
