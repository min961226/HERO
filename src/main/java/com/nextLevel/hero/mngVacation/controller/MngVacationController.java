package com.nextLevel.hero.mngVacation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
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

		return "mngVacation/annualVacation"; // 연차
	}
	
	// 여기서 오류가 남;;
	
	/* 연차 일괄조정 조회화면 */
	
	  @GetMapping("/annualVacation/modal") public ModelAndView
	  annualVacationControl(ModelAndView mv, @AuthenticationPrincipal UserImpl
	  user, @RequestParam int vacationCode) {
	  
	  List<AnnualVacationControlDTO> annualVacationList =
	  mngVacationService.annualList(vacationCode);
	  
	  mv.addObject("annualVacationList", annualVacationList);
	  mv.setViewName("mngVacation/annualVacation");
	  
	  System.out.println(annualVacationList);
	  
	 return mv; }
	 
	
	

	/* 조회는 get */
	@GetMapping("/publicHoliday")
	public ModelAndView mngPublicHoliday(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {

		List<MngHolidayDTO> holidayList = mngVacationService.listHoliday(user.getCompanyNo());

		mv.addObject("holidayList", holidayList);
		mv.setViewName("mngVacation/publicHoliday"); // 폴더/html명

		return mv; // 휴일
	}

	/* 맞는지 모르겠음!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! */
	/* 신규추가 */
	@PostMapping(value = "publicHoliday", produces = "application/json; chartset=UTF-8")
	@ResponseBody
	public void insertPublicHoliday(@AuthenticationPrincipal UserImpl user, MngHolidayDTO mngHolidayDTO) {

		/* 지정된 회사번호를 받아오게 한다. */
		mngHolidayDTO.setCompanyNo(user.getCompanyNo());

		mngVacationService.insertPublicHoliday(mngHolidayDTO);

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss:SSS").setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).serializeNulls().disableHtmlEscaping().create();

		/* 확인용 */
		System.out.println(mngHolidayDTO);

//		return gson.toJson(mngHolidayDTO); 

	}

	@PostMapping("/holidayDelete")
	public ModelAndView holidayDelete(ModelAndView mv, @AuthenticationPrincipal UserImpl user,
			@RequestParam String selectedHolidayNo, RedirectAttributes rttr) {

		/* ajax로 넘어온 휴가 종류 번호를 int 로 parsing 조장님꺼 참고 */ 
		/* int holidayNo = Integer.parseInt(selectedholidayNo); */
		
		int holidayNo = Integer.parseInt(selectedHolidayNo); 
		
		int result = mngVacationService.holidayDelete(user.getCompanyNo(),holidayNo);
		 
		if(result >0) {
            rttr.addFlashAttribute("successMessage", " 완료하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "실패하였습니다");
        }
		
		System.out.println(selectedHolidayNo);
		
		mv.setViewName("redirect:/mngVacation/publicHoliday");
		

		return mv;
	}

	@GetMapping("/vacationList")
	public String mngVacationList() {
		return "mngVacation/vacationList"; // 직원 휴가
	}

}
