package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationDTO;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;

public interface MngVacationService {

	List<MngHolidayDTO> listHoliday(int companyNo);

	int insertPublicHoliday(MngHolidayDTO mngHolidayDTO);

	int holidayDelete(int companyNo, int holidayNo);

	List<AnnualVacationDTO> listAnnualVacation(int companyNo);

	int updateAnnualVacationDate(String idNo, String selectedVacationType);

	List<EmployeeVacationDTO> selectVacationList(int companyNo);

	int confirmVacationY(String requestNo);

	int confirmVacationN(String requestNo);

	List<AnnualVacationControlDTO> listAnnualVacationControl();

	int updateControl(@Param("map") Map<String, String> map);


//	List<AnnualVacationControlDTO> annualList(int vacationCode);

	/*
	 * 휴일 insert public int holidayModalInsert(MngHolidayDTO mngHolidayDTO);
	 */

	// 연차 & 직원휴가 & 연차일괄조정

}
