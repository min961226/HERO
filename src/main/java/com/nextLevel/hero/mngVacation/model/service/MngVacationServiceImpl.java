package com.nextLevel.hero.mngVacation.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.mngVacation.model.dao.MngVacationMapper;
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationControlDTO;
import com.nextLevel.hero.mngVacation.model.dto.AnnualVacationDTO;
import com.nextLevel.hero.mngVacation.model.dto.MngHolidayDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;

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

	/* 휴일 생성 */
	@Override
	@Transactional
	public int insertPublicHoliday(MngHolidayDTO mngHolidayDTO) {
		
		return mngVacationMapper.insertPublicHoliday(mngHolidayDTO);
	}
	
	/* 휴일 삭제 */
	@Override
	@Transactional
	public int holidayDelete(int companyNo, int holidayNo) {
		
		return mngVacationMapper.holidayDelete(companyNo, holidayNo);
	}

	/* 인사관리자가 직원의 연차 조회 */
	@Override
	public List<AnnualVacationDTO> listAnnualVacation(int companyNo) {
		
		return mngVacationMapper.listAnnualVacation(companyNo);
	}

	/* 연차 지급 */
	@Override
	@Transactional
	public int updateAnnualVacationDate(String idNo, String selectedVacationType) {
		
		return mngVacationMapper.updateAnnualVacationDate(idNo,selectedVacationType);
	}

	/* 직원 휴가 */
	@Override
	public List<EmployeeVacationDTO> selectVacationList(int companyNo) {
		
		return mngVacationMapper.selectVacationList(companyNo);
	}

	/* 직원 휴가 신청 승인 */
	@Override
	@Transactional
	public int confirmVacationY(String requestNo) {
		
		return mngVacationMapper.confirmVacationY(requestNo);
	}

	/* 직원 휴가 신청 반려 */
	@Override
	public int confirmVacationN(String requestNo) {
		
		return mngVacationMapper.confirmVacationN(requestNo);
	}

	/* 연차 일괄조정 */
	@Override
	public List<AnnualVacationControlDTO> listAnnualVacationControl() {
		
		return mngVacationMapper.listAnnualVacationControl();
	}

	/* 연차 일괄조정 수정 */
	@Override
	public int updateControl(Map<String, String> map) {
		
//		List<Map<String, String>> list = mngVacationMapper.listAnnualVacationControl(map);
		
		
		return mngVacationMapper.updateControl(map);
	}

}
