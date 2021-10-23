package com.nextLevel.hero.humanResource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.humanResource.model.dto.MyPageDTO;
import com.nextLevel.hero.humanResource.model.service.HumanResourceService;
import com.nextLevel.hero.member.model.dao.MemberMapper;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.UserImpl;

@Controller
@RequestMapping("/humanResource")
public class HumanResourceController {
	
	private final HumanResourceService humanResourceService;
	private final MemberMapper memberMapper;
	private final PasswordEncoder passwordEncoder;
	MyPageDTO myPageList;
	
	@Autowired
	public HumanResourceController(HumanResourceService humanResourceService, MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
		this.humanResourceService = humanResourceService; 
		this.memberMapper = memberMapper; 
		this.passwordEncoder = passwordEncoder; 
	}
	
	@GetMapping("/password")
	public String password() {
		return "humanResource/password";
	}
	
	@PostMapping("/password")
	public ModelAndView password(ModelAndView mv,@AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, FindPwdDTO findPwdDTO, @RequestParam String userPwdCheck) {
		
		int idNo = user.getNo();
		int companyNo = user.getCompanyNo();
		String userPwd = findPwdDTO.getUserPwd();
		
		if (userPwd.equals(userPwdCheck)) {
			userPwd = passwordEncoder.encode(userPwd);
			findPwdDTO.setUserPwd(userPwd);
			findPwdDTO.setIdNo(idNo);
			
		int resultPassword = humanResourceService.updatePassword(companyNo,findPwdDTO);
		
		if (resultPassword > 0) {
			rttr.addFlashAttribute("successMessage" , "비밀번호 변경에 성공하셨습니다." );		
		} else {
			rttr.addFlashAttribute("failedMessage" , "비밀번호 변경에 실패하셨습니다." );
		}
		
		} else {
			rttr.addFlashAttribute("failedMessage" , "입력 하신 비밀번호가 비밀번호 재확인이랑 일치하지 않습니다." );
		}
		
		mv.setViewName("redirect:/humanResource/password");
		
		
		return mv;
	}
	
	@GetMapping("/myPage")
	public ModelAndView hrMyPage(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {

		int idNo = user.getNo();
		int memberNo = humanResourceService.selectMemberNo(user.getCompanyNo(), idNo);
		System.out.println("memberNo : " + memberNo);
		int jobNo = humanResourceService.selectjobNo(user.getCompanyNo(), idNo);
		System.out.println("jobNo : " + jobNo);
		
		myPageList = humanResourceService.selectMypage(user.getCompanyNo(), idNo, memberNo, jobNo);
		System.out.println("myPageList : " + myPageList);
		mv.addObject("myPageList", myPageList);
		mv.setViewName("humanResource/myPage");
		return mv;
	}
	@PostMapping("/myPageUpdate")
	public ModelAndView MyPageUpdate(RedirectAttributes rttr, ModelAndView mv, @AuthenticationPrincipal UserImpl user, MyPageDTO myPageDTO, @RequestParam String ssn1,@RequestParam String ssn2) {
		myPageDTO.setHireDate(myPageList.getHireDate());
		myPageDTO.setSsn(ssn1 + "-" + ssn2);
		System.out.println("myPageDTO : " + myPageDTO);
		int idNo = user.getNo();
		int empUpdate = humanResourceService.updateEmp(user.getCompanyNo(), idNo, myPageDTO);
		System.out.println("myPageDTO2 : " + myPageDTO);
		int myPageUpdate = humanResourceService.updateMyPage(user.getCompanyNo(), idNo, myPageDTO);
		System.out.println("myPageUpdate : " + myPageUpdate);
	
		
	    rttr.addFlashAttribute("successMessage" , "개인정보 수정에 성공하셨습니다.");
		
		mv.setViewName("redirect:/humanResource/myPage");
		return mv;
	}
	
	
}
