package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.Lection;
import com.snks.mylection.model.json.LectionJSON;

public interface LectionService {

	void save(Lection lection, String name);

	void saveFromJSON(LectionJSON lect);

	void delete(int id);

	List<Lection> findAll();

}
