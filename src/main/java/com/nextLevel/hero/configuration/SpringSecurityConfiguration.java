package com.nextLevel.hero.configuration;


import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nextLevel.hero.member.model.service.MemberService;


@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private MemberService memberService;
	
	@Autowired
	public SpringSecurityConfiguration(MemberService memberService) {
		this.memberService = memberService;
	}
	
	/* 암호화 처리내용 빈 설정*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	/* 무시할 내용 configure로 설정 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/lib/**" );
	}
	
	/* 권한 설정 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/humanResource/**").hasRole("MEMBER")
				.antMatchers(HttpMethod.GET, "/workattitude/**").hasRole("MEMBER")
				.antMatchers(HttpMethod.GET, "/salary/**").hasRole("MEMBER")
				.antMatchers(HttpMethod.GET, "/certificate/**").hasRole("MEMBER")
				.antMatchers("/mnghumanResource/**").hasRole("HR")
				.antMatchers("/mnghumanResource/**").hasRole("ADMIN")
				.antMatchers("/mngWorkAttitude/**").hasRole("ATTITUDE")
				.antMatchers("/mngWorkAttitude/**").hasRole("ADMIN")
				.antMatchers("/mngVacation/annualVacation").hasRole("HOLIDAY")
				.antMatchers("/mngVacation/annualVacation").hasRole("ADMIN")
				.antMatchers("/mngVacation/publicHoliday").hasRole("HOLIDAY")
				.antMatchers("/mngVacation/publicHoliday").hasRole("ADMIN")
				.antMatchers("/mngVacation/vacationList").hasRole("APPROVAL")
				.antMatchers("/mngVacation/vacationList").hasRole("ADMIN")
				.antMatchers("/mngCertificate/**").hasRole("APPROVAL")
				.antMatchers("/mngCertificate/**").hasRole("ADMIN")
				.antMatchers("/mngSalary/**").hasRole("SALARY")
				.antMatchers("/mngSalary/**").hasRole("ADMIN")
				.antMatchers("/mngSalary/paySalaryAndBonus").hasRole("PAY")
				.antMatchers("/mngSalary/paySalaryAndBonus").hasRole("ADMIN")
				.antMatchers("/mngRole/**").hasRole("ROLE")
				.antMatchers("/mngRole/**").hasRole("ADMIN")
				.antMatchers("/mngBasicInformation/**").hasRole("ROLE")
				.antMatchers("/mngBasicInformation/**").hasRole("ADMIN")
				.anyRequest().permitAll()  //누구나 접근가능
			.and()
				.formLogin()				
				.loginPage("/member/login")
				.successForwardUrl("/main")		//로그인이성공하면 포워딩
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))	//로그아웃 처리
				.deleteCookies("JESSIONID")		//쿠키제거
				.invalidateHttpSession(true)	//세션만료
				.logoutSuccessUrl("/member/login")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/error/403");
				
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 * memberservice 사용자가 비즈니스 로직을 처리한다고 설정 스프링 시큐리티는 패스워드가 일치하면 성공하도록 설정되있다.
		 * memberservice 에서 정보를 가져와 내부에서 비교 사용하는 암호화방식을 passwordEncoder 에서 설정
		 */
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());		
	}
	
}




