package com.nextLevel.hero.mngBasicInformation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.mngBasicInformation.model.dao.MngBasicInformationMapper;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;

@Service("mngBasicInformationService")
public class MngBasicInformationServiceImpl implements MngBasicInformationService {

	private final MngBasicInformationMapper  mngBasicInformationMapper;
	
	@Autowired
	public MngBasicInformationServiceImpl(MngBasicInformationMapper mngBasicInformationMapper) {
		this.mngBasicInformationMapper = mngBasicInformationMapper;
	}

	@Override
	public MngBasicInformationDTO selectCompanyInformationByCompanyNo(int companyNo) {
		return mngBasicInformationMapper.selectCompanyInformationByCompanyNo(companyNo);
	}


	
}
