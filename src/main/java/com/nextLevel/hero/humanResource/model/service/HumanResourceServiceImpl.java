package com.nextLevel.hero.humanResource.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.humanResource.model.dao.HumanResourceMapper;
import com.nextLevel.hero.humanResource.model.dto.MyPageDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;

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
		return memberNo;
	}

	@Override
	public int selectjobNo(int companyNo, int idNo) {
		int jobNo = humanResourceMapper.selectjobNo(companyNo, idNo);
		return jobNo;
	}
	
	@Override
	public MyPageDTO selectMypage(int companyNo, int idNo, int memberNo, int jobNo) {
		MyPageDTO MypageList = humanResourceMapper.selectMypage(companyNo,idNo,memberNo,jobNo);
		return MypageList;
	}


	@Override
	public int updateEmp(int companyNo, int idNo, MyPageDTO myPageDTO) {
		int EmpResult = humanResourceMapper.updateEmp(companyNo, idNo, myPageDTO);
		return EmpResult;
	}


	@Override
	public int updateMyPage(int companyNo, int idNo, MyPageDTO myPageDTO) {
		int MypageResult = humanResourceMapper.updateMypage(companyNo, idNo, myPageDTO);
		return MypageResult;
	}




	@Override
	public int updatePassword(int companyNo, FindPwdDTO findPwdDTO) {
		int updatePasswordResult = humanResourceMapper.updatePassword( companyNo, findPwdDTO);
		return updatePasswordResult;
	}








}
