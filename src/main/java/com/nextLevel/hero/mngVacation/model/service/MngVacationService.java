package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;

import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;

public interface MngVacationService {

	List<MngHolidayDTO> listHoliday(int companyNo);

	/* 휴일 insert*/
	List<MngHolidayDTO> insertPublicHoliday(int companyNo1);

	// 연차 & 직원휴가 & 연차일괄조정
	
}


