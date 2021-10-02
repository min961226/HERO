package com.nextLevel.hero.mngRole.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.mngRole.model.dao.MngRoleMapper;
import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserDTO;

import ch.qos.logback.core.net.SyslogOutputStream;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Service("mngRoleService")
public class MngRoleServiceImpl implements MngRoleService {

	private final MngRoleMapper mngRoleMapper;
	
	@Autowired
	public MngRoleServiceImpl(MngRoleMapper mngRoleMapper) {
		this.mngRoleMapper = mngRoleMapper;
	}
	
	/* 직급 조회 */
	@Override
	public List<MngRoleDTO> selectRank(int companyNO) {
		
		return mngRoleMapper.selectRank(companyNO);
	}
	
	/* 직급 권한 보유 조회 */
	@Override
	public List<MngRankAuthDTO> selectRankAuth(int companyNo, String rank) {
		
		List<MngRankAuthDTO> rankAuth = mngRoleMapper.selectRankAuth(companyNo, rank);
		
		rankAuth.addAll(mngRoleMapper.selectAuthority(rankAuth.get(0).getSalaryStepByRank(), companyNo));
		
		System.out.println("--------------------");
		System.out.println("--------------------");

		System.out.println("--------------------");
		System.out.println(rankAuth);
		
		return rankAuth;
	}
	
	/* 직급 권한 보유 생성 */
	@Override
	@Transactional
	public int updateRoleAuth(MngRankSalaryDTO mngRankSalaryDTO) {
		
		return mngRoleMapper.updateRoleAuth(mngRankSalaryDTO);

	}
	
	/* 해당 직급 번호 list 조회*/
	@Override
	public List<MngRankAuthDTO> selectStepByRank(MngRankAuthDTO mngRankAuthDTO) {
		
		return mngRoleMapper.selectStepByRank(mngRankAuthDTO);
	}
	
	/* insert전 보유권한 delete*/
	@Override
	@Transactional
	public int deleteRankAuth(MngRankAuthDTO mngRankAuthDTO) {
		
		return mngRoleMapper.deleteRankAuth(mngRankAuthDTO);
	}
	
	/* 직급 권한 insert */
	@Override
	@Transactional
	public int insertRankAuth(MngRankAuthDTO mngRankAuthDTO) {
		
		int result = 0;
		
		
		for(int i=0; i < mngRankAuthDTO.getAuthoryityNoArg().size(); i++) {
			
			mngRankAuthDTO.setAuthoryityNo(mngRankAuthDTO.getAuthoryityNoArg().get(i).getAuthoryityNo());
			
			if(mngRankAuthDTO.getAuthoryityNo() != 0) {
			result = mngRoleMapper.insertRankAuth(mngRankAuthDTO);
			}
		}
		
		return result;
	}

	@Override
	public List<MngUserDTO> selectUser(int companyNo) {
		
		return mngRoleMapper.selectUser(companyNo);
	}
	
	

}
