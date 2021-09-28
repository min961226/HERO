package com.nextLevel.hero.mngRole.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.mngRole.model.dao.MngRoleMapper;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;

@Service("mngRoleService")
public class MngRoleServiceImpl implements MngRoleService {

	private final MngRoleMapper mngRoleMapper;
	
	@Autowired
	public MngRoleServiceImpl(MngRoleMapper mngRoleMapper) {
		this.mngRoleMapper = mngRoleMapper;
	}

	@Override
	public List<MngRoleDTO> selectRank(int companyNO) {
		
		return mngRoleMapper.selectRank(companyNO);
	}

	@Override
	public List<MngRankSalaryDTO> selectRankAuth(int companyNo, String rank) {

		return mngRoleMapper.selectRankAuth(companyNo, rank);
	}

	@Override
	@Transactional
	public void updateRoleAuth(MngRankSalaryDTO mngRankSalaryDTO) {
		
		mngRoleMapper.updateRoleAuth(mngRankSalaryDTO);

	}



	
}
