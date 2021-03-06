package com.nextLevel.hero.mngWorkAttitude.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.common.Pagenation;
import com.nextLevel.hero.common.SelectCriteria;
import com.nextLevel.hero.mngWorkAttitude.model.dao.MngWorkAttitudeMapper;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngAttitudeUpdateViewDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngUpdateDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkCommuteDTO;


@Service("mngWorkAttitudeService")
public class MngWorkAttitudeServiceImpl implements MngWorkAttitudeService {

	private final MngWorkAttitudeMapper mngWorkAttitudeMapper;
	
	@Autowired
	public MngWorkAttitudeServiceImpl(MngWorkAttitudeMapper mngWorkAttitudeMapper) {
		this.mngWorkAttitudeMapper = mngWorkAttitudeMapper;
	}
	
	/* 사원수 조회 */
	@Override
	public int selectMemberCount(int companyNo, Map searchMap) {
		
		return  mngWorkAttitudeMapper.selectMemberCount(searchMap, companyNo);
	}

	@Override
	public List<MngWorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo, Map searchMap, SelectCriteria selectCriteria) {
		
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
		DateTimeFormatter formatterView = DateTimeFormatter.ofPattern("yyyy/MM");
		// 포맷 적용
		String formatView = null;
		String formatedNow = null;
		if(searchMap.get("searchDate") == null || searchMap.get("searchDate") == "") {
			formatedNow = now.format(formatter) + "%";
			formatView = now.format(formatterView);
		} else {
			formatedNow = ((String) searchMap.get("searchDate")).substring(2, 7).replaceAll("-", "/") + "%";
			formatView = ((String) searchMap.get("searchDate")).replaceAll("-", "/");
		}
		
		/* 사원 조회 */
		List<MngWorkAttitudeDTO> memberList = mngWorkAttitudeMapper.selectMemberList(searchMap, companyNo, selectCriteria);

		for(int w = 0; w < memberList.size(); w++) {
			
			int todayCount = 0;					//지각횟수
			int earlyCount = 0;					//조퇴횟수
			int absentCount = 0;				//결근횟수
			List<MngWorkCommuteDTO> workList = new ArrayList<>();
			
			MngWorkAttitudeDTO memberInfo = new MngWorkAttitudeDTO();
			memberInfo.setIdNo(memberList.get(w).getIdNo());
			memberInfo.setCompanyNo(companyNo);
			
			/* 출퇴근 기록 조회 */
			List<MngWorkCommuteDTO> workSpList = mngWorkAttitudeMapper.selectWorkAttitudeList(memberInfo, formatedNow);
			
				
			for(int i = 0; i < workSpList.size(); i++) {
				
				MngWorkCommuteDTO workViewDTO = new MngWorkCommuteDTO();
				
				if(workSpList.get(i).getYearAndMonth() != null) {
					workViewDTO.setYearAndMonth(workSpList.get(i).getYearAndMonth().substring(6, 8));
				} 
				workViewDTO.setWorkStartTime(workSpList.get(i).getWorkStartTime());
				workViewDTO.setWorkEndTime(workSpList.get(i).getWorkEndTime());
				
				todayCount += (workSpList.get(i).getTodayStatus() == 'Y') ? 1 : 0; 
				earlyCount += (workSpList.get(i).getTodayStatus() == 'Y') ? 1 : 0; 
				absentCount += (workSpList.get(i).getTodayStatus() == 'Y') ? 1 : 0; 
				
				workList.add(workViewDTO);
			}
			
			memberList.get(w).setTodayCount(todayCount);
			memberList.get(w).setEarlyCount(earlyCount);
			memberList.get(w).setAbsentCount(absentCount);
			memberList.get(w).setWorkCoList(workList);
			memberList.get(w).setYearMonth(formatView);
			memberList.get(w).setMemberNo(memberList.get(w).getMemberNo());
			
		}
		
		return memberList;
	}

	/* 근태 수정 조회 */
	@Override
	public List<MngAttitudeUpdateDTO> selectAllWorkAttitudeUpdate(int companyNo, Map searchMap, SelectCriteria selectCriteria) {
		
		/* 사원 조회 */
		List<MngAttitudeUpdateDTO> memberList = mngWorkAttitudeMapper.selectUpdateList(searchMap, companyNo, selectCriteria );
		
		return memberList;
	}
	
	/* 근태 수정 */
	@Override
	@Transactional
	public int updateWorkAttitude(MngUpdateDTO updateDTO) {
		
		String updateDate = ((String) updateDTO.getUpdateDate().substring(2, 10)).replaceAll("-", "/") + "%";
		updateDTO.setUpdateDate(updateDTO.getUpdateDate().substring(2, 10).replaceAll("-", "/"));
		
		MngWorkCommuteDTO commuteDTO = new MngWorkCommuteDTO();
		/* insert할 내용 select */
		commuteDTO = mngWorkAttitudeMapper.selectWorkAttitude(updateDTO, updateDate);
		/* 근태 수정 insert*/ 
		int result = mngWorkAttitudeMapper.insertWorkAttitude(updateDTO, commuteDTO);
		/* 근태 수정 update */
		result += mngWorkAttitudeMapper.updateWorkAttitude(updateDTO, updateDate);
		
		return result;
	}

	/* 근태 기록 수정 내역 */
	@Override
	public List<MngAttitudeUpdateDTO> selectUpdateAttitudeList(int companyNo, Map searchMap, SelectCriteria selectCriteria) {
		
		/* 사원 조회 */
		List<MngAttitudeUpdateDTO> memberList = mngWorkAttitudeMapper.selectUpdateList(searchMap, companyNo, selectCriteria);
		
		return memberList;
	}

	@Override
	public List<MngAttitudeUpdateViewDTO> selectAllUpdateAttitudeList(int companyNo, int memberNo) {
		
		/* 수정 기록 기록 조회 */
		List<MngAttitudeUpdateViewDTO> updateList = mngWorkAttitudeMapper.selectUpdateAttitudeList(companyNo, memberNo);
		
		return updateList;
	}
	


}
