package com.nextLevel.hero.workattitude.model.service;

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
import com.nextLevel.hero.workattitude.model.dao.WorkAttitudeMapper;
import com.nextLevel.hero.workattitude.model.dto.EmployeeAnnualVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.EmployeeVacationDTO;
import com.nextLevel.hero.workattitude.model.dto.WorkAttitudeDTO;
import com.nextLevel.hero.workattitude.model.dto.WorkCommuteDTO;


@Service("workAttitudeService")
public class WorkAttitudeServiceImpl implements WorkAttitudeService{
	
	 private WorkAttitudeMapper workAttitudeMapper;
	   
	   @Autowired
	   public WorkAttitudeServiceImpl(WorkAttitudeMapper workAttitudeMapper) {
	      this.workAttitudeMapper = workAttitudeMapper;
	   }


	@Override
	public List<EmployeeVacationDTO> listEmployeeVacation(int companyNo, int no) {
		return workAttitudeMapper.listEmployeeVacation(companyNo,no);
	}


	@Override
	public EmployeeAnnualVacationDTO listEmployeeAnnualVacation(int companyNo, int idNo) {
		return workAttitudeMapper.listEmployeeAnnualVacation(companyNo,idNo);
	}


	@Override
	@Transactional
	public int insertVacation(EmployeeVacationDTO employeeVacationDTO) {
		
		return workAttitudeMapper.insertVacation(employeeVacationDTO);
	}




	   @Override
		public List<WorkAttitudeDTO> selectAllWorkAttitudeList(int companyNo,int idNo, Map searchMap) {
			
			LocalDate now = LocalDate.now();
			// 포맷 정의
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
			
			DateTimeFormatter formatterView = DateTimeFormatter.ofPattern("yyyy/MM");
			// 포맷 적용
			String formatView = null;
			String formatedNow = null;
			
			/* 페이징 */
			String currentPage = (String) searchMap.get("currentPage");
			String searchCondition = (String) searchMap.get("searchCondition");
			String searchValue = (String) searchMap.get("searchValue");
			int pageNo = 1;
			if(currentPage != null && !"".equals(currentPage)) {
				pageNo = Integer.parseInt(currentPage);
			}
			
			/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
			if(pageNo <= 0) {
				pageNo = 1;
			}
			
			if(searchMap.get("searchDate") == null || searchMap.get("searchDate") == "") {
				formatedNow = now.format(formatter) + "%";
				formatView = now.format(formatterView);
			} else {
				formatedNow = ((String) searchMap.get("searchDate")).substring(2, 7).replaceAll("-", "/") + "%";
				formatView = ((String) searchMap.get("searchDate")).replaceAll("-", "/");
			}
			
			/* 사원수 검색 */
			int totalCount = workAttitudeMapper.selectMemberCount(searchMap, companyNo, idNo);
			
			/* 한 페이지에 보여 줄 게시물 수 */
			int limit = 3;		
			/* 한 번에 보여질 페이징 버튼의 갯수 */
			int buttonAmount = 5;
			
			/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
			SelectCriteria selectCriteria = null;

			
			if(searchCondition != null && !"".equals(searchCondition)) {
				selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
			} else {
				selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
			}
			
			/* 사원 조회 */
			List<WorkAttitudeDTO> memberList = workAttitudeMapper.selectMemberList(searchMap, companyNo, idNo, selectCriteria );

			for(int w = 0; w < memberList.size(); w++) {
				
				int todayCount = 0;					//지각횟수
				int earlyCount = 0;					//조퇴횟수
				int absentCount = 0;				//결근횟수
				List<WorkCommuteDTO> workList = new ArrayList<>();
				
				WorkAttitudeDTO memberInfo = new WorkAttitudeDTO();
				memberInfo.setIdNo(memberList.get(w).getIdNo());
				memberInfo.setCompanyNo(companyNo);
				
				/* 출퇴근 기록 조회 */
				List<WorkCommuteDTO> workSpList = workAttitudeMapper.selectWorkAttitudeList(memberInfo, formatedNow, idNo);
				
					
				for(int i = 0; i < workSpList.size(); i++) {
					
					WorkCommuteDTO workViewDTO = new WorkCommuteDTO();

					workViewDTO.setYearAndMonth(workSpList.get(i).getYearAndMonth().substring(8, 10));
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
}
