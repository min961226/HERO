package com.nextLevel.hero.basicSetting.model.service;

import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;

public interface BasicSettingService {

	int insertOrUpdateBasicSettingCompany(MngBasicInformationDTO basicInformation);

	int insertUpperDept(MngDepartmentHistoryDTO departmentDTO);

	MngDepartmentHistoryDTO selectOneUpperDepartment(int companyNo);

}
