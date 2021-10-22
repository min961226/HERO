package com.nextLevel.hero.mnghumanResource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView mngMemberHistory(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		
		
		List<MngHumanResourceDTO> memberHistoryList = mngHumanResourceService.selectMemberHistoryList(user.getCompanyNo(), user.getNo());
		mv.setViewName("mngHumanResource/memberHistory");
		mv.addObject("memberHistoryList", memberHistoryList);
		return mv;
	}
	@GetMapping("/memberInsert")
	public ModelAndView mngMemberInsert(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		
		List<MngDepartmentHistoryDTO> departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());
		List<SalaryStepDTO> SalaryStepList = mngHumanResourceService.selectSalaryStep(user.getCompanyNo());
		List<JobDTO> JobList = mngHumanResourceService.selectJobList(user.getCompanyNo());
		
		mv.setViewName("mngHumanResource/memberInsert");
		mv.addObject("departmentList", departmentList);
		mv.addObject("SalaryStepList", SalaryStepList);
		mv.addObject("JobList", JobList);
		return mv;
	}

	@PostMapping(value = "/memberInsert" , produces = "application/json; chartset=UTF-8")
	public ModelAndView mngMember(ModelAndView mv, RedirectAttributes rttr, MngHumanResourceDTO mngHumanResourceDTO ,@AuthenticationPrincipal UserImpl user 
			,@RequestParam String memberPasswordCheck, @RequestParam String memberId, @RequestParam String familyOriginAddressDetail, @RequestParam String addressDetail) {
		
		int companyNo = user.getCompanyNo();
		
		String familyOriginAddress = mngHumanResourceDTO.getFamilyOriginAddress();
		System.out.println("familyOriginAddress + familyOriginAddress2 : " + familyOriginAddress + familyOriginAddressDetail);
		mngHumanResourceDTO.setFamilyOriginAddress(familyOriginAddress + familyOriginAddressDetail);
		
		String Password = mngHumanResourceDTO.getMemberPassword(); //입력 받은 패스워드를 불러온다.
		if (Password.equals(memberPasswordCheck)) {
			Password = passwordEncoder.encode(Password);	//입력 받은 패스워드를 암호화 처리해준다.
		} else {
			rttr.addFlashAttribute("failedMessage","입력하신 비밀번호가 서로 다릅니다." );
		}
				
		mngHumanResourceDTO.setMemberPassword(Password);	//입력받은 패스워드 암호화 처리된걸 다시 DTO에 넣어준다.
		
		int insertMember = mngHumanResourceService.insertMember(mngHumanResourceDTO , user.getCompanyNo());
		
		
		
		if (insertMember > 0) {
			rttr.addFlashAttribute("successMessage"," 직원 등록에 성공하셨습니다.");
		}else {
			rttr.addFlashAttribute("failedMessage","직원 등록에 실패하셨습니다." );
		}
		
		mv.setViewName("redirect:/mngHumanResource/memberInsert");
		return mv;
	}
	
	
	
	@GetMapping("/memberList")
	public ModelAndView mngMyPage(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<MemberListDTO> memberList = mngHumanResourceService.selectMemberList(user.getCompanyNo());
		System.out.println("memberList : " + memberList);
		mv.addObject("memberList", memberList);
		mv.setViewName("mngHumanResource/memberList");
		return mv;
	}

	
	@GetMapping("/memberHistoryDetail")
	public ModelAndView memberHistoryDetail(HttpServletRequest request, ModelAndView mv, @AuthenticationPrincipal UserImpl user ) {
		
		System.out.println("get방식 parameter 값:"+request.getParameter("idNo"));
		int idNo = Integer.parseInt(request.getParameter("idNo"));
		MngHumanResourceDTO memberHistoryDetail = mngHumanResourceService.selectmemberHistoryDetailList(user.getCompanyNo(), idNo);
		System.out.println("memberHistoryDetail : " + memberHistoryDetail);
		mv.addObject("memberHistoryDetail", memberHistoryDetail);
		mv.setViewName("redirect:/mngHumanResource/memberHistoryDetail");
		return mv;
	}
	
	@GetMapping("/memberDetail")
	public ModelAndView mngMemberDetail(HttpServletRequest request, ModelAndView mv, @AuthenticationPrincipal UserImpl user ) {
		
		System.out.println("get방식 parameter 값:"+request.getParameter("idNo"));
		int idNo = Integer.parseInt(request.getParameter("idNo"));
		MngHumanResourceDTO memberDetailList = mngHumanResourceService.selectMemberDetailList(user.getCompanyNo(), idNo);
		List<MngDepartmentHistoryDTO>departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());
		List<JobDTO> JobList = mngHumanResourceService.selectJobList(user.getCompanyNo());
		mv.addObject("departmentList", departmentList);
		mv.addObject("JobList", JobList);
		mv.addObject("memberDetailList", memberDetailList);
		mv.setViewName("mngHumanResource/memberDetail");
		System.out.println("mv : " + mv);
		return mv;
	}
	@PostMapping("/memberDetailUpdate")
	public ModelAndView mngMemberDetailUpdate(RedirectAttributes rttr, ModelAndView mv, @AuthenticationPrincipal UserImpl user ,MngHumanResourceDTO mngHumanResourceDTO) {
		
		System.out.println("mngHumanResourceDTO : " + mngHumanResourceDTO);
		
		int resultMemberDetailUpdate = mngHumanResourceService.memberDetailUpdate(user.getCompanyNo(),mngHumanResourceDTO, user.getNo());
		
		System.out.println("resultMemberDetailUpdate :" + resultMemberDetailUpdate);
		
		rttr.addFlashAttribute("successMessage","정보 수정에 성공하였습니다.");
		mv.setViewName("redirect:/mngHumanResource/memberList");
		return mv;
	}
	
	
}
