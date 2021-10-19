package com.nextLevel.hero.workattitude.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;
import com.nextLevel.hero.workattitude.model.service.WorkAttitudeService;

@Controller
@RequestMapping("/workattitude")
public class WorkAttitudeController {
	
	private final WorkAttitudeService workAttitudeService; 
	
	@Autowired
	public WorkAttitudeController(WorkAttitudeService workAttitudeService) {
		this.workAttitudeService = workAttitudeService;
	}
	
	/* 임직원 근태 조회 */
	@ResponseBody
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mngWorkSelectAttitudeList(ModelAndView mv, @AuthenticationPrincipal UserImpl user,  @RequestParam Map searchMap) {
		
		int companyNo = user.getCompanyNo();
		int idNo = user.getNo();
		
		List<WorkAttitudeDTO> workList = workAttitudeService.selectAllWorkAttitudeList(companyNo,idNo, searchMap);
		
		mv.addObject("workList", workList);
		mv.setViewName("/workattitude/list");
		
		return mv;
	}

	@GetMapping("/vacation")
	public String vacation() {
		return "workattitude/vacation";
	}
	
}
