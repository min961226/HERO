package com.nextLevel.hero.mngBasicInformation.model.service;

import java.util.List;

import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;

public interface MngBasicInformationService {

	MngBasicInformationDTO selectCompanyInformationByCompanyNo(int companyNo);

	int updateCompanyInformation(MngBasicInformationDTO basicInformation);

	List<MngDepartmentHistoryDTO> selectDepartmentHistory(int companyNo);

	List<MngInsuranceRateDTO> selectInsuranceHistory(int companyNo);

	MngInsuranceRateDTO selectInsurance(int companyNo);



}
