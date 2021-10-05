package com.nextLevel.hero.mnghumanResource.model.dto;

import java.io.Serializable;
import java.util.Date;

public class MngHumanResourceDTO implements Serializable{

	private int companyNo;                 				//TBL_EMPLOYEE 임직원 계정 테이블
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
	private char gender;
	private String national;
	private java.util.Date entDate; 
	
	private int idNo;								//TBL_MEMBER 맴버 테이블
	private String memberId;						
	private String memberPassword;							
	private char tempPwdYn;								
//	private String memberName;								
	private java.util.Date hireDate;								
	private char accSecessionYn;
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
								
		
	//	TBL_EMP_SALARY_STEP							하림님 신규 사원이 생성시 값 인서트 해주기
	//	TBL_EMP_SALARY_STEP_UPDATE
	//	TBL_FOUR_INSURANCE_DEDUCT
	
	
	public MngHumanResourceDTO() {}

	public MngHumanResourceDTO(int companyNo, int memberNo, int jobNo, int departmentNo, String koreanName, String ssn,
			String englishName, String speciality, String familyOriginAddress, String address, String phone, String tel,
			String departmentPhone, String email, char gender, String national, Date entDate, int idNo, String memberId,
			String memberPassword, char tempPwdYn, Date hireDate, char accSecessionYn, char basicSettingYn,
			Date appointmentDate, String personalAppointmentCategory, String veteranStatus, String relationship,
			int veteranNo, char militaryServiceStatus, char militaryKind, String rankIng, Date militaryStartDate,
			Date militaryEndDate, Date graduatedDate, String nativeSchool, char graduatedStatus, String relationShip2,
			char familyGender, int familyAge, String job, Date employeementPeriod, String position, String companyName,
			String department) {
		super();
		this.companyNo = companyNo;
		this.memberNo = memberNo;
		this.jobNo = jobNo;
		this.departmentNo = departmentNo;
		this.koreanName = koreanName;
		this.ssn = ssn;
		this.englishName = englishName;
		this.speciality = speciality;
		this.familyOriginAddress = familyOriginAddress;
		this.address = address;
		this.phone = phone;
		this.tel = tel;
		this.departmentPhone = departmentPhone;
		this.email = email;
		this.gender = gender;
		this.national = national;
		this.entDate = entDate;
		this.idNo = idNo;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.tempPwdYn = tempPwdYn;
		this.hireDate = hireDate;
		this.accSecessionYn = accSecessionYn;
		this.basicSettingYn = basicSettingYn;
		this.appointmentDate = appointmentDate;
		this.personalAppointmentCategory = personalAppointmentCategory;
		this.veteranStatus = veteranStatus;
		this.relationship = relationship;
		this.veteranNo = veteranNo;
		this.militaryServiceStatus = militaryServiceStatus;
		this.militaryKind = militaryKind;
		this.rankIng = rankIng;
		this.militaryStartDate = militaryStartDate;
		this.militaryEndDate = militaryEndDate;
		this.graduatedDate = graduatedDate;
		this.nativeSchool = nativeSchool;
		this.graduatedStatus = graduatedStatus;
		relationShip = relationShip2;
		this.familyGender = familyGender;
		this.familyAge = familyAge;
		this.job = job;
		this.employeementPeriod = employeementPeriod;
		this.position = position;
		this.companyName = companyName;
		this.department = department;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getKoreanName() {
		return koreanName;
	}

	public void setKoreanName(String koreanName) {
		this.koreanName = koreanName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getFamilyOriginAddress() {
		return familyOriginAddress;
	}

	public void setFamilyOriginAddress(String familyOriginAddress) {
		this.familyOriginAddress = familyOriginAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDepartmentPhone() {
		return departmentPhone;
	}

	public void setDepartmentPhone(String departmentPhone) {
		this.departmentPhone = departmentPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getNational() {
		return national;
	}

	public void setNational(String national) {
		this.national = national;
	}

	public java.util.Date getEntDate() {
		return entDate;
	}

	public void setEntDate(java.util.Date entDate) {
		this.entDate = entDate;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public char getTempPwdYn() {
		return tempPwdYn;
	}

	public void setTempPwdYn(char tempPwdYn) {
		this.tempPwdYn = tempPwdYn;
	}

	public java.util.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Date hireDate) {
		this.hireDate = hireDate;
	}

	public char getAccSecessionYn() {
		return accSecessionYn;
	}

	public void setAccSecessionYn(char accSecessionYn) {
		this.accSecessionYn = accSecessionYn;
	}

	public char getBasicSettingYn() {
		return basicSettingYn;
	}

	public void setBasicSettingYn(char basicSettingYn) {
		this.basicSettingYn = basicSettingYn;
	}

	public java.util.Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getPersonalAppointmentCategory() {
		return personalAppointmentCategory;
	}

	public void setPersonalAppointmentCategory(String personalAppointmentCategory) {
		this.personalAppointmentCategory = personalAppointmentCategory;
	}

	public String getVeteranStatus() {
		return veteranStatus;
	}

	public void setVeteranStatus(String veteranStatus) {
		this.veteranStatus = veteranStatus;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public int getVeteranNo() {
		return veteranNo;
	}

	public void setVeteranNo(int veteranNo) {
		this.veteranNo = veteranNo;
	}

	public char getMilitaryServiceStatus() {
		return militaryServiceStatus;
	}

	public void setMilitaryServiceStatus(char militaryServiceStatus) {
		this.militaryServiceStatus = militaryServiceStatus;
	}

	public char getMilitaryKind() {
		return militaryKind;
	}

	public void setMilitaryKind(char militaryKind) {
		this.militaryKind = militaryKind;
	}

	public String getRankIng() {
		return rankIng;
	}

	public void setRankIng(String rankIng) {
		this.rankIng = rankIng;
	}

	public java.util.Date getMilitaryStartDate() {
		return militaryStartDate;
	}

	public void setMilitaryStartDate(java.util.Date militaryStartDate) {
		this.militaryStartDate = militaryStartDate;
	}

	public java.util.Date getMilitaryEndDate() {
		return militaryEndDate;
	}

	public void setMilitaryEndDate(java.util.Date militaryEndDate) {
		this.militaryEndDate = militaryEndDate;
	}

	public java.util.Date getGraduatedDate() {
		return graduatedDate;
	}

	public void setGraduatedDate(java.util.Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}

	public String getNativeSchool() {
		return nativeSchool;
	}

	public void setNativeSchool(String nativeSchool) {
		this.nativeSchool = nativeSchool;
	}

	public char getGraduatedStatus() {
		return graduatedStatus;
	}

	public void setGraduatedStatus(char graduatedStatus) {
		this.graduatedStatus = graduatedStatus;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public char getFamilyGender() {
		return familyGender;
	}

	public void setFamilyGender(char familyGender) {
		this.familyGender = familyGender;
	}

	public int getFamilyAge() {
		return familyAge;
	}

	public void setFamilyAge(int familyAge) {
		this.familyAge = familyAge;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public java.util.Date getEmployeementPeriod() {
		return employeementPeriod;
	}

	public void setEmployeementPeriod(java.util.Date employeementPeriod) {
		this.employeementPeriod = employeementPeriod;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "MngHumanResourceDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", jobNo=" + jobNo
				+ ", departmentNo=" + departmentNo + ", koreanName=" + koreanName + ", ssn=" + ssn + ", englishName="
				+ englishName + ", speciality=" + speciality + ", familyOriginAddress=" + familyOriginAddress
				+ ", address=" + address + ", phone=" + phone + ", tel=" + tel + ", departmentPhone=" + departmentPhone
				+ ", email=" + email + ", gender=" + gender + ", national=" + national + ", entDate=" + entDate
				+ ", idNo=" + idNo + ", memberId=" + memberId + ", memberPassword=" + memberPassword + ", tempPwdYn="
				+ tempPwdYn + ", hireDate=" + hireDate + ", accSecessionYn=" + accSecessionYn + ", basicSettingYn="
				+ basicSettingYn + ", appointmentDate=" + appointmentDate + ", personalAppointmentCategory="
				+ personalAppointmentCategory + ", veteranStatus=" + veteranStatus + ", relationship=" + relationship
				+ ", veteranNo=" + veteranNo + ", militaryServiceStatus=" + militaryServiceStatus + ", militaryKind="
				+ militaryKind + ", rankIng=" + rankIng + ", militaryStartDate=" + militaryStartDate
				+ ", militaryEndDate=" + militaryEndDate + ", graduatedDate=" + graduatedDate + ", nativeSchool="
				+ nativeSchool + ", graduatedStatus=" + graduatedStatus + ", relationShip=" + relationShip
				+ ", familyGender=" + familyGender + ", familyAge=" + familyAge + ", job=" + job
				+ ", employeementPeriod=" + employeementPeriod + ", position=" + position + ", companyName="
				+ companyName + ", department=" + department + "]";
	}

	
}
