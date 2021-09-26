package com.nextLevel.hero.mngBasicInformation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.mngBasicInformation.model.dao.MngBasicInformationMapper;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;

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

	@Override
	@Transactional
	public int updateCompanyInformation(MngBasicInformationDTO basicInformation) {
		return mngBasicInformationMapper.updateCompanyInformation(basicInformation);
	}

	@Override
	public List<MngDepartmentHistoryDTO> selectDepartmentHistory(int companyNo) {
		return mngBasicInformationMapper.selectDepartmentHistory(companyNo);
	}

	@Override
	public MngInsuranceRateDTO selectInsuranceHistory(int companyNo) {
		return mngBasicInformationMapper.selectInsuranceHistory(companyNo);
	}


	
}
