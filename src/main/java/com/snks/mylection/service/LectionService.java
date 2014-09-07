package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.Lection;
import com.snks.mylection.model.json.LectionJSON;

public interface LectionService {

	void save(Lection lection, String name);

	int saveFromJSON(LectionJSON lect);

	void delete(int id);

	List<Lection> findAll();

	Lection findById(int id);

	int updateFromJSON(LectionJSON lect, int id);

	void delete(Lection lection);

	void update(Lection lection);

	List<Lection> findLast();

}
