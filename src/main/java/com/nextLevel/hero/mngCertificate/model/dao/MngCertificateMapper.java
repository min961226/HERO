package com.nextLevel.hero.mngCertificate.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngCertificate.model.dto.CertificateMemberDTO;

@Mapper
public interface MngCertificateMapper {


	CertificateMemberDTO findAllMember();
	
}
