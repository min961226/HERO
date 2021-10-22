package com.nextLevel.hero.workattitude.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngVacationTypeDTO;
import com.nextLevel.hero.mngBasicInformation.model.service.MngBasicInformationService;
import com.nextLevel.hero.workattitude.model.dto.EmployeeAnnualVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;
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
	private final MngBasicInformationService mngBasicInformationService; 
	
	@Autowired
	public WorkAttitudeController(WorkAttitudeService workAttitudeService,MngBasicInformationService mngBasicInformationService) {
		this.workAttitudeService = workAttitudeService;
		this.mngBasicInformationService = mngBasicInformationService;
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

	/* 직원의 연차 조회 & 신청내역 조회*/
	@GetMapping("/vacation")
	public ModelAndView vacation(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		// 연차 받아오는걸로 생성하기
		EmployeeAnnualVacationDTO employeeAnnualVacationList = workAttitudeService.listEmployeeAnnualVacation(user.getCompanyNo(),user.getNo());
		List<EmployeeVacationDTO> employeeVacationList = workAttitudeService.listEmployeeVacation(user.getCompanyNo(), user.getNo());
		List<MngVacationTypeDTO> vacationTypeList = mngBasicInformationService.selectVacationTypeList(user.getCompanyNo());
		
		mv.addObject("employeeAnnualVacationList", employeeAnnualVacationList);		// 값셋팅
		mv.addObject("employeeVacationList", employeeVacationList);					// 값셋팅
		mv.addObject("vacationTypeList", vacationTypeList);							// 값셋팅
		mv.setViewName("/workattitude/vacation");									// 폴더/html명 -> 보여질 페이지를 띄워줌
		
		return mv; // 연차
	}
	
	/* 직원의 휴가 신청 */
	@PostMapping("/vacationInsert")
	public ModelAndView vacationInsert(EmployeeVacationDTO employeeVacationDTO,ModelAndView mv, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr) {
		
		employeeVacationDTO.setCompanyNo(user.getCompanyNo());
		
		int result = workAttitudeService.insertVacation(employeeVacationDTO);
		
		if (result > 0) {
			rttr.addFlashAttribute("successMessage","휴가 신청이 완료되었습니다.");
		}else {
			rttr.addFlashAttribute("failedMessage","휴가 신청에 실패하였습니다.");
		}
		
		mv.setViewName("redirect:/workattitude/vacation");
	
		return mv; // 연차
	}
	
	
	
	
}








