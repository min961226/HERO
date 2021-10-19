package com.nextLevel.hero.SYSTEM.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.SYSTEM.model.dto.NewMemberDTO;
import com.nextLevel.hero.SYSTEM.model.service.SystemManagerService;
import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;

@Controller
@RequestMapping("/systemManager")
public class SystemManagerController {
	
	private final SystemManagerService systemManagerService;
	
	@Autowired
	   private PasswordEncoder passwordEncoder;
	 
	@Autowired
	public SystemManagerController(SystemManagerService systemManagerService) {
		this.systemManagerService = systemManagerService;

	}
	
	@GetMapping("/userList")
	public ModelAndView userList(ModelAndView mv) {
		/* 생성된 계정 리스트 */
		List<NewMemberDTO> controlClientList = systemManagerService.selectControlClientList();
		System.out.println(controlClientList);
		mv.addObject("clientList",controlClientList);
		mv.setViewName("systemManager/userList");
		return mv;
	}

	@GetMapping("/createUser")
	public ModelAndView createUser( ModelAndView mv) {
		mv.setViewName("systemManager/createUser");
		return mv;
	}
	@RequestMapping(value="/memberIdCheck", method=RequestMethod.POST)
    @ResponseBody
	public int memberIdCheck(@RequestParam String memberId) {
		
		int idCheck = 0;
		List<String> memberIdList = systemManagerService.selectMemberIdList();		
		System.out.println(memberIdList);
		for(String id : memberIdList) {
			if(id.equals(memberId)) {
				idCheck ++;
			}
		}
		System.out.println("id check" + idCheck);
		
		
		return idCheck;
	}
	@PostMapping("/insertNewMember")
	public ModelAndView insertNewMember(ModelAndView mv,NewMemberDTO newMemberDTO,RedirectAttributes rttr) {
		/* 사업자 등록번호 병합 */
		newMemberDTO.setCompanyRegistrationNo(newMemberDTO.getCompanyRegistrationNo1()+"-"+newMemberDTO.getCompanyRegistrationNo2()+"-"+newMemberDTO.getCompanyRegistrationNo3());
		/* 비밀번호 암호화 */
		String encodedPassword = passwordEncoder.encode(newMemberDTO.getMemberPasswordCheck());
		/* 암호화된 비밀번호를 저장 */
		newMemberDTO.setMemberPasswordCheck(encodedPassword);
		
		int result = systemManagerService.insertNewMember(newMemberDTO);
		if(result > 0) {
			rttr.addFlashAttribute("successMessage", "계정 생성에 성공하였습니다!");
		}else {
			rttr.addFlashAttribute("failedMessage", "계정 생성에 실패하였습니다!");
		}
		mv.setViewName("redirect:/systemManager/createUser");
		return mv;
	}
}
