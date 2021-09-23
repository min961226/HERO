package com.nextLevel.hero.member.model.dto;

import java.sql.Date;
import java.util.List;

public class MemberDTO {
   
   private int no;                              //회원번호
   private String id;                           //회원아이디
   private String pwd;                           //회원비밀번호
   private String tempPwdYn;                     //임시비밀번호여부
   private String name;                        //회원이름
   private java.sql.Date registDatetime;            //회원가입일시
   private java.sql.Date accSecessionDatetime;         //계정탈퇴일시
   private String accSecessionYn;                  //계정탈퇴여부
   
   private List<MemberRoleDTO> memberRoleList;         //회원별권한리스트
   
   public MemberDTO() {}

   public MemberDTO(int no, String id, String pwd, String tempPwdYn, String name, Date registDatetime,
         Date accSecessionDatetime, String accSecessionYn, List<MemberRoleDTO> memberRoleList) {
      super();
      this.no = no;
      this.id = id;
      this.pwd = pwd;
      this.tempPwdYn = tempPwdYn;
      this.name = name;
      this.registDatetime = registDatetime;
      this.accSecessionDatetime = accSecessionDatetime;
      this.accSecessionYn = accSecessionYn;
      this.memberRoleList = memberRoleList;
   }

   public int getNo() {
      return no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
   }

   public String getTempPwdYn() {
      return tempPwdYn;
   }

   public void setTempPwdYn(String tempPwdYn) {
      this.tempPwdYn = tempPwdYn;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public java.sql.Date getRegistDatetime() {
      return registDatetime;
   }

   public void setRegistDatetime(java.sql.Date registDatetime) {
      this.registDatetime = registDatetime;
   }

   public java.sql.Date getAccSecessionDatetime() {
      return accSecessionDatetime;
   }

   public void setAccSecessionDatetime(java.sql.Date accSecessionDatetime) {
      this.accSecessionDatetime = accSecessionDatetime;
   }

   public String getAccSecessionYn() {
      return accSecessionYn;
   }

   public void setAccSecessionYn(String accSecessionYn) {
      this.accSecessionYn = accSecessionYn;
   }

   public List<MemberRoleDTO> getMemberRoleList() {
      return memberRoleList;
   }

   public void setMemberRoleList(List<MemberRoleDTO> memberRoleList) {
      this.memberRoleList = memberRoleList;
   }

   @Override
   public String toString() {
      return "MemberDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", tempPwdYn=" + tempPwdYn + ", name=" + name
            + ", registDatetime=" + registDatetime + ", accSecessionDatetime=" + accSecessionDatetime
            + ", accSecessionYn=" + accSecessionYn + ", memberRoleList=" + memberRoleList + "]";
   }


   
}