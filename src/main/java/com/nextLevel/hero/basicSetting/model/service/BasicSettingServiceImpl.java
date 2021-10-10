package com.nextLevel.hero.basicSetting.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.basicSetting.model.dao.BasicSettingMapper;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;

@Service("basicSettingService")
public class BasicSettingServiceImpl implements BasicSettingService {

	private final BasicSettingMapper basicSettingMapper; 
	
	@Autowired
	public BasicSettingServiceImpl(BasicSettingMapper basicSettingMapper) {
		this.basicSettingMapper = basicSettingMapper;
	}

	@Override
	@Transactional
	public int insertOrUpdateBasicSettingCompany(MngBasicInformationDTO basicInformation) {
		return basicSettingMapper.insertOrUpdateBasicSettingCompany(basicInformation);
	}

	@Override
	@Transactional
	public int insertUpperDept(MngDepartmentHistoryDTO departmentDTO) {
		return basicSettingMapper.insertUpperDept(departmentDTO);
	}

	@Override
	public MngDepartmentHistoryDTO selectOneUpperDepartment(int companyNo) {
		return basicSettingMapper.selectOneUpperDepartment(companyNo);
	}
	
	
	
}
