package com.nextLevel.hero.mngWorkAttitude.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextLevel.hero.mngWorkAttitude.model.dao.MngWorkAttitudeMapper;


@Service("mngWorkAttitudeService")
public class MngWorkAttitudeServiceImpl implements MngWorkAttitudeService {

	private final MngWorkAttitudeMapper mngWorkAttitudeMapper;
	
	@Autowired
	public MngWorkAttitudeServiceImpl(MngWorkAttitudeMapper mngWorkAttitudeMapper) {
		this.mngWorkAttitudeMapper = mngWorkAttitudeMapper;
	}
}
