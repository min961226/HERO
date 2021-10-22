package com.nextLevel.hero.humanResource.model.service;

import com.nextLevel.hero.humanResource.model.dto.MyPageDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;

public interface HumanResourceService {

	int selectMemberNo(int companyNo, int idNo);

	int selectjobNo(int companyNo, int idNo);

	MyPageDTO selectMypage(int companyNo, int idNo, int memberNo, int jobNo);

	int updateMyPage(int companyNo, int idNo, MyPageDTO myPageDTO);

	int updateEmp(int companyNo, int idNo, MyPageDTO myPageDTO);

	int updatePassword(int companyNo, FindPwdDTO findPwdDTO);
}
