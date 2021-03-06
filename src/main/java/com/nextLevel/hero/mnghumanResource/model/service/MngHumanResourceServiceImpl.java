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
		
		
		int insertMemberResult = mngHumanResourceMapper.insertMember(mngHumanResourceDTO, companyNo);           					//Member(??????) ????????? ?????????
		int idNo = 0;
		if (insertMemberResult > 0 ) {
			
			idNo = mngHumanResourceMapper.selectNewMemberNumber();																	//?????? ??????(??????)??? ??????
			mngHumanResourceDTO.setIdNo(idNo);
			insertEmployeeResult = mngHumanResourceMapper.insertEmployee(mngHumanResourceDTO, companyNo);							//Employee(??????)????????? ?????????
			insertEmpUpdateResult  = mngHumanResourceMapper.insertEmpUpdate(mngHumanResourceDTO, companyNo);						//EmployeeUpdate(??????)????????? ?????????
		}
		if (insertEmployeeResult > 0 ) {
			insertMemberCompanyResult = mngHumanResourceMapper.insertMemberCompany(mngHumanResourceDTO, companyNo);					//MemberCompany????????? ?????????
		} if (insertMemberCompanyResult > 0) {
			insertMilitaryResult  = mngHumanResourceMapper.insertMilitary(mngHumanResourceDTO, companyNo);							//MILITARY_SERVICE ????????? ?????????
		} if (insertMilitaryResult > 0) {
			insertVeteranResult  = mngHumanResourceMapper.insertVeteran(mngHumanResourceDTO, companyNo);							//Veteran ????????? ?????????
		} if (insertVeteranResult > 0) {
			insertAppointmentResult  = mngHumanResourceMapper.insertAppointment(mngHumanResourceDTO, companyNo);					//Appointment ????????? ?????????
		} if (insertAppointmentResult > 0) {
			insertGraduatedResult  = mngHumanResourceMapper.insertGraduated(mngHumanResourceDTO, companyNo);	                    //Graduated ????????? ?????????
		} if (insertGraduatedResult > 0) {
			insertCareerResult  = mngHumanResourceMapper.insertCareer(mngHumanResourceDTO, companyNo);								//Career ????????? ?????????
		} if (insertCareerResult > 0) {
			insertFamilyResult  = mngHumanResourceMapper.insertFamily(mngHumanResourceDTO, companyNo);								//Family ????????? ?????????
			selectFamilyUpdateResult = mngHumanResourceMapper.selectFamilyUpdate(mngHumanResourceDTO, companyNo);					//FamilyUpdate????????? ??????
			int familyNo = selectFamilyUpdateResult;																				//familyNo ??????
			insertFamilyUpdateResult = mngHumanResourceMapper.insertFamilyUpdate(mngHumanResourceDTO, companyNo, familyNo);			//FamilyUpdate????????? ?????????
		} if (insertFamilyResult > 0) {
			insertUserAuthResult  = mngHumanResourceMapper.insertUserAuth(mngHumanResourceDTO, companyNo);							//UserAuth ???????????? ?????????
		} if (insertUserAuthResult > 0) {
			selectVacationControlResult  = mngHumanResourceMapper.selectVacationControl();											//VacationControl ????????? ??????		

			int vacationCode = vacationControlDTO.getVacationCode();																
			int vacationDays = vacationControlDTO.getVacationDays();

			insertVacationControlResult = mngHumanResourceMapper.insertVacation(mngHumanResourceDTO, companyNo, vacationCode, vacationDays);	//Vacation ???????????? ?????????
		 
		}if (insertVacationControlResult > 0) {
		
			selectRankSalaryStepResult = mngHumanResourceMapper.selectRankSalaryStep(companyNo,  mngHumanResourceDTO);									//RankSalaryStep ????????? startDate ??????
			startDate = selectRankSalaryStepResult;
			selectRankResult = mngHumanResourceMapper.selectRank(companyNo, mngHumanResourceDTO);														//RankSalaryStep ????????? ??????
			mngHumanResourceDTO.setSalaryStepByRank(selectRankResult.getSalaryStepByRank());															
			insertEmpSalaryStepResult  = mngHumanResourceMapper.insertEmpSalaryStep(mngHumanResourceDTO, companyNo, startDate );						//EmpSalaryStep ???????????? ?????????
			selectEmpSalaryStepResult = mngHumanResourceMapper.selectEmpSalaryStep(mngHumanResourceDTO ,companyNo);										//EmpSalaryStep ???????????? ??????	
			int divNo = selectEmpSalaryStepResult;
			insertEmpSalaryStepUpdateResult  = mngHumanResourceMapper.insertEmpSalaryStepUpdate(mngHumanResourceDTO, companyNo, startDate, divNo);		//EmpSalaryStepUpdate ???????????? ?????????
		} 
		 if (insertEmpSalaryStepUpdateResult > 0) {
			insertFourInsuranceDeductResult  = mngHumanResourceMapper.insertFourInsuranceDeduct(mngHumanResourceDTO, companyNo);						//FourInsuranceDeduct ????????? ?????????
			int deductDivNo = mngHumanResourceMapper.selectFourInsuranceDeduct(mngHumanResourceDTO, companyNo);											//FourInsuranceDeduct ????????? ??????
			insertEmpUpdateResult  = mngHumanResourceMapper.insertFourInsHistory(mngHumanResourceDTO, companyNo, deductDivNo);							//FourInsHistory ????????? ?????????
		}
		
		return insertEmpUpdateResult;
	}


	@Override
	public List<SalaryStepDTO> selectSalaryStep(int companyNo) {										//salaryStep ??????
		return mngHumanResourceMapper.selectSalaryStep(companyNo);
	}

	@Override
	public List<JobDTO> selectJobList(int companyNo) {													//JobList ??????
		return mngHumanResourceMapper.selectJobList(companyNo);
	}

	@Override
	public List<MemberListDTO> selectMemberList(int companyNo) {										//memberList ??????
		return mngHumanResourceMapper.selectMemberList(companyNo);
	}

	@Override
	public List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo) {					//memberHistoryList ??????
		return  mngHumanResourceMapper.selectMemberHistoryList(companyNo, idNo);
	}

	@Override
	public MngHumanResourceDTO selectMemberDetailList(int companyNo, int idNo) {						//memberDetailList ??????
		return mngHumanResourceMapper.selectMemberDetailList(companyNo, idNo);
	}

	@Override
	public MngHumanResourceDTO selectmemberHistoryDetailList(int companyNo, int idNo) {					//memberHistoryDetailList ??????
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
		
		int empResult = mngHumanResourceMapper.updateEmp(companyNo, idNo, mngHumanResourceDTO);												//TBL_EMPLOYEE ????????? ????????????		
		if (empResult > 0) {
		    empUpdateResult = mngHumanResourceMapper.updateEmpUpdate(companyNo, idNo, mngHumanResourceDTO);									//TBL_EMPLOYEEUpdate ????????? ????????????
		}
		if (empUpdateResult > 0) {
			 miltaryResult = mngHumanResourceMapper.updateMilitary(companyNo, idNo, mngHumanResourceDTO);									//Military ????????? ????????????
		}
		if (miltaryResult > 0) {
			veteranResult = mngHumanResourceMapper.updateVeteran(companyNo, idNo, mngHumanResourceDTO);										//Veteran ????????? ????????????
		}
		if (veteranResult > 0) {
			appointmentResult = mngHumanResourceMapper.updateAppointment(companyNo, idNo, mngHumanResourceDTO);								//Appointment ????????? ????????????
		}
		if (appointmentResult > 0) {
			graduatedResult = mngHumanResourceMapper.updateGraduated(companyNo, idNo, mngHumanResourceDTO);									//Graduated ????????? ????????????
		}
		if (graduatedResult > 0) {
			careerResult = mngHumanResourceMapper.updateCareer(companyNo, idNo, mngHumanResourceDTO);										//Career ????????? ????????????
		}
		if (careerResult > 0) {
			familyResult = mngHumanResourceMapper.updateFamily(companyNo, idNo, mngHumanResourceDTO);										//Family ????????? ????????????
			familyNo = mngHumanResourceMapper.selectFamilyNo(companyNo, idNo);																//Family ????????? ??????
			familyUpdateResult = mngHumanResourceMapper.updateFamilyUpdate(companyNo, idNo, mngHumanResourceDTO,familyNo);					//FamilyUpdate ????????? ????????????
		}
		if (familyUpdateResult > 0) {
			salaryStepByRank = mngHumanResourceMapper.selectSalaryStepByRank(companyNo, idNo);												//SalaryStepByRank ????????? ??????
			salaryStepResult = mngHumanResourceMapper.updateSalaryStep(companyNo, idNo, mngHumanResourceDTO, salaryStepByRank);				//SalaryStep ????????? ????????????
			salaryStepNo = mngHumanResourceMapper.selectSalaryStepNo(companyNo, idNo);														//SalaryStep ????????? ??????
			salaryStepUpdateResult = mngHumanResourceMapper.updateSalaryStepUpdate(companyNo, idNo, salaryStepByRank, salaryStepNo);		//SalaryStepUpdate ????????? ????????????
		}
		return salaryStepUpdateResult;
	
	}

	@Override
	public MngHumanResourceDTO selectMemberRankList(int companyNo, int idNo ,MngHumanResourceDTO mngHumanResourceDTO) {						//MemberRankList ??????
		
		int salaryStepByRank = mngHumanResourceMapper.selectSalaryStepByRank(companyNo, idNo);
		
		return mngHumanResourceMapper.selectMemberRankList(companyNo, idNo, mngHumanResourceDTO, salaryStepByRank);
	}

	@Override
	public int memberIdNo(int companyNo, MngHumanResourceDTO mngHumanResourceDTO) {															//MemberIdNo ??????
		
		int resultMemberIdNo = mngHumanResourceMapper.selectMemberIdNo(companyNo, mngHumanResourceDTO);
		return resultMemberIdNo;
	}




}
