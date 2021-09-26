package com.nextLevel.hero.mngBasicInformation.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;


@Mapper
public interface MngBasicInformationMapper {

	MngBasicInformationDTO selectCompanyInformationByCompanyNo(int companyNo);

	int updateCompanyInformation(MngBasicInformationDTO basicInformation);

	List<MngDepartmentHistoryDTO> selectDepartmentHistory(int companyNo);

	MngInsuranceRateDTO selectInsuranceHistory(int companyNo);



}
