package com.nextLevel.hero.workattitude.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.workattitude.model.dao.WorkAttitudeMapper;


@Service("workAttitudeService")
public class WorkAttitudeServiceImpl implements WorkAttitudeService{
	
	 private WorkAttitudeMapper workAttitudeMapper;
	   
	   @Autowired
	   public WorkAttitudeServiceImpl(WorkAttitudeMapper workAttitudeMapper) {
	      this.workAttitudeMapper = workAttitudeMapper;
	   }
}
