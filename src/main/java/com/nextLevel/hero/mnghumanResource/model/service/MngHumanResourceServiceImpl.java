package com.nextLevel.hero.mnghumanResource.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mnghumanResource.model.dao.MngHumanResourceMapper;
import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;

@Service("mngHumanResourceService")
public class MngHumanResourceServiceImpl implements MngHumanResourceService {

	 private MngHumanResourceMapper mngHumanResourceMapper;
	   
	   @Autowired
	   public MngHumanResourceServiceImpl(MngHumanResourceMapper mngHumanResourceMapper) {
	      this.mngHumanResourceMapper = mngHumanResourceMapper;
	   }


	@Override
	public int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo) {
		int insertEmployeeResult = 0;
		int insertMemberCompanyResult = 0;
		int insertMilitaryResult = 0;
		
		int insertMemberResult = mngHumanResourceMapper.insertMember(humanResourceDTO, companyNo);
		int newMemberNo = 0;
		if (insertMemberResult > 0 ) {
			
			newMemberNo = mngHumanResourceMapper.selectNewMemberNumber();
			humanResourceDTO.setIdNo(newMemberNo);
			
			System.out.println("newMemberNo : " + newMemberNo);
			
			insertEmployeeResult = mngHumanResourceMapper.insertEmployee(humanResourceDTO, companyNo);
		
		} if (insertEmployeeResult > 0 ) {
			
			insertMemberCompanyResult = mngHumanResourceMapper.insertMemberCompany(newMemberNo, companyNo);
		} if (insertMemberCompanyResult > 0) {
			
			insertMilitaryResult  = mngHumanResourceMapper.insertMilitary(newMemberNo, companyNo);
		}
		
		
		return mngHumanResourceMapper.insertMember(humanResourceDTO, companyNo);
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
	public String selectIdCheck(String memberId, int companyNo) {
		return mngHumanResourceMapper.selectIdCheck(memberId, companyNo);
	}


	@Override
	public List<MemberListDTO> selectMemberList(int companyNo) {
		return mngHumanResourceMapper.selectMemberList(companyNo);
	}




}
