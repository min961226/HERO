package com.nextLevel.hero.mngRole.controller;

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

import com.nextLevel.hero.common.Pagenation;
import com.nextLevel.hero.common.SelectCriteria;
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
	@ResponseBody
	@RequestMapping(value="/roleUser", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mngRoleUser(ModelAndView mv, @AuthenticationPrincipal UserImpl user, @RequestParam Map searchMap) {

		int companyNo = user.getCompanyNo();
		
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
		
		/* 사원수 검색 */
		int totalCount = mngRoleService.selectMemberCount(companyNo, searchMap);
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 8;		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;

		if(searchCondition != null && !"".equals(searchCondition)) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}

		List<MngUserDTO> userList = mngRoleService.selectUser(companyNo, searchMap, selectCriteria);
		
		mv.addObject("selectCriteria", selectCriteria);
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
