package com.nextLevel.hero.mngCertificate.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngCertificate.model.dao.MngCertificateMapper;
import com.nextLevel.hero.mngCertificate.model.dto.CertificateMemberDTO;

@Service
public class CertificateMemberService {

	private static MngCertificateMapper mngCertificateMapper;
	
	@Autowired
	public CertificateMemberService(MngCertificateMapper mngCertificateMapper) {
		this.mngCertificateMapper = mngCertificateMapper;
	}
	
	public static List<CertificateMemberDTO> findAllMember() {
		
		
		return mngCertificateMapper.findAllMember();
	}

}
