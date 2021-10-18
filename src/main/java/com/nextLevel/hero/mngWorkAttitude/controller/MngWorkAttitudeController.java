package com.nextLevel.hero.mngWorkAttitude.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;
import com.nextLevel.hero.mngWorkAttitude.model.service.MngWorkAttitudeService;

@Controller
@RequestMapping("/mngWorkAttitude")
public class MngWorkAttitudeController {
	
	private final MngWorkAttitudeService mngWorkAttitudeService;
	
	@Autowired
	public MngWorkAttitudeController(MngWorkAttitudeService mngWorkAttitudeService) {
		this.mngWorkAttitudeService = mngWorkAttitudeService;
	}

	/* 근태 조회 */
	@ResponseBody
	@RequestMapping(value="/workAttitudeList", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mngWorkSelectAttitudeList(ModelAndView mv, @AuthenticationPrincipal UserImpl user, @RequestParam Map searchMap) {
		
		int companyNo = user.getCompanyNo();
		
		List<MngWorkAttitudeDTO> workList = mngWorkAttitudeService.selectAllWorkAttitudeList(companyNo, searchMap);
		
		mv.addObject("workList", workList);
		mv.setViewName("/mngWorkAttitude/workAttitudeList");
		
		return mv;
	}
	
	/* 근태 수정 조회 */
	@ResponseBody
 	@RequestMapping(value="/workAttitudeUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mngWorkAttitudeUpdateList(ModelAndView mv, @AuthenticationPrincipal UserImpl user, @RequestParam Map searchMap) {
		
		int companyNo = user.getCompanyNo();
		
		List<MngAttitudeUpdateDTO> updateList = mngWorkAttitudeService.selectAllWorkAttitudeUpdate(companyNo, searchMap);
		
		mv.addObject("updateList", updateList);
		mv.setViewName("/mngWorkAttitude/workAttitudeUpdate");
		
		return mv;
	}
	
	/* 근태 수정 */
	@PostMapping("/AttitudeUpdate")
	public ModelAndView mngWorkAttitudeUpdate(ModelAndView mv, MngUpdateDTO updateDTO, @AuthenticationPrincipal UserImpl user,
											  RedirectAttributes rttr) {
		
		updateDTO.setCompanyNo(user.getCompanyNo());
		updateDTO.setName(user.getName());
		
		System.out.println("===========");
		System.out.println(updateDTO);
		
		int result =  mngWorkAttitudeService.updateWorkAttitude(updateDTO);
		
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", "근태 수정에 성공하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "근태 수정에 실패하였습니다");
        }
		
		mv.setViewName("redirect:/mngWorkAttitude/workAttitudeUpdate");
		
		return mv;
	}
	
	
	@GetMapping("/workAttitudeHistory")
	public String mngWorkAttitudeHistory() {
		return "mngWorkAttitude/workAttitudeHistory";
	}
	
}
