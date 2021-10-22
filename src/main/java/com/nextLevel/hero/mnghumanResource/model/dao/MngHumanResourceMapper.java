package com.nextLevel.hero.mnghumanResource.model.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.RankSalaryStepDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.VacationControlDTO;

@Mapper
public interface MngHumanResourceMapper {

	List<SalaryStepDTO> selectSalaryStep(int companyNo);
	
	List<JobDTO> selectJobList(int companyNo);
	
	List<MemberListDTO> selectMemberList(int companyNo);

	int insertMember(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);
	
	int insertEmployee(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);
	
	int insertMemberCompany(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);
	
	int selectNewMemberNumber();

	int insertMilitary(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);
	
	int insertVeteran(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int insertAppointment(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int insertGraduated(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int insertCareer(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int insertFamily(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int insertUserAuth(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	List<VacationControlDTO> selectVacationControl();

	int insertVacation(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, int vacationCode, int vacationDays);
	
	int insertFamilyUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, int familyNo);

	int insertEmpSalaryStep(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, java.sql.Date startDate);

	int insertEmpSalaryStepUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, java.sql.Date startDate, int divNo);

	Date selectRankSalaryStep(int companyNo, int salaryStepByRank);

	int selectEmpSalaryStep(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int insertFourInsuranceDeduct(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int insertEmpUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	int selectFamilyUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);

	List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo);

	MngHumanResourceDTO selectMemberDetailList(int companyNo, int idNo);

	MngHumanResourceDTO selectmemberHistoryDetailList(int companyNo, int idNo);

	int updateEmp(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateEmpUpdate(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateMilitary(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateVeteran(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateAppointment(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateGraduated(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateCareer(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateFamily(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateFamilyUpdate(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO,int familyNo);

	int updateSalaryStep(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int updateSalaryStepUpdate(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO, int salaryStepNo);

	int selectFamilyNo(int companyNo, int idNo);

	int selectSalaryStepNo(int companyNo, int idNo);

	


	



}
