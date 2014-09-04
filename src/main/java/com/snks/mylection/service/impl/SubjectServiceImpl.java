package com.snks.mylection.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snks.mylection.dao.SubjectDAO;
import com.snks.mylection.model.Subject;
import com.snks.mylection.model.SubjectClassification;
import com.snks.mylection.service.SubjectClassificationService;
import com.snks.mylection.service.SubjectService;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDAO subjectDao;
	
	@Autowired
	private SubjectClassificationService classificationService;

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

	@Override
	public Subject findByName(String name) {
		 return subjectDao.findByName(name);
	}

	@Override
	public void saveWithClass(Subject subject, String subjectClassificationName) {
		SubjectClassification classification= classificationService.findByName(subjectClassificationName);
		subject.setClassification(classification);
		save(subject);
		
	}

	@Override
	public List<String> getSubjectsNamesByClass(String classificationName) {
		SubjectClassification classification=  classificationService.findByName(classificationName);
		List<Subject> subjects =  subjectDao.findByClass(classification);
		List<String> names = new ArrayList<String>();
		for ( Subject subject : subjects) { 
			names.add(subject.getSubjectName());
		}
		return names;
	}

}
