package com.nextLevel.hero.humanResource.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.humanResource.model.dao.HumanResourceMapper;
import com.nextLevel.hero.humanResource.model.dto.MyPageDTO;

@Service("humanResourceService")
public class HumanResourceServiceImpl implements HumanResourceService {

	 private final HumanResourceMapper humanResourceMapper;
	   
	   @Autowired
	   public HumanResourceServiceImpl(HumanResourceMapper humanResourceMapper) {
	      this.humanResourceMapper = humanResourceMapper;
	   }




	@Override
	public int selectMemberNo(int companyNo, int idNo) {
		int memberNo = humanResourceMapper.selectMemberNo(companyNo, idNo);
		return humanResourceMapper.selectMemberNo(companyNo, idNo);
	}

	@Override
	public int selectjobNo(int companyNo, int idNo) {
		int jobNo = humanResourceMapper.selectjobNo(companyNo, idNo);
		return humanResourceMapper.selectjobNo(companyNo, idNo);
	}
	
	@Override
	public MyPageDTO selectMypage(int companyNo, int idNo, int memberNo, int jobNo) {
		MyPageDTO MypageList = humanResourceMapper.selectMypage(companyNo,idNo,memberNo,jobNo);
		return humanResourceMapper.selectMypage(companyNo,idNo,memberNo,jobNo);
	}


	@Override
	public int updateEmp(int companyNo, int idNo, MyPageDTO myPageDTO) {
		int EmpResult = humanResourceMapper.updateEmp(companyNo, idNo, myPageDTO);
		return humanResourceMapper.updateEmp(companyNo, idNo, myPageDTO);
	}


	@Override
	public int updateMyPage(int companyNo, int idNo, MyPageDTO myPageDTO) {
		int MypageResult = humanResourceMapper.updateMypage(companyNo, idNo, myPageDTO);
		return humanResourceMapper.updateMypage(companyNo, idNo, myPageDTO);
	}




}
