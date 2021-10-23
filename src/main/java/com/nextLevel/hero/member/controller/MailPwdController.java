package com.nextLevel.hero.member.controller;

import java.io.PrintWriter;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import com.nextLevel.hero.member.model.dto.FindPwdDTO;

public class MailPwdController {

	public MailPwdController(FindPwdDTO findPwdDTO, StringBuffer temp) {
		
		String email =  findPwdDTO.getEmail();									//폼에서 전달 받은 보낼 이메일 값을 가져온다
		String username =  findPwdDTO.getUsername();							//폼에서 전달 받은 유저 이름
		String AuthenticationKey = temp.toString();								//랜덤 인증번호 값
		
		PrintWriter out=null;
		
		SimpleEmail email1 = new SimpleEmail();									//SimpleEmail 클래스 생성
		email1.setHostName("smtp.naver.com");									//호스트 네임
		email1.setSmtpPort(465);												//포트 번호
		email1.setAuthentication("rpaxk2", "dkfvl123");							//아이디 비밀번호	
		
		email1.setSSLOnConnect(true);
		email1.setStartTLSEnabled(true);
		
		String response1 = "fail";
		
		try {
			//보내는 사람 설정 (SMTP 서비스 로그인 계정 아이디와 동일하게 해야함 주의!)
			email1.setFrom("rpaxk2@naver.com", "HERO", "utf-8");
			//받는 사람 설정
			email1.addTo(email, username, "utf-8");
			//제목 설정
			email1.setSubject("HERO 임시 비밀번호.");
			email1.setMsg("===================================================\n"			
					+ "                  회원님 안녕하세요. \n"
					+ "   HERO 회원 임시 비밀번호를 발송하였습니다. \n"
					+ "             [ 임시 비밀번호 : " + AuthenticationKey + " ] \n"
					+ "===================================================\n"
					+ "                   - HERO -");
			
			
			response1 = email1.send();

		} catch (EmailException e) {
				e.printStackTrace();
		}
		
	}
}
