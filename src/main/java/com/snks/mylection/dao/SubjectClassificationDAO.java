package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.SubjectClassification;

public interface SubjectClassificationDAO {

	List<SubjectClassification> findAll();

	void addClassification(SubjectClassification classification);

	void delete(int id);

	void save(SubjectClassification classification);

}
