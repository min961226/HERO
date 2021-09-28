package com.nextLevel.hero.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
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

//	@RequestMapping( value = "/member/findId", method = RequestMethod.POST)
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
		
		rttr.addFlashAttribute("successMessage", "findIdDTO.getId()");
		
		mv.setViewName("redirect:/member/findIdForm");
		
	return mv;
	
	}
			
			
			
			
			
			
			
	
	@GetMapping("/findPasswordForm")
	public String memberFindPasswordForm() {
		return "member/findPasswordForm";
	}
	
	@PostMapping("/findPassword")
	public ModelAndView memberFindPassword(@RequestParam String userId
			, @RequestParam String username , @RequestParam String email ,  @RequestParam String emailCode
			,ModelAndView mv) {
		
		System.out.println("userId : " + userId);
		System.out.println("username : " + username);
		System.out.println("email : " + email);
		System.out.println("emailCode : " + emailCode);
		
		
		
		
		
		
		
		return mv;
	}
	
}
