package com.nextLevel.hero.basicSetting.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;

@Mapper
public interface BasicSettingMapper {

	int insertOrUpdateBasicSettingCompany(MngBasicInformationDTO basicInformation);

	int insertUpperDept(MngDepartmentHistoryDTO departmentDTO);

	MngDepartmentHistoryDTO selectOneUpperDepartment(int companyNo);

}
