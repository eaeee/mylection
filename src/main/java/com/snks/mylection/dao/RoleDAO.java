package com.snks.mylection.dao;

import com.snks.mylection.model.Role;

public interface RoleDAO {
	void save(Role role);

	Role findByName(String string);

	void init(Role roleUser);


}
