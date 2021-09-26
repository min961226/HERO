package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngVacation.model.dao.MngVacationMapper;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;

@Service("mngVacationService")
public class MngVacationServiceImpl implements MngVacationService {

	private final MngVacationMapper mngVacationMapper;
	
	@Autowired
	public MngVacationServiceImpl(MngVacationMapper mngVacationMapper) {
		this.mngVacationMapper = mngVacationMapper;
	}
	
	
	
	

	/* 휴일 조회 */
	@Override
	public List<MngHolidayDTO> listHoliday(int companyNo) {
		
		return mngVacationMapper.listHoliday(companyNo);
	}
}
