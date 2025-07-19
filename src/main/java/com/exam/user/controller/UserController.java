package com.exam.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.common.constant.UrlMapping;
import com.exam.common.dao.CommonDao;
import com.exam.common.entity.Role;
import com.exam.user.dto.UserDto;
import com.exam.user.entity.User;
import com.exam.user.model.UserModel;
import com.exam.user.service.UserService;

@RestController
@RequestMapping(UrlMapping.BASE_URL)
@CrossOrigin("*")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private CommonDao commonDao;

	//add user
//	@PreAuthorize(Constants.ROLE_ADMIN)
	@PostMapping(UrlMapping.USERS)
	public ResponseEntity<UserModel> saveUser(@RequestBody UserDto userDto) {
		Role role = commonDao.getRole();
		UserModel userModel = userService.addUser(userDto, role);
		return new ResponseEntity<>(userModel, HttpStatus.CREATED);
	}

	//get user using uuid
//	@PreAuthorize(Constants.ROLE_NORMAL)
	@GetMapping(UrlMapping.USER_UUID)
	public ResponseEntity<UserModel> getSingleUser(@PathVariable String userUuid) {
		UserModel userModel = userService.getSingleUser(userUuid);
		return new ResponseEntity<>(userModel, HttpStatus.OK);
	}
	
	//get user list
//	@PreAuthorize(Constants.ROLE_NORMAL)
	@GetMapping(UrlMapping.USERS)
	public ResponseEntity<List<UserModel>> getListOfUsers(){
		return new ResponseEntity<>(userService.getUserList(),HttpStatus.OK);
	}
	
	
	//update user
	@PutMapping(UrlMapping.USER_UUID)
	public ResponseEntity<UserModel> updateUser(@RequestBody UserDto userDto,@PathVariable String userUuid){
		return new ResponseEntity<>(userService.updateUser(userDto, userUuid),HttpStatus.OK);
	}
	
	
	//delete user
	@DeleteMapping(UrlMapping.USER_UUID)
	public ResponseEntity<String> deleteUser(@PathVariable String userUuid){
		userService.deleteUser(userUuid);
		return new ResponseEntity<>("User Deleted Successfully.",HttpStatus.OK);
	}
	
	
	
	
}
