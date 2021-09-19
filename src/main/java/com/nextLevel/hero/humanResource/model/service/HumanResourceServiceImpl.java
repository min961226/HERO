package com.nextLevel.hero.humanResource.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.humanResource.model.dao.HumanResourceMapper;

@Service("humanResourceService")
public class HumanResourceServiceImpl implements HumanResourceService {

	 private final HumanResourceMapper humanResourceMapper;
	   
	   @Autowired
	   public HumanResourceServiceImpl(HumanResourceMapper humanResourceMapper) {
	      this.humanResourceMapper = humanResourceMapper;
	   }
}
