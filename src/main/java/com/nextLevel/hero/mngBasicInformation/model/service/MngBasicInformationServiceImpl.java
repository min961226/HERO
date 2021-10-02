package com.nextLevel.hero.mngBasicInformation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.mngBasicInformation.model.dao.MngBasicInformationMapper;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;

@Service("mngBasicInformationService")
public class MngBasicInformationServiceImpl implements MngBasicInformationService {

	private final MngBasicInformationMapper  mngBasicInformationMapper;
	
	@Autowired
	public MngBasicInformationServiceImpl(MngBasicInformationMapper mngBasicInformationMapper) {
		this.mngBasicInformationMapper = mngBasicInformationMapper;
	}

	@Override
	public MngBasicInformationDTO selectCompanyInformationByCompanyNo(int companyNo) {
		return mngBasicInformationMapper.selectCompanyInformationByCompanyNo(companyNo);
	}

	@Override
	@Transactional
	public int updateCompanyInformation(MngBasicInformationDTO basicInformation) {
		return mngBasicInformationMapper.updateCompanyInformation(basicInformation);
	}
	
	@Override
	@Transactional
	public int insertLogCompanyInformation(MngBasicInformationDTO basicInformation) {
		return mngBasicInformationMapper.insertLogCompanyInformation(basicInformation);
	}

	@Override
	public List<MngDepartmentHistoryDTO> selectDepartmentHistory(int companyNo) {
		return mngBasicInformationMapper.selectDepartmentHistory(companyNo);
	}
	
	@Override
	public MngInsuranceRateDTO selectInsurance(int companyNo) {
		return mngBasicInformationMapper.selectInsurance(companyNo);
	}

	@Override
	public List<MngInsuranceRateDTO> selectInsuranceHistory(int companyNo) {
		return mngBasicInformationMapper.selectInsuranceHistory(companyNo);
	}

	@Override
	@Transactional
	public int insertPremiumRate(MngInsuranceRateDTO insuranceRate) {
		return mngBasicInformationMapper.insertPremiumRate(insuranceRate);
	}

	@Override
	public List<MngDepartmentHistoryDTO> selectDepartment(int companyNo) {
		return mngBasicInformationMapper.selectDepartment(companyNo);
	}
	
	@Override
	@Transactional
	public int insertDepartment(MngDepartmentHistoryDTO departmentDTO) {
		return mngBasicInformationMapper.insertDepartment(departmentDTO);
	}

	@Override
	@Transactional
	public int insertLogDepartment(MngDepartmentHistoryDTO departmentDTO) {
		return mngBasicInformationMapper.insertLogDepartment(departmentDTO);
	}

	@Override
	public int selectDepartmentNo(MngDepartmentHistoryDTO departmentDTO) {
		return mngBasicInformationMapper.selectDepartmentNo(departmentDTO);
	}


	@Override
	public MngDepartmentHistoryDTO selectOneDepartment(int departmentNum) {
		return mngBasicInformationMapper.selectOneDepartment(departmentNum);
	}






	
}
