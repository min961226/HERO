package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationDTO;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;

public interface MngVacationService {

	/* 휴일 조회 */
	List<MngHolidayDTO> listHoliday(int companyNo);

	/* 휴일 신규추가 */
	int insertPublicHoliday(MngHolidayDTO mngHolidayDTO);

	/* 휴일 삭제 */
	int holidayDelete(int companyNo, int holidayNo);

	/* 인사관리자가 직원의 연차 조회 */
	List<AnnualVacationDTO> listAnnualVacation(int companyNo);

	/* 연차 지급 */
	int updateAnnualVacationDate(String idNo, String selectedVacationType);

	/* 직원 휴가 */
	List<EmployeeVacationDTO> selectVacationList(int companyNo);

	/* 직원 휴가 신청 승인 */
	int confirmVacationY(String requestNo);

	/* 직원 휴가 신청 반려 */
	int confirmVacationN(String requestNo);

	/* 연차 일괄조정 */
	List<AnnualVacationControlDTO> listAnnualVacationControl();

	/* 연차 일괄조정 수정 */
	int updateControl(@Param("map") Map<String, String> map);

}
