package com.nextLevel.hero.basicSetting.model.service;

import java.beans.Transient;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.basicSetting.model.dao.BasicSettingMapper;
import com.nextLevel.hero.basicSetting.model.dto.ExcelBusiness;
import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;

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

	@Override
	public BusinessDTO selectBusinessInfo(int companyNo) {
		return basicSettingMapper.selectBusinessInfo(companyNo);
	}

	@Override
	@Transactional
	public int insertInsuranceRate(MngInsuranceRateDTO insuranceRateDTO) {
		return basicSettingMapper.insertInsuranceRate(insuranceRateDTO);
	}
	
	@Override
	@Transactional
	public int finishBasicSetting(int userId) {
		int result1 = basicSettingMapper.finishBasicSetting(userId);
		int result2 = basicSettingMapper.insertUserAuth(userId);
		
		if(result1 + result2 > 1) {
			return 1;
		}else {
			return 0;
		}
		
	}

	@Override
	@Transactional
	public int insertBusinessList(List<ExcelBusiness> dataList) {
		return basicSettingMapper.insertBusinessList(dataList);
	}
	
	
}
