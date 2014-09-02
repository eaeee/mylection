package com.snks.mylection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.SubjectClassificationDAO;
import com.snks.mylection.model.SubjectClassification;
import com.snks.mylection.service.SubjectClassificationService;

@Service
@Transactional
public class SubjectClassificationServiceImpl implements SubjectClassificationService {
	
	@Autowired
	private SubjectClassificationDAO subjectClassificationDao;

	@Override
	public List<SubjectClassification> findAll() {
		// TODO Auto-generated method stub
		return subjectClassificationDao.findAll();
	}

	@Override
	public void addSubjectClassification(SubjectClassification subjectClassification) {
		subjectClassificationDao.addClassification(subjectClassification);
		
	}

}
