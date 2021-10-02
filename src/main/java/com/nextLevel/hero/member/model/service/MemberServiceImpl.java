package com.nextLevel.hero.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.member.model.dao.MemberMapper;
import com.nextLevel.hero.member.model.dto.AuthorityDTO;
import com.nextLevel.hero.member.model.dto.FindIdDTO;
import com.nextLevel.hero.member.model.dto.FindPwdDTO;
import com.nextLevel.hero.member.model.dto.MailDTO;
import com.nextLevel.hero.member.model.dto.MemberDTO;
import com.nextLevel.hero.member.model.dto.MemberRoleDTO;
import com.nextLevel.hero.member.model.dto.RankAuthDTO;
import com.nextLevel.hero.member.model.dto.UserImpl;


@Service("memberService")
public class MemberServiceImpl implements MemberService{

   private final MemberMapper memberMapper;
   
   @Autowired
   public MemberServiceImpl(MemberMapper memberMapper) {
      this.memberMapper = memberMapper;
   }
   
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {   //시큐리티가 username을 호출
      
      /*데이터베이스에서 사용자정보를 조회하고 시큐리티가 달라는대로 주는 메소드*/
      /* 사용자 id입력해서 일치하면 회원정보 조회 userDEtails 타입으로 반환하는 메소드 */
      MemberDTO member = memberMapper.findMemberById(username);               //사용자 정보를 조회한다.
      int companyNo = memberMapper.findCompanyNoByUserNo(member.getNo());
      List<AuthorityDTO> rankRoleList = memberMapper.findRankAuth(member, companyNo);

      if(member == null) {
         member = new MemberDTO();
      }
      
      List<GrantedAuthority> authorities = new ArrayList<>();               // 권한목록
      
      if(member.getMemberRoleList() != null) {
         List<MemberRoleDTO> roleList = member.getMemberRoleList();
         
         for(int i = 0; i <roleList.size(); i++) {
            AuthorityDTO authority = roleList.get(i).getAuthority();
            System.out.println(authority.getName());
            if(authority != null) {
               authorities.add(new SimpleGrantedAuthority(authority.getName()));   //지금은 두 개가 들어간다. member와 admin
            }
         }
      }
      System.out.println("----");
      for(int i = 0; i < rankRoleList.size(); i++) {
    	  String rankRole = rankRoleList.get(i).getName();
    	  
    	  if(rankRole != null) {
    		  authorities.add(new SimpleGrantedAuthority(rankRole));
    	  }
    	  System.out.println(rankRole);
      }
      
      System.out.println("-----------");
      System.out.println(authorities);
      //아이디 pwd 권한을 타입 객체로 만들어 반환
//      return new User(member.getId(), member.getPwd(), authorities);      //유저 타입 반환
      
      UserImpl user = new UserImpl(member.getNo(), member.getId(), member.getPwd(), authorities);
      user.setDetails(member,companyNo);
      System.out.println(user);
      return user;
   }


@Override
public FindIdDTO selectFindId(String username, String phone2) {

	return memberMapper.selectFindId(username, phone2);
}


@Override
public FindPwdDTO selectFindPwd(String userId, String username, String email) {
	return memberMapper.selectFindPwd(userId, username, email);
}


@Override
public int updatePwd(FindPwdDTO findPwdDTO) {
	return memberMapper.updatePwd(findPwdDTO);
}


@Override
public MailDTO emailCheck(MailDTO mailDTO) {

	SimpleMailMessage message = new SimpleMailMessage();
    
	message.setTo(mailDTO.getAddress());
    message.setSubject(mailDTO.getTitle());
    message.setText(mailDTO.getMessage());
	
    
    return mailDTO;

	
	
}











   
}