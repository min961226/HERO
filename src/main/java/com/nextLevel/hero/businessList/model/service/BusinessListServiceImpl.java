package com.nextLevel.hero.businessList.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextLevel.hero.businessList.model.dao.BusinessListMapper;

@Service("businessListService")
public class BusinessListServiceImpl implements BusinessListService {

	private final BusinessListMapper businessListMapper; 
	
	@Autowired
	public BusinessListServiceImpl(BusinessListMapper businessListMapper) {
		this.businessListMapper = businessListMapper;
	}

	
	
	
}
