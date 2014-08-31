package com.snks.mylection.service;

import java.util.List;

import com.snks.mylection.model.User;

public interface UserService {
	void addDefaultUser();
	List<User> findAll();
	User findById(int id);
	void save(User user);
	void saveAdmin(User user);
	void saveUser(User user);

}
