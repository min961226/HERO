package com.nextLevel.hero.humanResource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.humanResource.model.dto.MyPageDTO;
import com.nextLevel.hero.humanResource.model.service.HumanResourceService;
import com.nextLevel.hero.member.model.dao.MemberMapper;
import com.nextLevel.hero.member.model.dto.UserImpl;

@Controller
@RequestMapping("/humanResource")
public class HumanResourceController {
	
	private final HumanResourceService humanResourceService;
	private final MemberMapper memberMapper;
	MyPageDTO myPageList;
	
	@Autowired
	public HumanResourceController(HumanResourceService humanResourceService, MemberMapper memberMapper) {
		this.humanResourceService = humanResourceService; 
		this.memberMapper = memberMapper; 
	}
	
	@GetMapping("/organizationChart")
	public String hrOrganizationChart() {
		return "humanResource/organizationChart";
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
	public ModelAndView MyPageUpdate(ModelAndView mv, @AuthenticationPrincipal UserImpl user, MyPageDTO myPageDTO, @RequestParam String ssn1,@RequestParam String ssn2) {
		myPageDTO.setHireDate(myPageList.getHireDate());
		myPageDTO.setSsn(ssn1 + "-" + ssn2);
		System.out.println("myPageDTO : " + myPageDTO);
		int idNo = user.getNo();
		int empUpdate = humanResourceService.updateEmp(user.getCompanyNo(), idNo, myPageDTO);
		System.out.println("myPageDTO2 : " + myPageDTO);
		int myPageUpdate = humanResourceService.updateMyPage(user.getCompanyNo(), idNo, myPageDTO);
		
		mv.addObject("myPageList", myPageList);
		mv.setViewName("humanResource/myPage");
		return mv;
	}
	
	
}
