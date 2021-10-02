package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;

import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;

public interface MngVacationService {

	List<MngHolidayDTO> listHoliday(int companyNo);

	int insertPublicHoliday(MngHolidayDTO mngHolidayDTO);

	/*
	 * 휴일 insert List<MngHolidayDTO> insertPublicHoliday(int companyNo1);
	 */

	/*
	 * 휴일 insert public int holidayModalInsert(MngHolidayDTO mngHolidayDTO);
	 */

	// 연차 & 직원휴가 & 연차일괄조정

}
