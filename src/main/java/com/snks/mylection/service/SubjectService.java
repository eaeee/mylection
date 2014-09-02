package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.Subject;

public interface SubjectService {

	void addSubject(Subject subject);

	List<Subject> findAll();

}
