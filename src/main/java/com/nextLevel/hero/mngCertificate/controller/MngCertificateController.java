package com.nextLevel.hero.mngCertificate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.mngCertificate.model.service.MngCertificateService;

@Controller
@RequestMapping("/mngCertificate")
public class MngCertificateController {
	
	private final MngCertificateService mngCertificateService; 
	
	public MngCertificateController(MngCertificateService mngCertificateService) {
		this.mngCertificateService = mngCertificateService;
	}
	
	@GetMapping("/printList")
	public String mngPrintList() {
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
