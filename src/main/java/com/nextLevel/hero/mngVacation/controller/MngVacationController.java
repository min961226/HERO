package com.nextLevel.hero.mngVacation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;
import com.nextLevel.hero.mngVacation.model.service.MngVacationService;

@Controller
@RequestMapping("/mngVacation")
public class MngVacationController {
	
	private final MngVacationService mngVacationService;
	
	@Autowired
	public MngVacationController(MngVacationService mngVacationService) {
		this.mngVacationService = mngVacationService;
	}
	
	@GetMapping("/annualVacation")
	public String mngAnnualVacation() {
		// 연차 받아오는걸로 생성하기
		
		
		
		
		
		return "mngVacation/annualVacation";				//연차
	}
	
	/* 조회는 get*/
	@GetMapping("/publicHoliday")
	public ModelAndView mngPublicHoliday(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<MngHolidayDTO> holidayList = mngVacationService.listHoliday(user.getCompanyNo());
		
		mv.addObject("holidayList", holidayList);
		mv.setViewName("mngVacation/publicHoliday"); //  폴더/html명
		
		return mv;				//휴일
	}
	
	/* 맞는지 모르겠음!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	/* 신규추가 */
//	@PostMapping(value ="publicHoliday", produces = "application/json; chartset=UTF-8")
//	@ResponseBody
//	public String insertPublicHoliday(@AuthenticationPrincipal UserImpl user, int companyNo) {
//		
//		int companyNo1 = user.getCompanyNo();
//		List<MngHolidayDTO> insertHoliday = mngVacationService.insertPublicHoliday(companyNo1);
//		Gson gson = new GsonBuilder()
//				   .setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
//				   .setPrettyPrinting()
//				   .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//				   .serializeNulls()
//				   .disableHtmlEscaping()
//				   .create();
//				
//		return gson.toJson(insertHoliday);
//	}
//	
	
	
	
	@GetMapping("/vacationList")
	public String mngVacationList() {
		return "mngVacation/vacationList";				//직원 휴가
	}
	
}
