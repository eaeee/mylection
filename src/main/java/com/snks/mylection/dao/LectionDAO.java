package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.Lection;
import com.snks.mylection.model.Subject;
import com.snks.mylection.model.User;

public interface LectionDAO {
	

	void save(Lection lection);

	List<Lection> findByUser(User user);

	void delete(int id);

	List<Lection> findAll();

	Lection findByid(int id);

	void update(Lection lection);

	void delete(Lection lection);

	List<Lection> findLast();

	Lection findByIdWithCourses(int lectionId);

	List<Lection> search(String word, String wordInBody, Subject subject);

}
