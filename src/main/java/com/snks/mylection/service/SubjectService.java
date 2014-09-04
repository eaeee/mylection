package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.Subject;

public interface SubjectService {

	void addSubject(Subject subject);

	List<Subject> findAll();

	void delete(int id);

	void save(Subject subject);

	Subject findByName(String subject);

	void saveWithClass(Subject subject, String subjectClassificationName);

	List<String> getSubjectsNamesByClass(String classificationName);

}
