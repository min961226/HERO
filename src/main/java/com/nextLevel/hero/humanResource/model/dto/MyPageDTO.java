package com.nextLevel.hero.humanResource.model.dto;

import java.sql.Date;

public class MyPageDTO {

	private int companyNo;                 				//회사번호
	private int updateNo;                 				//업데이트 번호
	private int memberNo;  								//사번
	private String koreanName;							//이름
	private String ssn;									//주민번호
	private String englishName;							//영어 이름
	private String speciality;							//특기
	private String familyOriginAddress;					//본적
	private String address;								//주소
	private String phone;								//폰번호
	private String tel;									//집번호
	private String departmentPhone;						//핸드폰
	private String email;								//이메일
	private char gender;								//성별
	private String national;							//국적
	private java.sql.Date hireDate;						//퇴사일
	private java.sql.Date entDate;						//퇴사일
	private java.sql.Date updateDate;				    //수정일
	private int idNo;									//계정번호
	

	private int jobNo;									//직책번호
	private int departmentNo;							//부서번호
	private int salaryStepByRank;						//부서번호
	private String departmentName;						//부서명
	private String memberId;							//부서명
	private String jobName;								//부서명
	
	private String addressDetail;						//주소
	private String familyOriginAddressDetail;			//본적
	
	public MyPageDTO() {}

	public MyPageDTO(int companyNo, int updateNo, int memberNo, String koreanName, String ssn, String englishName,
			String speciality, String familyOriginAddress, String address, String phone, String tel,
			String departmentPhone, String email, char gender, String national, Date hireDate, Date entDate,
			Date updateDate, int idNo, int jobNo, int departmentNo, int salaryStepByRank, String departmentName,
			String memberId, String jobName, String familyOriginAddressDetail, String addressDetail) {
		super();
		this.companyNo = companyNo;
		this.updateNo = updateNo;
		this.memberNo = memberNo;
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
		this.hireDate = hireDate;
		this.entDate = entDate;
		this.updateDate = updateDate;
		this.idNo = idNo;
		this.jobNo = jobNo;
		this.departmentNo = departmentNo;
		this.salaryStepByRank = salaryStepByRank;
		this.departmentName = departmentName;
		this.memberId = memberId;
		this.jobName = jobName;
		this.familyOriginAddressDetail = familyOriginAddressDetail;
		this.addressDetail = addressDetail;
	}

	public int getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}

	public int getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(int updateNo) {
		this.updateNo = updateNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	public java.sql.Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.sql.Date hireDate) {
		this.hireDate = hireDate;
	}

	public java.sql.Date getEntDate() {
		return entDate;
	}

	public void setEntDate(java.sql.Date entDate) {
		this.entDate = entDate;
	}

	public java.sql.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.sql.Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
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

	public int getSalaryStepByRank() {
		return salaryStepByRank;
	}

	public void setSalaryStepByRank(int salaryStepByRank) {
		this.salaryStepByRank = salaryStepByRank;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getFamilyOriginAddressDetail() {
		return familyOriginAddressDetail;
	}

	public void setFamilyOriginAddressDetail(String familyOriginAddressDetail) {
		this.familyOriginAddressDetail = familyOriginAddressDetail;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "MyPageDTO [companyNo=" + companyNo + ", updateNo=" + updateNo + ", memberNo=" + memberNo
				+ ", koreanName=" + koreanName + ", ssn=" + ssn + ", englishName=" + englishName + ", speciality="
				+ speciality + ", familyOriginAddress=" + familyOriginAddress + ", address=" + address + ", phone="
				+ phone + ", tel=" + tel + ", departmentPhone=" + departmentPhone + ", email=" + email + ", gender="
				+ gender + ", national=" + national + ", hireDate=" + hireDate + ", entDate=" + entDate
				+ ", updateDate=" + updateDate + ", idNo=" + idNo + ", jobNo=" + jobNo + ", departmentNo="
				+ departmentNo + ", salaryStepByRank=" + salaryStepByRank + ", departmentName=" + departmentName
				+ ", memberId=" + memberId + ", jobName=" + jobName + ", familyOriginAddressDetail="
				+ familyOriginAddressDetail + ", addressDetail=" + addressDetail + "]";
	}
	
}
