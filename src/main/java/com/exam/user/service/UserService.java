package com.exam.user.service;

import java.util.List;
import java.util.Set;

import com.exam.user.dto.UserDto;
import com.exam.user.entity.UserRole;
import com.exam.user.model.UserModel;

public interface UserService {

	// Add User
	UserModel addUser(UserDto userDto,Set<UserRole> userRole);

	// get Single User
	UserModel getSingleUser(String userUuid);

	// get List of USer
	List<UserModel> getUserList();

	// update User
	UserModel updateUser(UserDto UserDto, String userUuid);
	
	//delete User
	void deleteUser(String userUuid);
}
