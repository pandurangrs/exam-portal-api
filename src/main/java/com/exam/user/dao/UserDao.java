package com.exam.user.dao;

import java.util.List;

import com.exam.user.entity.User;

public interface UserDao {

	// save User
	User saveUser(User user);

	// get Single User
	User getUserUsingId(String userUuid);

	// get List Of User
	List<User> getUserList();

	// delete User
	void deleteUser(User user);
	
	//Check userExist
	boolean exitByUserName(String userName);
}
