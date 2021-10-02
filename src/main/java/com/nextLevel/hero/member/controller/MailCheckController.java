package com.nextLevel.hero.member.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MailCheckController {

	@PostMapping(value="checkMail", produces ="application/json; charset=UTF-8")
	@ResponseBody
	public void mail(HttpServletResponse response, HttpServletRequest request , @RequestParam String email, @RequestParam String username ) {

		System.out.println("email : " + email);
		System.out.println("username : " + username);
		
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
		
		String AuthenticationKey = temp.toString();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=null;
		
		SimpleEmail email1 = new SimpleEmail();
		email1.setHostName("smtp.naver.com");
		email1.setSmtpPort(465);
		email1.setAuthentication("rpaxk2", "dkfvl123");
		
		email1.setSSLOnConnect(true);
		email1.setStartTLSEnabled(true);
		
		String response1 = "fail";
		
		try {
			//보내는 사람 설정 (SMTP 서비스 로그인 계정 아이디와 동일하게 해야함 주의!)
			email1.setFrom("rpaxk2@naver.com", "HERO", "utf-8");
			//받는 사람 설정
			email1.addTo(email, username, "utf-8");
			//제목 설정
			email1.setSubject("HERO 이메일 인증번호.");
			email1.setMsg("===================================================\n"			
					+ "                  회원님 안녕하세요. \n"
					+ "   HERO 회원 이메일 인증번호를 발송해드립니다. \n"
					+ "             [ 인증번호 : " + temp + " ] \n"
					+ "===================================================\n"
					+ "                   - HERO -");
			//메일 전송하기
			try {
				out = response.getWriter();
				response1 = email1.send();
				out.println("<script>alert('메일을 보냈습니다'); history.back();</script>");
				
				HttpSession saveKey = request.getSession();
				
				saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
				
				System.out.println("AuthenticationKey : " + AuthenticationKey);
			} catch (IOException e) {
					e.printStackTrace();
			}
		} catch (EmailException e) {
				e.printStackTrace();
		}
		
	}
	
}




















//@RestController
//@RequestMapping("/mail")
//public class MailController {
//
//    @Autowired
//    private MailService mailService;
//
//    @PostMapping("/checkMail")
//    public MailDTO sendTestMail(String email) {
//    	
//    	System.out.println("email : " + email);
//    	
//    	MailDTO mailDTO = new MailDTO();
//
//    	mailDTO.setAddress(email);
//    	mailDTO.setTitle("밤둘레 님이 발송한 이메일입니다.");
//    	mailDTO.setMessage("안녕하세요. 반가워요!");
//
//        mailService.sendMail(mailDTO);
//
//        return mailDTO;
//    }
//}