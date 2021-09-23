package com.nextLevel.hero.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nextLevel.hero.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/login")
	public void memberLoginForm() {
		
	}
	
	
	@GetMapping("/findIdForm")
	public String memberFindIdForm() {
		
		return "member/findIdForm";
	}
	
	@GetMapping("/findPasswordForm")
	public String memberFindPasswordForm() {
		return "member/findPasswordForm";
	}
}
