package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;

import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;

public interface MngVacationService {

	List<MngHolidayDTO> listHoliday(int companyNo);

}


