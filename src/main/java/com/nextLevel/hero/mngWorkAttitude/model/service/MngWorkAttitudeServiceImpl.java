package com.nextLevel.hero.mngWorkAttitude.model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngWorkAttitude.model.dao.MngWorkAttitudeMapper;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkAttitudeDTO;
import com.nextLevel.hero.mngWorkAttitude.model.dto.MngWorkCommuteDTO;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service("mngWorkAttitudeService")
public class MngWorkAttitudeServiceImpl implements MngWorkAttitudeService {

	private final MngWorkAttitudeMapper mngWorkAttitudeMapper;
	
	@Autowired
	public MngWorkAttitudeServiceImpl(MngWorkAttitudeMapper mngWorkAttitudeMapper) {
		this.mngWorkAttitudeMapper = mngWorkAttitudeMapper;
	}

	@Override
	public List<MngWorkAttitudeDTO> selectWorkAttitudeList(int companyNo) {
		
		LocalDate now = LocalDate.now();
		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM");
		DateTimeFormatter formatterb = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
		// 포맷 적용
		String formated = now.format(formatter);
		// 결과 출력
		String formatedNow = formated + "%";
//		String formatedNow = "21/09" + "%";
		
		List<MngWorkAttitudeDTO> workSpList = mngWorkAttitudeMapper.selectWorkAttitudeList(companyNo, formatedNow);
		
		System.out.println(workSpList);
		List<MngWorkAttitudeDTO> workList = new ArrayList<>();
		MngWorkAttitudeDTO workDTO = new MngWorkAttitudeDTO();
		MngWorkCommuteDTO workDTO2 = new MngWorkCommuteDTO();
		
		String a = "";
//		for(int i = 0; i < workSpList.size(); i++ ) {
//			System.out.println(workSpList.get(i).getYearAndMonth().substring(11,19));
//			 a += " " + workSpList.get(i).getWorkStartTime().substring(11,19);
//			workDTO.setWorkStartTime(workSpList.get(i).getWorkStartTime().substring(11,19));
//			workDTO.setWorkEndTime(workSpList.get(i).getWorkEndTime().substring(11,19));
//			
//		}
//		workDTO.setWorkStartTime(a);
//		workSpList.get(0).getWorkCoList().set(0 ,workDTO2);
		workList.addAll(workSpList);
		
		System.out.println(workSpList);
		System.out.println("-------");
		System.out.println(workList);
		
		
		
		return workList;
	}
}
