package com.nextLevel.hero.mngWorkAttitude.model.dto;

public class MngWorkViewDTO {
	
	private int companyNo;					//회사번호
	private int IdNo; 						//계정번호
	private String koreanName;				//이름
	private int memberNo;					//사번
	private String yearMonth;				//연월 
	private String yearAndMonth; 			//연도월
	private String workStartTime;			//시작시간
	private String workEndTime;				//퇴근시간
	private int commuteNo; 					//출티근번호
	private char todayStatus;				//지각여부
	private char earlyLeaveStatus;			//조퇴여부
	private char absentStatus;		 		//결근여부
	private int holidayNo; 					//휴일번호
	private int perCount;					//지각횟수
	
	public MngWorkViewDTO() {
		super();
	}

	public MngWorkViewDTO(int companyNo, int idNo, String koreanName, int memberNo, String yearMonth,
			String yearAndMonth, String workStartTime, String workEndTime, int commuteNo, char todayStatus,
			char earlyLeaveStatus, char absentStatus, int holidayNo, int perCount) {
		super();
		this.companyNo = companyNo;
		IdNo = idNo;
		this.koreanName = koreanName;
		this.memberNo = memberNo;
		this.yearMonth = yearMonth;
		this.yearAndMonth = yearAndMonth;
		this.workStartTime = workStartTime;
		this.workEndTime = workEndTime;
		this.commuteNo = commuteNo;
		this.todayStatus = todayStatus;
		this.earlyLeaveStatus = earlyLeaveStatus;
		this.absentStatus = absentStatus;
		this.holidayNo = holidayNo;
		this.perCount = perCount;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getIdNo() {
		return IdNo;
	}

	public void setIdNo(int idNo) {
		IdNo = idNo;
	}

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public String getYearAndMonth() {
		return yearAndMonth;
	}

	public void setYearAndMonth(String yearAndMonth) {
		this.yearAndMonth = yearAndMonth;
	}

	public String getWorkStartTime() {
		return workStartTime;
	}

	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}

	public String getWorkEndTime() {
		return workEndTime;
	}

	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}

	public int getCommuteNo() {
		return commuteNo;
	}

	public void setCommuteNo(int commuteNo) {
		this.commuteNo = commuteNo;
	}

	public char getTodayStatus() {
		return todayStatus;
	}

	public void setTodayStatus(char todayStatus) {
		this.todayStatus = todayStatus;
	}

	public char getEarlyLeaveStatus() {
		return earlyLeaveStatus;
	}

	public void setEarlyLeaveStatus(char earlyLeaveStatus) {
		this.earlyLeaveStatus = earlyLeaveStatus;
	}

	public char getAbsentStatus() {
		return absentStatus;
	}

	public void setAbsentStatus(char absentStatus) {
		this.absentStatus = absentStatus;
	}

	public int getHolidayNo() {
		return holidayNo;
	}

	public void setHolidayNo(int holidayNo) {
		this.holidayNo = holidayNo;
	}

	public int getPerCount() {
		return perCount;
	}

	public void setPerCount(int perCount) {
		this.perCount = perCount;
	}

	@Override
	public String toString() {
		return "MngWorkViewDTO [companyNo=" + companyNo + ", IdNo=" + IdNo + ", koreanName=" + koreanName
				+ ", memberNo=" + memberNo + ", yearMonth=" + yearMonth + ", yearAndMonth=" + yearAndMonth
				+ ", workStartTime=" + workStartTime + ", workEndTime=" + workEndTime + ", commuteNo=" + commuteNo
				+ ", todayStatus=" + todayStatus + ", earlyLeaveStatus=" + earlyLeaveStatus + ", absentStatus="
				+ absentStatus + ", holidayNo=" + holidayNo + ", perCount=" + perCount + "]";
	}


	

}
