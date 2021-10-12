package com.nextLevel.hero.mngSalary.model.service;



import java.util.List;

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
import com.nextLevel.hero.mngSalary.model.dto.SalaryAndBonusDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {HeroApplication.class})
public class MngServiceTest {

	@Autowired
	private MngSalaryService mngSalaryService;
	private MngSalaryMapper mngSalaryMapper;
	
	private MemberInsFeeDTO testDTO;
	private SalaryAndBonusDTO insDTO;
	
	@BeforeAll
	public static void test() {
		System.out.println("최초실행!");
	}

	@BeforeEach
	public void init() {
		this.insDTO = new SalaryAndBonusDTO();
		this.insDTO.setCompanyNo(1);
		this.insDTO.setSearchPayDate("2021-10-10");
		this.insDTO.setSearchingValidateDate("20211001");
		this.insDTO.setCategory("급여");
		this.insDTO.setYear("2021");
		this.insDTO.setMonth("09");
	}
	
	
	
	
	
}
