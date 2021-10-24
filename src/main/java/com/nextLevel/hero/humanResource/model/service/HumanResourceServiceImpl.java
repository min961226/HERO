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
	public int updatePassword(int companyNo, FindPwdDTO findPwdDTO) {									//비밀번호 변경
		int updatePasswordResult = humanResourceMapper.updatePassword(companyNo, findPwdDTO);
		return updatePasswordResult;
	}

	@Override
	public int selectMemberNo(int companyNo, int idNo) {												//memberNo 조회
		int memberNo = humanResourceMapper.selectMemberNo(companyNo, idNo);
		return memberNo;
	}

	@Override
	public int selectjobNo(int companyNo, int idNo) {													//jobNo 조회
		int jobNo = humanResourceMapper.selectjobNo(companyNo, idNo);
		return jobNo;
	}

	@Override
	public MyPageDTO selectMypage(int companyNo, int idNo, int memberNo, int jobNo) {					//mypage 유저 정보 조회	
		MyPageDTO MypageList = humanResourceMapper.selectMypage(companyNo, idNo, memberNo, jobNo);
		return MypageList;
	}

	@Override
	public int updateEmp(int companyNo, int idNo, MyPageDTO myPageDTO) {								//mypage 유저 정보 수정
		int EmpResult = humanResourceMapper.updateEmp(companyNo, idNo, myPageDTO);
		return EmpResult;
	}

	@Override
	public int updateMyPage(int companyNo, int idNo, MyPageDTO myPageDTO) {								//mypage 유저 정보 수정
		int MypageResult = humanResourceMapper.updateMypage(companyNo, idNo, myPageDTO);
		return MypageResult;
	}

}
