package com.nextLevel.hero.mngBasicInformation.model.service;

import java.util.List;

import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;

public interface MngBasicInformationService {

	MngBasicInformationDTO selectCompanyInformationByCompanyNo(int companyNo);

	int updateCompanyInformation(MngBasicInformationDTO basicInformation);

	MngDepartmentHistoryDTO selectDepartmentHistory(int companyNo);



}
