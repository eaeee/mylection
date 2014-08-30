package com.snks.mylection.dao;

import java.util.List;

import com.snks.mylection.model.User;


public interface UserDAO {
	void addDefaultUser();
	User findUserByName(String userName);
	List<User> findAll();
	User findById(int id);
	void save(User user);

}
