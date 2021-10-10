package com.nextLevel.hero.businessList.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.basicSetting.model.service.BasicSettingService;
import com.nextLevel.hero.businessList.model.service.BusinessListService;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.service.MngBasicInformationService;


@Controller
@RequestMapping("/businessList")
public class BusinessListController {
	
	private final MngBasicInformationService mngBasicInformationService;
	private final BusinessListService businessListService;

	
	@Autowired
	public BusinessListController(BusinessListService businessListService,MngBasicInformationService mngBasicInformationService) {
		this.businessListService = businessListService; 
		this.mngBasicInformationService = mngBasicInformationService;

	}
	@GetMapping("/businessList")
	public ModelAndView businessList(ModelAndView mv) {
		
		mv.setViewName("businessList/businessList");
		return mv;
	}
	
	@PostMapping(value="/getSearchList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ModelAndView getSearchList(ModelAndView mv,@RequestParam String keyword,Model model) throws Exception{
		
		
		System.out.println(keyword);
		
		BusinessDTO businessDTO = new BusinessDTO();
		businessDTO.setKeyword(keyword);
		List<BusinessDTO> list = mngBasicInformationService.getSearchList(businessDTO);
		mv.setViewName("businessList/businessList");
		mv.addObject("list",list);
		return mv;
	}
	
	
}
