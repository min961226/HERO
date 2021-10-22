package com.nextLevel.hero.mngVacation.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationDTO;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;

@Mapper
public interface MngVacationMapper {

	/* 휴일 조회 */
	List<MngHolidayDTO> listHoliday(int companyNo);
	
	/* 휴일 생성 */
	int insertPublicHoliday(MngHolidayDTO mngHolidayDTO);

	/* 휴일 삭제 */
	int holidayDelete(int companyNo, int holidayNo);

	/* 인사관리자가 직원의 연차 조회 */
	List<AnnualVacationDTO> listAnnualVacation(int companyNo);

	/* 연차 지급 */
	int updateAnnualVacationDate(String idNo, String selectedVacationType);

	/* 직원 휴가 */
	List<EmployeeVacationDTO> selectVacationList(int companyNo);
	
	/* 직원 휴가 신청에 대한 승인 */
	int confirmVacationY(String requestNo);

	/* 직원 휴가 신청에 대한 반려*/
	int confirmVacationN(String requestNo);

	/* 일괄 조정 연차 조회 */
	List<AnnualVacationControlDTO> listAnnualVacationControl();

	/* 일괄 조정 연차 수정 */
	int updateControl(Map<String, String> map);

//	List<Map<String, String>> listAnnualVacationControl(Map<String, String> map);

}
