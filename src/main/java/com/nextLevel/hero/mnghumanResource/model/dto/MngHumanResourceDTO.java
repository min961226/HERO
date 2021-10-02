package com.nextLevel.hero.mnghumanResource.model.dto;

import java.io.Serializable;

public class MngHumanResourceDTO implements Serializable{

	private int companyNo;                 				//TBL_EMPLOYEE 임직원 계정 테이블
	private int idNo;						
	private int memberNo;  					
	private int jobNo;								
	private int departmentNo;						
	private String koreanName;					
	private String ssn;
	private String englishName;
	private String speciality;
	private String familyOriginAddress;
	private String address;
	private String phone;
	private String tel;
	private String departmentPhone;
	private String email;
	private String password;
	private char gender;
	private String national;
	private java.util.Date hireDate; 
	private java.util.Date entDate; 
	private char basicSettingYn;
	
	private java.util.Date appointmentDate;               //TBL_APPOINTMENT 발령 테이블
	private String personalAppointmentCategory; 
	
	private String veteranStatus;						//TBL_VETERAN 보훈 테이블
	private String relationship;
	private int veteranNo;
	
	private char militaryServiceStatus;					//TBL_MILITARY_SERVICE 병역 테이블
	private char militaryKind;
	private String rankIng;
	private java.util.Date militaryStartDate;
	private java.util.Date militaryEndDate;

	private java.util.Date graduatedDate;       //TBL_GRADUATED 학력 테이블
	private String nativeSchool;
	private char graduatedStatus;
	
	private String relationShip;  				//TBL_FAMILY 가족 테이블
	private char familyGender;
	private int familyAge;
	private String job;
	
	private java.util.Date employeementPeriod;      //TBL_CAREER 경력 테이블
	private String position;
	private String companyName;
	private String department; 
	

}
