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

	int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo);
	
	int insertEmployee(MngHumanResourceDTO humanResourceDTO, int companyNo);
	
	int insertMemberCompany(MngHumanResourceDTO humanResourceDTO, int companyNo);
	
	int selectNewMemberNumber();

	int insertMilitary(MngHumanResourceDTO humanResourceDTO, int companyNo);
	
	int insertVeteran(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertAppointment(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertGraduated(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertCareer(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertFamily(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertUserAuth(MngHumanResourceDTO humanResourceDTO, int companyNo);

	List<VacationControlDTO> selectVacationControl();

	int insertVacation(MngHumanResourceDTO humanResourceDTO, int companyNo, int vacationCode, int vacationDays);
	
	int insertFamilyUpdate(MngHumanResourceDTO humanResourceDTO, int companyNo, int familyNo);

	int insertEmpSalaryStep(MngHumanResourceDTO humanResourceDTO, int companyNo, java.sql.Date startDate);

	int insertEmpSalaryStepUpdate(MngHumanResourceDTO humanResourceDTO, int companyNo, java.sql.Date startDate, int divNo);

	Date selectRankSalaryStep(int companyNo, int salaryStepByRank);

	int selectEmpSalaryStep(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertFourInsuranceDeduct(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertEmpUpdate(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int selectFamilyUpdate(MngHumanResourceDTO humanResourceDTO, int companyNo);

	List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo);

	


	



}
