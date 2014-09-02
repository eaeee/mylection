package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.Subject;

public interface SubjectDAO {

	void addSubject(Subject subject);

	List<Subject> findAll();

	void delete(int id);

	void save(Subject subject);

}
