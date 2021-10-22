package com.nextLevel.hero.mngRole.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.mngRole.model.dao.MngRoleMapper;
import com.nextLevel.hero.mngRole.model.dto.MngRankAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRankSalaryDTO;
import com.nextLevel.hero.mngRole.model.dto.MngRoleDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserAuthDTO;
import com.nextLevel.hero.mngRole.model.dto.MngUserDTO;

@Service("mngRoleService")
public class MngRoleServiceImpl implements MngRoleService {

	private final MngRoleMapper mngRoleMapper;
	
	@Autowired
	public MngRoleServiceImpl(MngRoleMapper mngRoleMapper) {
		this.mngRoleMapper = mngRoleMapper;
	}
	
	/* 사원수 조회 */
	@Override
	public int selectMemberCount(int companyNo, Map searchMap) {
		
		return mngRoleMapper.selectMemberCount(searchMap, companyNo);
	}
	
	/* 직급 조회 */
	@Override
	public List<MngRoleDTO> selectRank(int companyNO) {
		
		return mngRoleMapper.selectRank(companyNO);
	}
	
	/* 직급 권한 ajax 조회 */
	@Override
	public List<MngRankAuthDTO> selectRankAuth(int companyNo, String rank) {
		
		List<MngRankAuthDTO> rankAuth = mngRoleMapper.selectRankAuth(companyNo, rank);
		
		rankAuth.addAll(mngRoleMapper.selectAuthority(rankAuth.get(0).getSalaryStepByRank(), companyNo));
		
		return rankAuth;
	}
	
	/* 직급 권한 보유 생성 */
	@Override
	@Transactional
	public int updateRoleAuth(MngRankSalaryDTO mngRankSalaryDTO) {
		
		return mngRoleMapper.updateRoleAuth(mngRankSalaryDTO);
	}
	
	/* 직급 권한 수정 */
	@Override
	@Transactional
	public int selectStepByRank(MngRankAuthDTO mngRankAuthDTO) {
		
		/* 해당 직급 번호 list 조회*/
		mngRankAuthDTO.setSalaryStepByRankArg(mngRoleMapper.selectStepByRank(mngRankAuthDTO));
		
		/* insert전 delete*/
		int result = mngRoleMapper.deleteRankAuth(mngRankAuthDTO);
		/* 직급 권한 insert */
		if(mngRankAuthDTO.getAuthoryityNoArg() != null) {
			
		for(int i=0; i < mngRankAuthDTO.getAuthoryityNoArg().size(); i++) {
			
			mngRankAuthDTO.setAuthoryityNo(mngRankAuthDTO.getAuthoryityNoArg().get(i).getAuthoryityNo());
			
			if(mngRankAuthDTO.getAuthoryityNo() != 0) {
				
				result = mngRoleMapper.insertRankAuth(mngRankAuthDTO);
			}
				
			}
		}

		if(result < 2) {
			result = 0;
		} else if(result > 2) {
			result = 1;
		}
		return result;
	}

	/* 사용자별 권한 */
	@Override
	public List<MngUserDTO> selectUser(int companyNo, Map searchMap, SelectCriteria selectCriteria) {
		
		return mngRoleMapper.selectUser(companyNo, searchMap, selectCriteria);
	}

	/* 사원 권한 ajax 조회 */
	@Override
	public List<MngUserAuthDTO> selectUserAuth(String userName, String memberNo, int companyNo) {
		
		List<MngUserAuthDTO> userAuth =  mngRoleMapper.selectUserAuth(userName, memberNo, companyNo);
		
		userAuth.addAll(mngRoleMapper.selectUserAuthority(userAuth.get(0).getIdNo()));
		
		return userAuth;
	}
	
	/* 사원 권한 생성 */
	@Override
	@Transactional
	public int updateUserRoleAuth(MngUserAuthDTO mngUserAuthDTO) {
		
		return mngRoleMapper.updateUserRoleAuth(mngUserAuthDTO);
	}
	
	/* 사원 권한 수정 */ 
	@Override
	@Transactional
	public int insertUserAuth(MngUserAuthDTO mngUserAuthDTO) {
		
		/* insert전 delete*/
		int result = mngRoleMapper.deleteUserAuth(mngUserAuthDTO);
		/* 사원 권한 수정 */
		if(mngUserAuthDTO.getAuthoryityNoArg() != null) {
			result += mngRoleMapper.insertUserAuth(mngUserAuthDTO);
		}
		
		if(result < 2) {
			result = 0;
		} 
		
		return result;
	}


}
