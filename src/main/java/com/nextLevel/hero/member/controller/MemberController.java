package com.nextLevel.hero.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.MailDTO;
import com.nextLevel.hero.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final MailDTO MailDTO = null;
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/login")
	public void memberLoginForm() {
		
	}


	@GetMapping("/findIdForm")
	public String memberFindIdForm() {
		return "member/findIdForm";
	}

	@PostMapping("/findId")
	public ModelAndView memberFindId(@RequestParam String username
			, @RequestParam String phone
			, ModelAndView mv
			, RedirectAttributes rttr) {
		
		System.out.println("username : " + username);
		System.out.println("phone : " + phone);
		
		String phone2 = "";
		
		phone2 = phone.substring(0, 3) + "-" +phone.substring(3, 7) + "-" + phone.substring(7, 11);
		
		System.out.println("phone2 : " + phone2);
		
		FindIdDTO findIdDTO = memberService.selectFindId(username, phone2);
		
		System.out.println("findIdDTO : " + findIdDTO.getId());
		
		rttr.addFlashAttribute("successMessage","귀하의 ID는 " + findIdDTO.getId()+ " 입니다.");
		
		mv.setViewName("redirect:/member/login");
		
	return mv;
	
	}
			
			
			
			
			
			
			
	
	@GetMapping("/findPasswordForm")
	public String memberFindPasswordForm() {
		return "member/findPasswordForm";
	}

	
	@PostMapping("/findPassword")
	public ModelAndView memberFindPassword(@RequestParam String userId
			, @RequestParam String username , @RequestParam String email ,  @RequestParam String emailCode
			,ModelAndView mv ,RedirectAttributes rttr, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String AuthenticationKey = request.getParameter("AuthenticationKey");
		String AuthenticationKey2 = (String) session.getAttribute("AuthenticationKey");
		
		
		System.out.println("AuthenticationKey : " + AuthenticationKey);
		System.out.println("AuthenticationKey2 : " + AuthenticationKey2);
		System.out.println("userId : " + userId);
		System.out.println("username : " + username);
		System.out.println("email : " + email);
		System.out.println("emailCode : " + emailCode);
		
		FindPwdDTO findPwdDTO = memberService.selectFindPwd(userId, username, email);
		
		findPwdDTO = memberService.updatePwd(userId, username, email);
		

		System.out.println("findPwdDTO :" + findPwdDTO.getUserPwd());

		rttr.addFlashAttribute("successMessage","귀하의 ID는 " + findPwdDTO.getUserPwd()+ " 입니다.");
		
		mv.setViewName("redirect:/member/login");
		
		return mv;
	}
	
}
