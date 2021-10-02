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
import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;

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
	public MngDepartmentHistoryDTO selectOneDepartment(int companyNo, int departmentNum) {
		return mngBasicInformationMapper.selectOneDepartment(companyNo,departmentNum);
	}

	@Override
	@Transactional
	public int updateDepartment(MngDepartmentHistoryDTO departmentDTO) {
		return mngBasicInformationMapper.updateDepartment(departmentDTO);
	}

	@Override
	@Transactional
	public int insertUpdateLogDepartment(MngDepartmentHistoryDTO departmentDTO) {
		return mngBasicInformationMapper.insertUpdateLogDepartment(departmentDTO);
	}

	@Override
	public List<MngMemberDepartmentDTO> selectMemberDepartment(MngMemberDepartmentDTO memberDepartment) {
		return mngBasicInformationMapper.selectMemberDepartment(memberDepartment);
	}

	@Override
	@Transactional
	public int deleteDepartment(int departmentNum, int companyNo) {
		return mngBasicInformationMapper.deleteDepartment(departmentNum,companyNo);
	}

	@Override
	@Transactional
	public int insertDeleteLogDepartment(MngDepartmentHistoryDTO departmentDTO) {
		return mngBasicInformationMapper.insertDeleteLogDepartment(departmentDTO);
	}






	
}
