package com.nextLevel.hero.main.controller;

import java.security.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.main.model.service.MainService;

@Controller
@RequestMapping("/*")
public class MainController {

	private final MainService mainService;
	
	@Autowired
	public MainController(MainService mainService) {
		this.mainService = mainService; 
	}
	
	
	@GetMapping(value = "/")
	public String redirect() {
		return "main/redirect";
	}
	@GetMapping(value =  "/member")
	public String login() {
		return "member/login";
	}
	@GetMapping(value = "/main")
	public String toMain() {
		return "main/main";
	}
	
	@PostMapping(value="/main")
	public String redirectMain() {
		return "main/main";
	}
	
	@GetMapping(value = "/logout")
	public String tologout() {
		return "member/logout";
	}
	
	@PostMapping(value="/logout")
	public String redirectlogout() {
		return "member/logout";
	}
}
