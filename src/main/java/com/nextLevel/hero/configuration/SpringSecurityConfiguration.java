package com.nextLevel.hero.configuration;


import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
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
				.antMatchers("/mnghumanResource/**").hasAnyRole("HR", "ADMIN")
				.antMatchers("/mngWorkAttitude/**").hasAnyRole("ATTITUDE", "ADMIN")
				.antMatchers("/mngVacation/annualVacation").hasAnyRole("HOLIDAY", "ADMIN")
				.antMatchers("/mngVacation/publicHoliday").hasAnyRole("HOLIDAY", "ADMIN")
				.antMatchers("/mngVacation/vacationList").hasAnyRole("APPROVAL", "ADMIN")
				.antMatchers("/mngCertificate/**").hasAnyRole("APPROVAL", "ADMIN")
				.antMatchers("/mngSalary/**").hasAnyRole("SALARY", "ADMIN")
				.antMatchers("/mngPay/paySalaryAndBonus").hasAnyRole("PAY", "ADMIN")
				.antMatchers("/mngRole/**").hasAnyRole("ROLE", "ADMIN")
				.antMatchers("/mngBasicInformation/**").hasAnyRole("ROLE", "ADMIN")
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
				.logoutSuccessUrl("/logout")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/error/403");
	
			http.sessionManagement()
		    .maximumSessions(1)
		    .maxSessionsPreventsLogin(true)
		    .expiredUrl("/duplicated-login")
		    .sessionRegistry(sessionRegistry());
	}
	
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}// Register HttpSessionEventPublisher

	@Bean
	public static ServletListenerRegistrationBean httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
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




