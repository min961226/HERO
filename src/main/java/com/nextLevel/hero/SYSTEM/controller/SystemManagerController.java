package com.nextLevel.hero.SYSTEM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.SYSTEM.model.service.SystemManagerService;

@Controller
@RequestMapping("/systemManager")
public class SystemManagerController {
	
	private final SystemManagerService systemManagerService;
	
	@Autowired
	public SystemManagerController(SystemManagerService systemManagerService) {
		this.systemManagerService = systemManagerService;
	}
	
	@GetMapping("/userList")
	public String userList() {
		return "systemManager/userList";
	}

	@GetMapping("/createUser")
	public String createUser() {
		return "systemManager/createUser";
	}
	
}
