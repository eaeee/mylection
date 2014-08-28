package com.snks.mylection.dao;

import com.snks.mylection.model.User;


public interface UserDAO {
	void addDefaultUser();
	User findUserByName(String userName);

}
