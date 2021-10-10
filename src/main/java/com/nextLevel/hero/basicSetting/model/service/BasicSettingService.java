package com.nextLevel.hero.basicSetting.model.service;

import java.util.List;

import com.nextLevel.hero.basicSetting.model.dto.ExcelBusiness;
import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;

public interface BasicSettingService {

	int insertOrUpdateBasicSettingCompany(MngBasicInformationDTO basicInformation);

	int insertUpperDept(MngDepartmentHistoryDTO departmentDTO);

	MngDepartmentHistoryDTO selectOneUpperDepartment(int companyNo);

	BusinessDTO selectBusinessInfo(int companyNo);

	int insertInsuranceRate(MngInsuranceRateDTO insuranceRateDTO);

	int finishBasicSetting(int userId);

	int insertBusinessList(List<ExcelBusiness> dataList);

}
