package com.exam.user.service;

import java.util.List;

import com.exam.common.entity.Role;
import com.exam.user.dto.UserDto;
import com.exam.user.model.UserModel;

public interface UserService {

	// Add User
	UserModel addUser(UserDto userDto,Role role);

	// get Single User
	UserModel getSingleUser(String userUuid);

	// get List of USer
	List<UserModel> getUserList();

	// update User
	UserModel updateUser(UserDto UserDto, String userUuid);
	
	//delete User
	void deleteUser(String userUuid);
}
