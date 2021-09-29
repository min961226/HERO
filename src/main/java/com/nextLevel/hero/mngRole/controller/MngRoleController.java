package com.nextLevel.hero.mngRole.controller;

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

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.service.MngRoleService;

@Controller
@RequestMapping("/mngRole")
public class MngRoleController {
	
	private final MngRoleService mngRoleService; 
	
	@Autowired
	public MngRoleController(MngRoleService mngRoleService) {
		this.mngRoleService = mngRoleService;
	}
	
	/* 지급별 권한 */
	@GetMapping("/roleDept")
	public ModelAndView mngRoleDept(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		int companyNo = user.getCompanyNo();
		 
		List<MngRoleDTO> rankList = mngRoleService.selectRank(companyNo);
		
		System.out.println(rankList);  
		mv.addObject("rankList", rankList);
		mv.setViewName("/mngRole/roleDept");
		
		return mv;								
	}
	
	/* 직급 리스트 ajax 조회 */
	@GetMapping(value="role_auth", produces ="application/json; charset=UTF-8")
	@ResponseBody
	public List<MngRankSalaryDTO> findCategoryList(@AuthenticationPrincipal UserImpl user,
												 @RequestParam("rank") String rank) {
		int companyNo = user.getCompanyNo();
		List<MngRankSalaryDTO> rankAuth = mngRoleService.selectRankAuth(companyNo, rank);
	
		return rankAuth;
	}

	/* 직급 권한 조회 */
	@PostMapping("updateRoleAuth")
	public ModelAndView createRoleAuth(ModelAndView mv, MngRankSalaryDTO mngRankSalaryDTO, @AuthenticationPrincipal UserImpl user) {
		
		mngRankSalaryDTO.setCompanyNo(user.getCompanyNo());
		mngRoleService.updateRoleAuth(mngRankSalaryDTO);
		
		mv.setViewName("redirect:/mngRole/roleDept");
		
		return mv;
	}
	
	/* 해당 직급별호봉 조회 */
	@PostMapping("/roleDept")
	public ModelAndView insertUserAuth(ModelAndView mv, @AuthenticationPrincipal UserImpl user,MngRankAuthDTO mngRankAuthDTO) {
		
		mngRankAuthDTO.setCompanyNo(user.getCompanyNo());
		 
		List<MngRankAuthDTO> StepByRankArgList = mngRoleService.selectStepByRank(mngRankAuthDTO);
		mngRankAuthDTO.setSalaryStepByRankArg(StepByRankArgList);
		
//		mngRoleService.deleteRankAuth(mngRankAuthDTO);
		
		System.out.println(mngRankAuthDTO);
		mv.setViewName("redirect:/mngRole/roleDept");
		
		return mv;
		
	}
	
	/* 사용자별 권한 */
	@GetMapping("/roleUser")
	public String mngRoleUser() {
		
		return "mngRole/roleUser";									
	}
	
	
}
