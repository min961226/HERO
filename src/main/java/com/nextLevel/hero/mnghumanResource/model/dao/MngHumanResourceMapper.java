package com.nextLevel.hero.mnghumanResource.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;

@Mapper
public interface MngHumanResourceMapper {

	int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertEmployee(MngHumanResourceDTO humanResourceDTO, int companyNo);

	int insertMemberCompany(int newMemberNo, int companyNo);

	int selectNewMemberNumber();

	List<SalaryStepDTO> selectSalaryStep(int companyNo);

	List<JobDTO> selectJobList(int companyNo);

	int insertMilitary(int newMemberNo, int companyNo);

	String selectIdCheck(String memberId, int companyNo);

	List<MemberListDTO> selectMemberList(int companyNo);


}
