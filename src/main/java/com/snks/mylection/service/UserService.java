package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.User;

public interface UserService {
	List<User> findAll();
	User findById(int id);
	void save(User user);
	void saveAdmin(User user);
	void saveUser(User user);
	User findByName(String userName);
	void delete(int id);
	User findByNameWithLections(String userName);
	User findByIdWithLections(int id);
	void update(User user);
	User findByNameWithSubs(String userName);

}
