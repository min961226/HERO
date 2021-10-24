package com.nextLevel.hero.mnghumanResource.model.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.nextLevel.hero.mnghumanResource.model.dto.JobDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MemberListDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;
import com.nextLevel.hero.mnghumanResource.model.dto.SalaryStepDTO;

public interface MngHumanResourceService {

	List<MngHumanResourceDTO> selectMemberHistoryList(int companyNo, int idNo);												//직원 수정된 리스트 조회한다.

	List<SalaryStepDTO> selectSalaryStep(int companyNo);																	//직급별 호봉을 조회한다.

	List<JobDTO> selectJobList(int companyNo);																				//직책 리스트를 조회한다.

	List<MemberListDTO> selectMemberList(int companyNo);																	//사원 정보 리스트를 조회한다.

	int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo);													//사원 정보를 입력한다.

	MngHumanResourceDTO selectMemberDetailList(int companyNo, int idNo);													//사원 상세정보를 조회한다.

	MngHumanResourceDTO selectmemberHistoryDetailList(int companyNo, int idNo);												//사원 수정된 정보를 상세조회한다.

	int memberDetailUpdate(int companyNo, MngHumanResourceDTO mngHumanResourceDTO, int idNo);								//사원 상세정보를 수정한다.

	MngHumanResourceDTO selectMemberRankList(int companyNo, int idNo, MngHumanResourceDTO mngHumanResourceDTO);				//사원 호봉 리스트를 조회한다.

	int memberIdNo(int companyNo, MngHumanResourceDTO mngHumanResourceDTO);													//사원 idNo를 조회한다.

}
