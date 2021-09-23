package com.nextLevel.hero.mngRole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.mngRole.model.service.MngRoleService;

@Controller
@RequestMapping("/mngRole")
public class MngRoleController {
	
	private final MngRoleService mngRoleService; 
	
	@Autowired
	public MngRoleController(MngRoleService mngRoleService) {
		this.mngRoleService = mngRoleService;
	}
	
	@GetMapping("/roleDept")
	public String mngRoleDept() {
		
		 
		
		
		return "mngRole/roleDept";									//직급별 권한
	}
	
	@GetMapping("/roleUser")
	public String mngRoleUser() {
		
		return "mngRole/roleUser";									//사용자별 권한
	}
	
	
	
}
