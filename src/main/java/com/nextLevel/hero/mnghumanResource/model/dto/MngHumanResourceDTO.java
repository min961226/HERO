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
	private java.sql.Date entDate;
	private char tblUserAuth;
	private String jobName;								
	private String departmentName;
	private String addressDetail;
	private String familyOriginAddressDetail;
	private java.sql.Date empUpdateDate;	
	
	private int idNo;								//TBL_MEMBER 맴버 테이블
	private String memberId;						
	private String memberPassword;							
	private char tempPwdYn;								
//	private String memberName;								
	private java.util.Date hireDate;								
	private char accSecessionYn;
	
	private String militaryServiceStatus;				//TBL_MILITARY_SERVICE 병역 테이블
	private String militaryKind;
	private String rankIng;
	private java.sql.Date militaryStartDate;			
	private java.sql.Date militaryEndDate;
	
	private String veteranStatus;						//TBL_VETERAN 보훈 테이블
	private String relationship;
	private int veteranNo;
	
	private java.sql.Date appointmentDate;              //TBL_APPOINTMENT 발령 테이블 
	private String personalAppointmentCategory; 

	private java.sql.Date graduatedDateStart;       
	private java.sql.Date graduatedDateEnd;      	 
	private String nativeSchool;
	private char graduatedStatus;
	
	private int salaryStepByRank;							//TBL_EMP_SALARY_STEP 호봉 테이블
	private int salaryStep;							//TBL_EMP_SALARY_STEP 호봉 테이블
	private String rank;							//TBL_EMP_SALARY_STEP 호봉 테이블
	
	private java.sql.Date employeementPeriodStart;      
	private java.sql.Date employeementPeriodEnd;      
	private String position;
	private String companyName;
	private String department;
								
	private String familyRelationShip;  							//TBL_FAMILY 가족 테이블
	private char familyGender;
	private int familyAge;
	private String familyJob;
		
	//	TBL_EMP_SALARY_STEP							하림님 신규 사원이 생성시 값 인서트 해주기
	//	TBL_EMP_SALARY_STEP_UPDATE
	//	TBL_FOUR_INSURANCE_DEDUCT
	
	
	public MngHumanResourceDTO() {}

	public MngHumanResourceDTO(int companyNo, int memberNo, int jobNo, int departmentNo, String koreanName, String ssn,
			String englishName, String speciality, String familyOriginAddress, String address, String phone, String tel,
			String departmentPhone, String email, char gender, String national, java.sql.Date entDate, char tblUserAuth,
			String jobName, String departmentName, String addressDetail, String familyOriginAddressDetail,
			java.sql.Date empUpdateDate, int idNo, String memberId, String memberPassword, char tempPwdYn,
			Date hireDate, char accSecessionYn, String militaryServiceStatus, String militaryKind, String rankIng,
			java.sql.Date militaryStartDate, java.sql.Date militaryEndDate, String veteranStatus, String relationship,
			int veteranNo, java.sql.Date appointmentDate, String personalAppointmentCategory,
			java.sql.Date graduatedDateStart, java.sql.Date graduatedDateEnd, String nativeSchool, char graduatedStatus,
			int salaryStepByRank, int salaryStep, String rank, java.sql.Date employeementPeriodStart,
			java.sql.Date employeementPeriodEnd, String position, String companyName, String department,
			String familyRelationShip, char familyGender, int familyAge, String familyJob) {
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
		this.tblUserAuth = tblUserAuth;
		this.jobName = jobName;
		this.departmentName = departmentName;
		this.addressDetail = addressDetail;
		this.familyOriginAddressDetail = familyOriginAddressDetail;
		this.empUpdateDate = empUpdateDate;
		this.idNo = idNo;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.tempPwdYn = tempPwdYn;
		this.hireDate = hireDate;
		this.accSecessionYn = accSecessionYn;
		this.militaryServiceStatus = militaryServiceStatus;
		this.militaryKind = militaryKind;
		this.rankIng = rankIng;
		this.militaryStartDate = militaryStartDate;
		this.militaryEndDate = militaryEndDate;
		this.veteranStatus = veteranStatus;
		this.relationship = relationship;
		this.veteranNo = veteranNo;
		this.appointmentDate = appointmentDate;
		this.personalAppointmentCategory = personalAppointmentCategory;
		this.graduatedDateStart = graduatedDateStart;
		this.graduatedDateEnd = graduatedDateEnd;
		this.nativeSchool = nativeSchool;
		this.graduatedStatus = graduatedStatus;
		this.salaryStepByRank = salaryStepByRank;
		this.salaryStep = salaryStep;
		this.rank = rank;
		this.employeementPeriodStart = employeementPeriodStart;
		this.employeementPeriodEnd = employeementPeriodEnd;
		this.position = position;
		this.companyName = companyName;
		this.department = department;
		this.familyRelationShip = familyRelationShip;
		this.familyGender = familyGender;
		this.familyAge = familyAge;
		this.familyJob = familyJob;
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

	public java.sql.Date getEntDate() {
		return entDate;
	}

	public void setEntDate(java.sql.Date entDate) {
		this.entDate = entDate;
	}

	public char getTblUserAuth() {
		return tblUserAuth;
	}

	public void setTblUserAuth(char tblUserAuth) {
		this.tblUserAuth = tblUserAuth;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getFamilyOriginAddressDetail() {
		return familyOriginAddressDetail;
	}

	public void setFamilyOriginAddressDetail(String familyOriginAddressDetail) {
		this.familyOriginAddressDetail = familyOriginAddressDetail;
	}

	public java.sql.Date getEmpUpdateDate() {
		return empUpdateDate;
	}

	public void setEmpUpdateDate(java.sql.Date empUpdateDate) {
		this.empUpdateDate = empUpdateDate;
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

	public String getMilitaryServiceStatus() {
		return militaryServiceStatus;
	}

	public void setMilitaryServiceStatus(String militaryServiceStatus) {
		this.militaryServiceStatus = militaryServiceStatus;
	}

	public String getMilitaryKind() {
		return militaryKind;
	}

	public void setMilitaryKind(String militaryKind) {
		this.militaryKind = militaryKind;
	}

	public String getRankIng() {
		return rankIng;
	}

	public void setRankIng(String rankIng) {
		this.rankIng = rankIng;
	}

	public java.sql.Date getMilitaryStartDate() {
		return militaryStartDate;
	}

	public void setMilitaryStartDate(java.sql.Date militaryStartDate) {
		this.militaryStartDate = militaryStartDate;
	}

	public java.sql.Date getMilitaryEndDate() {
		return militaryEndDate;
	}

	public void setMilitaryEndDate(java.sql.Date militaryEndDate) {
		this.militaryEndDate = militaryEndDate;
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

	public java.sql.Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(java.sql.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getPersonalAppointmentCategory() {
		return personalAppointmentCategory;
	}

	public void setPersonalAppointmentCategory(String personalAppointmentCategory) {
		this.personalAppointmentCategory = personalAppointmentCategory;
	}

	public java.sql.Date getGraduatedDateStart() {
		return graduatedDateStart;
	}

	public void setGraduatedDateStart(java.sql.Date graduatedDateStart) {
		this.graduatedDateStart = graduatedDateStart;
	}

	public java.sql.Date getGraduatedDateEnd() {
		return graduatedDateEnd;
	}

	public void setGraduatedDateEnd(java.sql.Date graduatedDateEnd) {
		this.graduatedDateEnd = graduatedDateEnd;
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

	public int getSalaryStepByRank() {
		return salaryStepByRank;
	}

	public void setSalaryStepByRank(int salaryStepByRank) {
		this.salaryStepByRank = salaryStepByRank;
	}

	public int getSalaryStep() {
		return salaryStep;
	}

	public void setSalaryStep(int salaryStep) {
		this.salaryStep = salaryStep;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public java.sql.Date getEmployeementPeriodStart() {
		return employeementPeriodStart;
	}

	public void setEmployeementPeriodStart(java.sql.Date employeementPeriodStart) {
		this.employeementPeriodStart = employeementPeriodStart;
	}

	public java.sql.Date getEmployeementPeriodEnd() {
		return employeementPeriodEnd;
	}

	public void setEmployeementPeriodEnd(java.sql.Date employeementPeriodEnd) {
		this.employeementPeriodEnd = employeementPeriodEnd;
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

	public String getFamilyRelationShip() {
		return familyRelationShip;
	}

	public void setFamilyRelationShip(String familyRelationShip) {
		this.familyRelationShip = familyRelationShip;
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

	public String getFamilyJob() {
		return familyJob;
	}

	public void setFamilyJob(String familyJob) {
		this.familyJob = familyJob;
	}

	@Override
	public String toString() {
		return "MngHumanResourceDTO [companyNo=" + companyNo + ", memberNo=" + memberNo + ", jobNo=" + jobNo
				+ ", departmentNo=" + departmentNo + ", koreanName=" + koreanName + ", ssn=" + ssn + ", englishName="
				+ englishName + ", speciality=" + speciality + ", familyOriginAddress=" + familyOriginAddress
				+ ", address=" + address + ", phone=" + phone + ", tel=" + tel + ", departmentPhone=" + departmentPhone
				+ ", email=" + email + ", gender=" + gender + ", national=" + national + ", entDate=" + entDate
				+ ", tblUserAuth=" + tblUserAuth + ", jobName=" + jobName + ", departmentName=" + departmentName
				+ ", addressDetail=" + addressDetail + ", familyOriginAddressDetail=" + familyOriginAddressDetail
				+ ", empUpdateDate=" + empUpdateDate + ", idNo=" + idNo + ", memberId=" + memberId + ", memberPassword="
				+ memberPassword + ", tempPwdYn=" + tempPwdYn + ", hireDate=" + hireDate + ", accSecessionYn="
				+ accSecessionYn + ", militaryServiceStatus=" + militaryServiceStatus + ", militaryKind=" + militaryKind
				+ ", rankIng=" + rankIng + ", militaryStartDate=" + militaryStartDate + ", militaryEndDate="
				+ militaryEndDate + ", veteranStatus=" + veteranStatus + ", relationship=" + relationship
				+ ", veteranNo=" + veteranNo + ", appointmentDate=" + appointmentDate + ", personalAppointmentCategory="
				+ personalAppointmentCategory + ", graduatedDateStart=" + graduatedDateStart + ", graduatedDateEnd="
				+ graduatedDateEnd + ", nativeSchool=" + nativeSchool + ", graduatedStatus=" + graduatedStatus
				+ ", salaryStepByRank=" + salaryStepByRank + ", salaryStep=" + salaryStep + ", rank=" + rank
				+ ", employeementPeriodStart=" + employeementPeriodStart + ", employeementPeriodEnd="
				+ employeementPeriodEnd + ", position=" + position + ", companyName=" + companyName + ", department="
				+ department + ", familyRelationShip=" + familyRelationShip + ", familyGender=" + familyGender
				+ ", familyAge=" + familyAge + ", familyJob=" + familyJob + "]";
	}

}