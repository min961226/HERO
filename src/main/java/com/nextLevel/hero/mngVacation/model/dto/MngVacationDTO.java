package com.nextLevel.hero.mngVacation.model.dto;

import java.io.Serializable;

public class MngVacationDTO implements Serializable{

	//직원휴가로 다시
	// 디비보고 확인
	private int resquestNo;					//신청번호
	private int companyNo;					//회사번호
	private int memberNo;					//사번
	private String vacationCategory;		//휴가종류
	private java.sql.Date startDate;		//휴가시작일
	private java.sql.Date endDate;			//휴가종료일
	private String vacationContents;		//휴가내용
	private String vacationUsedYn;			//휴가여부
	private String confirmedYn;				//승인여부
	private int idNo;						//계정번호
	
	
	
	

	
	
	
}










