package com.nextLevel.hero.member.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("/login")
	public void memberLoginForm() {
		
	}
	@GetMapping("/logout")
	public void memberLogoutForm() {
		
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
		
		if (findIdDTO != null) {
			rttr.addFlashAttribute("successMessage","귀하의 ID는 " + findIdDTO.getId()+ " 입니다.");
			
		} 
		
		
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
		
		String AuthenticationKey = (String) session.getAttribute("AuthenticationKey");
		
		System.out.println("AuthenticationKey : " + AuthenticationKey);
		System.out.println("userId : " + userId);
		System.out.println("username : " + username);
		System.out.println("email : " + email);
		System.out.println("emailCode : " + emailCode);
		
		if (AuthenticationKey.equals(emailCode)) {
			
			StringBuffer temp = new StringBuffer();											/* 인증 번호 생성기 랜덤 메소드*/
			Random rnd = new Random();
			for (int i = 0; i < 10; i++) {
				int rIndex = rnd.nextInt(3);
				switch (rIndex) {
				case 0:
					// a-z
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			}
			
			
			FindPwdDTO findPwdDTO = new FindPwdDTO();
			
			
			String userPwd = temp.toString();
			userPwd = passwordEncoder.encode(userPwd);
			
			System.out.println("암호화 인코딩 잘되었니? : " + userPwd);
			
			findPwdDTO.setEmail(email);
			findPwdDTO.setUserId(userId);
			findPwdDTO.setUsername(username);
			findPwdDTO.setUserPwd(userPwd);
			
			
			 int result = memberService.updatePwd(findPwdDTO);
			 
			 if (result > 0) {
				 
				 
				 MailPwdController mailPwdController = new MailPwdController(findPwdDTO, temp);
				 
			}
			
		}else {
			System.out.println("에러 메세지 출력해주기");
		}
		
		FindPwdDTO findPwdDTO = memberService.selectFindPwd(userId, username, email);
		

		rttr.addFlashAttribute("successMessage"," 이메일을 통해 임시 비밀번호를 발급하였습니다. 로그인 즉시 비밀번호를 변경해주시길 바랍니다.");
		
		mv.setViewName("redirect:/member/login");
		
		return mv;
	}
	
}
