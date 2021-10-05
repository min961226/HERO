package com.nextLevel.hero.mnghumanResource.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mnghumanResource.model.dao.MngHumanResourceMapper;
import com.nextLevel.hero.mnghumanResource.model.dto.MngHumanResourceDTO;

@Service("mngHumanResourceService")
public class MngHumanResourceServiceImpl implements MngHumanResourceService {

	 private MngHumanResourceMapper mngHumanResourceMapper;
	   
	   @Autowired
	   public MngHumanResourceServiceImpl(MngHumanResourceMapper mngHumanResourceMapper) {
	      this.mngHumanResourceMapper = mngHumanResourceMapper;
	   }


	@Override
	public int insertMember(MngHumanResourceDTO humanResourceDTO, int companyNo) {
		return mngHumanResourceMapper.insertMember(humanResourceDTO, companyNo);
	}
}
