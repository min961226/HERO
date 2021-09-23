package com.nextLevel.hero.mngCertificate.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.mngCertificate.model.dto.CertificateMemberDTO;
import com.nextLevel.hero.mngCertificate.model.service.CertificateMemberService;
import com.nextLevel.hero.mngCertificate.model.service.MngCertificateService;

@Controller
@RequestMapping("/mngCertificate")
public class MngCertificateController {
	
	private final MngCertificateService mngCertificateService; 
	
	public MngCertificateController(MngCertificateService mngCertificateService) {
		this.mngCertificateService = mngCertificateService;
	}
	
	@GetMapping("/printList")
	public String mngPrintList(ModelAndView mv) {
		
		List<CertificateMemberDTO> memberList = CertificateMemberService.findAllMember();
		
		mv.addObject("MemberList", memberList);
		mv.setViewName("mngCertificate/printList");
		
		System.out.println("memberList" + memberList);
		
		return "mngCertificate/printList";
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
