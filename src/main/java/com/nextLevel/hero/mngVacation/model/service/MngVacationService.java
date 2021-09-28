package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;

import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;

public interface MngVacationService {

	List<MngHolidayDTO> listHoliday(int companyNo);

	// 연차 & 직원휴가 & 연차일괄조정
	
}


