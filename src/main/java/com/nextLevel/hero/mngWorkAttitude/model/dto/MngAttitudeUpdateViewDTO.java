package com.nextLevel.hero.mngWorkAttitude.model.dto;

import java.sql.Date;

public class MngAttitudeUpdateViewDTO {
	
	private String writer;					//수정자
	private java.sql.Date chhangeWantDate; 	//수정일
	private String updateDate; 			 	//수정변경일
	private String afterChangeStartTime;	//출근시간
	private String afterChangeEndTime;		//퇴근시간
	private int workAttitudeUpdateNo;		//근태수정번호
	private int memberNo;					//사번
	private String rank;					//직급
	
	public MngAttitudeUpdateViewDTO() {
		super();
	}

	public MngAttitudeUpdateViewDTO(String writer, Date chhangeWantDate, String updateDate, String afterChangeStartTime,
			String afterChangeEndTime, int workAttitudeUpdateNo, int memberNo, String rank) {
		super();
		this.writer = writer;
		this.chhangeWantDate = chhangeWantDate;
		this.updateDate = updateDate;
		this.afterChangeStartTime = afterChangeStartTime;
		this.afterChangeEndTime = afterChangeEndTime;
		this.workAttitudeUpdateNo = workAttitudeUpdateNo;
		this.memberNo = memberNo;
		this.rank = rank;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public java.sql.Date getChhangeWantDate() {
		return chhangeWantDate;
	}

	public void setChhangeWantDate(java.sql.Date chhangeWantDate) {
		this.chhangeWantDate = chhangeWantDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getAfterChangeStartTime() {
		return afterChangeStartTime;
	}

	public void setAfterChangeStartTime(String afterChangeStartTime) {
		this.afterChangeStartTime = afterChangeStartTime;
	}

	public String getAfterChangeEndTime() {
		return afterChangeEndTime;
	}

	public void setAfterChangeEndTime(String afterChangeEndTime) {
		this.afterChangeEndTime = afterChangeEndTime;
	}

	public int getWorkAttitudeUpdateNo() {
		return workAttitudeUpdateNo;
	}

	public void setWorkAttitudeUpdateNo(int workAttitudeUpdateNo) {
		this.workAttitudeUpdateNo = workAttitudeUpdateNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "MngAttitudeUpdateViewDTO [writer=" + writer + ", chhangeWantDate=" + chhangeWantDate + ", updateDate="
				+ updateDate + ", afterChangeStartTime=" + afterChangeStartTime + ", afterChangeEndTime="
				+ afterChangeEndTime + ", workAttitudeUpdateNo=" + workAttitudeUpdateNo + ", memberNo=" + memberNo
				+ ", rank=" + rank + "]";
	}

	
	
}
