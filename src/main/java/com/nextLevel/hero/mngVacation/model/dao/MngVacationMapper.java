package com.nextLevel.hero.mngVacation.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;

@Mapper
public interface MngVacationMapper {

	/* 휴일 조회 */
	List<MngHolidayDTO> listHoliday(int companyNo);
	
	/* 휴일 insert */
	//ㅗㅓ허ㅏㅗㅎ
	
	
	
}
