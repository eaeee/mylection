package com.snks.mylection.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.LectionDAO;

@Service
public class LectionServiceImpl implements LectionService {
	private LectionDAO lectionsDAO;

	@Override
	@Transactional
	public void addDefaultLection() {
		lectionsDAO.addDefaultLection();
		
	}

}
