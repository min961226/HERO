package com.nextLevel.hero.mngCertificate.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.member.model.dto.UserImpl;
import com.nextLevel.hero.mngCertificate.model.dto.CertificateMemberDTO;
import com.nextLevel.hero.mngCertificate.model.service.MngCertificateService;

@Controller
@RequestMapping("/mngCertificate")
public class MngCertificateController {
	
	private final MngCertificateService mngCertificateService; 
	
	public MngCertificateController(MngCertificateService mngCertificateService) {
		this.mngCertificateService = mngCertificateService;
	}
	
	@GetMapping("/printList")
	public ModelAndView mngPrintList(ModelAndView mv,@AuthenticationPrincipal UserImpl user) {
		
		List<CertificateMemberDTO> memberList = mngCertificateService.findAllMember(user.getCompanyNo());
		
		System.out.println("memberList : " + memberList);
		mv.setViewName("mngCertificate/printList");
		mv.addObject("memberList", memberList);
		return mv;
	}
	
	@GetMapping("/requestList")
	public String mngRequestList() {
		return "mngCertificate/requestList";
	}
	
	@GetMapping("/certificateHistory")
	public String mngCertificateHistory() {
		return "mngCertificate/certificateHistory";
	}
	
}
