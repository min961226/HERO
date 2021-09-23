package com.nextLevel.hero.mngCertificate.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngCertificate.model.dto.CertificateMemberDTO;

@Mapper
public interface MngCertificateMapper {

	List<CertificateMemberDTO> findAllMember();
	
	
}
