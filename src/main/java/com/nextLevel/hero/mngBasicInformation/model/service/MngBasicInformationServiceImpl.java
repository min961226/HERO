package com.nextLevel.hero.mngBasicInformation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.mngBasicInformation.model.dao.MngBasicInformationMapper;
import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBonusDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngSalaryCriteriaDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngVacationTypeDTO;

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

	@Override
	public int selectMemberCount(int companyNo) {
		return mngBasicInformationMapper.selectMemberCount(companyNo);
	}

	@Override
	@Transactional
	public int insertVacationType(MngVacationTypeDTO mngVacationTypeDTO) {
		return mngBasicInformationMapper.insertVacationType(mngVacationTypeDTO);
	}

	@Override
	public List<MngVacationTypeDTO> selectVacationTypeList(int companyNo) {
		return mngBasicInformationMapper.selectVacationTypeList(companyNo);
	}

	@Override
	public MngVacationTypeDTO selectOneVacationType(int companyNo, int vacationNo) {
		return mngBasicInformationMapper.selectOneVacationType(companyNo,vacationNo);
	}

	@Override
	@Transactional
	public int updateVacationType(MngVacationTypeDTO mngVacationTypeDTO) {
		return mngBasicInformationMapper.updateVacationType(mngVacationTypeDTO);
	}

	@Override
	@Transactional
	public int deleteVacationType(int companyNo, int vacationNo) {
		return mngBasicInformationMapper.deleteVacationType(companyNo,vacationNo);
	}

	@Override
	public List<BusinessDTO> getSearchList(BusinessDTO businessDTO) {
		return mngBasicInformationMapper.selectSearchList(businessDTO);
	}

	@Override
	@Transactional
	public int insertSalaryCriteria(MngSalaryCriteriaDTO salaryCriteriaDTO) {
		return mngBasicInformationMapper.insertSalaryCriteria(salaryCriteriaDTO);
	}

	@Override
	public List<MngSalaryCriteriaDTO> selectSalaryList(int companyNo) {
		return mngBasicInformationMapper.selectSalaryList(companyNo);
	}

	@Override
	public List<MngBonusDTO> selectBonusList(int companyNo) {
		return mngBasicInformationMapper.selectBonusList(companyNo);
	}

	@Override
	@Transactional
	public int insertBonusType(MngBonusDTO bonusDTO) {
		return mngBasicInformationMapper.insertBonusType(bonusDTO);
	}

	@Override
	@Transactional
	public int deleteSalaryType(int companyNo, int salNo) {
		return mngBasicInformationMapper.deleteSalaryType(companyNo,salNo);
	}

	@Override
	@Transactional
	public int deleteBonusType(int companyNo, int bonusNo) {
		return mngBasicInformationMapper.deleteBonusType(companyNo,bonusNo);
	}

	@Override
	@Transactional
	public MngSalaryCriteriaDTO selectOneSalaryType(int companyNo, int salaryNo) {
		return mngBasicInformationMapper.selectOneSalaryType(companyNo,salaryNo);
	}

	@Override
	@Transactional
	public int updateSalaryType(MngSalaryCriteriaDTO salaryCriteriaDTO) {
		return mngBasicInformationMapper.updateSalaryType(salaryCriteriaDTO);
	}

	@Override
	public MngBonusDTO selectOneBonusType(int companyNo, int bonusNo) {
		return mngBasicInformationMapper.selectOneBonusType(companyNo,bonusNo);
	}

	@Override
	@Transactional
	public int updateBonusType(MngBonusDTO bonusDTO) {
		return mngBasicInformationMapper.updateBonusType(bonusDTO);
	}






	
}
