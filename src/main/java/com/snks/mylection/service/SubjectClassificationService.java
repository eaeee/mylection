package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.SubjectClassification;

public interface SubjectClassificationService {
	
	void addSubjectClassification(SubjectClassification subjectClassification);

	List<SubjectClassification> findAll();

	void delete(int id);


}
