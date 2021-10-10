package com.nextLevel.hero.basicSetting.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;

@Mapper
public interface BasicSettingMapper {

	int insertOrUpdateBasicSettingCompany(MngBasicInformationDTO basicInformation);

	int insertUpperDept(MngDepartmentHistoryDTO departmentDTO);

	MngDepartmentHistoryDTO selectOneUpperDepartment(int companyNo);

	BusinessDTO selectBusinessInfo(int companyNo);

	int insertInsuranceRate(MngInsuranceRateDTO insuranceRateDTO);

	int finishBasicSetting(int userId);

	int insertUserAuth(int userId);

}
