package com.nextLevel.hero.mnghumanResource.model.service;

import java.util.List;

import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;

public interface MngHumanResourceService {

	int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo);

	List<SalaryStepDTO> selectSalaryStep(int companyNo);

	List<JobDTO> selectJobList(int companyNo);

	String selectIdCheck(String memberId, int companyNo);

	List<MemberListDTO> selectMemberList(int companyNo);


}
