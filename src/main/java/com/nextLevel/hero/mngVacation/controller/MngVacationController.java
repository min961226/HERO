package com.nextLevel.hero.mngVacation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngVacationTypeDTO;
import com.nextLevel.hero.mngBasicInformation.model.service.MngBasicInformationService;
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationDTO;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;
import com.nextLevel.hero.mngVacation.model.service.MngVacationService;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;

@Controller
@RequestMapping("/mngVacation")
public class MngVacationController {

	private final MngVacationService mngVacationService;
	private final MngBasicInformationService mngBasicInformationService;

	@Autowired
	public MngVacationController(MngVacationService mngVacationService,MngBasicInformationService mngBasicInformationService) {
		this.mngVacationService = mngVacationService;
		this.mngBasicInformationService = mngBasicInformationService;
	}

	/* ?????????????????? ????????? ?????? ?????? */
	@GetMapping("/annualVacation")
	public ModelAndView mngAnnualVacation(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		/* ?????? ?????????????????? ???????????? */
		List<AnnualVacationDTO> annualVacationList = mngVacationService.listAnnualVacation(user.getCompanyNo());
		List<MngVacationTypeDTO> vacationTypeList = mngBasicInformationService.selectVacationTypeList(user.getCompanyNo());
		List<AnnualVacationControlDTO> annualVacationControlList = mngVacationService.listAnnualVacationControl();
		
		mv.addObject("annualVacationList", annualVacationList);		// ?????????
		mv.addObject("vacationTypeList", vacationTypeList);			// ?????????
		mv.addObject("controlList", annualVacationControlList);		// ?????????
		mv.setViewName("mngVacation/annualVacation");				// ??????/html??? -> ????????? ???????????? ?????????
		
		return mv; // ??????
	}
	
	/* ?????????????????? ?????? */
	@PostMapping("/updateControl")
	public ModelAndView updateControl(RedirectAttributes rttr, ModelAndView mv, @AuthenticationPrincipal UserImpl user,@RequestParam List<String> vacationDays,@RequestParam List<String> vacationCode) {
		
		System.out.println(vacationCode);
		System.out.println(vacationDays);
		
		Map<String,String> map = new HashMap<>();
		
		for(int i = 0 ; i < vacationCode.size(); i++) {
			map.put(vacationCode.get(i),vacationDays.get(i));
		}
		System.out.println(map);
		
	
		int result = mngVacationService.updateControl(map);
		
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "?????? ????????? ?????????????????????.");
        }else {
            rttr.addFlashAttribute("failedMessage", "?????? ????????? ?????????????????????.");
        }
		mv.setViewName("redirect:/mngVacation/annualVacation");						// ??????/html??? -> ????????? ???????????? ?????????	
		
		return mv; // ??????
	}
	
	/* ?????? ?????? */
	@PostMapping("/insertAnnualVacation")
	public ModelAndView insertAnnualVacation(RedirectAttributes rttr, ModelAndView mv, @AuthenticationPrincipal UserImpl user,@RequestParam String idNo,@RequestParam String selectedVacationType) {
		
		int result = mngVacationService.updateAnnualVacationDate(idNo,selectedVacationType);
		
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "?????? ????????? ?????????????????????.");
        }else {
            rttr.addFlashAttribute("failedMessage", "?????? ????????? ?????????????????????.");
        }
		mv.setViewName("redirect:/mngVacation/annualVacation");						// ??????/html??? -> ????????? ???????????? ?????????
		
		return mv; 
	}
	
	/* ?????? ?????? */
	/* ????????? get */
	@GetMapping("/publicHoliday")
	public ModelAndView mngPublicHoliday(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {

		List<MngHolidayDTO> holidayList = mngVacationService.listHoliday(user.getCompanyNo());

		mv.addObject("holidayList", holidayList);		// ?????????
		mv.setViewName("mngVacation/publicHoliday"); 	// ??????/html???// ????????? ???????????? ?????????

		return mv; 
	}

	/* ?????? ???????????? */
	@PostMapping(value = "publicHoliday", produces = "application/json; chartset=UTF-8")
	@ResponseBody
	public void insertPublicHoliday(@AuthenticationPrincipal UserImpl user, @ModelAttribute MngHolidayDTO mngHolidayDTO) {

		/* ????????? ??????????????? ???????????? ??????. */
		mngHolidayDTO.setCompanyNo(user.getCompanyNo());

		mngVacationService.insertPublicHoliday(mngHolidayDTO);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss:SSS").setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).serializeNulls().disableHtmlEscaping().create();

	}

	/* ?????? ?????? */
	@PostMapping("/holidayDelete")
	public ModelAndView holidayDelete(ModelAndView mv, @AuthenticationPrincipal UserImpl user,
			@RequestParam String selectedHolidayNo, RedirectAttributes rttr) {

		/* ajax??? ????????? ?????? ?????? ????????? int ??? parsing */ 
		int holidayNo = Integer.parseInt(selectedHolidayNo); 
		
		int result = mngVacationService.holidayDelete(user.getCompanyNo(),holidayNo);
		 
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "?????? ????????? ?????????????????????");
        }else {
            rttr.addFlashAttribute("failedMessage", "?????? ????????? ?????????????????????");
        }
		
		mv.setViewName("redirect:/mngVacation/publicHoliday");
		
		return mv;
	}

	/* ?????? ?????? */
	@GetMapping("/vacationList")
	public ModelAndView mngVacationList(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {
		
		List<EmployeeVacationDTO> employeeVacationDTO = mngVacationService.selectVacationList(user.getCompanyNo());
		
		mv.addObject("employeeVacationList", employeeVacationDTO);		// ?????????
		mv.setViewName("/mngVacation/vacationList"); 					// ??????/html??? -> ????????? ???????????? ?????????
		
		return mv; 
	}
	
	/* ?????? ?????? ?????? ?????? */
	@GetMapping(value="confirmVacationY", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ModelAndView confirmVacationY(ModelAndView mv,@AuthenticationPrincipal UserImpl user, @RequestParam String requestNo) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		mngVacationService.confirmVacationY(requestNo);
		
		mv.setViewName("/mngVacation/vacationList");
		
		return mv;
	}
	
	/* ?????? ?????? ?????? ?????? */
	@GetMapping(value="confirmVacationN", produces="application/json; charset=UTF-8")
	@ResponseBody
	public ModelAndView confirmVacationN(ModelAndView mv,@AuthenticationPrincipal UserImpl user, @RequestParam String requestNo) {
		
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd hh:mm:ss:SSS")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		mngVacationService.confirmVacationN(requestNo);
		
		mv.setViewName("/mngVacation/vacationList");
		
		return mv;
	}

}














