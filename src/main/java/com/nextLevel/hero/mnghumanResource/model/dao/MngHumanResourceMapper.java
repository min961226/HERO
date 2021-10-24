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

	int insertMember(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);													//Member(유저) 테이블 인서트
	
	int selectNewMemberNumber();																								//맴버 번호(사번)를 조회
	
	int insertEmployee(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);													//Employee(회원)테이블 인서트		
	
	int insertEmpUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);												//EmployeeUpdate(회원)테이블 인서트
	
	int insertMemberCompany(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);											//MemberCompany테이블 인서트
	
	int insertMilitary(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);													//MILITARY_SERVICE 테이블 인서트
	
	int insertVeteran(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);													//Veteran 테이블 인서트
	
	int insertAppointment(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);												//Appointment 테이블 인서트		
	
	int insertGraduated(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);												//Graduated 테이블 인서트
	
	int insertCareer(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);													//Career 테이블 인서트
	
	int insertFamily(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);													//Family 테이블 인서트
	
	int selectFamilyUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);												//FamilyUpdate테이블 조회	
	
	int insertFamilyUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, int familyNo);								//FamilyUpdate테이블 인서트
	
	int insertUserAuth(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);													//UserAuth 테이블에 인서트
	
	List<VacationControlDTO> selectVacationControl();																			//VacationControl 테이블 조회
	
	int insertVacation(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, int vacationCode, int vacationDays);				//Vacation 테이블에 인서트
	
	Date selectRankSalaryStep(int companyNo,  MngHumanResourceDTO mngHumanResourceDTO);											//RankSalaryStep 테이블 startDate 조회
	
	MngHumanResourceDTO selectRank(int companyNo,  MngHumanResourceDTO mngHumanResourceDTO );									//RankSalaryStep 테이블 조회
	
	int insertEmpSalaryStep(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, java.sql.Date startDate);					//EmpSalaryStep 테이블에 인서트
	
	int selectEmpSalaryStep(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);											//EmpSalaryStep 테이블에 조회	
	
	int insertEmpSalaryStepUpdate(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, java.sql.Date startDate, int divNo);	//EmpSalaryStepUpdate 테이블에 인서트
	
	int insertFourInsuranceDeduct(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);										//FourInsuranceDeduct 테이블 인서트
	
	int selectFourInsuranceDeduct(MngHumanResourceDTO mngHumanResourceDTO, int companyNo);										//FourInsuranceDeduct 테이블 조회
	
	int insertFourInsHistory(MngHumanResourceDTO mngHumanResourceDTO, int companyNo, int deductDivNo);							//FourInsHistory 테이블 인서트
	
	List<SalaryStepDTO> selectSalaryStep(int companyNo);																		//salaryStep 조회
	
	List<JobDTO> selectJobList(int companyNo);																					//JobList 조회
	
	List<MemberListDTO> selectMemberList(int companyNo);																		//memberList 조회
	
	List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo);													//memberHistoryList 조회		
	
	MngHumanResourceDTO selectMemberDetailList(int companyNo, int idNo);														//memberDetailList 조회
	
	MngHumanResourceDTO selectmemberHistoryDetailList(int companyNo, int idNo);													//memberHistoryDetailList 조회	

	int updateEmp(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);											//TBL_EMPLOYEE 테이블 업데이트			
	
	int updateEmpUpdate(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);										//TBL_EMPLOYEEUpdate 테이블 업데이트

	int updateMilitary(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);										//Military 테이블 업데이트

	int updateVeteran(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);										//Veteran 테이블 업데이트	

	int updateAppointment(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);									//Appointment 테이블 업데이트						

	int updateGraduated(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);										//Graduated 테이블 업데이트			

	int updateCareer(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);											//Career 테이블 업데이트

	int updateFamily(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);											//Family 테이블 업데이트
	
	int selectFamilyNo(int companyNo, int idNo);																				//Family 테이블 조회
	
	int updateFamilyUpdate(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO,int familyNo);						//FamilyUpdate 테이블 업데이트				

	int selectSalaryStepByRank(int companyNo, int idNo);																		//SalaryStepByRank 테이블 조회	
	
	int updateSalaryStep(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO, int salaryStepByRank);				//SalaryStep 테이블 업데이트	
	
	int selectSalaryStepNo(int companyNo, int idNo);																			//SalaryStep 테이블 조회
	
	int updateSalaryStepUpdate(int companyNo, int idNo, int salaryStepByRank, int salaryStepNo);								//SalaryStepUpdate 테이블 업데이트

	MngHumanResourceDTO selectMemberRankList(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO, int salaryStepByRank); 			//MemberRankList 조회
	

	int selectMemberIdNo(int companyNo, MngHumanResourceDTO mngHumanResourceDTO);												//MemberIdNo 조회


	


	



}
