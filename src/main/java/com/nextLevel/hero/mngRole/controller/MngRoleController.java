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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserDTO;
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

		mv.addObject("rankList", rankList);
		mv.setViewName("/mngRole/roleDept");

		return mv;
	}

	/* 직급 권한 ajax 조회 */
	@GetMapping(value = "role_auth", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<MngRankAuthDTO> selectRankAuth(@AuthenticationPrincipal UserImpl user,
												 @RequestParam("rank") String rank) {
		int companyNo = user.getCompanyNo();
		List<MngRankAuthDTO> rankAuth = mngRoleService.selectRankAuth(companyNo, rank);

		return rankAuth ;
	}
	
	/* 직급 권한 생성 */
	@PostMapping("updateRoleAuth")
	public ModelAndView createRoleAuth(ModelAndView mv, MngRankSalaryDTO mngRankSalaryDTO, @AuthenticationPrincipal UserImpl user,
									   RedirectAttributes rttr) {

		mngRankSalaryDTO.setCompanyNo(user.getCompanyNo());
		int result = mngRoleService.updateRoleAuth(mngRankSalaryDTO);

		if(result >0) {
			rttr.addFlashAttribute("successMessage", "권한 생성에 성공하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "권한 생성에 실패하였습니다");
        }
		mv.setViewName("redirect:/mngRole/roleDept");

		return mv;
	}

	/* 직급 권한 수정 */
	@PostMapping("/rankRoleDept")
	public ModelAndView insertRankAuth(ModelAndView mv, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr,
									   MngRankAuthDTO mngRankAuthDTO) {
		
		mngRankAuthDTO.setCompanyNo(user.getCompanyNo());
		
		/* 해당 직급 번호 list 조회*/
		int result = mngRoleService.selectStepByRank(mngRankAuthDTO);
		
		if(result >0) {
			rttr.addFlashAttribute("successMessage", "권한 수정에 성공하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "권한 수정에 실패하였습니다");
        }
		
		mv.setViewName("redirect:/mngRole/roleDept");

		return mv;

	}

	/* 사용자별 권한 */
	@GetMapping("/roleUser")
	public ModelAndView mngRoleUser(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {

		int companyNo = user.getCompanyNo();

		List<MngUserDTO> userList = mngRoleService.selectUser(companyNo);

		mv.addObject("userList", userList);
		mv.setViewName("/mngRole/roleUser");

		return mv;
	}
	
	/* 사원 권한 ajax 조회 */
	@PostMapping(value = "user_auth", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<MngUserAuthDTO> selectUserAuth(@AuthenticationPrincipal UserImpl user,
		  									   @RequestParam("userName") String userName,
		 								       @RequestParam("memberNo") String memberNo) {
		int companyNo = user.getCompanyNo(); 
		
		List<MngUserAuthDTO> userAuth = mngRoleService.selectUserAuth(userName, memberNo, companyNo);
		
		return userAuth;
	}
	
	/* 사원 권한 생성 */
	@PostMapping("updateUserRoleAuth")
	public ModelAndView createUserRoleAuth(ModelAndView mv,  @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, 
										  @RequestParam String name, @RequestParam String memberNo) {
		
		MngUserAuthDTO mngUserAuthDTO = new MngUserAuthDTO();
		
		mngUserAuthDTO.setUserName(name);
		mngUserAuthDTO.setMemberNo(memberNo);
		mngUserAuthDTO.setCompanyNo(user.getCompanyNo());
		
		int result = mngRoleService.updateUserRoleAuth(mngUserAuthDTO);
		
		if(result >0) {
			rttr.addFlashAttribute("successMessage", "권한 생성에 성공하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "권한 생성에 실패하였습니다");
        }

		mv.setViewName("redirect:/mngRole/roleUser");
		return mv;
	}
	
	/* 사원 권한 수정 */
	@PostMapping("/userRoleDept")
	public ModelAndView insertUserAuth(ModelAndView mv, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr,
									   MngUserAuthDTO mngUserAuthDTO) {
		
		/* 사원 권한 수정 */
		int result = mngRoleService.insertUserAuth(mngUserAuthDTO);
		
		if(result > 1) {
			rttr.addFlashAttribute("successMessage", "권한 수정에 성공하였습니다");
        }else {
            rttr.addFlashAttribute("failedMessage", "권한 수정에 실패하였습니다");
        }
		
		mv.setViewName("redirect:/mngRole/roleUser");

		return mv;

	}

}
