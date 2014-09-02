package com.snks.mylection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.SubjectDAO;
import com.snks.mylection.model.Subject;
import com.snks.mylection.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDAO subjectDao;

	@Override
	public void addSubject(Subject subject) {
		subjectDao.addSubject(subject);
		
	}

	@Override
	public List<Subject> findAll() {
		return subjectDao.findAll();
	}

	@Override
	public void delete(int id) {
		subjectDao.delete(id);
		
	}

	@Override
	public void save(Subject subject) {
		subjectDao.save(subject);
		
	}

}
