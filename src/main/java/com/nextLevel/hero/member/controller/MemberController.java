package com.nextLevel.hero.member.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.MailDTO;
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
	@GetMapping("/mail")
	public MailDTO mailCheck(@RequestParam String email) {
	
		System.out.println("email : " + email);

		MailDTO mailDTO = new MailDTO();
		
		mailDTO.setAddress(email);
		mailDTO.setTitle("밤둘레 님이 발송한 이메일입니다.");
		mailDTO.setMessage("안녕하세요. 반가워요!");
		
	    mailDTO = memberService.emailCheck(mailDTO);
		


		
	        return mailDTO;
		
		
		
		
		
//		boolean emailCheck = memberService.emailCheck(email);
		
		

//	        System.out.println(pwFindCheck);
//	        json.put("check", pwFindCheck);
		
		
//		Random random=new Random();  //난수 생성을 위한 랜덤 클래스
//		String key="";  //인증번호 
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(email); //스크립트에서 보낸 메일을 받을 사용자 이메일 주소 
//		//입력 키를 위한 코드
//		for(int i =0; i<3;i++) {
//			int index=random.nextInt(25)+65; //A~Z까지 랜덤 알파벳 생성
//			key+=(char)index;
//		}
//		int numIndex=random.nextInt(9999)+1000; //4자리 랜덤 정수를 생성
//		key+=numIndex;
//		message.setSubject("인증번호 입력을 위한 메일 전송");
//		message.setText("인증 번호 : " + key);
		
		
		

//		StringBuffer temp = new StringBuffer();											/* 인증 번호 생성기 랜덤 메소드*/
//		Random rnd = new Random();
//		for (int i = 0; i < 10; i++) {
//			int rIndex = rnd.nextInt(3);
//			switch (rIndex) {
//			case 0:
//				// a-z
//				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
//				break;
//			case 1:
//				// A-Z
//				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
//				break;
//			case 2:
//				// 0-9
//				temp.append((rnd.nextInt(10)));
//				break;
//			}
//		}
			
//			msg.setSubject("GrouBear 이메일 인증번호");										/* 메일 제목*/	
//			
//			msg.setText("===================================================\n"			/* 메일 내용*/
//						+ "                  회원님 안녕하세요. \n"
//						+ "   GrouBear 회원 이메일 인증번호를 발송해드립니다. \n"
//						+ "             [ 인증번호 : " + temp + " ] \n"
//						+ "===================================================\n"
//						+ "                   - Grou Bear -");

	

	
		
	}
	
	@PostMapping("/findPassword")
	public ModelAndView memberFindPassword(@RequestParam String userId
			, @RequestParam String username , @RequestParam String email ,  @RequestParam String emailCode
			,ModelAndView mv
			,RedirectAttributes rttr) {
		
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
