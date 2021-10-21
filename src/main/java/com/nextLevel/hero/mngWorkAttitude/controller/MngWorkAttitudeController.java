package com.nextLevel.hero.mngWorkAttitude.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nextLevel.hero.common.Pagenation;
import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateViewDTO;
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
		System.out.println("버튼 값 : " + searchMap.get("currentPage"));
		
		/* 페이징 */
		String currentPage = (String) searchMap.get("currentPage");
		String searchCondition = (String) searchMap.get("searchCondition");
		String searchValue = (String) searchMap.get("searchValue");
		
		int pageNo = 1;
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 3;		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;

		/* 사원수 검색 */
		int totalCount = mngWorkAttitudeService.selectMemberCount(companyNo, searchMap);
		
		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		/* 근태 조회 */
		List<MngWorkAttitudeDTO> workList = mngWorkAttitudeService.selectAllWorkAttitudeList(companyNo, searchMap, selectCriteria);
		
		
		mv.addObject("selectCriteria", selectCriteria);
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
	
	/* 근태 기록 수정 내역 */
	@ResponseBody
	@RequestMapping(value="/workAttitudeHistory", method = {RequestMethod.GET, RequestMethod.POST})
	public /* 근태 수정 */ ModelAndView mngWorkAttitudeHistory(ModelAndView mv, @AuthenticationPrincipal UserImpl user, @RequestParam Map searchMap) {
		
		int companyNo = user.getCompanyNo();
		
		List<MngAttitudeUpdateDTO> workList = mngWorkAttitudeService.selectUpdateAttitudeList(companyNo, searchMap);
		
		mv.addObject("workList", workList);
		mv.setViewName("mngWorkAttitude/workAttitudeHistory");
		
		return mv;
	}
	
	/* 근태 기록 수정 내역 상세보기 */
	@PostMapping(value="updateList", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectPayListDetail(@AuthenticationPrincipal UserImpl user, int memberNo) {
		
		int companyNo = user.getCompanyNo();
		
		List<MngAttitudeUpdateViewDTO> updateList = mngWorkAttitudeService.selectAllUpdateAttitudeList(companyNo, memberNo);
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd")
				.setPrettyPrinting()
				.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
				.serializeNulls()
				.disableHtmlEscaping()
				.create();
		
		return gson.toJson(updateList);
	}
	
}
