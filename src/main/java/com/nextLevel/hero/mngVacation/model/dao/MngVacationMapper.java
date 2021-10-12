package com.nextLevel.hero.mngVacation.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;

@Mapper
public interface MngVacationMapper {

	/* 휴일 조회 */
	List<MngHolidayDTO> listHoliday(int companyNo);
	
	/* 휴일 생성 */
	int insertPublicHoliday(MngHolidayDTO mngHolidayDTO);

	/* 휴일 삭제 */
	int holidayDelete(int companyNo, int holidayNo);

	/* 연차일괄조정표 조회 */
	List<AnnualVacationControlDTO> annualList(int vacationCode);



}
