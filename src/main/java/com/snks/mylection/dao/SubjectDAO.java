package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.Subject;
import com.snks.mylection.model.SubjectClassification;

public interface SubjectDAO {

	void addSubject(Subject subject);

	List<Subject> findAll();

	void delete(int id);

	void save(Subject subject);

	Subject findByName(String name);

	List<Subject> findByClass(SubjectClassification classification);

}
