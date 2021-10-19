package com.nextLevel.hero.workattitude.model.dto;
import java.io.Serializable;
import java.util.List;

public class WorkAttitudeDTO implements Serializable{
	
	private int companyNo;					//회사번호
	private int IdNo; 						//계정번호
	private String koreanName;				//이름
	private int memberNo;					//사번
	private String yearMonth;				//연월
	private int todayCount;					//지각횟수
	private int earlyCount;					//조퇴횟수
	private int absentCount;				//결근횟수

	private List<WorkCommuteDTO> workCoList;
	
	public WorkAttitudeDTO() {}

	public WorkAttitudeDTO(int companyNo, int idNo, String koreanName, int memberNo, String yearMonth,
			int todayCount, int earlyCount, int absentCount, List<WorkCommuteDTO> workCoList) {
		super();
		this.companyNo = companyNo;
		IdNo = idNo;
		this.koreanName = koreanName;
		this.memberNo = memberNo;
		this.yearMonth = yearMonth;
		this.todayCount = todayCount;
		this.earlyCount = earlyCount;
		this.absentCount = absentCount;
		this.workCoList = workCoList;
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

	public int getTodayCount() {
		return todayCount;
	}

	public void setTodayCount(int todayCount) {
		this.todayCount = todayCount;
	}

	public int getEarlyCount() {
		return earlyCount;
	}

	public void setEarlyCount(int earlyCount) {
		this.earlyCount = earlyCount;
	}

	public int getAbsentCount() {
		return absentCount;
	}

	public void setAbsentCount(int absentCount) {
		this.absentCount = absentCount;
	}

	public List<WorkCommuteDTO> getWorkCoList() {
		return workCoList;
	}

	public void setWorkCoList(List<WorkCommuteDTO> workCoList) {
		this.workCoList = workCoList;
	}

	@Override
	public String toString() {
		return "WorkAttitudeDTO [companyNo=" + companyNo + ", IdNo=" + IdNo + ", koreanName=" + koreanName
				+ ", memberNo=" + memberNo + ", yearMonth=" + yearMonth + ", todayCount=" + todayCount + ", earlyCount="
				+ earlyCount + ", absentCount=" + absentCount + ", workCoList=" + workCoList + "]";
	}

	

	

}
