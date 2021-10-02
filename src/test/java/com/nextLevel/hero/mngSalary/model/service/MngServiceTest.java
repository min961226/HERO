package com.nextLevel.hero.mngSalary.model.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.nextLevel.hero.configuration.HeroApplication;
import com.nextLevel.hero.mngSalary.model.dao.MngSalaryMapper;
import com.nextLevel.hero.mngSalary.model.dto.MemberInsFeeDTO;
import com.nextLevel.hero.mngSalary.model.dto.MngDeductFourInsDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {HeroApplication.class})
public class MngServiceTest {

	@Autowired
	private MngSalaryService mngSalaryService;
	private MngSalaryMapper mngSalaryMapper;
	
	private MemberInsFeeDTO testDTO;
	private MngDeductFourInsDTO insDTO;
	
	@BeforeAll
	public static void test() {
		System.out.println("최초실행!");
	}

	@BeforeEach
	public void init() {
		this.insDTO = new MngDeductFourInsDTO();
		this.insDTO.setMemberNo(15001);
		this.insDTO.setCompanyNo(1);
		this.insDTO.setIdNo(5);
		this.insDTO.setDivNo(2);
		this.insDTO.setHealthYn("Y");
		this.insDTO.setPensionYn("Y");
		this.insDTO.setUnemployeeYn("Y");
		this.insDTO.setIndustryYn("N");
	}
	
	
	@Test
	public void testUpdate() {
		int result = mngSalaryMapper.updateFourInsuranceList(insDTO);
		
		assertEquals(1, result);
	}
	
	
	
}
