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

	@Override
	public List<AnnualVacationDTO> listAnnualVacation(int companyNo) {
		
		return mngVacationMapper.listAnnualVacation(companyNo);
	}

	@Override
	@Transactional
	public int updateAnnualVacationDate(String idNo, String selectedVacationType) {
		return mngVacationMapper.updateAnnualVacationDate(idNo,selectedVacationType);
	}

	@Override
	public List<EmployeeVacationDTO> selectVacationList(int companyNo) {
		return mngVacationMapper.selectVacationList(companyNo);
	}

	@Override
	@Transactional
	public int confirmVacationY(String requestNo) {
		
		return mngVacationMapper.confirmVacationY(requestNo);
	}

	@Override
	public int confirmVacationN(String requestNo) {
		
		return mngVacationMapper.confirmVacationN(requestNo);
	}

	@Override
	public List<AnnualVacationControlDTO> listAnnualVacationControl() {
		
		return mngVacationMapper.listAnnualVacationControl();
	}

	@Override
	public int updateControl(Map<String, String> map) {
		
//		List<Map<String, String>> list = mngVacationMapper.listAnnualVacationControl(map);
		
		
		return mngVacationMapper.updateControl(map);
	}

//	@Override
//	public List<AnnualVacationControlDTO> annualList(int vacationCode) {
//		
//		return mngVacationMapper.annualList(vacationCode);
//	}

	
	  
	  
	/*
	 * @Override public int holidayModalInsert(MngHolidayDTO mngHolidayDTO) {
	 * 
	 * return mngVacationMapper.holidayModalInsert(mngHolidayDTO); }
	 */
	 

	// 이거 다시 확인해야됌
	/*
	 * @Override public List<MngHolidayDTO> insertPublicHoliday(int companyNo1) { //
	 * TODO Auto-generated method stub
	 * 
	 * //null 말고 확인해보고 리턴값 받아오게 return null; }
	 */

	// 조회하는거 다시 만들기

}
