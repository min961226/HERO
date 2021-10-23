package com.nextLevel.hero.mnghumanResource.model.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;

public interface MngHumanResourceService {


	List<SalaryStepDTO> selectSalaryStep(int companyNo);

	List<JobDTO> selectJobList(int companyNo);

	List<MemberListDTO> selectMemberList(int companyNo);

	int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo);

	List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo);


	MngHumanResourceDTO selectMemberDetailList(int companyNo, int idNo);

	MngHumanResourceDTO selectmemberHistoryDetailList(int companyNo, int idNo);

	int memberDetailUpdate(int companyNo, MngHumanResourceDTO mngHumanResourceDTO, int idNo);

	MngHumanResourceDTO selectMemberRankList(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);

	int memberIdNo(int companyNo, MngHumanResourceDTO mngHumanResourceDTO);

}
