 package com.nextLevel.hero.mngCertificate.model.service;

import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngCertificate.model.dao.MngCertificateMapper;

@Service("mngCertificateService")
public class MngCertificateServiceImpl implements MngCertificateService {

	private final MngCertificateMapper mngCertificateMapper; 
	
	public MngCertificateServiceImpl(MngCertificateMapper mngCertificateMapper) {
		this.mngCertificateMapper = mngCertificateMapper;
	}
}
