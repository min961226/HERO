package com.nextLevel.hero.SYSTEM.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.SYSTEM.model.dao.SystemManagerMapper;
import com.nextLevel.hero.SYSTEM.model.dto.NewMemberDTO;

@Service("systemManagerService")
public class SystemManagerServiceImpl implements SystemManagerService{

	private final SystemManagerMapper systemManagerMapper; 
	
	@Autowired
	public SystemManagerServiceImpl(SystemManagerMapper systemManagerMapper) {
		this.systemManagerMapper = systemManagerMapper;
	}

	@Override
	public List<String> selectMemberIdList() {
		return systemManagerMapper.selectMemberIdList();
	}

	@Override
	@Transactional
	public int insertNewMember(NewMemberDTO newMemberDTO) {
		
		/* 구매자 정보 기입 */
		int result1 = systemManagerMapper.insertControlClient(newMemberDTO);
		/* 새로 생성된 companyNo 값 가져옴 */
		int companyNo = systemManagerMapper.selectLastCompanyNo();
		/* 새로운 id값으로 멤버 생성 */
		int result2 = systemManagerMapper.insertNewMember(newMemberDTO);
		/* 생성된 id_no 값을 회사와 이어야 하므로 가져옴 */
		int idNo = systemManagerMapper.selectLastIdNo();
		/* id_no와 company_no로 테이블에 삽입 */
		int result3 = systemManagerMapper.insertMemberCompany(companyNo,idNo);
		/* 초기세팅을 위한 권한 테이블에 삽입 */
		int result4 = systemManagerMapper.insertMemberAuth(idNo);
		if(result1 + result2 + result3 + result4 > 3) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public List<NewMemberDTO> selectControlClientList() {
		return systemManagerMapper.selectControlClientList();
	}
	
}
