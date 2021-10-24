package com.nextLevel.hero.mnghumanResource.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.mnghumanResource.model.dao.MngHumanResourceMapper;
import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.RankSalaryStepDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.VacationControlDTO;

@Service("mngHumanResourceService")
public class MngHumanResourceServiceImpl implements MngHumanResourceService {

	 private MngHumanResourceMapper mngHumanResourceMapper;
	   
	   @Autowired
	   public MngHumanResourceServiceImpl(MngHumanResourceMapper mngHumanResourceMapper) {
	      this.mngHumanResourceMapper = mngHumanResourceMapper;
	   }

	@Override
	public int insertMember(MngHumanResourceDTO mngHumanResourceDTO, int companyNo) {
		RankSalaryStepDTO rankSalaryStepDTO = new RankSalaryStepDTO();
		VacationControlDTO vacationControlDTO = new VacationControlDTO();
		int insertEmployeeResult = 0;
		int insertMemberCompanyResult = 0;
		int insertMilitaryResult = 0;
		int insertVeteranResult = 0;
		int insertAppointmentResult = 0;
		int insertGraduatedResult = 0;
		int insertCareerResult = 0;
		int insertFamilyResult = 0;
		int insertUserAuthResult = 0;
		java.sql.Date selectRankSalaryStepResult;
		List<VacationControlDTO> selectVacationControlResult;
		int insertVacationControlResult = 0;
		int insertFamilyUpdateResult = 0;
		int insertEmpSalaryStepResult = 0;
		int insertEmpSalaryStepUpdateResult = 0;
		int insertFourInsuranceDeductResult = 0;
		int selectFamilyUpdateResult = 0;
		int insertEmpUpdateResult = 0;
		int selectEmpSalaryStepResult = 0;
		java.sql.Date startDate = null;
		MngHumanResourceDTO selectRankResult;
		
		
		int insertMemberResult = mngHumanResourceMapper.insertMember(mngHumanResourceDTO, companyNo);           					//Member(유저) 테이블 인서트
		int idNo = 0;
		if (insertMemberResult > 0 ) {
			
			idNo = mngHumanResourceMapper.selectNewMemberNumber();																	//맴버 번호(사번)를 조회
			mngHumanResourceDTO.setIdNo(idNo);
			insertEmployeeResult = mngHumanResourceMapper.insertEmployee(mngHumanResourceDTO, companyNo);							//Employee(회원)테이블 인서트
			insertEmpUpdateResult  = mngHumanResourceMapper.insertEmpUpdate(mngHumanResourceDTO, companyNo);						//EmployeeUpdate(회원)테이블 인서트
		}
		if (insertEmployeeResult > 0 ) {
			insertMemberCompanyResult = mngHumanResourceMapper.insertMemberCompany(mngHumanResourceDTO, companyNo);					//MemberCompany테이블 인서트
		} if (insertMemberCompanyResult > 0) {
			insertMilitaryResult  = mngHumanResourceMapper.insertMilitary(mngHumanResourceDTO, companyNo);							//MILITARY_SERVICE 테이블 인서트
		} if (insertMilitaryResult > 0) {
			insertVeteranResult  = mngHumanResourceMapper.insertVeteran(mngHumanResourceDTO, companyNo);							//Veteran 테이블 인서트
		} if (insertVeteranResult > 0) {
			insertAppointmentResult  = mngHumanResourceMapper.insertAppointment(mngHumanResourceDTO, companyNo);					//Appointment 테이블 인서트
		} if (insertAppointmentResult > 0) {
			insertGraduatedResult  = mngHumanResourceMapper.insertGraduated(mngHumanResourceDTO, companyNo);	                    //Graduated 테이블 인서트
		} if (insertGraduatedResult > 0) {
			insertCareerResult  = mngHumanResourceMapper.insertCareer(mngHumanResourceDTO, companyNo);								//Career 테이블 인서트
		} if (insertCareerResult > 0) {
			insertFamilyResult  = mngHumanResourceMapper.insertFamily(mngHumanResourceDTO, companyNo);								//Family 테이블 인서트
			selectFamilyUpdateResult = mngHumanResourceMapper.selectFamilyUpdate(mngHumanResourceDTO, companyNo);					//FamilyUpdate테이블 조회
			int familyNo = selectFamilyUpdateResult;																				//familyNo 조회
			insertFamilyUpdateResult = mngHumanResourceMapper.insertFamilyUpdate(mngHumanResourceDTO, companyNo, familyNo);			//FamilyUpdate테이블 인서트
		} if (insertFamilyResult > 0) {
			insertUserAuthResult  = mngHumanResourceMapper.insertUserAuth(mngHumanResourceDTO, companyNo);							//UserAuth 테이블에 인서트
		} if (insertUserAuthResult > 0) {
			selectVacationControlResult  = mngHumanResourceMapper.selectVacationControl();											//VacationControl 테이블 조회		

			int vacationCode = vacationControlDTO.getVacationCode();																
			int vacationDays = vacationControlDTO.getVacationDays();

			insertVacationControlResult = mngHumanResourceMapper.insertVacation(mngHumanResourceDTO, companyNo, vacationCode, vacationDays);	//Vacation 테이블에 인서트
		 
		}if (insertVacationControlResult > 0) {
		
			selectRankSalaryStepResult = mngHumanResourceMapper.selectRankSalaryStep(companyNo,  mngHumanResourceDTO);									//RankSalaryStep 테이블 startDate 조회
			startDate = selectRankSalaryStepResult;
			selectRankResult = mngHumanResourceMapper.selectRank(companyNo, mngHumanResourceDTO);														//RankSalaryStep 테이블 조회
			mngHumanResourceDTO.setSalaryStepByRank(selectRankResult.getSalaryStepByRank());															
			insertEmpSalaryStepResult  = mngHumanResourceMapper.insertEmpSalaryStep(mngHumanResourceDTO, companyNo, startDate );						//EmpSalaryStep 테이블에 인서트
			selectEmpSalaryStepResult = mngHumanResourceMapper.selectEmpSalaryStep(mngHumanResourceDTO ,companyNo);										//EmpSalaryStep 테이블에 조회	
			int divNo = selectEmpSalaryStepResult;
			insertEmpSalaryStepUpdateResult  = mngHumanResourceMapper.insertEmpSalaryStepUpdate(mngHumanResourceDTO, companyNo, startDate, divNo);		//EmpSalaryStepUpdate 테이블에 인서트
		} 
		 if (insertEmpSalaryStepUpdateResult > 0) {
			insertFourInsuranceDeductResult  = mngHumanResourceMapper.insertFourInsuranceDeduct(mngHumanResourceDTO, companyNo);						//FourInsuranceDeduct 테이블 인서트
			int deductDivNo = mngHumanResourceMapper.selectFourInsuranceDeduct(mngHumanResourceDTO, companyNo);											//FourInsuranceDeduct 테이블 조회
			insertEmpUpdateResult  = mngHumanResourceMapper.insertFourInsHistory(mngHumanResourceDTO, companyNo, deductDivNo);							//FourInsHistory 테이블 인서트
		}
		
		return insertEmpUpdateResult;
	}


	@Override
	public List<SalaryStepDTO> selectSalaryStep(int companyNo) {										//salaryStep 조회
		return mngHumanResourceMapper.selectSalaryStep(companyNo);
	}

	@Override
	public List<JobDTO> selectJobList(int companyNo) {													//JobList 조회
		return mngHumanResourceMapper.selectJobList(companyNo);
	}

	@Override
	public List<MemberListDTO> selectMemberList(int companyNo) {										//memberList 조회
		return mngHumanResourceMapper.selectMemberList(companyNo);
	}

	@Override
	public List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo) {					//memberHistoryList 조회
		return  mngHumanResourceMapper.selectMemberHistoryList(companyNo, idNo);
	}

	@Override
	public MngHumanResourceDTO selectMemberDetailList(int companyNo, int idNo) {						//memberDetailList 조회
		return mngHumanResourceMapper.selectMemberDetailList(companyNo, idNo);
	}

	@Override
	public MngHumanResourceDTO selectmemberHistoryDetailList(int companyNo, int idNo) {					//memberHistoryDetailList 조회
		MngHumanResourceDTO resultMemberHistoryDetailList= mngHumanResourceMapper.selectmemberHistoryDetailList(companyNo, idNo);
		return resultMemberHistoryDetailList;
	}

	@Override
	public int memberDetailUpdate(int companyNo, MngHumanResourceDTO mngHumanResourceDTO, int idNo) {
		
		int empUpdateResult = 0;
		int miltaryResult = 0;
		int veteranResult = 0;
		int appointmentResult = 0;
		int graduatedResult = 0;
		int careerResult = 0;
		int familyResult = 0;
		int familyNo = 0;
		int familyUpdateResult = 0;
		int salaryStepByRank = 0;
		int salaryStepResult = 0;
		int salaryStepNo = 0;
		int salaryStepUpdateResult = 0;
		
		int empResult = mngHumanResourceMapper.updateEmp(companyNo, idNo, mngHumanResourceDTO);												//TBL_EMPLOYEE 테이블 업데이트		
		if (empResult > 0) {
		    empUpdateResult = mngHumanResourceMapper.updateEmpUpdate(companyNo, idNo, mngHumanResourceDTO);									//TBL_EMPLOYEEUpdate 테이블 업데이트
		}
		if (empUpdateResult > 0) {
			 miltaryResult = mngHumanResourceMapper.updateMilitary(companyNo, idNo, mngHumanResourceDTO);									//Military 테이블 업데이트
		}
		if (miltaryResult > 0) {
			veteranResult = mngHumanResourceMapper.updateVeteran(companyNo, idNo, mngHumanResourceDTO);										//Veteran 테이블 업데이트
		}
		if (veteranResult > 0) {
			appointmentResult = mngHumanResourceMapper.updateAppointment(companyNo, idNo, mngHumanResourceDTO);								//Appointment 테이블 업데이트
		}
		if (appointmentResult > 0) {
			graduatedResult = mngHumanResourceMapper.updateGraduated(companyNo, idNo, mngHumanResourceDTO);									//Graduated 테이블 업데이트
		}
		if (graduatedResult > 0) {
			careerResult = mngHumanResourceMapper.updateCareer(companyNo, idNo, mngHumanResourceDTO);										//Career 테이블 업데이트
		}
		if (careerResult > 0) {
			familyResult = mngHumanResourceMapper.updateFamily(companyNo, idNo, mngHumanResourceDTO);										//Family 테이블 업데이트
			familyNo = mngHumanResourceMapper.selectFamilyNo(companyNo, idNo);																//Family 테이블 조회
			familyUpdateResult = mngHumanResourceMapper.updateFamilyUpdate(companyNo, idNo, mngHumanResourceDTO,familyNo);					//FamilyUpdate 테이블 업데이트
		}
		if (familyUpdateResult > 0) {
			salaryStepByRank = mngHumanResourceMapper.selectSalaryStepByRank(companyNo, idNo);												//SalaryStepByRank 테이블 조회
			salaryStepResult = mngHumanResourceMapper.updateSalaryStep(companyNo, idNo, mngHumanResourceDTO, salaryStepByRank);				//SalaryStep 테이블 업데이트
			salaryStepNo = mngHumanResourceMapper.selectSalaryStepNo(companyNo, idNo);														//SalaryStep 테이블 조회
			salaryStepUpdateResult = mngHumanResourceMapper.updateSalaryStepUpdate(companyNo, idNo, salaryStepByRank, salaryStepNo);		//SalaryStepUpdate 테이블 업데이트
		}
		return salaryStepUpdateResult;
	
	}

	@Override
	public MngHumanResourceDTO selectMemberRankList(int companyNo, int idNo ,MngHumanResourceDTO mngHumanResourceDTO) {						//MemberRankList 조회
		
		int salaryStepByRank = mngHumanResourceMapper.selectSalaryStepByRank(companyNo, idNo);
		
		return mngHumanResourceMapper.selectMemberRankList(companyNo, idNo, mngHumanResourceDTO, salaryStepByRank);
	}

	@Override
	public int memberIdNo(int companyNo, MngHumanResourceDTO mngHumanResourceDTO) {															//MemberIdNo 조회
		
		int resultMemberIdNo = mngHumanResourceMapper.selectMemberIdNo(companyNo, mngHumanResourceDTO);
		return resultMemberIdNo;
	}




}
