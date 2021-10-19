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
	public int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo, ModelAndView mv) {
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
		
		
		int insertMemberResult = mngHumanResourceMapper.insertMember(humanResourceDTO, companyNo);           		//Member 테이블 인서트
		int idNo = 0;
		if (insertMemberResult > 0 ) {
			
			idNo = mngHumanResourceMapper.selectNewMemberNumber();											//맴버 번호(사번)를 조회
			humanResourceDTO.setIdNo(idNo);
			System.out.println("idNo : " + idNo);
			insertEmployeeResult = mngHumanResourceMapper.insertEmployee(humanResourceDTO, companyNo);				//Employee테이블 인서트
		}
		if (insertEmployeeResult > 0 ) {
			insertMemberCompanyResult = mngHumanResourceMapper.insertMemberCompany(humanResourceDTO, companyNo);			//MemberCompany테이블 인서트
		} if (insertMemberCompanyResult > 0) {
			insertMilitaryResult  = mngHumanResourceMapper.insertMilitary(humanResourceDTO, companyNo);					//Military테이블 인서트
		} if (insertMilitaryResult > 0) {
			insertVeteranResult  = mngHumanResourceMapper.insertVeteran(humanResourceDTO, companyNo);	
		} if (insertVeteranResult > 0) {
			insertAppointmentResult  = mngHumanResourceMapper.insertAppointment(humanResourceDTO, companyNo);	
		} if (insertAppointmentResult > 0) {
			insertGraduatedResult  = mngHumanResourceMapper.insertGraduated(humanResourceDTO, companyNo);	
		} if (insertGraduatedResult > 0) {
			insertCareerResult  = mngHumanResourceMapper.insertCareer(humanResourceDTO, companyNo);	
		} if (insertCareerResult > 0) {
			insertFamilyResult  = mngHumanResourceMapper.insertFamily(humanResourceDTO, companyNo);	
		} if (insertFamilyResult > 0) {
			insertUserAuthResult  = mngHumanResourceMapper.insertUserAuth(humanResourceDTO, companyNo);	
		} if (insertUserAuthResult > 0) {
			selectVacationControlResult  = mngHumanResourceMapper.selectVacationControl();
			System.out.print("selectVacationControlResult : " + selectVacationControlResult);

			int vacationCode = vacationControlDTO.getVacationCode();
			int vacationDays = vacationControlDTO.getVacationDays();

			System.out.print("vacationCode : " + vacationCode);
			System.out.print("vacationDays : " + vacationDays);
	
			insertVacationControlResult = mngHumanResourceMapper.insertVacation(humanResourceDTO, companyNo, vacationCode, vacationDays);	
		 
		}if (insertVacationControlResult > 0) {
			selectFamilyUpdateResult = mngHumanResourceMapper.selectFamilyUpdate(humanResourceDTO, companyNo);
			int familyNo = selectFamilyUpdateResult;
			insertFamilyUpdateResult = mngHumanResourceMapper.insertFamilyUpdate(humanResourceDTO, companyNo, familyNo);	
		} 
		if (insertFamilyUpdateResult > 0) {
			int salaryStepByRank = humanResourceDTO.getSalaryStepByRank();
			selectRankSalaryStepResult = mngHumanResourceMapper.selectRankSalaryStep(companyNo, salaryStepByRank);
			System.out.print("selectRankSalaryStepResult : " + selectRankSalaryStepResult);
			startDate = selectRankSalaryStepResult;
			System.out.print("startDate : " + startDate);
			insertEmpSalaryStepResult  = mngHumanResourceMapper.insertEmpSalaryStep(humanResourceDTO, companyNo, startDate);	
		} if (insertEmpSalaryStepResult > 0) {
			selectEmpSalaryStepResult = mngHumanResourceMapper.selectEmpSalaryStep(humanResourceDTO ,companyNo);
			int divNo = selectEmpSalaryStepResult;
			System.out.print("startDate2 : " + startDate);
			insertEmpSalaryStepUpdateResult  = mngHumanResourceMapper.insertEmpSalaryStepUpdate(humanResourceDTO, companyNo, startDate, divNo);	
		} if (insertEmpSalaryStepUpdateResult > 0) {
			insertFourInsuranceDeductResult  = mngHumanResourceMapper.insertFourInsuranceDeduct(humanResourceDTO, companyNo);	
		} if (insertFourInsuranceDeductResult > 0) {
			insertEmpUpdateResult  = mngHumanResourceMapper.insertEmpUpdate(humanResourceDTO, companyNo);	
		}
		
		return insertEmpUpdateResult;
	}


	@Override
	public List<SalaryStepDTO> selectSalaryStep(int companyNo) {
		return mngHumanResourceMapper.selectSalaryStep(companyNo);
	}


	@Override
	public List<JobDTO> selectJobList(int companyNo) {
		return mngHumanResourceMapper.selectJobList(companyNo);
	}


	@Override
	public List<MemberListDTO> selectMemberList(int companyNo) {
		return mngHumanResourceMapper.selectMemberList(companyNo);
	}


	@Override
	public List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo) {
		return  mngHumanResourceMapper.selectMemberHistoryList(companyNo, idNo);
	}




}
