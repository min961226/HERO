package com.nextLevel.hero.certificate.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.certificate.model.dao.CertificateMapper;


@Service("certificateService")
public class CertificateServiceImpl implements CertificateService {

	private final CertificateMapper certificateMapper; 
	
	@Autowired
	public CertificateServiceImpl(CertificateMapper certificateMapper) {
		this.certificateMapper = certificateMapper;
	}
	
	
	
}
