package com.nextLevel.hero.mngCertificate.model.service;

import java.util.List;

import com.nextLevel.hero.mngCertificate.model.dto.CertificateMemberDTO;

public interface MngCertificateService {

	List<CertificateMemberDTO> findAllMember(int companyNo);



}
