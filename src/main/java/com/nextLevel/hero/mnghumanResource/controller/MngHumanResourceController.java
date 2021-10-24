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
	
	
	@GetMapping("/memberInsert")
	public ModelAndView mngMemberInsert(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<MngDepartmentHistoryDTO> departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());							//부서목록을 불러오기 위해 서비스로 값을 전달한다.
		List<SalaryStepDTO> SalaryStepList = mngHumanResourceService.selectSalaryStep(user.getCompanyNo());											//직급별 호봉 리스트를 불러오기 위해 서비스로 값을 전달한다.
		List<JobDTO> JobList = mngHumanResourceService.selectJobList(user.getCompanyNo());															//job 리스트를 불러오기 위해 서비스로 값을 전달한다.
		
		mv.addObject("departmentList", departmentList);																								//ModelAndView에 값을 저장한다
		mv.addObject("SalaryStepList", SalaryStepList);																								//ModelAndView에 값을 저장한다
		mv.addObject("JobList", JobList);																											//ModelAndView에 값을 저장한다	
		mv.setViewName("mngHumanResource/memberInsert");																							
		return mv;
	}

	@PostMapping(value = "/memberInsert" , produces = "application/json; chartset=UTF-8")
	public ModelAndView mngMember(ModelAndView mv, RedirectAttributes rttr, MngHumanResourceDTO mngHumanResourceDTO ,@AuthenticationPrincipal UserImpl user 
			,@RequestParam String memberPasswordCheck, @RequestParam String memberId, @RequestParam String familyOriginAddressDetail, @RequestParam String addressDetail
			,@RequestParam String ssn1, @RequestParam String ssn2) {
		
		int companyNo = user.getCompanyNo();																	//로그인시 가져온 회사번호를 가져온다.
		mngHumanResourceDTO.setSsn(ssn1 + "-" + ssn2);															//폼에서 입력받은 주민번호 값을 합친후 DTO에 넣어준다.

		String Password = mngHumanResourceDTO.getMemberPassword(); //입력 받은 패스워드를 불러온다.
		if (Password.equals(memberPasswordCheck)) {
			Password = passwordEncoder.encode(Password);	//입력 받은 패스워드를 암호화 처리해준다.
		} else {
			rttr.addFlashAttribute("failedMessage","입력하신 비밀번호가 서로 다릅니다." );							//입력 받은 비밀번호가 서로 다를시 메세지를 출력한다.
		}
				
		mngHumanResourceDTO.setMemberPassword(Password);	//입력받은 패스워드 암호화 처리된걸 다시 DTO에 넣어준다.
		
		int insertMember = mngHumanResourceService.insertMember(mngHumanResourceDTO , user.getCompanyNo());
		
		if (insertMember > 0) {
			rttr.addFlashAttribute("successMessage"," 직원 등록에 성공하셨습니다.");										//직원등록 성공시 성공 메세지를 출력한다.
		}else {
			rttr.addFlashAttribute("failedMessage","직원 등록에 실패하셨습니다." );										//직원등록 실패시 실패 메세지를 출력한다.
		}
		
		mv.setViewName("redirect:/mngHumanResource/memberInsert");													//redirect 통해 화면을 이동한다.
		return mv;
	}

	@GetMapping("/memberList")
	public ModelAndView mngMyPage(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<MemberListDTO> memberList = mngHumanResourceService.selectMemberList(user.getCompanyNo());				//memberList를 가져오기 위해 서비스에 값을 전달한다.
		mv.addObject("memberList", memberList);																		//memberList 값을 저장한다.
		mv.setViewName("mngHumanResource/memberList");
		return mv;
	}

	@GetMapping("/memberHistory")
	public ModelAndView mngMemberHistory(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {
		
		List<MngHumanResourceDTO> memberHistoryList = mngHumanResourceService.selectMemberHistoryList(user.getCompanyNo(), user.getNo());			//직원 수정된 목록을 불러오기 위해 서비스로 값을 전달한다.
		mv.setViewName("mngHumanResource/memberHistory");
		mv.addObject("memberHistoryList", memberHistoryList);
		return mv;
	}
	
	@GetMapping("/memberHistoryDetail")
	public ModelAndView memberHistoryDetail(HttpServletRequest request, ModelAndView mv, @AuthenticationPrincipal UserImpl user, MngHumanResourceDTO mngHumanResourceDTO) {
		
		int idNo = Integer.parseInt(request.getParameter("idNo"));																						//리스트에서 사원 클릭시 사원번호를 입력 받아온다.
		
		MngHumanResourceDTO memberHistoryDetailList = mngHumanResourceService.selectmemberHistoryDetailList(user.getCompanyNo(), idNo);					//리스트에 사원 정보를 보기 위해 서비스에 값을 전달한다.
		MngHumanResourceDTO memberRankList = mngHumanResourceService.selectMemberRankList(user.getCompanyNo(), idNo, mngHumanResourceDTO);				//사원에 호봉을 조회하기 위해 서비스에 값을 전달한다.
		mv.addObject("memberHistoryDetailList", memberHistoryDetailList);
		mv.addObject("memberRankList", memberRankList);
		mv.setViewName("mngHumanResource/memberHistoryDetail");
		return mv;
	}
	
	@GetMapping("/memberDetail")
	public ModelAndView mngMemberDetail(HttpServletRequest request, ModelAndView mv, @AuthenticationPrincipal UserImpl user, MngHumanResourceDTO mngHumanResourceDTO) {
		
		int idNo = Integer.parseInt(request.getParameter("idNo"));																						//리스트에서 사원 클릭시 사원번호를 입력 받아온다.
		MngHumanResourceDTO memberDetailList = mngHumanResourceService.selectMemberDetailList(user.getCompanyNo(), idNo);								//리스트에 사원 정보를 보기 위해 서비스에 값을 전달한다.
		MngHumanResourceDTO memberRankList = mngHumanResourceService.selectMemberRankList(user.getCompanyNo(), idNo, mngHumanResourceDTO);				//사원에 호봉을 조회하기 위해 서비스에 값을 전달한다.
		List<MngDepartmentHistoryDTO>departmentList = mngBasicInformationService.selectDepartment(user.getCompanyNo());									//부서 정보를 가져오기 위해 서비스에 값을 전달한다.
		List<JobDTO> JobList = mngHumanResourceService.selectJobList(user.getCompanyNo());																//직급을 조회하기 위해 서비스에 값을 전달한다.
		mv.addObject("departmentList", departmentList);																									//departmentList 값을 저장한다.
		mv.addObject("memberRankList", memberRankList);																									//memberRankList 값을 저장한다.
		mv.addObject("JobList", JobList);																												//JobList 값을 저장한다.
		mv.addObject("memberDetailList", memberDetailList);																								//memberDetailList 값을 저장한다.
		mv.setViewName("mngHumanResource/memberDetail");
		return mv;
	}
	
	@PostMapping("/memberDetailUpdate")
	public ModelAndView mngMemberDetailUpdate(HttpServletRequest request, RedirectAttributes rttr, ModelAndView mv, @AuthenticationPrincipal UserImpl user ,MngHumanResourceDTO mngHumanResourceDTO) {
		
		int idNo = mngHumanResourceService.memberIdNo(user.getCompanyNo(),mngHumanResourceDTO);														//idNo를 조회하기위해 서비스에 값을 전달한다.
		int resultMemberDetailUpdate = mngHumanResourceService.memberDetailUpdate(user.getCompanyNo(),mngHumanResourceDTO, idNo);					//사원 정보를 업데이트 하기위해 서비스에 값을 전달한다.
		
		rttr.addFlashAttribute("successMessage","정보 수정에 성공하였습니다.");																			//정보가 수정될시 성공 메세지를 출력한다.
		mv.setViewName("redirect:/mngHumanResource/memberList");																					//redirect 통해 화면을 이동한다.
		return mv;
	}
	
	
}
