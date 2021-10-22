package com.nextLevel.hero.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.main.model.service.MainService;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;

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
	
	/* 메인페이지 근태 조회 */
	@GetMapping(value = "/main")
	public ModelAndView toMain(ModelAndView mv, @AuthenticationPrincipal UserImpl user,  @RequestParam Map searchMap) {
		
		int companyNo = user.getCompanyNo();
		int idNo = user.getNo();
		
		List<WorkAttitudeDTO> workList = mainService.selectAllWorkAttitudeList(companyNo, idNo, searchMap);
		
		mv.addObject("workList", workList);
		mv.setViewName("/main/main");
		
		return mv;
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
