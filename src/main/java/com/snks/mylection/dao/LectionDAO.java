package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.Lection;
import com.snks.mylection.model.User;

public interface LectionDAO {
	

	void save(Lection lection);

	List<Lection> findByUser(User user);

	void delete(int id);

	List<Lection> findAll();

	Lection findByid(int id);

}
