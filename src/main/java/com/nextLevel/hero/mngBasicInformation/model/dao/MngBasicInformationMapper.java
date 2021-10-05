package com.nextLevel.hero.mngBasicInformation.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngBasicInformation.model.dto.BusinessDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngBonusDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngSalaryCriteriaDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngVacationTypeDTO;


@Mapper
public interface MngBasicInformationMapper {

	MngBasicInformationDTO selectCompanyInformationByCompanyNo(int companyNo);

	int updateCompanyInformation(MngBasicInformationDTO basicInformation);

	int insertLogCompanyInformation(MngBasicInformationDTO basicInformation);
	
	List<MngDepartmentHistoryDTO> selectDepartmentHistory(int companyNo);

	List<MngInsuranceRateDTO> selectInsuranceHistory(int companyNo);

	MngInsuranceRateDTO selectInsurance(int companyNo);

	int insertPremiumRate(MngInsuranceRateDTO insuranceRate);

	int insertDepartment(MngDepartmentHistoryDTO departmentDTO);

	int insertLogDepartment(MngDepartmentHistoryDTO departmentDTO);

	int selectDepartmentNo(MngDepartmentHistoryDTO departmentDTO);

	List<MngDepartmentHistoryDTO> selectDepartment(int companyNo);

	MngDepartmentHistoryDTO selectOneDepartment(int companyNo,int departmentNum);

	int updateDepartment(MngDepartmentHistoryDTO departmentDTO);

	int insertUpdateLogDepartment(MngDepartmentHistoryDTO departmentDTO);

	List<MngMemberDepartmentDTO> selectMemberDepartment(MngMemberDepartmentDTO memberDepartment);

	int deleteDepartment(int departmentNum, int companyNo);

	int insertDeleteLogDepartment(MngDepartmentHistoryDTO departmentDTO);

	int selectMemberCount(int companyNo);

	int insertVacationType(MngVacationTypeDTO mngVacationTypeDTO);

	List<MngVacationTypeDTO> selectVacationTypeList(int companyNo);

	MngVacationTypeDTO selectOneVacationType(int companyNo, int vacationNo);

	int updateVacationType(MngVacationTypeDTO mngVacationTypeDTO);

	int deleteVacationType(int companyNo, int vacationNo);

	List<BusinessDTO> selectSearchList(BusinessDTO businessDTO);

	int insertSalaryCriteria(MngSalaryCriteriaDTO salaryCriteriaDTO);

	List<MngSalaryCriteriaDTO> selectSearchList(int companyNo);

	List<MngBonusDTO> selectBonusList(int companyNo);

	List<MngSalaryCriteriaDTO> selectSalaryList(int companyNo);

	int insertBonusType(MngBonusDTO bonusDTO);




}
