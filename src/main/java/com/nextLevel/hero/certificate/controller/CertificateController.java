package com.nextLevel.hero.certificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nextLevel.hero.certificate.model.service.CertificateService;

@Controller
@RequestMapping("/certificate")
public class CertificateController {
	
	private final CertificateService certificateService;
	
	@Autowired
	public CertificateController(CertificateService certificateService) {
		this.certificateService = certificateService; 
	}
	
	@GetMapping("/employment")
	public String certificateEmployment() {
		
		return "certificate/employment";
	}
	
	@GetMapping("/list")
	public String certificateList() {
		
		return "certificate/list";
	}
	
	
}
