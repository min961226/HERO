 package com.nextLevel.hero.mngCertificate.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngCertificate.model.dao.MngCertificateMapper;
import com.nextLevel.hero.mngCertificate.model.dto.CertificateMemberDTO;

@Service("mngCertificateService")
public class MngCertificateServiceImpl implements MngCertificateService {

	private final MngCertificateMapper mngCertificateMapper; 
	
	@Autowired
	public MngCertificateServiceImpl(MngCertificateMapper mngCertificateMapper) {
		this.mngCertificateMapper = mngCertificateMapper;
	}

	@Override
	public CertificateMemberDTO findAllMember() {
		return mngCertificateMapper.findAllMember();
	}
}
