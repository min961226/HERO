package com.nextLevel.hero.mngWorkAttitude.model.dto;

public class MngWorkCommuteDTO {
	
	private String yearAndMonth; 			//연도월
	private String workStartTime;			//시작시간
	private String workEndTime;				//퇴근시간
	private int commuteNo; 					//출티근번호
	private char todayStatus;				//지각여부
	private char earlyLeaveStatus;			//조퇴여부
	private char absentStatus;		 		//결근여부
	private int holidayNo; 					//휴일번호
	
	public MngWorkCommuteDTO() {
		super();
	}

	public MngWorkCommuteDTO(String yearAndMonth, String workStartTime, String workEndTime, int commuteNo,
			char todayStatus, char earlyLeaveStatus, char absentStatus, int holidayNo) {
		super();
		this.yearAndMonth = yearAndMonth;
		this.workStartTime = workStartTime;
		this.workEndTime = workEndTime;
		this.commuteNo = commuteNo;
		this.todayStatus = todayStatus;
		this.earlyLeaveStatus = earlyLeaveStatus;
		this.absentStatus = absentStatus;
		this.holidayNo = holidayNo;
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

	@Override
	public String toString() {
		return "MngWorkCommuteDTO [yearAndMonth=" + yearAndMonth + ", workStartTime=" + workStartTime + ", workEndTime="
				+ workEndTime + ", commuteNo=" + commuteNo + ", todayStatus=" + todayStatus + ", earlyLeaveStatus="
				+ earlyLeaveStatus + ", absentStatus=" + absentStatus + ", holidayNo=" + holidayNo + "]";
	}



	
}
