package com.nextLevel.hero.mngBasicInformation.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngBasicInformation.model.dto.MngBasicInformationDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngDepartmentHistoryDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngInsuranceRateDTO;
import com.nextLevel.hero.mngBasicInformation.model.dto.MngMemberDepartmentDTO;


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




}
