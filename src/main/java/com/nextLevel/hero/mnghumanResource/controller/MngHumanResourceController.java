package com.nextLevel.hero.mnghumanResource.controller;

import java.util.List;

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

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.service.MngBasicInformationService;
import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;
import com.nextLevel.hero.mnghumanResource.model.service.MngHumanResourceService;

@Controller
@RequestMapping("/mngHumanResource")
public class MngHumanResourceController {
	
	private final MngHumanResourceService mngHumanResourceService;
	private final PasswordEncoder passwordEncoder;
	private final MngBasicInformationService mngBasicInformationService;
	
	@Autowired
	public MngHumanResourceController(MngHumanResourceService mngHumanResourceService, PasswordEncoder passwordEncoder, MngBasicInformationService mngBasicInformationService) {
		this.mngHumanResourceService = mngHumanResourceService;
		this.passwordEncoder = passwordEncoder;
		this.mngBasicInformationService = mngBasicInformationService;
	}
	
	@GetMapping("/memberHistory")
	public String mngMemberHistory() {
		return "mngHumanResource/memberHistory";
	}
	@GetMapping("/memberInsert")
	public ModelAndView mngMemberInsert(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		
		List<MngDepartmentHistoryDTO> departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());
		List<SalaryStepDTO> SalaryStepList = mngHumanResourceService.selectSalaryStep(user.getCompanyNo());
		List<JobDTO> JobList = mngHumanResourceService.selectJobList(user.getCompanyNo());
		System.out.println("departmentList : " + departmentList);
		System.out.println("SalaryStepList : " + SalaryStepList);
		System.out.println("JobList : " + JobList);
		
//		System.out.println("user.getCompanyNo() : " + user.getCompanyNo());
		mv.setViewName("mngHumanResource/memberInsert");
		mv.addObject("departmentList", departmentList);
		mv.addObject("SalaryStepList", SalaryStepList);
		mv.addObject("JobList", JobList);
		return mv;
	}

//	@PostMapping(value = "/memberInsert" , produces = "application/json; chartset=UTF-8")
	@PostMapping(value = "/memberInsert" , produces = "application/json; chartset=UTF-8")
	public ModelAndView mngMember(ModelAndView mv, RedirectAttributes rttr, MngHumanResourceDTO humanResourceDTO ,@AuthenticationPrincipal UserImpl user 
			,@RequestParam String memberPasswordCheck, @RequestParam String memberId, @RequestParam String familyOriginAddress2, @RequestParam String address2) {
		
//		String sss= humanResourceDTO.getAddress();					
//		String ss = request.getParameter("name");
//		System.out.println("ss : " + ss);
//		System.out.println("sss : " + sss);
		int companyNo = user.getCompanyNo();
		
		String familyOriginAddress = humanResourceDTO.getFamilyOriginAddress();
		System.out.println("familyOriginAddress + familyOriginAddress2 : " + familyOriginAddress + familyOriginAddress2);
		humanResourceDTO.setFamilyOriginAddress(familyOriginAddress + familyOriginAddress2);
		System.out.println(humanResourceDTO);
		System.out.println("memberId : " + memberId);
		
//		int departmentNo = departmentList
				
		
		
		
		
		String Password = humanResourceDTO.getMemberPassword(); //입력 받은 패스워드를 불러온다.
		if (Password.equals(memberPasswordCheck)) {
			Password = passwordEncoder.encode(Password);	//입력 받은 패스워드를 암호화 처리해준다.
		} else {
			rttr.addFlashAttribute("failedMessage","입력하신 비밀번호가 서로 다릅니다." );
		}
		
		System.out.println("Password : " + Password);		
		humanResourceDTO.setMemberPassword(Password);	//입력받은 패스워드 암호화 처리된걸 다시 DTO에 넣어준다.
		
		
		int insertMember = mngHumanResourceService.insertMember(humanResourceDTO , user.getCompanyNo());
		
		System.out.println("insertMember : " + insertMember);
		
		
		return mv;
	}
	
	
	@GetMapping("/organizationChart")
	public String mngOrganizationChart() {
		return "mngHumanResource/organizationChart";
	}
	@GetMapping("/memberList")
	public ModelAndView mngMyPage(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<MemberListDTO> memberList = mngHumanResourceService.selectMemberList(user.getCompanyNo());
		System.out.println("memberList : " + memberList);
		mv.setViewName("mngHumanResource/memberList");
		mv.addObject("memberList", memberList);
		return mv;
	}
	
	
}
