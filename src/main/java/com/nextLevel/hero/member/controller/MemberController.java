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
	
	private final MemberService memberService;                                    							//서비스
	private final PasswordEncoder passwordEncoder;                               						    //비밀번호 암호화
	
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
		return "member/findIdForm";                           											   //아이디 찾기 폼으로 이동
	}

	@PostMapping("/findId")                                 											   //findId 맵핑 주소를 받아온다
	public ModelAndView memberFindId(@RequestParam String username
			, @RequestParam String phone
			, ModelAndView mv
			, RedirectAttributes rttr) {
		
		String phone2 = "";                                          
		
		phone2 = phone.substring(0, 3) + "-" +phone.substring(3, 7) + "-" + phone.substring(7, 11);			//핸드폰 번호를 @RequestParam 사용하여 findIdForm 값을 가져와 subString으로 값을 쪼개서 넣어준다.
		
		FindIdDTO findIdDTO = memberService.selectFindId(username, phone2);									//아이디 찾기를 하기 위해 맴버서비스로 값이 가져간다.
		
		if (findIdDTO != null) {																			//아이디 값이 있을경우 실행한다.
			rttr.addFlashAttribute("successMessage","귀하의 ID는 " + findIdDTO.getId()+ " 입니다.");
		} else {
			rttr.addFlashAttribute("failedMessage","아이디 찾기가 실패하였습니다. 다시 입력해 주시기 바랍니다.");
		}
		
		mv.setViewName("redirect:/member/login");															//ModelandView.setViewName redirect로 화면을 이동한다.
	
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
		
		String AuthenticationKey = (String) session.getAttribute("AuthenticationKey");		//인증 번호
		
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
			userPwd = passwordEncoder.encode(userPwd);							//비밀번호를 암호화 걸어준다.
			
			findPwdDTO.setEmail(email);											//findPwdDTO에 이메일 값을 담아준다
			findPwdDTO.setUserId(userId);										//findPwdDTO에 유저 아이디 값을 담아준다
			findPwdDTO.setUsername(username);									//findPwdDTO에 유저이름 값을 담아준다
			findPwdDTO.setUserPwd(userPwd);										//findPwdDTO에 유저 비밀번호 값을 담아준다
			
			 int result = memberService.updatePwd(findPwdDTO);					//비밀번호를 변경하는 서비스로 이동한다
			 
			 if (result > 0) {
				 
				 MailPwdController mailPwdController = new MailPwdController(findPwdDTO, temp);
			}
			
		}else {
			rttr.addFlashAttribute("failedMessage"," 비밀번호 변경이 실패하였습니다. 다시 입력해 주시기 바랍니다.");			//비밀번호 변경 실패시 메세지 출력	
		}
		
		FindPwdDTO findPwdDTO = memberService.selectFindPwd(userId, username, email);
		

		rttr.addFlashAttribute("successMessage"," 이메일을 통해 임시 비밀번호를 발급하였습니다. 로그인 즉시 비밀번호를 변경해주시길 바랍니다.");			//비밀번호 변경 성공시 메세지 출력	
		
		mv.setViewName("redirect:/member/login");																				//redirect를 통해 화면 이동
		
		return mv;
	}
	
}
