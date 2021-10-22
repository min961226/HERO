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

	/* 인사관리자가 직원의 연차 조회 */
	@GetMapping("/annualVacation")
	public ModelAndView mngAnnualVacation(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		/* 연차 받아오는걸로 생성하기 */
		List<AnnualVacationDTO> annualVacationList = mngVacationService.listAnnualVacation(user.getCompanyNo());
		List<MngVacationTypeDTO> vacationTypeList = mngBasicInformationService.selectVacationTypeList(user.getCompanyNo());
		List<AnnualVacationControlDTO> annualVacationControlList = mngVacationService.listAnnualVacationControl();
		
		mv.addObject("annualVacationList", annualVacationList);		// 값셋팅
		mv.addObject("vacationTypeList", vacationTypeList);			// 값셋팅
		mv.addObject("controlList", annualVacationControlList);		// 값셋팅
		mv.setViewName("mngVacation/annualVacation");				// 폴더/html명 -> 보여질 페이지를 띄워줌
		
		return mv; // 연차
	}
	
	/* 일괄조정연차 수정 */
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
            rttr.addFlashAttribute("successMessage", "연차 조정이 완료되었습니다.");
        }else {
            rttr.addFlashAttribute("failedMessage", "연차 조정에 실패하였습니다.");
        }
		mv.setViewName("redirect:/mngVacation/annualVacation");						// 폴더/html명 -> 보여질 페이지를 띄워줌	
		
		return mv; // 연차
	}
	
	/* 연차 지급 */
	@PostMapping("/insertAnnualVacation")
	public ModelAndView insertAnnualVacation(RedirectAttributes rttr, ModelAndView mv, @AuthenticationPrincipal UserImpl user,@RequestParam String idNo,@RequestParam String selectedVacationType) {
		
		int result = mngVacationService.updateAnnualVacationDate(idNo,selectedVacationType);
		
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "연차 지급이 완료되었습니다.");
        }else {
            rttr.addFlashAttribute("failedMessage", "연차 지급에 실패하였습니다.");
        }
		mv.setViewName("redirect:/mngVacation/annualVacation");						// 폴더/html명 -> 보여질 페이지를 띄워줌
		
		return mv; 
	}
	
	/* 휴일 조회 */
	/* 조회는 get */
	@GetMapping("/publicHoliday")
	public ModelAndView mngPublicHoliday(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {

		List<MngHolidayDTO> holidayList = mngVacationService.listHoliday(user.getCompanyNo());

		mv.addObject("holidayList", holidayList);		// 값셋팅
		mv.setViewName("mngVacation/publicHoliday"); 	// 폴더/html명// 보여질 페이지를 띄워줌

		return mv; 
	}

	/* 휴일 신규추가 */
	@PostMapping(value = "publicHoliday", produces = "application/json; chartset=UTF-8")
	@ResponseBody
	public void insertPublicHoliday(@AuthenticationPrincipal UserImpl user, @ModelAttribute MngHolidayDTO mngHolidayDTO) {

		/* 지정된 회사번호를 받아오게 한다. */
		mngHolidayDTO.setCompanyNo(user.getCompanyNo());

		mngVacationService.insertPublicHoliday(mngHolidayDTO);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss:SSS").setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).serializeNulls().disableHtmlEscaping().create();

		/* 확인용 */
		System.out.println(mngHolidayDTO);

//		return gson.toJson(mngHolidayDTO); 

	}

	/* 휴일 삭제 */
	@PostMapping("/holidayDelete")
	public ModelAndView holidayDelete(ModelAndView mv, @AuthenticationPrincipal UserImpl user,
			@RequestParam String selectedHolidayNo, RedirectAttributes rttr) {

		/* ajax로 넘어온 휴가 종류 번호를 int 로 parsing */ 
		int holidayNo = Integer.parseInt(selectedHolidayNo); 
		
		int result = mngVacationService.holidayDelete(user.getCompanyNo(),holidayNo);
		 
		if(result >0) {
            rttr.addFlashAttribute("successMessage", "휴일 삭제가 완료하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "휴일 삭제에 실패하였습니다");
        }
		
		mv.setViewName("redirect:/mngVacation/publicHoliday");
		
		return mv;
	}

	/* 직원 휴가 */
	@GetMapping("/vacationList")
	public ModelAndView mngVacationList(@AuthenticationPrincipal UserImpl user, ModelAndView mv) {
		
		List<EmployeeVacationDTO> employeeVacationDTO = mngVacationService.selectVacationList(user.getCompanyNo());
		
		mv.addObject("employeeVacationList", employeeVacationDTO);		// 값셋팅
		mv.setViewName("/mngVacation/vacationList"); 					// 폴더/html명 -> 보여질 페이지를 띄워줌
		
		return mv; 
	}
	
	/* 직원 휴가 신청 승인 */
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
	
	/* 직원 휴가 신청 반려 */
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














