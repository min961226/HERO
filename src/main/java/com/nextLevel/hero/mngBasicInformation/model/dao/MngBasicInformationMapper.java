package com.nextLevel.hero.mngBasicInformation.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;


@Mapper
public interface MngBasicInformationMapper {

	MngBasicInformationDTO selectCompanyInformationByCompanyNo(int companyNo);



}
