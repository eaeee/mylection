package com.snks.mylection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snks.mylection.dao.SubjectClassificationDAO;
import com.snks.mylection.service.SubjectClassificationService;

@Service
public class SubjectClassificationServiceImpl implements SubjectClassificationService {
	
	@Autowired
	private SubjectClassificationDAO subjectClassificationDao;

}
