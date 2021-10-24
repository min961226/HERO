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
	public ModelAndView password(ModelAndView mv,@AuthenticationPrincipal UserImpl user, 
			RedirectAttributes rttr, FindPwdDTO findPwdDTO, @RequestParam String userPwdCheck) {
		
		int idNo = user.getNo();																		//로그인시 불러온 사원 번호를 가져온다
		int companyNo = user.getCompanyNo();															//로그인시 불러온 회서 번호를 가져온다
		System.out.println("companyNo : " + companyNo);
		String userPwd = findPwdDTO.getUserPwd();														//password 변경 폼에서 입력 받은 패스워드 값을 가져온다.
		
		if (userPwd.equals(userPwdCheck)) {																//password 변경 폼에서 입력 받은 패스워드와 패스워드 재확인 값을 비교한다.
			userPwd = passwordEncoder.encode(userPwd);													//비밀번호를 암호화 처리 한다.
			findPwdDTO.setUserPwd(userPwd);																//비밀번호 값을 DTO에 값을 저장한다.
			findPwdDTO.setIdNo(idNo);																	//사원 번호를 DTO에 값을 저장한다.
			
		int resultPassword = humanResourceService.updatePassword(companyNo,findPwdDTO);					//비밀번호 변경하기 위해 서비스로 넘어간다.
		
		if (resultPassword > 0) {																		//비밀번호가 업데이트 되었을시 값이 1이 되어 if 안에 로직을 실행한다.
			rttr.addFlashAttribute("successMessage" , "비밀번호 변경에 성공하셨습니다." );						//비밀번호가 변경되었다는 메세지를 출력한다.
		} else {
			rttr.addFlashAttribute("failedMessage" , "비밀번호 변경에 실패하셨습니다." );							//비밀번호가 업데이트가 실패하여 비밀번호 변경 실패 메세지를 출력한다.
		}
		
		} else {
			rttr.addFlashAttribute("failedMessage" , "입력 하신 비밀번호가 비밀번호 재확인이랑 일치하지 않습니다." );		//password 변경 폼에서 입력 받은 패스워드와 패스워드 재확인 값을 비교했을때 실패시 메세지를 출력한다.
		}
		
		mv.setViewName("redirect:/humanResource/password");												//redirect를 통해 화면을 이동한다.
		
		return mv;
	}
	
	@GetMapping("/myPage")
	public ModelAndView hrMyPage(ModelAndView mv, @AuthenticationPrincipal UserImpl user) {

		int idNo = user.getNo();																		//로그인시 불러온 사원 번호를 가져온다
		int memberNo = humanResourceService.selectMemberNo(user.getCompanyNo(), idNo);					//멤버 번호 조회하기 위해 서비스로 값을 가져간다.
		int jobNo = humanResourceService.selectjobNo(user.getCompanyNo(), idNo);						//JobNo를 조회하기 위해 서비스로 값을 가져간다.
		
		myPageList = humanResourceService.selectMypage(user.getCompanyNo(), idNo, memberNo, jobNo);		//myPage에 값을 조회하기 위해 서비스로 값을 가져간다
		mv.addObject("myPageList", myPageList);															//조회한 myPageList 값을 addObject로 값을 저장한다.	
		mv.setViewName("humanResource/myPage");															
		return mv;
	}
	@PostMapping("/myPageUpdate")
	public ModelAndView MyPageUpdate(RedirectAttributes rttr, ModelAndView mv, 								
			@AuthenticationPrincipal UserImpl user, MyPageDTO myPageDTO, 
			@RequestParam String ssn1,@RequestParam String ssn2) {
		
		myPageDTO.setHireDate(myPageList.getHireDate());												
		myPageDTO.setSsn(ssn1 + "-" + ssn2);															//myPage 폼에서 주민번호를 받아와 값을 합친후 DTO에 값을 저장한다.
		int idNo = user.getNo();																		//로그인시 불러온 사원 번호를 가져온다
		int empUpdate = humanResourceService.updateEmp(user.getCompanyNo(), idNo, myPageDTO);			//Emp테이블에 값을 업데이트 하기위해 서비스로 값을 가져간다.
		int myPageUpdate = humanResourceService.updateMyPage(user.getCompanyNo(), idNo, myPageDTO);		//EmpUpdate테이블에 값을 업데이트 하기위해 서비스로 값을 가져간다.
		
		rttr.addFlashAttribute("successMessage" , "개인정보 수정에 성공하셨습니다.");								//개인정보 수정시 메세지를 출력한다.
		mv.setViewName("redirect:/humanResource/myPage");												//redirect를 통해 화면을 이동한다.
		return mv;
	}
	
	
}
