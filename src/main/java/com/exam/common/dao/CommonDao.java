package com.exam.common.dao;

import com.exam.common.entity.Role;

public interface CommonDao {
	Role saveRole(Role role);
	Role getRole();
}
